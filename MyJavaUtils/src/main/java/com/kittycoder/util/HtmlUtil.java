package com.kittycoder.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by shucheng on 2018-07-16 上午 0:11.
 * Html工具类
 **/
public class HtmlUtil {

    /**
     * 将list中包含对象的所有字符串属性取消转义
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> listHtmlUnEscape(List<T> list) {
        return listHtmlTextHandle(list, 0);
    }

    /**
     * 将list中包含对象的所有字符串属性添加转义
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> listHtmlEscape(List<T> list) {
        return listHtmlTextHandle(list, 1);
    }

    /**
     * 将对象中的所有字符串属性取消转义
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T objectHtmlUnEscape(T t) {
        return objectHtmlTextHandle(t, 0);
    }

    /**
     * 将对象中的所有字符串属性添加转义
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T objectHtmlEscape(T t) {
        return objectHtmlTextHandle(t, 1);
    }

    /**
     * list中的对象属性值批量html转义
     * @param list 需要做转义操作的list
     * @param option 0 取消转义 1 转义
     * @param <T>
     * @return
     */
    public static <T> List<T> listHtmlTextHandle(List<T> list, int option) {
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            list.remove(i); // 先移除原有的对象
            t = 0 == option ? objectHtmlUnEscape(t) : objectHtmlEscape(t);
            list.add(i, t); // 再将取消转义后的对象添加到list对应位置
        }
        return list;
    }

    /**
     * 对象属性值批量html转义
     * @param t 需要做转义操作的对象
     * @param option 0 取消转义 1 转义
     * @param <T>
     * @return
     */
    public static <T> T objectHtmlTextHandle(T t, int option) {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            if (type.equals(String.class)) {
                field.setAccessible(true);
                try {
                    String filedValue = (String) field.get(t);
                    // 进行取消转义（0），转义（1）操作
                    filedValue = 0 == option ? htmlUnescape(filedValue) : htmlEscape(filedValue);
                    field.set(t, filedValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return t;
    }

    /**
     * Spring的HtmlUtils进行转义
     */
    public static String htmlEscape(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        } else {
            return HtmlUtils.htmlEscape(str);
        }
    }

    /**
     * Spring的HtmlUtils进行还原
     */
    public static String htmlUnescape(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        } else {
            return HtmlUtils.htmlUnescape(str);
        }
    }
}
