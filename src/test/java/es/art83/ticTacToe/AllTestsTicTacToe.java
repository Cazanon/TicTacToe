package es.art83.ticTacToe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.art83.ticTacToe.controllers.ws.AllTestsControllersWebService;
import es.art83.ticTacToe.ws.AllTestsWs;

@RunWith(Suite.class)
@SuiteClasses({AllTestsWs.class, AllTestsControllersWebService.class})
public class AllTestsTicTacToe {

}
