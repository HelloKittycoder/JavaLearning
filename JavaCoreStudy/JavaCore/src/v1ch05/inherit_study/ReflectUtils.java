package v1ch05.inherit_study;

import po.Student;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shucheng on 2018/5/2.
 * 自己尝试写的Object转Map的工具类
 */
public class ReflectUtils {

    public static Map<String, Object> ObjectToMap(Object o) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Class clazz = o.getClass();
        // 获取对象中的所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            Object fieldValue = field.get(o);
            String fieldName = field.getName();
            map.put(fieldName, fieldValue);
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("1", "张三", 10);
        Map<String, Object> map = ObjectToMap(student);
        System.out.println(map);
    }
}
