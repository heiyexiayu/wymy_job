package com.test;

import java.io.File;
import java.io.IOException;

public class Test10_File2 {
    public static void main(String[] args) throws IOException {
//           File f1=new File("C:\\Users\\Administrator\\Desktop\\ceshi\\Koala.jpg");
//           FileInputStream  fis=new FileInputStream(f1);
//           FileOutputStream  fos=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\CSDN\\Kaola.jpg");
//
//        byte [] b=new byte[1024];
//           int n=0;
//           while((n=fis.read(b))!=-1)
//           {
//               //System.out.println( new String (b));
//                fos.write(b ) ;
//               System.out.println(n);
//           }
        File f = new File("C:\\Users\\Administrator\\Desktop\\CSDN");
        File[] s = f.listFiles();
        for (int i = 0; i < s.length; i++)
            System.out.println(s[i]);
        File f2 = new File("C:\\Users\\Administrator\\Desktop\\adc");
        f2.mkdir();
//           fis.close() ;
//           fos.close() ;
//        String s="qwee";
//        byte[] by=s.getBytes() ;
//        FileReader fr=new FileReader("C:\\Users\\Administrator\\Desktop\\ceshi\\Koala.jpg");
//        FileWriter fw=new FileWriter("C:\\Users\\Administrator\\Desktop\\CSDN\\Kaola.jpg");
//        char [] arr=new char[1024];
//        while(fr.read(arr)!=-1){
//
//            fw.write(arr );
//        }
//        fr.close();
//   fw.close() ;
    }
}
