package spike;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PadreTest {

    @Before
    public void before() {
        System.out.println("padre: before");
    }

    @Test
    public void test1() {
        System.out.println("test1: padre");
    }

    @Test
    public void test2() {
        System.out.println("test2: padre");
    }

    @After
    public void after() {
        System.out.println("padre: after");
    }

}
