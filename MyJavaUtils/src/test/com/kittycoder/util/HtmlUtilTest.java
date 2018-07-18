package com.kittycoder.util;

import com.kittycoder.po.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class HtmlUtilTest {

    // List中对象中的所有String属性取消转义
    @Test
    public void listHtmlUnEscape() {
    }

    // List中对象中的所有String属性添加转义
    @Test
    public void listHtmlEscape() {
    }

    // 对象中的所有String属性取消转义
    @Test
    public void objectHtmlUnEscape() {
        Student student = new Student();
        student.setSname("&copy;张三");
        HtmlUtil.objectHtmlUnEscape(student);
        System.out.println(student.getSname());
    }

    // 对象中的所有String属性添加转义
    @Test
    public void objectHtmlEscape() {
        Student student = new Student();
        student.setSname("©张三");
        HtmlUtil.objectHtmlEscape(student);
        System.out.println(student.getSname());
    }
}