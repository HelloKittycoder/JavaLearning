package com.kittycoder.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 将list中对象的两个属性批量转换至map中（支持字符串属性）
     * @param list
     * @param listProp
     * @param <T>
     * @return
     */
    public static <T> Map<String, String> listPropToStrMap(List<T> list, String[] listProp) {
        Map<String, String> map = new HashMap<String, String>();
        String fieldOne = listProp[0]; // 属性名称1
        String fieldTwo = listProp[1]; // 属性名称2
        Class clazz = list.get(0).getClass();
        try {
            Field field1 = clazz.getDeclaredField(fieldOne);
            Field field2 = clazz.getDeclaredField(fieldTwo);
            field1.setAccessible(true);
            field2.setAccessible(true);
            for (T t : list) {
                map.put(field1.get(t) + "", field2.get(t) + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
