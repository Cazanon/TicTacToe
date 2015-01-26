package es.art83.ticTacToe.models.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

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
                this.testCoordinateEntityRowColumn(i, j, new CoordinateEntity(i + "-" + j));
            }
        }
    }

    @Test
    public void testInDirectionCoordinateEntity() {
        final int[][][] PUT_INT_INT_SET = { { {0, 0}, {0, 1}}, { {1, 0}, {2, 0}},
                { {2, 0}, {0, 0}}, { {0, 0}, {0, 1}}, { {0, 1}, {0, 2}}, { {0, 2}, {0, 1}},
                { {0, 0}, {1, 0}}, { {0, 2}, {0, 1}}, { {1, 1}, {0, 0}}, { {0, 0}, {1, 0}},
                { {1, 1}, {0, 2}}, { {0, 0}, {2, 1}}};
        final DirectionModel[] PUT_DIRECTION_SET = {DirectionModel.IN_ROW,
                DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN, DirectionModel.IN_ROW,
                DirectionModel.IN_ROW, DirectionModel.IN_ROW, DirectionModel.IN_COLUMN,
                DirectionModel.IN_ROW, DirectionModel.IN_MAIN_DIAGONAL, DirectionModel.IN_COLUMN,
                DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.WITHOUT_DIRECTION};

        assert PUT_INT_INT_SET.length == PUT_DIRECTION_SET.length;
        for (int i = 0; i < PUT_DIRECTION_SET.length; i++) {
            assertEquals(PUT_DIRECTION_SET[i], new CoordinateEntity(PUT_INT_INT_SET[i][0][0],
                    PUT_INT_INT_SET[i][0][1]).inDirection(new CoordinateEntity(
                    PUT_INT_INT_SET[i][1][0], PUT_INT_INT_SET[i][1][1])));
        }
    }

    @Test
    public void testInDirectionCoordinateEntities() {
        final int[][][] PUT_INT_INT_SET = { { {0, 0}, {0, 1}, {0, 2}}, { {0, 0}, {1, 0}, {2, 0}},
                { {0, 0}, {1, 1}, {2, 2}}, { {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {2, 1}, {1, 2}},
                { {0, 1}, {1, 0}, {2, 2}}, { {0, 2}, {1, 0}, {2, 1}}, { {0, 0}, {0, 1}, {1, 1}},
                { {0, 0}, {1, 0}, {2, 2}}, { {0, 0}, {1, 2}, {2, 2}}, { {0, 2}, {1, 1}, {2, 1}},
                { {0, 0}, {2, 2}, {1, 2}}, { {1, 0}, {1, 1}, {1, 2}}, { {0, 1}, {1, 1}, {2, 1}},
                { {2, 2}, {2, 1}, {1, 1}}, { {2, 0}, {2, 1}, {2, 2}}, { {2, 2}, {1, 2}, {0, 2}},
                { {0, 2}, {2, 0}, {1, 1}}, { {0, 0}, {0, 1}, {0, 2}}};
        final DirectionModel[] PUT_DIRECTION_SET = {DirectionModel.IN_ROW,
                DirectionModel.IN_COLUMN, DirectionModel.IN_MAIN_DIAGONAL,
                DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.WITHOUT_DIRECTION,
                DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
                DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
                DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
                DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW, DirectionModel.IN_COLUMN,
                DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW, DirectionModel.IN_COLUMN,
                DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.IN_ROW};

        assert PUT_INT_INT_SET.length == PUT_DIRECTION_SET.length;
        for (int i = 0; i < PUT_DIRECTION_SET.length; i++) {
            CoordinateEntity coordinate = null;
            List<CoordinateEntity> coordinates = new ArrayList<CoordinateEntity>();
            for (int j = 0; j < PUT_INT_INT_SET[i].length; j++) {
                if (j == 0) {
                    coordinate = new CoordinateEntity(PUT_INT_INT_SET[i][j][0],
                            PUT_INT_INT_SET[i][j][1]);
                } else {
                    coordinates.add(new CoordinateEntity(PUT_INT_INT_SET[i][j][0],
                            PUT_INT_INT_SET[i][j][1]));
                }
            }
            assertEquals(PUT_DIRECTION_SET[i], coordinate.inDirection(coordinates));
        }
    }
    
    @Test
    public void testAllCoordinates() {
        List<CoordinateEntity> coordinates = CoordinateEntity.allCoordinates();
        for (int i = CoordinateEntity.MIN; i <= CoordinateEntity.MAX; i++) {
            for (int j = CoordinateEntity.MIN; j <= CoordinateEntity.MAX; j++) {
                CoordinateEntity coordinate = new CoordinateEntity(i,j);
                assertTrue(coordinates.contains(coordinate));
                coordinates.remove(coordinate);
            }
        }
        assertEquals(0, coordinates.size());
    }

}
