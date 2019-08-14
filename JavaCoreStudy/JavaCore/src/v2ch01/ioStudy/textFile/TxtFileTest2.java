package v2ch01.ioStudy.textFile;

import org.junit.Test;
import po.Student;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shucheng on 2019-8-14 上午 11:03
 * 仿照TxtFileTest另外写的
 */
public class TxtFileTest2 {

    @Test
    public void test1() {
        List<Student> list = generateStudentList();
        // 向文件中写数据
        // 写法1：
        /*PrintWriter out = null;
        try {
            out = new PrintWriter("student.dat", "UTF-8");
            writeData(list, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }*/

        // 写法2：
        try (PrintWriter out = new PrintWriter("student.dat", "UTF-8")) {
            writeData(list, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 从文件中读数据
        // 写法1：
        /*Scanner in = null;
        try {
            in = new Scanner(new FileInputStream("student.dat"), "UTF-8");
            List<Student> list1 = readData(in);
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }*/

        // 写法2：
        try (Scanner in = new Scanner(new FileInputStream("student.dat"), "UTF-8")) {
            List<Student> list1 = readData(in);
            System.out.println(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeData(List<Student> studentList, PrintWriter out) {
        for (Student student : studentList) {
            writeStudent(student, out);
        }
    }

    public void writeStudent(Student student, PrintWriter out) {
        out.println(student.getSid() + "|" + student.getSname() + "|" + student.getSage());
    }

    public List<Student> readData(Scanner in) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(readStudent(in));
        }
        return list;
    }

    public Student readStudent(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String sid = tokens[0];
        String sname = tokens[1];
        int sage = Integer.parseInt(tokens[2]);
        return new Student(sid, sname, sage);
    }

    public List<Student> generateStudentList() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("101", "张三", 10));
        list.add(new Student("102", "李四", 20));
        list.add(new Student("103", "王五", 30));
        return list;
    }
}
