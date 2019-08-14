package v1ch05.inherit_study.objectAnalyzer;

import java.util.ArrayList;

/**
 * Created by shucheng on 2018/5/3.
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
