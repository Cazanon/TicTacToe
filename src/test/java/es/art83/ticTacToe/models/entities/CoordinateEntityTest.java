package es.art83.ticTacToe.models.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import es.art83.ticTacToe.models.utils.DirectionModel;

public class CoordinateEntityTest {

    @Test
    public void testCoordinateEntity() {
        this.testCoordinateEntityRowColumn(CoordinateEntity.MIN, CoordinateEntity.MIN,
                new CoordinateEntity());
    }

    private void testCoordinateEntityRowColumn(int row, int column, CoordinateEntity coordinate) {
        assertEquals(row, coordinate.getRow());
        assertEquals(column, coordinate.getColumn());
    }

    @Test
    public void testCoordinateEntityIntInt() {
        for (int i = CoordinateEntity.MIN; i < CoordinateEntity.MAX; i++) {
            for (int j = CoordinateEntity.MIN; j < CoordinateEntity.MAX; j++) {
                this.testCoordinateEntityRowColumn(i, j, new CoordinateEntity(i, j));
            }
        }
    }
    
    @Test
    public void testCoordinateEntityString() {
        for (int i = CoordinateEntity.MIN; i < CoordinateEntity.MAX; i++) {
            for (int j = CoordinateEntity.MIN; j < CoordinateEntity.MAX; j++) {
                this.testCoordinateEntityRowColumn(i, j, new CoordinateEntity(i+"-"+j));
            }
        }
    }
    
    @Test
    public void testDirectionCoordinateEntity() {
        final CoordinateEntity[][] COORDINATES = {
                {new CoordinateEntity(0,0), new CoordinateEntity(0,1)},
                {new CoordinateEntity(0,0), new CoordinateEntity(1,2)}
        };
        final DirectionModel[] DIRECTIONS = {
                DirectionModel.IN_ROW,
                DirectionModel.WITHOUT_DIRECTION
        };
        assert COORDINATES.length == DIRECTIONS.length;
        for (int i = 0; i < COORDINATES.length; i++) {
            assertEquals(DIRECTIONS[i], COORDINATES[i][0].direction(COORDINATES[i][1]));
        }
    }
    
    @Test
    public void testDirectionCoordinateEntities() {
        final CoordinateEntity[][][] COORDINATES = {
                {{new CoordinateEntity(0,0)}, {new CoordinateEntity(0,1), new CoordinateEntity(0,2)}},
                {{new CoordinateEntity(0,0)}, {new CoordinateEntity(1,2), new CoordinateEntity(2,1)}}
        };
        final DirectionModel[] DIRECTIONS = {
                DirectionModel.IN_ROW,
                DirectionModel.WITHOUT_DIRECTION
        };
        assert COORDINATES.length == DIRECTIONS.length;
        for (int i = 0; i < COORDINATES.length; i++) {
            assertEquals(DIRECTIONS[i], COORDINATES[i][0][0].direction(COORDINATES[i][1]));
        }
    }
    
}
