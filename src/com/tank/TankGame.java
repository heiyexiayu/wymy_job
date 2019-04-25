package com.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class TankGame extends JFrame implements ActionListener {
    MyPanel mp = null;

    @Override
    public void actionPerformed(ActionEvent e) {
// 对用户不同点击不同相应
        if (e.getActionCommand().equals("newGame")) {
            mp = new MyPanel();
            Thread t = new Thread(mp);
            t.start();
            //删除旧的面板
            this.remove(msp);
            this.add(mp);
            //注册监听
            this.addKeyListener(mp);
            //刷新
            this.setVisible(true);
        }
    }

    //定义一个开始面板
    MyStartPanel msp = null;
    //定义菜单
    JMenuBar jmb = null;
    JMenu jm1 = null;
    JMenuItem jmi1 = null;

    public static void main(String[] args) {
        TankGame tg = new TankGame();
//       tg.mp.mt.setSpeed(3);
//        tg.mp.mt.setDrect(0);
//        tg.mp.mt.setY(200);
//        tg.mp.mt.setX(200);
    }

    public TankGame() {
        // mp=new MyPanel();
        //启动线程
        //  Thread t=new Thread(mp);
        //  t.start();
        //  this.add(mp);
        //注释监听
        //this.addKeyListener(mp) ;
        //创建菜单及选项
        jmb = new JMenuBar();
        jm1 = new JMenu("游戏");
        //快捷方式
        jm1.setMnemonic('g');
        jmi1 = new JMenuItem("开始游戏（N）");
        //对jmi1相应
        jmi1.addActionListener(this);
        jmi1.setActionCommand("newGame");
        jm1.add(jmi1);
        jmb.add(jm1);

        msp = new MyStartPanel();
        Thread t = new Thread(msp);
        t.start();
        this.setJMenuBar(jmb);
        this.add(msp);
        this.setSize(600, 600);
        this.setVisible(true);
    }
}

