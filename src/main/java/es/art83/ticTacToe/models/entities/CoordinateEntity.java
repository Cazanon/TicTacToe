package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import es.art83.ticTacToe.models.utils.ClosedInterval;
import es.art83.ticTacToe.models.utils.DirectionModel;

@XmlRootElement
@Embeddable
public class CoordinateEntity implements Cloneable {
    public static final int DIMENSION = 3;

    public static final int MIN = 0;

    public static final int MAX = DIMENSION - 1;

    private int row;

    @Column(name = "COLUM")
    // Colisiona con SQL
    private int column;

    public CoordinateEntity(int row, int column) {
        final ClosedInterval LIMITS = new ClosedInterval(CoordinateEntity.MIN, CoordinateEntity.MAX);
        assert (LIMITS.include(row));
        assert (LIMITS.include(column));
        this.setRow(row);
        this.setColumn(column);
    }

    // LUIS debería irse a la vista: a un Bean o un CoordinateFormater
    public CoordinateEntity(String coordinate) {
        String[] fields = coordinate.split("-");
        try {
            this.row = Integer.valueOf(fields[0]);
            this.column = Integer.valueOf(fields[1]);
        } catch (NumberFormatException ex) {
            assert false;
        }
    }

    public CoordinateEntity() {
        this(CoordinateEntity.MIN, CoordinateEntity.MIN);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // LUIS debería irse a board, son todas las coordenadas de un board
    // particular
    public static List<CoordinateEntity> allCoordinates() {
        List<CoordinateEntity> coordinates = new ArrayList<>();
        for (int i = MIN; i < MAX + 1; i++) {
            for (int j = MIN; j < MAX + 1; j++) {
                coordinates.add(new CoordinateEntity(i, j));
            }
        }
        return coordinates;
    }

    public DirectionModel inDirection(CoordinateEntity coordinate) {
        assert(!this.equals(coordinate));
        if (this.inRow(coordinate)) {
            return DirectionModel.IN_ROW;
        } else if (this.inColumn(coordinate)) {
            return DirectionModel.IN_COLUMN;
        } else if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
            return DirectionModel.IN_MAIN_DIAGONAL;
        } else if (this.inSecondaryDiagonal() && coordinate.inSecondaryDiagonal()) {
            return DirectionModel.IN_SECONDARY_DIAGONAL;
        } else {
            return DirectionModel.WITHOUT_DIRECTION;
        }
    }

    private boolean inMainDiagonal() {
        return this.getRow() - this.getColumn() == MIN;
    }

    private boolean inSecondaryDiagonal() {
        return this.getRow() + this.getColumn() == MAX;
    }

    private boolean inRow(CoordinateEntity coordinate) {
        return this.getRow() == coordinate.getRow();
    }

    private boolean inColumn(CoordinateEntity coordinate) {
        return this.getColumn() == coordinate.getColumn();
    }

    public DirectionModel inDirection(List<CoordinateEntity> coordinates) {
        assert coordinates.size() == CoordinateEntity.DIMENSION-1;
        CoordinateEntity firstCoordinate = coordinates.get(0);
        DirectionModel direction = this.inDirection(firstCoordinate);
        coordinates.remove(firstCoordinate);
        for (CoordinateEntity coordinate : coordinates) {
            if (direction != this.inDirection(coordinate))
                return DirectionModel.WITHOUT_DIRECTION;
        }
        return direction;
    }

    @Override
    public boolean equals(Object object) {
        assert object != null;
        CoordinateEntity coordinate = (CoordinateEntity) object;
        return this.inRow(coordinate) && this.inColumn(coordinate);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.getColumn();
        result = PRIME * result + this.getRow();
        return result;
    }

    @Override
    public String toString() {
        return row + "-" + column;
    }
    
    @Override
    public CoordinateEntity clone() {
        return new CoordinateEntity(row, column);
    }

}
