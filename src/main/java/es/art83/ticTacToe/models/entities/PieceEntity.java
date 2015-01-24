package es.art83.ticTacToe.models.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import es.art83.ticTacToe.models.utils.ColorModel;

@XmlRootElement
@Entity
public class PieceEntity {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private ColorModel color;

    @Embedded
    private CoordinateEntity coordinate;

    public PieceEntity(ColorModel color, CoordinateEntity coordinate) {
        this.setColor(color);
        this.setCoordinate(coordinate);
    }

    public PieceEntity() {
        this(null, null);
    }

    public int getId() {
        return id;
    }

    public ColorModel getColor() {
        return color;
    }

    public void setColor(ColorModel color) {
        this.color = color;
    }

    public CoordinateEntity getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(CoordinateEntity coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((coordinate == null) ? 0 : coordinate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        assert object != null;
        PieceEntity piece = (PieceEntity) object;
        return this.color.equals(piece.color) && this.coordinate.equals(piece.coordinate);
    }

    @Override
    public String toString() {
        return "Piece[" + color + "-" + coordinate + "]";
    }

}