class MyStartPanel extends JPanel implements Runnable {
    int times = 0;

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 400, 400);
        // 游戏提示
        if (times % 2 == 0) {
            g.setColor(Color.cyan);
            Font myFont = new Font("微软雅黑", Font.BOLD, 30);
            g.setFont(myFont);
            g.drawString("Stage 1", 150, 200);
        }
    }

    public void run() {
        while (true) {
            times++;
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

}

//我的面板
class MyPanel extends Panel implements KeyListener, Runnable {
    //定义我的坦克
    MyTank mt = null;
    //定义敌人坦克
    Vector<EnemyTank> ets = new Vector<EnemyTank>();
    int etSize = 4;
    //定义三张图片，作为一颗炸弹效果
    Image im1 = null;
    Image im2 = null;
    Image im3 = null;
    //定义炸弹集合
    Vector<Bomb> bombs = new Vector<Bomb>();

    //构造函数
    public MyPanel() {
        //初始我的坦克
        mt = new MyTank(200, 100);
        //初始敌人坦克
        for (int i = 0; i < etSize; i++) {
            EnemyTank et = new EnemyTank((i + 1) * 80, 0);
            et.setDrect(1);
            //调用getEts()
            et.getEts(ets);
            //启动坦克
            Thread t = new Thread(et);
            t.start();
            Shot s = new Shot(et.x + 10, et.y + 30, 1);
            et.ess.add(s);
            //启动子弹
            Thread t2 = new Thread(s);
            t2.start();
            ets.add(et);

        }
        im1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Koala.jpg"));
        im2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Lighthouse.jpg"));
        im3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Penguins.jpg"));
    }

    //重写update函数消除闪烁（update是repaint（）中的一个方法）
    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.CYAN);
        //画出我的坦克
        if (mt.isLive)
            this.drawTank(mt.getX(), mt.getY(), g, this.mt.drect, 0);
        //画出我的子弹
        for (int i = 0; i < mt.ss.size(); i++) {
            Shot s1 = mt.ss.get(i);
            if (s1 != null && s1.isLive) {
                g.setColor(Color.red);
                g.draw3DRect(s1.x, s1.y, 1, 1, false);
            }
            //  当子弹到达边界后，把这颗子弹从集合中删除
            if (s1.isLive == false)
                mt.ss.remove(s1);
        }
        //画出炸弹
        for (int i = 0; i < bombs.size(); i++) {
            System.out.println(bombs.size());
            //取出炸弹
            Bomb b = bombs.get(i);
            System.out.println(b.life);
            if (b.life > 6)
                g.drawImage(im1, b.x, b.y, 30, 30, null);
            else if (b.life > 3)
                g.drawImage(im2, b.x, b.y, 30, 30, null);
            else
                g.drawImage(im3, b.x, b.y, 30, 30, null);
            b.lifeDown();
            if (b.life == 0)
                bombs.remove(i);
        }
        // 画敌人坦克
        for (int i = 0; i < ets.size(); i++) {
            EnemyTank et = ets.get(i);
            if (et.isLive) {
                this.drawTank(et.x, et.y, g, et.drect, 1);
                for (int j = 0; j < et.ess.size(); j++) {
                    Shot s1 = et.ess.get(j);
                    if (s1.isLive) {
                        g.setColor(Color.red);
                        g.draw3DRect(s1.x, s1.y, 1, 1, false);
                    }
                    //  当子弹到达边界或者坦克死亡后，把这颗子弹从集合中删除
                    if (s1.isLive == false) {
                        et.ess.remove(s1);
                    }
                }
            }
        }
    }

    public void hit(Shot s, Tank et) {
        switch (et.drect) {
            case 0:
            case 1:
                //设置子弹 击中敌人坦克后子弹和敌人坦克的状态
                if (s.x >= et.x && s.x <= (et.x + 20) && s.y >= et.y && (s.y <= et.y + 30)) {
                    //子弹消失，敌方坦死亡
                    s.isLive = false;
                    et.isLive = false;
                    //创建炸弹,放入Vector
                    Bomb b = new Bomb(et.x, et.y);
                    bombs.add(b);
                }
                break;
            case 2:
            case 3:
                if (s.x >= et.x && s.x <= (et.x + 30) && s.y >= et.y && (s.y <= et.y + 20)) {
                    s.isLive = false;
                    et.isLive = false;
                    //创建炸弹,放入Vector
                    Bomb b = new Bomb(et.x, et.y);
                    bombs.add(b);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            this.mt.setDrect(0);
            if (mt.y > 0)
                this.mt.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.mt.setDrect(1);
            if (mt.y < 370)
                this.mt.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.mt.setDrect(3);
            if (mt.x > 0)
                this.mt.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.mt.setDrect(2);
            if (mt.x < 370)
                this.mt.moveRight();
        }
        //开火
        if (e.getKeyCode() == KeyEvent.VK_J) {
            if (mt.ss.size() < 5)
                this.mt.shot();

        }
//        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //画出坦克的函数
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }
        //0向上，1向下，2向右，3向左
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.fillOval(x + 5, y + 10, 10, 10);
                g.drawLine(x + 10, y + 15, x + 10, y);
                break;
            case 1:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.fillOval(x + 5, y + 10, 10, 10);
                g.drawLine(x + 10, y + 15, x + 10, y + 30);
                break;
            case 2:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 10, y + 5, 10, 10);
                g.drawLine(x + 15, y + 10, x + 30, y + 10);
                break;
            case 3:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 10, y + 5, 10, 10);
                g.drawLine(x + 15, y + 10, x + 0, y + 10);
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //击中让敌人坦克
            for (int i = 0; i < mt.ss.size(); i++) {
                Shot s = mt.ss.get(i);
                if (s.isLive)
                    for (int j = 0; j < ets.size(); j++) {
                        EnemyTank et = ets.get(j);
                        if (et.isLive)
                            this.hit(s, et);
                    }
            }
            // 被敌人击中
            for (int i = 0; i < ets.size(); i++) {
                EnemyTank et = ets.get(i);
                for (int j = 0; j < et.ess.size(); j++) {
                    Shot s1 = et.ess.get(j);
                    if (mt.isLive)
                        this.hit(s1, mt);
                }
            }
            //重绘动作
            this.repaint();
        }
    }
}

