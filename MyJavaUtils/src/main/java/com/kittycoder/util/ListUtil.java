package com.kittycoder.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shucheng on 2018/6/17 23:02.
 **/
public class ListUtil {

    /**
     * 获取list中存放的最后一个元素
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getLastElement(List<T> list) {
        return list.get(list.size() - 1);
    }

    /**
     * 合并多个list
     * @param lists
     * @param <T>
     * @return
     */
    public static <T> List<T> mergeLists(List<T>... lists) {
        Class clazz = lists[0].getClass();
        List<T> list = null;
        try {
            list = (List<T>) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0, len = lists.length; i < len; i++) {
            list.addAll(lists[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("张三");
        list1.add("李四");
        list1.add("王五");
        List<String> list2 = new ArrayList<String>();
        list2.add("老张");
        list2.add("老李");
        list2.add("老王");
        /*List<String> list = new ArrayList<String>();
        list.addAll(list1);
        list.addAll(list2);*/
        List<String> list = mergeLists(new List[]{list1, list2});
        System.out.println(list);
    }
}
