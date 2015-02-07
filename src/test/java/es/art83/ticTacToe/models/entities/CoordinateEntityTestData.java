package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.DirectionModel;
import es.art83.ticTacToe.utils.ArrayToListTransformer;

public class CoordinateEntityTestData {

    private static final int[][] INT_INT_COORDINATE = { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1},
            {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0},
            {2, 1}, {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2},
            {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 0}, {0, 1},
            {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0},
            {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1},
            {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 0},
            {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {1, 1}};

    private static final String[] STRING_COORDINATE = {"0-0", "0-1", "0-2", "1-0", "1-1", "1-2",
            "2-0", "2-1", "2-2", "0-0", "0-1", "0-2", "1-0", "1-1", "1-2", "2-0", "2-1", "2-2",
            "0-0", "0-1", "0-2", "1-0", "1-1", "1-2", "2-0", "2-1", "2-2", "0-0", "0-1", "0-2",
            "1-0", "1-1", "1-2", "2-0", "2-1", "2-2", "0-0", "0-1", "0-2", "1-0", "1-1", "1-2",
            "2-0", "2-1", "2-2", "0-0", "0-1", "0-2", "1-0", "1-1", "1-2", "2-0", "2-1", "2-2",
            "0-0", "0-1", "0-2", "1-0", "1-1", "1-2", "2-0", "2-1", "2-2", "0-0", "0-1", "0-2",
            "1-0", "1-1", "1-2", "2-0", "2-1", "2-2", "0-0", "0-1", "0-2", "1-0", "1-1", "1-2",
            "2-0", "2-1", "2-2", "0-0", "0-1", "0-2", "1-0", "1-1", "1-2", "2-0", "2-1", "2-2",
            "0-0", "0-1", "0-2", "1-0", "1-1", "1-2", "2-0", "2-1", "2-2", "1-1"};

    private static final int[][] IN_DIRECTION_COORDINATE = { {0, 1}, {1, 0}, {1, 2}, {1, 2},
            {1, 0}, {2, 0}, {2, 1}, {0, 1}, {1, 1}, {1, 0}, {2, 2}, {1, 0}, {1, 2}, {1, 2}, {1, 0},
            {0, 0}, {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 0}, {1, 1}, {0, 2}, {2, 1}, {2, 1}, {1, 0},
            {2, 0}, {1, 0}, {1, 0}, {0, 0}, {1, 1}, {2, 1}, {0, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1},
            {1, 1}, {1, 2}, {0, 0}, {0, 1}, {1, 0}, {1, 2}, {1, 2}, {1, 0}, {2, 0}, {2, 1}, {0, 1},
            {1, 1}, {1, 0}, {2, 2}, {1, 0}, {1, 2}, {1, 2}, {1, 0}, {0, 0}, {1, 1}, {0, 0}, {0, 2},
            {2, 0}, {0, 0}, {1, 1}, {0, 2}, {2, 1}, {2, 1}, {1, 0}, {2, 0}, {1, 0}, {1, 0}, {0, 0},
            {1, 1}, {2, 1}, {0, 1}, {1, 1}, {1, 1}, {1, 1}, {2, 0}, {1, 1}, {1, 2}, {0, 0}, {0, 1},
            {1, 0}, {1, 2}, {1, 2}, {0, 0}, {2, 0}, {2, 1}, {0, 1}, {1, 1}, {1, 0}, {2, 2}, {1, 0},
            {1, 2}, {1, 2}, {1, 0}, {0, 0}, {1, 1}, {0, 0}, {0, 2}, {1, 0}};