//坦克类
class Tank {
    //坦克生死情况
    boolean isLive = true;
    //坦克的坐标
    int x = 0;
    int y = 0;
    //坦克方向
    int drect = 0;
    //坦克速度
    int speed = 2;
    //颜色
    int color = 0;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDrect() {
        return drect;
    }

    public void setDrect(int drect) {
        this.drect = drect;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}

//我的坦克
class MyTank extends Tank {
    Shot s = null;
    //子弹的集合
    Vector<Shot> ss = new Vector<Shot>();

    //开火
    public void shot() {
        switch (this.drect) {
            case 0:
                s = new Shot(x + 10, y, 0);
                ss.add(s);
                break;
            case 1:
                s = new Shot(x + 10, y + 30, 1);
                ss.add(s);
                break;
            case 2:
                s = new Shot(x + 30, y + 10, 2);
                ss.add(s);
                break;
            case 3:
                s = new Shot(x, y + 10, 3);
                ss.add(s);
                break;
        }
        //启动子弹
        Thread t1 = new Thread(s);
        t1.start();
    }

    //构造函数
    public MyTank(int x, int y) {
        super(x, y);
    }

    //向上
    public void moveUp() {
        y -= speed;
    }

    //向右
    public void moveRight() {
        x += speed;
    }

    //向下
    public void moveDown() {
        y += speed;
    }

    //向左
    public void moveLeft() {
        x -= speed;
    }
}

class EnemyTank extends Tank implements Runnable {
    int time = 0;
    Vector<EnemyTank> ets = new Vector<EnemyTank>();
    Vector<Shot> ess = new Vector<Shot>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    // 得到Mypanel中的坦克集合
    public void getEts(Vector<EnemyTank> ets) {
        this.ets = ets;
    }

