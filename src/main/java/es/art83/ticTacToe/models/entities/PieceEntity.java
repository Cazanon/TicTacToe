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
    private ColorModel colorModel;

    @Embedded
    private CoordinateEntity coordinateEntity;

    public PieceEntity(ColorModel color, CoordinateEntity coordinate) {
        this.setColorModel(color);
        this.setCoordinateEntity(coordinate);
    }

    public PieceEntity() {
        this(null, null);
    }

    public int getId() {
        return id;
    }

    public ColorModel getColorModel() {
        return colorModel;
    }

    public void setColorModel(ColorModel colorModel) {
        this.colorModel = colorModel;
    }

    public CoordinateEntity getCoordinateEntity() {
        return coordinateEntity;
    }

    public void setCoordinateEntity(CoordinateEntity coordinateEntity) {
        this.coordinateEntity = coordinateEntity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((colorModel == null) ? 0 : colorModel.hashCode());
        result = prime * result + ((coordinateEntity == null) ? 0 : coordinateEntity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        assert object != null;
        PieceEntity piece = (PieceEntity) object;
        return this.colorModel.equals(piece.colorModel) && this.coordinateEntity.equals(piece.coordinateEntity);
    }

    @Override
    public String toString() {
        return "Piece[" + colorModel + "-" + coordinateEntity + "]";
    }
    
    @Override
    public PieceEntity clone() {
        return new PieceEntity(colorModel, (CoordinateEntity) coordinateEntity.clone());
    }

}
