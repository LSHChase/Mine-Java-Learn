
import com.me.note.test.TestStatic;
import org.junit.Test;

public class test{
    @Test
    public void print(){
        System.out.println("Hello JUnit test.");
    }

    @Test
    public void function(){
        TestStatic testStatic = new TestStatic();
        testStatic.testFunction();
    }
}
