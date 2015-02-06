package es.art83.ticTacToe.ws;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PlayerResourceTest.class, SessionGameResourceTest.class,
        SessionPlayerResourceTest.class, SessionResourceTest.class, GameResourceTest.class})
public class AllTestsWs {

}
