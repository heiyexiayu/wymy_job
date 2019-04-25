package com.arithmetic;

public class Hanio {
    public void moveOne(int n, String init, String desti) {    //只有一个盘子的情况

        System.out.println(" move:" + n + " from " + init + " to " + desti);
    }

    public void move(int n, String init, String temp, String desti) {
        if (n <= 0) {
            System.out.println("number error");
            return;
        } else if (n == 1) {
            moveOne(n, init, desti);
        } else {
            move(n - 1, init, desti, temp);//首先将上面的（n-1）个盘子从init杆借助desti杆移至temp杆
            moveOne(n, init, desti);     //然后将编号为n的盘子从init杆移至desti杆
            move(n - 1, temp, init, desti);//最后将上面的（n-1）个盘子从temp杆借助init杆移至desti杆
        }
    }
}

class HanioApp {
    public static void main(String args[]) {
        Hanio hanio = new Hanio();
        hanio.move(4, "A", "B", "C");
    }
}

