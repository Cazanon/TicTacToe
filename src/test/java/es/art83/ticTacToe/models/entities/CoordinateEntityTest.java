package es.art83.ticTacToe.models.entities;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoordinateEntityTest {

    private CoordinateEntityTestData data;

    @Before
    public void init() {
        data = new CoordinateEntityTestData();
    }
    
    @Test
    public void testCoordinateEntityIntInt() {
        while (data.hasNextCoordinate()) {
            CoordinateEntity coordinate = new CoordinateEntity(data.getCoordinate().getRow(), data.getCoordinate().getColumn());
            assertEquals(data.message(), data.getCoordinate(), coordinate);
            data.nextCoordinate();
        }
    }

    @Test
    public void testCoordinateEntityString() {
        while (data.hasNextCoordinate()) {
            CoordinateEntity coordinate = new CoordinateEntity(data.getStringCoordinate());
            assertEquals(data.message(), data.getStringCoordinate(), coordinate.toString());
            data.nextCoordinate();
        }
    }

    @Test
    public void testCoordinateEntity() {
        CoordinateEntity coordinate = new CoordinateEntity();
        assertEquals(data.message(), 0, coordinate.getRow());
        assertEquals(data.message(), 0, coordinate.getColumn());
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

    @Test
    public void testInDirectionCoordinateEntity() {
        while (data.hasNextCoordinate()) {
            CoordinateEntity coordinate = new CoordinateEntity(data.getCoordinate().getRow(), data.getCoordinate().getColumn());
            assertEquals(data.message(), data.getInDirection(), coordinate.inDirection(data.getInDirectionCoordinate()));
            data.nextCoordinate();
        }
    }

    @Test
    public void testInDirectionListOfCoordinateEntity() {
        while (data.hasNextCoordinate()) {
            CoordinateEntity coordinate = new CoordinateEntity(data.getCoordinate().getRow(), data.getCoordinate().getColumn());
            assertEquals(data.message(), data.getInDirectionList(), coordinate.inDirection(data.getInDirectionCoordinateList()));
            data.nextCoordinate();
        }
    }

    @Test
    public void testEqualsObject() {
        while (data.hasNextCoordinate()) {
            CoordinateEntity coordinate = new CoordinateEntity(data.getCoordinate().getRow(), data.getCoordinate().getColumn());
            assertEquals(data.message(), data.getEquals(), coordinate.equals(data.getEqualsCoordinate()));
            data.nextCoordinate();
        }
    }

}
