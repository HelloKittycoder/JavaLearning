package com.kittycoder.util;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by shucheng on 2018/6/16 21:28.
 **/
public class MapUtil {

    /**
     * 合并多个map
     * @param maps
     * @param <K>
     * @param <V>
     * @return
     * @throws Exception
     */
    public static <K, V> Map mergeMaps(Map<K, V>... maps) {
        Class clazz = maps[0].getClass(); // 获取传入map的类型
        Map<K, V> map = null;
        try {
            map = (Map) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0, len = maps.length; i < len; i++) {
            map.putAll(maps[i]);
        }
        return map;
    }

    /**
     * Map中根据key批量删除键值对
     * @param map
     * @param excludeKeys
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map removeEntries(Map<K, V> map, K[] excludeKeys) {
        Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            K k = iterator.next();
            // 如果k刚好在要排除的key的范围中
            if (ArrayUtils.contains(excludeKeys, k)) {
                iterator.remove();
                map.remove(k);
            }
        }
        return map;
    }

    /**
     * 将map转换为object，转换全部属性（按照key和对象属性之间的关系进行转换）
     * @param map
     * @param t
     * @param <T>
     * @return
     */
    public static <T, K, V> T  mapToObject(Map<K, V> map, T t) {
        return mapToObject(map, t, null, 0);
    }

    /**
     * 将map转换为object，排除指定key
     * @param map
     * @param t
     * @param keys
     * @param <T>
     * @return
     */
    public static <T, K, V> T  mapToObjectExclude(Map<K, V> map, T t, K[] keys) {
        return mapToObject(map, t, keys, 0);
    }

    /**
     * 将map转换为object，转换指定key
     * @param map
     * @param t
     * @param keys
     * @param <T>
     * @return
     */
    public static <T, K, V> T  mapToObjectInclude(Map<K, V> map, T t, K[] keys) {
        return mapToObject(map, t, keys, 1);
    }


    /**
     * 将map转换为object
     * @param map
     * @param t
     * @param keys
     * @param option 0 需要排除的key；1 需要包含的key
     * @param <T>
     * @return
     */
    public static <T, K, V> T  mapToObject(Map<K, V> map, T t, K[] keys, int option) {
        Class beanClass = t.getClass();
        String[] declaredFieldsName = getDeclaredFieldsName(beanClass);
        Set<K> keySet = new HashSet<K>();
        switch (option) {
            case 0: // 需要排除的key
                if (ArrayUtils.isNotEmpty(keys)) {
                    MapUtil.removeEntries(map, keys);
                }
                keySet = map.keySet();
                break;
            case 1: // 需要包含的key
                keySet = new HashSet<K>(Arrays.asList(keys));
                break;
        }

        for (Object k : keySet) {
            V v = map.get(k);
            if (ArrayUtils.contains(declaredFieldsName, k.toString())) {
                try {
                    Field field = beanClass.getDeclaredField(k.toString());
                    field.setAccessible(true);
                    field.set(t, v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return t;
    }

    /**
     * 获取指定类的所有属性名，包括公有属性和私有属性名称
     * @param beanClass
     * @return
     */
    public static String[] getDeclaredFieldsName(Class beanClass) {
        // Field[] fields = Approval.class.getDeclaredFields();
        Field[] fields = beanClass.getDeclaredFields();
        int size = fields.length;
        String[] fieldsName = new String[size];
        for (int i = 0; i < size; i++) {
            fieldsName[i] = fields[i].getName();
        }
        return fieldsName;
    }

    /**
     *
     * @Title: objectToMap
     * @Description: 将object转换为map，默认不保留空值
     * @param @param obj
     * @param @return 设定文件
     * @return Map<String,Object> 返回类型
     * @throws
     */
    public static Map objectToMap(Object obj) {

        Map<String, Object> map = new HashMap<String, Object>();
        map = objectToMap(obj, false);
        return map;
    }

    /**
     * 将object转换为map
     * @param obj
     * @param keepNullVal 转换时是否保留空值
     * @return
     */
    public static Map objectToMap(Object obj, boolean keepNullVal) {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (keepNullVal == true) {
                    map.put(field.getName(), field.get(obj));
                } else {
                    if (field.get(obj) != null && !"".equals(field.get(obj).toString())) {
                        map.put(field.getName(), field.get(obj));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>(){{
            put("1", "a");
            put("2", "b");
            put("3", "c");
        }};
        Map<String, String> map2 = new HashMap<String, String>(){{
            put("test1", "张三");
            put("test2", "李四");
            put("test3", "王五");
        }};
        /*Map<String, String> resultMap = new LinkedHashMap<String, String>(){{
            putAll(map1);
            putAll(map2);
        }};
        System.out.println(resultMap);*/
        // 合并多个map
        Map<String, String> resultMap = MapUtil.mergeMaps(new Map[]{map1, map2});
        System.out.println(resultMap);
    }
}
