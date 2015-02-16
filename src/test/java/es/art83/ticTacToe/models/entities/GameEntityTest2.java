package es.art83.ticTacToe.models.entities;

import org.junit.Test;

import es.art83.ticTacToe.utils.DependenceTest;

public class GameEntityTest2 {

    @Test
    public void testDependence() {
        new DependenceTest(GameEntity.class).test();
    }

}
