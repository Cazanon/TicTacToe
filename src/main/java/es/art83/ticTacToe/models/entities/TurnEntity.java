package es.art83.ticTacToe.models.entities;

import javax.persistence.Embeddable;

import es.art83.ticTacToe.models.utils.ColorModel;

@Embeddable
public class TurnEntity {
    private ColorModel color;

    public TurnEntity(ColorModel color) {
        this.setColor(color);
    }

    public TurnEntity() {
        this(ColorModel.X);
    }

    public ColorModel getColor() {
        return color;
    }

    public void setColor(ColorModel color) {
        this.color = color;
    }

    public ColorModel getColorChanged() {
        if (this.color == ColorModel.X) {
            return ColorModel.O;
        } else {
            return ColorModel.X;
        }
    }

    public void change() {
        this.color = this.getColorChanged();
    }

    public void update(TurnEntity turn) {
        this.setColor(turn.color);
    }

    @Override
    public String toString() {
        return "TurnEntity[" + color + "]";
    }

    @Override
    protected TurnEntity clone() {
        return new TurnEntity(this.color);
    }

}
