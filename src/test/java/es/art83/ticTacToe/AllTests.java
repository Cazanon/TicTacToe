package es.art83.ticTacToe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.art83.ticTacToe.controllers.webService.AllTestsControllersWebService;
import es.art83.ticTacToe.webService.AllTestsWebService;

@RunWith(Suite.class)
@SuiteClasses({AllTestsWebService.class, AllTestsControllersWebService.class})
public class AllTests {

}
