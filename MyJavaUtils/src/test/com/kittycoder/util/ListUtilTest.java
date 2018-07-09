package com.kittycoder.util;

import com.kittycoder.po.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shucheng on 2018/7/09 20:07.
 **/
public class ListUtilTest {

    /**
     * 测试合并多个list
     */
    @Test
    public void testMergeLists() {
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
        List<String> list = ListUtil.mergeLists(new List[]{list1, list2});
        System.out.println(list);
    }

    /**
     * 测试将list中对象的属性转换至字符串Map中
     */
    @Test
    public void testListPropToStrMap() {
        List<Student> studentList = new ArrayList<Student>();
        Student s = new Student();
        s.setSid("101");
        s.setSname("张三");
        studentList.add(s);

        s = new Student();
        s.setSid("102");
        s.setSname("李四");
        studentList.add(s);

        s = new Student();
        s.setSid("103");
        s.setSname("王五");
        studentList.add(s);

        Map<String, String> map1 = ListUtil.listPropToStrMap(studentList, new String[]{"sid", "sname"});
        Map<String, String> map2 = ListUtil.listPropToStrMap(studentList, new String[]{"sname", "sid"});
        System.out.println(map1);
        System.out.println(map2);
    }
}
