package v1ch05.inherit_study.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by shucheng on 2018/5/3.
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<Object>();

    /**
     * 将一个obj转换为string，该string中列出了obj中的所有属性值
     * （用到了递归调用）
     * @param obj 需要查看的对象
     * @return 包含对象名及其所有属性名的字符串
     */
    public String toString(Object obj) {
        if (obj == null) return "null"; // 传入的是null，则返回字符串"null"

        if (visited.contains(obj)) return "...";
        visited.add(obj);

        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj; // 本身就是string的话，就直接返回

        if (cl.isArray()) { // 传入的是数组
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ","; // 第0个属性前面不加逗号
                Object val = Array.get(obj, i); // 获取数组中的第i个元素
                if (cl.getComponentType().isPrimitive()) r += val; // 数组元素为基本类型
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        // 检查类和所有父类中包含的属性
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields(); // 获取类本身声明的所有属性（包括公有、私有的）
            AccessibleObject.setAccessible(fields, true); // 获取所有属性的访问权限
            // 获取所有属性的名称和值
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }
}
