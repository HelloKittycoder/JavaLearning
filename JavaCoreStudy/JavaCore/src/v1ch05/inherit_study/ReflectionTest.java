package v1ch05.inherit_study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by shucheng on 2018/4/22.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        // 从用户输入中读取类名
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name(e.g.java.util.Date):");
            name = in.next();
        }
        try {
            // 打印类名和父类的名称（如果不是Object的话）
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers()); // 获取类的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (supercl != null && supercl != Object.class) {
                System.out.print(" extends " + supercl.getName());
            }
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 打印一个类的所有构造器
     * @param cl
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors(); // 获取类中所有声明的构造器
        for (Constructor c : constructors) {
            String name = c.getName(); // 获取构造器的名称
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers()); // 获取构造器前面的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // 打印参数类型
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印一个类中的所有方法
     * @param cl
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods(); // 获取类中所有声明的方法
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName(); // 获取方法的返回类型的名称

            System.out.print("  ");
            // 打印的方法的修饰符，返回类型，方法名
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            // 打印参数类型
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印一个类中的所有属性
     * @param cl
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields(); // 获取类中所有声明的属性

        for (Field f : fields) {
            Class type = f.getType(); // 获取属性本身所属的类
            String name = f.getName(); // 获取属性名称
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers()); // 获取属性前面的修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
