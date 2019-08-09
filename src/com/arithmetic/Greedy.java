package com.arithmetic;

import java.util.*;

/**
 * @Author WYMY
 * @Date 2019/4/25 10:29
 */
//贪心算法 广播站覆盖问题
public class Greedy {

    //选出交集最大的，然后从全部地区将交集内容去除，再选出与剩下地区交集最大的，再次去除交集内容  优先选出交集多的
    public static void main(String[] args) {
        //初始化广播台信息
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        broadcasts.put("K1", new HashSet(Arrays.asList(new String[]{"ID", "NV", "UT"})));
        broadcasts.put("K2", new HashSet(Arrays.asList(new String[]{"WA", "ID", "MT"})));
        broadcasts.put("K3", new HashSet(Arrays.asList(new String[]{"OR", "NV", "CA"})));
        broadcasts.put("K4", new HashSet(Arrays.asList(new String[]{"NV", "UT"})));
        broadcasts.put("K5", new HashSet(Arrays.asList(new String[]{"CA", "AZ"})));

        //需要覆盖的全部地区
        HashSet<String> allAreas = new HashSet(Arrays.asList(new String[]{"ID", "NV", "UT", "WA", "MT", "OR", "CA", "AZ"}));
        //所选择的广播台列表
        List<String> selects = new ArrayList<String>();

        HashSet<String> tempSet = new HashSet<String>();
        String maxKey = null;
        while (allAreas.size() != 0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出2个集合的交集，此时tempSet会被赋值为交集的内容，所以使用临时变量
                tempSet.retainAll(allAreas);
                //如果该集合包含的地区数量比原本的集合多
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.print("selects:" + selects);

    }
}