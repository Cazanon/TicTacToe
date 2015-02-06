package es.art83.ticTacToe.controllers.ws;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CreateGameControllerWebServiceTest.class, LoginControllerWebServiceTest.class,
        LogoutControllerWebServiceTest.class, ShowGameControllerWebServiceTest.class})
public class AllTestsControllersWebService {

}
