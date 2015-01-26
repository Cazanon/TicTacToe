package es.art83.ticTacToe.models.entities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TurnEntityTest.class, CoordinateEntityTest.class, PieceEntityTest.class,
        BoardEntityTest.class})
public class AllTests {

}
