package es.art83.ticTacToe.controllers.webService;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CreateControllerWSClientTest.class, LoginControllerWSClientTest.class,
        LogoutControllerWSClientTest.class, ShowGameControllerWSClientTest.class})
public class AllTestsWSClient {

}
