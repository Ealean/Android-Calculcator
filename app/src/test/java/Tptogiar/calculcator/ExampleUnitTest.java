package Tptogiar.calculcator;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void TestPattern(){
//
        Pattern compile = Pattern.compile( "^(\\-|\\+)?\\d+(\\.\\d+)?$");
        String a="+45.5";
        boolean matches = compile.matcher(a).matches();
        System.out.println(matches);
        String result = compile.matcher(a).replaceAll("");
        System.out.println(result);


    }


}