package com.arithmetic;

import java.util.*;

/**
 * @Author WYMY
 * @Date 2019/4/28 11:13
 */
public class HuffmanTest {
    public static void main(String[] args) {
        String msg="can you can a can as a can canner can a can.";
        byte[]bytes=msg.getBytes();
      //  System.out.println(Arrays.toString(bytes));
        //进行赫夫曼编码
        byte[] b=huffmanZip(bytes);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 进行赫夫曼编码压缩
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每个byte出现次数，并放入集合
        List<HfNode> nodes=getNodes(bytes);
        //创建一棵赫夫曼树
        HfNode tree =createHuffmanTree(nodes);
        //  System.out.println(tree);
        //创建一个赫夫曼编码
        Map<Byte,String>huffCodes=createNodes(tree);
        //编码
        byte[]b=zip(bytes,huffCodes);
        return b;
    }
   //编码
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb=new StringBuilder();
        //将byte数组替换成字符串
        for(byte b:bytes){
            sb.append(huffCodes.get(b));
        }
        int len;
        if(sb.length()%8==0){
            len=sb.length()/8;
        }else {
            len=sb.length()/8+1;
        }
        //用于存储压缩后的byte
        byte[]by=new byte[len];
        int index=0;
        for(int i=0;i<sb.length();i+=8){
            String str;
            if(i+8>sb.length()){
                str= sb.substring(i);
            }else {
                str= sb.substring(i,i+8);
            }
            byte b=(byte)Integer.parseInt(str,2);
          //  System.out.println(str+"  "+b);
            by[index]=b;
            index++;
        }
        return by;
    }

    static StringBuilder sb=new StringBuilder();
    static Map<Byte,String>huffCodes=new HashMap<>();
    /**
     * 创建huffman编码
     * @param tree
     * @return
     */
    private static Map<Byte, String> createNodes(HfNode tree) {
         if(tree==null){
             return null;
         }
          createNodes2(tree.left,"0",sb);
          createNodes2(tree.right,"1",sb);
          return huffCodes;
    }

    private static void createNodes2(HfNode node, String code, StringBuilder sb) {
        StringBuilder sb2=new StringBuilder(sb);
        sb2.append(code);
        if(node.data==null){
            createNodes2(node.left,"0",sb2);
            createNodes2(node.right,"1",sb2);
        }else {
            huffCodes.put(node.data,sb2.toString());
        }
    }

    /**
     * 创建huffmanTree
     * @param nodes
     * @return
     */
    private static HfNode createHuffmanTree(List<HfNode> nodes) {
        while(nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出wight最小的两个节点
            HfNode leftNode=nodes.get(nodes.size()-1);
            HfNode rightNode=nodes.get(nodes.size()-2);
            //创建一个父节点
            HfNode newNode=new HfNode(null,leftNode.weight+rightNode.weight);
            newNode.left=leftNode;
            newNode.right=rightNode;
            //删除末尾两个节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //新创建的节点（二叉树）存入
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    /**
     * 把byte转成node集合
     * @param bytes
     * @return
     */
    private static List<HfNode> getNodes(byte[] bytes) {
        List<HfNode>nodes=new ArrayList<>();
        Map<Byte,Integer>counts=new HashMap<>();
        //统计每一个byte出现次数
        for(byte b:bytes){
            Integer count = counts.get(b);
            if(count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
      //  System.out.println(counts);
        //把每一个键值对转成一个node对象
        for(Map.Entry<Byte,Integer>entry:counts.entrySet()){
            nodes.add(new HfNode(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

}
class HfNode implements Comparable<HfNode>{
    Byte data;
    int weight;
    HfNode left;
    HfNode right;
    public HfNode(Byte data,int weight){
        this.data=data;
        this.weight=weight;
    }

    @Override
    public int compareTo(HfNode o) {
        return o.weight-this.weight;
    }

    @Override
    public String toString() {
        return "HfNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