    private static final DirectionModel[] IN_DIRECTION = {DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN, DirectionModel.IN_ROW,
            DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW,
            DirectionModel.IN_COLUMN, DirectionModel.IN_MAIN_DIAGONAL, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_ROW, DirectionModel.IN_ROW, DirectionModel.IN_ROW,
            DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN, DirectionModel.IN_MAIN_DIAGONAL,
            DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.IN_ROW,
            DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW,
            DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW,
            DirectionModel.IN_ROW, DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.IN_COLUMN,
            DirectionModel.IN_MAIN_DIAGONAL, DirectionModel.IN_MAIN_DIAGONAL,
            DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN,
            DirectionModel.IN_COLUMN, DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN, DirectionModel.IN_ROW,
            DirectionModel.IN_ROW, DirectionModel.IN_ROW, DirectionModel.IN_COLUMN,
            DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.IN_COLUMN, DirectionModel.IN_ROW, DirectionModel.IN_SECONDARY_DIAGONAL,
            DirectionModel.IN_COLUMN, DirectionModel.IN_SECONDARY_DIAGONAL,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN,
            DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN, DirectionModel.IN_ROW,
            DirectionModel.IN_ROW, DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN,
            DirectionModel.IN_ROW, DirectionModel.IN_ROW, DirectionModel.IN_COLUMN,
            DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.IN_ROW,
            DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN,
            DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_MAIN_DIAGONAL,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN, DirectionModel.IN_ROW,
            DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_SECONDARY_DIAGONAL, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_COLUMN, DirectionModel.IN_ROW};

    private static final int[][][] IN_DIRECTION_LIST_COORDINATES = { { {0, 1}, {0, 2}},
            { {1, 0}, {1, 1}}, { {1, 2}, {2, 2}}, { {1, 2}, {0, 1}}, { {1, 0}, {1, 2}},
            { {2, 0}, {2, 1}}, { {2, 1}, {2, 2}}, { {0, 1}, {1, 1}}, { {1, 1}, {1, 2}},
            { {1, 0}, {2, 0}}, { {2, 2}, {2, 0}}, { {1, 0}, {2, 1}}, { {1, 2}, {1, 1}},
            { {1, 2}, {2, 1}}, { {1, 0}, {2, 0}}, { {0, 0}, {1, 0}}, { {1, 1}, {0, 1}},
            { {0, 0}, {1, 1}}, { {0, 2}, {0, 1}}, { {2, 0}, {2, 1}}, { {2, 0}, {1, 2}},
            { {1, 1}, {2, 2}}, { {0, 2}, {2, 0}}, { {2, 1}, {1, 0}}, { {2, 1}, {0, 0}},
            { {1, 0}, {1, 2}}, { {2, 0}, {2, 1}}, { {1, 0}, {1, 1}}, { {1, 0}, {2, 2}},
            { {0, 0}, {0, 1}}, { {1, 1}, {1, 2}}, { {2, 1}, {1, 0}}, { {0, 1}, {2, 0}},
            { {1, 1}, {0, 2}}, { {1, 1}, {0, 2}}, { {1, 1}, {0, 0}}, { {1, 1}, {2, 2}},
            { {1, 1}, {2, 1}}, { {1, 2}, {2, 2}}, { {0, 0}, {2, 1}}, { {0, 1}, {2, 2}},
            { {1, 0}, {1, 1}}, { {1, 2}, {1, 0}}, { {1, 2}, {2, 0}}, { {1, 0}, {2, 0}},
            { {2, 0}, {2, 1}}, { {2, 1}, {1, 1}}, { {0, 1}, {2, 1}}, { {1, 1}, {2, 0}},
            { {1, 0}, {1, 2}}, { {2, 2}, {0, 1}}, { {1, 0}, {1, 1}}, { {1, 2}, {0, 1}},
            { {1, 2}, {2, 1}}, { {1, 0}, {1, 2}}, { {0, 0}, {2, 2}}, { {1, 1}, {2, 0}},
            { {0, 0}, {2, 0}}, { {0, 2}, {0, 0}}, { {2, 0}, {1, 0}}, { {0, 0}, {2, 1}},
            { {1, 1}, {0, 1}}, { {0, 2}, {1, 2}}, { {2, 1}, {0, 1}}, { {2, 1}, {1, 2}},
            { {1, 0}, {2, 2}}, { {2, 0}, {0, 0}}, { {1, 0}, {0, 2}}, { {1, 0}, {0, 2}},
            { {0, 0}, {1, 1}}, { {1, 1}, {2, 2}}, { {2, 1}, {0, 1}}, { {0, 1}, {1, 2}},
            { {1, 1}, {2, 1}}, { {1, 1}, {2, 2}}, { {1, 1}, {1, 2}}, { {2, 0}, {1, 2}},
            { {1, 1}, {2, 0}}, { {1, 2}, {1, 0}}, { {0, 0}, {1, 2}}, { {0, 1}, {1, 1}},
            { {1, 0}, {2, 1}}, { {1, 2}, {2, 0}}, { {1, 2}, {1, 0}}, { {0, 0}, {0, 1}},
            { {2, 0}, {0, 2}}, { {2, 1}, {0, 1}}, { {0, 1}, {2, 1}}, { {1, 1}, {1, 2}},
            { {1, 0}, {1, 1}}, { {2, 2}, {2, 0}}, { {1, 0}, {2, 1}}, { {1, 2}, {0, 0}},
            { {1, 2}, {1, 1}}, { {1, 0}, {2, 1}}, { {0, 0}, {1, 1}}, { {1, 1}, {2, 2}},
            { {0, 0}, {0, 1}}, { {0, 2}, {1, 2}}, { {1, 0}, {0, 2}}};

