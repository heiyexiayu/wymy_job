package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * 2018年8月22日13:26:24
 * list进行删除操作（迭代器）
 */
public class Test22_List {
    public static void delete(int i, ArrayList al) {
        Iterator it = al.iterator();
        while (it.hasNext()) {
            if (it.next().equals(i))
                it.remove();
        }
    }

    public static void print(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i = (int) it.next();
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        delete(3, list);
//        print(list);
        for(int i=0;i<100;i++){
            System.out.println( new Random().nextInt(10));
        }


//        Iterator iterator=list.iterator();
//       while (iterator.hasNext()){
//           list.remove(iterator.next());
//       }
    }
}