    //判断敌人坦克是否重叠
    public boolean isTouch() {
        boolean b = false;
        //
        switch (this.drect) {
            case 0:
                //坦克向上
                for (int i = 0; i < ets.size(); i++) {
                    EnemyTank et = ets.get(i);
                    //排除自己和自己比较
                    if (et != this) {    //其他敌人坦克方向向上或向下
                        if (et.drect == 0 || et.drect == 1) {
                            if (this.x >= et.x && this.x <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                            if (this.x + 20 >= et.x && this.x + 20 <= et.x + 20 && this.y <= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                        } //其他敌人坦克方向向左或向右
                        if (et.drect == 2 || et.drect == 3) {
                            if (this.x >= et.x && this.x <= et.x + 30 && this.y >= et.y && this.y <= et.y + 20) {
                                return true;
                            }
                            if (this.x + 20 >= et.x && this.x + 20 <= et.x + 30 && this.y <= et.y && this.y <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                //坦克向下
                for (int i = 0; i < ets.size(); i++) {
                    EnemyTank et = ets.get(i);
                    //排除自己和自己比较
                    if (et != this) {    //其他敌人坦克方向向上或向下
                        if (et.drect == 0 || et.drect == 1) {
                            if (this.x >= et.x && this.x <= et.x + 20 && this.y + 30 >= et.y && this.y + 30 <= et.y + 30) {
                                return true;
                            }
                            if (this.x + 20 >= et.x && this.x + 20 <= et.x + 20 && this.y + 30 <= et.y && this.y + 30 <= et.y + 30) {
                                return true;
                            }
                        }
                        //其他敌人坦克方向向左或向右
                        if (et.drect == 2 || et.drect == 3) {
                            if (this.x >= et.x && this.x <= et.x + 30 && this.y + 30 >= et.y && this.y + 30 <= et.y + 20) {
                                return true;
                            }
                            if (this.x + 20 >= et.x && this.x + 20 <= et.x + 30 && this.y + 30 <= et.y && this.y + 30 <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                //坦克向右
                for (int i = 0; i < ets.size(); i++) {
                    EnemyTank et = ets.get(i);
                    //排除自己和自己比较
                    if (et != this) {    //其他敌人坦克方向向上或向下
                        if (et.drect == 0 || et.drect == 1) {
                            if (this.x + 30 >= et.x && this.x + 30 <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                            if (this.x + 30 >= et.x && this.x + 30 <= et.x + 20 && this.y + 20 <= et.y && this.y + 20 <= et.y + 30) {
                                return true;
                            }
                        }
                        //其他敌人坦克方向向左或向右
                        if (et.drect == 2 || et.drect == 3) {
                            if (this.x + 30 >= et.x && this.x + 30 <= et.x + 30 && this.y >= et.y && this.y <= et.y + 20) {
                                return true;
                            }
                            if (this.x + 30 >= et.x && this.x + 30 <= et.x + 30 && this.y + 20 <= et.y && this.y + 20 <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                //坦克向左
                for (int i = 0; i < ets.size(); i++) {
                    EnemyTank et = ets.get(i);
                    //排除自己和自己比较
                    if (et != this) {    //其他敌人坦克方向向上或向下
                        if (et.drect == 0 || et.drect == 1) {
                            if (this.x >= et.x && this.x <= et.x + 20 && this.y >= et.y && this.y <= et.y + 30) {
                                return true;
                            }
                            if (this.x >= et.x && this.x <= et.x + 20 && this.y + 20 <= et.y && this.y + 20 <= et.y + 30) {
                                return true;
                            }
                        }
                        //其他敌人坦克方向向左或向右
                        if (et.drect == 2 || et.drect == 3) {
                            if (this.x >= et.x && this.x <= et.x + 30 && this.y >= et.y && this.y <= et.y + 20) {
                                return true;
                            }
                            if (this.x >= et.x && this.x <= et.x + 30 && this.y + 20 <= et.y && this.y + 20 <= et.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return b;
    }

    public void run() {
        while (true) {
            switch (this.drect) {
                case 0:
                    for (int j = 0; j < 30; j++) {
                        if (y > 0 && !isTouch())
                            this.y -= speed;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int j = 0; j < 30; j++) {
                        if (y < 370 && !isTouch())
                            this.y += speed;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int j = 0; j < 10; j++) {
                        if (x < 350 && !isTouch())
                            this.x += speed;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int j = 0; j < 30; j++) {
                        if (x > 0 && !isTouch())
                            this.x -= speed;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            // 判断是否需要给坦克加入新的子弹
            this.time++;
            if (time % 1 == 0)
                if (ess.size() < 4) {
                    Shot s = null;
                    switch (drect) {
                        case 0:
                            s = new Shot(x + 10, y, 0);
                            ess.add(s);
                            break;
                        case 1:
                            s = new Shot(x + 10, y + 30, 1);
                            ess.add(s);
                            break;
                        case 2:
                            s = new Shot(x + 30, y + 10, 2);
                            ess.add(s);
                            break;
                        case 3:
                            s = new Shot(x, y + 10, 3);
                            ess.add(s);
                            break;
                    }
                    //启动子弹线程
                    Thread t = new Thread(s);
                    t.start();
                }
            this.drect = (int) (Math.random() * 4);
            if (this.isLive == false)
                break;
        }
    }
}

class Shot implements Runnable {
    int x;
    int y;
    int direct;
    int speed = 2;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (isLive) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //判断子弹是否到边界
            if (x < 0 || x > 400 || y < 0 || y > 400) {
                isLive = false;
            }
            // System.out.println("x "+x+"y "+y);
        }
    }
}

class Bomb {
    int x;
    int y;
    //炸弹生命值
    int life = 9;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if (life > 0)
            life--;
        else
            this.isLive = false;
    }
}