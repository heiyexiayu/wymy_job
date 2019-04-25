package com.test;

/**
 * @Author create by  huarong
 * @Date 2019/4/22 16:54
 */
public class StringTest {
//    public static void main(String[] args) {
//        String s=new String("ab.c.d.efg");
//        System.out.println(s.hashCode());
//        char a='0';
//        int i=9;
//        char[] arr=new char[3];
//        arr[0]='a';
//        arr[1]='b';
//        arr[2]='c';
//        String s3="a";
//        String s4=new String(s3);
//        String s2=new String(arr);
//        System.out.println(0+a);
//        System.out.println(Arrays.toString(s.split("\\.")));
//        System.out.println(s.replaceAll("\\.","-"));
//        System.out.println(String.valueOf(i));
//        System.out.println(s2.hashCode());
//        System.out.println(s3.hashCode());
//        System.out.println(s4.hashCode());
//        System.out.println(s2.codePointAt(1));
//        System.out.println(s2.charAt(1));
//        System.out.println(s2.codePointBefore(1));
//
//    }
//         public static void main(String[] args) {
//         String a="a.b.c";
//         String replace=  a.replace(".","-");
//         String replaceall=a.replaceAll("\\.","-");
//         System.out.println("replace : "+replace);
//         System.out.println("replaceall : "+replaceall);
//             System.out.println(Arrays.toString(a.split(".")));
//             System.out.println(Arrays.toString(a.split("\\.")));
//
//             Long ww=999999L;
//             Double d=1.9999;
//             System.out.println(Arrays.toString(a.split("\\.")));
//             System.out.println(ww.hashCode());
//             System.out.println(d.hashCode());
//             String b="abce";
//             String c="abcabce";
//             System.out.println(a.compareTo(b));
//             String concat = a.concat(b);
//             System.out.println(concat);
//             String s=a+b;
//             System.out.println(concat.intern()==c);
//         }
public static void main(String[] args) {
  //采取字面值的方式
    String s1="a";
    String s2="b";
    String s4="ab";
    String s5="a"+"b";
    //采取new方式（会申请内存空间）
    String s3=new String("a");
    String s6=new String("ab");
    System.out.println("s1==s3: "+(s1==s3));
    System.out.println("s1+s2==s4: "+ ((s1+s2)==s4));
    System.out.println("s1+s2==s5: "+((s1+s2)==s5) );
    System.out.println("s5==s6: "+( s5==s6));
    System.out.println("s4==s5: "+(s4==s5));

    System.out.println("s1==s3.intern(): "+(s1==s3.intern()));

    StringBuffer stringBuffer= new StringBuffer("a");
    System.out.println(stringBuffer.append("b"));
}
}
