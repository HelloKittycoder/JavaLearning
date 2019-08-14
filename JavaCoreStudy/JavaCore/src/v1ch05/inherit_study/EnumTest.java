package v1ch05.inherit_study;

import java.util.Arrays;

/**
 * Created by shucheng on 2018/4/22.
 */
public class EnumTest {
    public static void main(String[] args) {
        String input = "SMALL";
        // 返回枚举变量的名称
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        System.out.println(size == Size.SMALL);
        System.out.println(Arrays.toString(Size.values()));
    }
}

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
