package v1ch05.inherit_study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by shucheng on 2018/5/2.
 */
public class MyReflectTest {

    public static void main(String[] args) throws Exception {
        // String className = "po.Student";
        String className = "java.util.Date";

        Class clazz = Class.forName(className);
        printConstructors(clazz);
        printMethods(clazz);
        printFields(clazz);
    }

    /**
     * 打印类的所有构造器
     * @param cl
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            // System.out.print(constructor);
            String modiferName = Modifier.toString(constructor.getModifiers()); // 构造器的修饰符
            System.out.print(modiferName + " ");
            String className = constructor.getDeclaringClass().getName(); // 构造器所在类的类名
            System.out.print(className+"(");
            Class[] paramTypes = constructor.getParameterTypes(); // 构造器的参数列表
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getName());
                if (i != paramTypes.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(")");
            System.out.println();
        }
    }

    /**
     * 打印类的所有方法
     * @param cl
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            String modifierName = Modifier.toString(method.getModifiers()); // 方法的修饰符
            System.out.print(modifierName + " ");
            Class returnType = method.getReturnType(); // 方法的返回类型
            System.out.print(returnType.getName() + " ");
            String methodName = method.getName(); // 方法名称
            System.out.print(methodName);
            System.out.print("(");
            Class[] paramTypes = method.getParameterTypes(); // 方法的参数列表
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getName());
                if (i != paramTypes.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(")");
            // System.out.print(method);
            System.out.println();
        }
    }

    /**
     * 打印类的所有属性
     * @param cl
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            String modifierName = Modifier.toString(field.getModifiers()); // 属性的修饰符
            System.out.print(modifierName + " ");
            Class type = field.getType(); // 属性本身的类型
            System.out.print(type.getName() + " ");
            String fieldName = field.getName(); // 属性名称
            System.out.print(fieldName);
            // System.out.print(field);
            System.out.println();
        }
    }
}
