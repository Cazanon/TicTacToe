package es.art83.ticTacToe.models.utils;

public class ClosedInterval implements Cloneable {
    private int minimum;

    private int maximum;

    public ClosedInterval(int minimum, int maximum) {
        assert (minimum <= maximum);
        this.minimum = minimum;
        this.maximum = maximum;
    }
    
    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public boolean include(int value) {
        return minimum <= value && value <= maximum;
    }
}
