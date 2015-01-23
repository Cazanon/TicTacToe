package spike;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HijoTest extends PadreTest{

    @Before
    public void before() {
        System.out.println("hijo: before");
    }

    @Test
    public void test11() {
        System.out.println("test1: hijo");
    }

    @Test
    public void test22() {
        System.out.println("test2: hijo");
    }

    @After
    public void after() {
        System.out.println("hijo: after");
    }

}
