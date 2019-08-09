package com.test;

/**
 * @Author create by  huarong
 * @Date ${Date} ${Time}
 */
public class FinalTest {

    public static void main(String[] args) {
//      final Tets tets=new Tets();
//       tets.s="aaa";
////       tets.s="ccc";
////       Tets tets1=new Tets();
////       tets1.s="bbb";
////       //tets=tets1;  final修饰的引用无法更改
////       System.out.println(tets.s+"  "+tets1.s);
        String s4 = "aabb";
        String s2 = "bb";
        String s3 = new String("aa");
        String s1 = "aa";
        String s5 = "aa" + "bb";
        System.out.println("sssssss");
        System.out.println("s3==s2   " + (s3 == s1));//f
        System.out.println(s4 == (s1 + s2));//f
        System.out.println("(s4==s5)   " + (s4 == s5));//true
        System.out.println("s4==(s1+s3)   " + (s4 == (s1 + s3)));//f
        System.out.println("s1==s3.intern()  " + (s1 == s3.intern()));//true
        System.out.println("s4==(s1+s3.intern())   " + (s4 == (s1 + s3.intern())));//f
        System.out.println("s4==(s1+s3).intern()     " + (s4 == (s1 + s3).intern()));//f
        System.out.println();
    }
}

final class Tets {
    String s = "sss";
}