package com.kittycoder.util;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by shucheng on 2018/7/7.
 **/
public class BeanUtil {

    /**
     * 将一个实体类中的多个属性复制到另外一个实体类中
     * @param source
     * @param target
     * @param includeProperties（键值对，键是需要复制的源属性，值是目标属性）
     * 使用示例：
     * Source source = new Source();
     * source.setSfield1("张三");
     * source.setSfield1("李四");
     * source.setSfield1("王五");
     * Target target = new Target();
     * Map<String, String> map = new HashMap<String, String>();
     * map.put("sfield1","tfield1");
     * map.put("sfield2","tfield2");
     * map.put("sfield3","tfield23");
     * BeanUtil.copyProperties(source,target,map);
     */
    public static void copyProperties(Object source, Object target, Map<String, String> includeProperties) {
        // 遍历出需要复制的属性
        Class sourceClazz = source.getClass();
        Class targetClazz = target.getClass();
        try {
            for (String key : includeProperties.keySet()) {
                String sourceFieldName = key;
                String targetFieldName = includeProperties.get(key);

                // 获取反射中的源属性和目标属性
                Field sourceField = sourceClazz.getDeclaredField(sourceFieldName);
                Field targetField = targetClazz.getDeclaredField(targetFieldName);
                sourceField.setAccessible(true);
                targetField.setAccessible(true);

                // 获取源属性的值
                Object sourceFieldValue = sourceField.get(source);

                // 给目标属性设置值
                targetField.set(target, sourceFieldValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
