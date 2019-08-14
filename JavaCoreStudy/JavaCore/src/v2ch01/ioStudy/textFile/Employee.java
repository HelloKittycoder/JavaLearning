package v2ch01.ioStudy.textFile;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author: luoshucheng
 * @email: luoshucheng@datadriver.com.cn
 * @company: DataDriver
 * @data: 2018-11-27 下午 23:22
 * @Description TODO
 **/
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee() {
    }

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
                + "]";
    }
}
