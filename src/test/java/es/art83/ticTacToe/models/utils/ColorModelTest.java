package es.art83.ticTacToe.models.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorModelTest {

    @Test
    public void testNext() {
        assertEquals(ColorModel.O, ColorModel.X.next());
        assertEquals(ColorModel.X, ColorModel.O.next());
    }

}
