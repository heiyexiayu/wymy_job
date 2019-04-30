package com.arithmetic.sorttree;

/**
 * @Author WYMY
 * @Date 2019/4/28 22:11
 */
public class Test {
    public static void main(String[] args) {
        //int[]arr={7,7,7,9,10,12,5,1,9};
        int []arr={4,3,7,6,5,8};
        BinarySortree binarySortree=new BinarySortree();
        for(int i:arr){
           binarySortree.add(new Node(i));
        }
        //binarySortree.midSort();
//        Node node=binarySortree.search(7);
//        System.out.println(node.value);
//        binarySortree.delete(12);
      //  binarySortree.delete(7);
        System.out.println("-------------");
        System.out.println( binarySortree.high(binarySortree.root));
        System.out.println("----------");
        binarySortree.midSort();
        System.out.println("-------------");
        System.out.println(binarySortree.root.value);
//        Node node1 = binarySortree.searchParent(10);
//        System.out.println(node1.value);
    }
}
