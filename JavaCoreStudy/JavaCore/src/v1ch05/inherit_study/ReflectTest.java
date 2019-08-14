package v1ch05.inherit_study;

import po.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by shucheng on 2018/5/2.
 * 反射方法测试
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            // testConstructor();
            // testMethod();
            testField();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 学习Constructor类
     * @throws Exception
     */
    public static void testConstructor() throws Exception {
        Constructor[] constructors = Student.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.print("构造器的名称为：=======" + constructor.getName());
            System.out.print("构造器为：====" + constructor);
            System.out.print("构造器的修饰符为：=====" + Modifier.toString(constructor.getModifiers()));
            System.out.println();
        }

        // 获取无参构造方法
        Constructor c1 = Student.class.getDeclaredConstructor();
        Student student1 = (Student) c1.newInstance();
        student1.setSid("1");
        student1.setSname("张三");
        student1.setSage(10);
        System.out.println(student1);

        // 获取指定的有参构造方法
        Constructor c2 = Student.class.getDeclaredConstructor(String.class, String.class, int.class);
        Student student2 = (Student) c2.newInstance(new Object[]{"2", "李四", 20});
        System.out.println(student2);

        System.out.println("****************************************************************");
    }

    /**
     * 学习Method类
     */
    public static void testMethod() throws Exception {
        Method[] methods = Student.class.getMethods();
        for (Method method : methods) {
            System.out.print("方法的名称为：========" + method.getName());
            System.out.print("方法为：========" + method);
            System.out.println("方法的修饰符为：=======" + Modifier.toString(method.getModifiers()));
            System.out.println();
        }

        // 通过反射调用方法
        // 1.通过名称加载类，然后将类实例化
        Class clazz = Class.forName("po.Student");
        Student student = (Student) clazz.newInstance();

        // 2.获取到类中的方法，通过反射进行调用
        Method method = clazz.getDeclaredMethod("setSid", String.class);
        method.invoke(student, "1");
        method = clazz.getDeclaredMethod("setSname", String.class);
        method.invoke(student, "张三");
        method = clazz.getDeclaredMethod("setSage", int.class);
        method.invoke(student, 10);
        System.out.println(student);
        System.out.println("****************************************************************");
    }

    /**
     * 学习Field类
     */
    public static void testField() throws Exception {
        Field[] fields = Student.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.print("属性的名称为：======" + field.getName());
            System.out.print("属性为：======" + field);
            System.out.print("属性的修饰符为：======" + Modifier.toString(field.getModifiers()));
            System.out.println();
        }
    }

    /**
     * 传入Object类，打印类名
     * @param o
     */
    public static void printClassName(Object o) {
        Class cl = o.getClass(); // 获取传入的类中包含的Class信息
        String className = cl.getName(); // 获取Class中包含的类名信息
        System.out.println(className);
    }
}