    private static final DirectionModel[] IN_DIRECTION_LIST = {DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN,
            DirectionModel.IN_MAIN_DIAGONAL, DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_SECONDARY_DIAGONAL,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_ROW, DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_SECONDARY_DIAGONAL,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_MAIN_DIAGONAL,
            DirectionModel.IN_MAIN_DIAGONAL, DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_ROW, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_SECONDARY_DIAGONAL,
            DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_COLUMN, DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_COLUMN,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_SECONDARY_DIAGONAL,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.IN_ROW,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.WITHOUT_DIRECTION, DirectionModel.WITHOUT_DIRECTION,
            DirectionModel.IN_COLUMN, DirectionModel.WITHOUT_DIRECTION};

    private static final int[][] EQUALS_COORDINATE = { {0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1},
            {2, 1}, {0, 2}, {1, 2}, {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0},
            {2, 1}, {2, 2}, {0, 1}, {0, 2}, {0, 0}, {1, 1}, {1, 2}, {1, 0}, {2, 1}, {2, 2}, {2, 0},
            {1, 1}, {1, 1}, {1, 1}, {2, 1}, {0, 1}, {0, 0}, {0, 0}, {1, 0}, {2, 0}, {0, 2}, {1, 2},
            {2, 2}, {2, 2}, {0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1}, {2, 1}, {0, 2}, {1, 2}, {2, 2},
            {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 1}, {0, 2},
            {0, 0}, {1, 1}, {1, 2}, {1, 0}, {2, 1}, {2, 2}, {2, 0}, {1, 1}, {1, 1}, {1, 1}, {2, 1},
            {0, 1}, {0, 0}, {0, 0}, {1, 0}, {2, 0}, {0, 2}, {1, 2}, {2, 2}, {2, 2}, {0, 0}, {1, 0},
            {2, 0}, {0, 1}, {1, 1}, {2, 1}, {0, 2}, {1, 2}, {2, 2}, {0, 0}, {0, 1}, {0, 2}, {1, 0},
            {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {0, 1}, {0, 2}};

    private static final boolean[] EQUALS = {true, false, false, false, true, false, false, false,
            true, true, true, true, true, true, true, true, true, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, true, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, true, false, false,
            true, false, true, false, false, false, false, true, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false};

    // coordinates
    private Iterator<CoordinateEntity> coordinatesIterator;

    private CoordinateEntity coordinate;

    // string coordinates
    private Iterator<String> stringCoordinatesIterator;

    private String stringCoordinate;

    // inDirection coordinates
    private Iterator<CoordinateEntity> inDirectionCoordinatesIterator;

    private CoordinateEntity inDirectionCoordinate;

    // inDirection
    private Iterator<DirectionModel> inDirectionsIterator;

    private DirectionModel inDirection;

    // inDirectionList coordinates
    private Iterator<List<CoordinateEntity>> inDirectionCoordinateListsIterator;

    private List<CoordinateEntity> inDirectionCoordinateList;

    // inDirectionList
    private Iterator<DirectionModel> inDirectionListsIterator;

    private DirectionModel inDirectionList;

    // equals coordinates
    private Iterator<CoordinateEntity> equalsCoordinatesIterator;

    private CoordinateEntity equalsCoordinate;

    // equals
    private Iterator<Boolean> equalsIterator;

    private Boolean equals;

    private int numCoordinate = 0;

    public String message() {
        String result = "Coordinate: " + numCoordinate + "\n" + "coordinate: " + coordinate + "\n"
                + "stringCoordinate: " + stringCoordinate + "\n" + "inDirectionCoordinate: "
                + inDirectionCoordinate + "\n" + "inDirection: " + inDirection + "\n"
                + "inDirectionCoordinateList: " + inDirectionCoordinateList + "\n"
                + "inDirectionList: " + inDirectionList + "\n" + "equalsCoordinate: "
                + equalsCoordinate + "\n" + "equal: " + equals;
        return result;
    }

    public CoordinateEntityTestData() {
        coordinatesIterator = ArrayToListTransformer.transform(INT_INT_COORDINATE);
        stringCoordinatesIterator = ArrayToListTransformer.transform(STRING_COORDINATE);
        inDirectionCoordinatesIterator = ArrayToListTransformer.transform(IN_DIRECTION_COORDINATE);
        inDirectionsIterator = ArrayToListTransformer.transform(IN_DIRECTION);
        inDirectionCoordinateListsIterator = ArrayToListTransformer
                .transform(IN_DIRECTION_LIST_COORDINATES);
        inDirectionListsIterator = ArrayToListTransformer.transform(IN_DIRECTION_LIST);
        equalsCoordinatesIterator = ArrayToListTransformer.transform(EQUALS_COORDINATE);
        equalsIterator = ArrayToListTransformer.transform(EQUALS);
        this.nextCoordinate();
    }

    public boolean hasNextCoordinate() {
        List<Boolean> results = new ArrayList<Boolean>();
        results.add(coordinatesIterator.hasNext());
        results.add(stringCoordinatesIterator.hasNext());
        results.add(inDirectionCoordinatesIterator.hasNext());
        results.add(inDirectionsIterator.hasNext());
        results.add(inDirectionCoordinateListsIterator.hasNext());
        results.add(inDirectionListsIterator.hasNext());
        results.add(equalsCoordinatesIterator.hasNext());
        results.add(equalsIterator.hasNext());
        boolean firstResult = results.remove(0);
        for (Boolean result : results) {
            assert (firstResult == result);
        }
        return firstResult;
    }

    public void nextCoordinate() {
        numCoordinate++;
        coordinate = coordinatesIterator.next();
        stringCoordinate = stringCoordinatesIterator.next();
        inDirectionCoordinate = inDirectionCoordinatesIterator.next();
        inDirection = inDirectionsIterator.next();
        inDirectionCoordinateList = inDirectionCoordinateListsIterator.next();
        inDirectionList = inDirectionListsIterator.next();
        equalsCoordinate = equalsCoordinatesIterator.next();
        equals = equalsIterator.next();
    }

    public CoordinateEntity getCoordinate() {
        return coordinate;
    }

    public String getStringCoordinate() {
        return stringCoordinate;
    }

    public CoordinateEntity getInDirectionCoordinate() {
        return inDirectionCoordinate;
    }

    public DirectionModel getInDirection() {
        return inDirection;
    }

    public List<CoordinateEntity> getInDirectionCoordinateList() {
        return inDirectionCoordinateList;
    }

    public DirectionModel getInDirectionList() {
        return inDirectionList;
    }

    public CoordinateEntity getEqualsCoordinate() {
        return equalsCoordinate;
    }

    public Boolean getEquals() {
        return equals;
    }

    public static void main(String[] arg) {
        CoordinateEntityTestData data = new CoordinateEntityTestData();
        while (data.hasNextCoordinate()) {
            System.out.println(data.message());
            data.nextCoordinate();
        }
    }
}
