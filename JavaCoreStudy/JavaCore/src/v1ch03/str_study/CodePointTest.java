package v1ch03.str_study;

import java.util.Arrays;

/**
 * Created by shucheng on 2018/4/21.
 */
public class CodePointTest {
    public static void main(String[] args) {
        String greeting = "Hello";
        /*int n = greeting.length();
        System.out.println(n);

        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println("cpCount===" + cpCount);

        System.out.println(greeting.charAt(0));
        System.out.println(greeting.charAt(4))*/;

        /*for (int i = 0; i < greeting.length();) {
            int cp = greeting.codePointAt(i);
            System.out.println(cp);
            if (Character.isSupplementaryCodePoint(cp)) i+=2;
            else i++;
        }*/

        String dir = System.getProperty("user.dir"); // 在ide环境中定位当前项目的位置
        // System.out.println(dir);
        String[] a = new String[]{"张三", "李四", "王五"};
        System.out.println(Arrays.toString(a));
    }
}
