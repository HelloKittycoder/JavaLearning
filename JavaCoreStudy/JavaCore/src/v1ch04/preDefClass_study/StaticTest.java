package v1ch04.preDefClass_study;

import java.text.NumberFormat;

/**
 * Created by shucheng on 2018/4/21.
 */
public class StaticTest {
    public static void main(String[] args) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        double x = 0.1;
        System.out.println(currencyFormatter.format(x));
        System.out.println(percentFormatter.format(x));
    }
}
