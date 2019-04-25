package com.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test9_File {
    public static void main(String[] args) throws IOException {

        File f1 = new File("C:\\Users\\Administrator\\Desktop\\ceshi\\two.txt");
//        if(f1.exists() ){
////            System.out.println("不能创建");
////        }else
////            System.out.println("ok");
////        System.out.println(f1.length() );
////        FileWriter w1=new FileWriter(f1) ;
////        w1.write("asdfgh");
////        f1.length() ;
////        w1.close();
        FileReader fr = new FileReader(f1);
//    char [] b=new char[1000];
//    char[] bb={'a','b','c'};
//    int i=0;
//    while(  (i=fr.read(b)) !=-1){
//        System.out.println(b );
//        System.out.println(Arrays.toString(b) );
//        i++;
//        }
//        System.out.println(bb);
//        System.out.println(Arrays.toString(bb) );
//     File f2=new File("C:\\Users\\Administrator\\Desktop\\ceshi");
//    File []list=f2.listFiles();
//    for(int i=0;i<list.length;i++ )
//        System.out.println(list[i].getName() );
        //  System.out.println(Arrays.toString(list) );
        fr.close();
    }
}
