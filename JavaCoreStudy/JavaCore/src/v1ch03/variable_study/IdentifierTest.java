package v1ch03.variable_study;

/**
 * Created by shucheng on 2018/4/8.
 */
public class IdentifierTest {
    public static void main(String[] args) {
        // 查看哪些Unicode字符属于Java中的“字母”
        System.out.println(Character.isJavaIdentifierStart((char)'?'));
        System.out.println(Character.isJavaIdentifierPart((char)'a'));
    }
}
