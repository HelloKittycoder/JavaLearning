import org.junit.Test;

/**
 * Created by shucheng on 2018/4/29.
 * 在StringBuffer中替换字符串
 * 01 replaceFirst 替换首字符
 * 02 replaceAll 替换所有字符
 */
public class StringBufferTest {

    private static String testString = "insert into student ('id','name','age','sex','regtime')";

    /**
     * 单个字符替换，将单引号替换为空字符串
     */
    @Test
    public void test1() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);

        // 替换目标
        String target = "'";
        // 替换结果
        String replacement = "";

        // 1.查找字符串中是否存在替换目标，不存在为-1
        int index = sb.indexOf(target);
        // 2.如果存在替换目标，则进行替换操作
        if (index != -1) {
            sb.replace(index, index + 1, replacement);
        }
        System.out.println(sb.toString());
    }

    /**
     * 单个字符替换，将单词student替换为mate
     */
    @Test
    public void test2() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);

        // 替换目标
        String target = "student";
        // 替换结果
        String replacement = "mate";

        // 1.查找字符串中是否存在替换目标，不存在为-1
        int index = sb.indexOf(target);
        // 2.如果存在替换目标，则进行替换操作（这里的7是替换目标的字符长度）
        if (index != -1) {
            sb.replace(index, index + 7, replacement);
        }
        System.out.println(sb.toString());
    }

    /**
     * 替换首个出现的字符（基于test1和test2进行封装）
     * @param sb
     * @param target
     * @param replacement
     * @return
     */
    public StringBuffer replaceFirst(StringBuffer sb, String target, String replacement) {
        // 1.查找字符串中是否存在替换目标，不存在为-1
        int index = sb.indexOf(target);
        // 2.如果存在替换目标，则进行替换操作（这里的7是替换目标的字符长度）
        if (index != -1) {
            sb.replace(index, index + target.length(), replacement);
        }
        return sb;
    }

    //==============================================================================================
    //使用封装过的方法改写test1和test2
    //==============================================================================================
    @Test
    public void test1_new() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);

        replaceFirst(sb, "'", "");
        System.out.println(sb);
    }

    @Test
    public void test2_new() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);

        replaceFirst(sb, "student", "mate");
        System.out.println(sb);
    }

    /**
     * 所有字符替换，将单引号替换为空字符串
     */
    @Test
    public void test3() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);

        String target = "'";
        String replacement = "";

        int index = -1;

        // 1.查找字符串中是否存在替换目标，不存在为-1
        while ((index = sb.indexOf(target)) != -1) {
            // 2.如果存在替换目标，则进行替换操作
            sb.replace(index, index + 1, replacement);
        }
        System.out.println(sb.toString());
    }

    /**
     * 单个字符替换，将单词student替换为mate
     */
    @Test
    public void test4() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);

        String target = "student";
        String replacement = "mate";

        int index = -1;

        // 1.查找字符串中是否存在替换目标，不存在为-1
        while ((index = sb.indexOf(target)) != -1) {
            // 2.如果存在替换目标，则进行替换操作
            sb.replace(index, index + 7, replacement);
        }
        System.out.println(sb.toString());
    }

    /**
     * 替换所有出现的字符（基于test3和test4进行封装）
     * @param sb
     * @param target
     * @param replacement
     * @return
     */
    public StringBuffer replaceAll(StringBuffer sb, String target, String replacement) {
        int index = -1;
        // 1.查找字符串中是否存在替换目标，不存在为-1

        while ((index = sb.indexOf(target)) != -1) {
            // 2.如果存在替换目标，则进行替换操作（这里的7是替换目标的字符长度）
            sb.replace(index, index + target.length(), replacement);
        }
        return sb;
    }

    //==============================================================================================
    //使用封装过的方法改写test3和test4
    //==============================================================================================
    @Test
    public void test3_new() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);
        replaceAll(sb, "'", "");
        System.out.println(sb.toString());
    }

    @Test
    public void test4_new() {
        StringBuffer sb = new StringBuffer();
        sb.append(testString);
        replaceAll(sb, "student", "mate");
        System.out.println(sb.toString());
    }
}
