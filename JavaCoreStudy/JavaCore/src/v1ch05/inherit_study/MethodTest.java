package v1ch05.inherit_study;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by shucheng on 2018/4/21.
 */
public class MethodTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.FRANCE);

        GregorianCalendar calendar = new GregorianCalendar();
        Date time = calendar.getTime();
        System.out.println(time);

        /*GregorianCalendar calendar = new GregorianCalendar(2018, 4, 21);
        Date hireDay = calendar.getTime();
        System.out.println(hireDay);*/
    }
}
