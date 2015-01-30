package es.art83.ticTacToe.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.TurnEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.DirectionModel;

public class ArrayToListTransformer {

    public static Iterator<Boolean> transform(boolean[] array) {
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result.iterator();
    }

    public static Iterator<String> transform(String[] array) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result.iterator();
    }

    public static Iterator<TurnEntity> transform(ColorModel[] array) {
        List<TurnEntity> result = new ArrayList<TurnEntity>();
        for (int i = 0; i < array.length; i++) {
            result.add(new TurnEntity(array[i]));
        }
        return result.iterator();
    }

    public static Iterator<DirectionModel> transform(DirectionModel[] array) {
        List<DirectionModel> result = new ArrayList<DirectionModel>();
        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result.iterator();
    }

    public static Iterator<CoordinateEntity> transform(int[][] coordinates) {
        List<CoordinateEntity> result = new ArrayList<CoordinateEntity>();
        for (int i = 0; i < coordinates.length; i++) {
            CoordinateEntity coordinate = null;
            if (coordinates[i] != null) {
                coordinate = new CoordinateEntity(coordinates[i][0], coordinates[i][1]);
            }
            result.add(coordinate);
        }
        return result.iterator();
    }

    public static Iterator<List<CoordinateEntity>> transform(int[][][] coordinatesArray) {
        List<List<CoordinateEntity>> result = new ArrayList<List<CoordinateEntity>>();
        for (int i = 0; i < coordinatesArray.length; i++) {
            ArrayList<CoordinateEntity> coordinates = new ArrayList<CoordinateEntity>();
            if (coordinatesArray[i] == null) {
                coordinates.add(null);
            } else {
                for (int j = 0; j < coordinatesArray[i].length; j++) {
                    coordinates.add(new CoordinateEntity(coordinatesArray[i][j][0],
                            coordinatesArray[i][j][1]));
                }
            }
            result.add(coordinates);
        }
        return result.iterator();
    }

    public static Iterator<PieceEntity> transform(ColorModel[] colors, int[][] coordinates) {
        List<PieceEntity> result = new ArrayList<PieceEntity>();
        for (int i = 0; i < colors.length; i++) {
            PieceEntity piece = null;
            if (colors[i] != null) {
                piece = new PieceEntity(colors[i], new CoordinateEntity(coordinates[i][0],
                        coordinates[i][1]));
            }
            result.add(piece);
        }
        return result.iterator();
    }

    public static Iterator<List<PieceEntity>> transform(ColorModel[][] colors, int[][][] coordinates) {
        List<List<PieceEntity>> result = new ArrayList<List<PieceEntity>>();
        for (int i = 0; i < colors.length; i++) {
            ArrayList<PieceEntity> piecesBoard = new ArrayList<PieceEntity>();
            for (int j = 0; j < colors[i].length; j++) {
                piecesBoard.add(new PieceEntity(colors[i][j], new CoordinateEntity(
                        coordinates[i][j][0], coordinates[i][j][1])));
            }
            result.add(piecesBoard);
        }
        return result.iterator();
    }

}
