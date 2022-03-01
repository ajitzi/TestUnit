package ajitzi.color.model;

import ajitzi.color.model.Color;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorTest {

    private Color color;

    @BeforeEach
    public void setUp() {
        color = new Color(33, 255, 16);
    }

    @Test
    public void testConstructorHexThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Color("#12LAB6"));
    }

    @Test
    public void testConstructorRGBNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Color(-1, 255, 190));
    }

    @Test
    public void testConstructorRGBOverMaxThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Color(252, 256, 190));
    }

    @Test
    public void testgetRed() {
        assertEquals(33, color.getRed());
    }

    @Test
    public void testgetGreen() {
        assertEquals(255, color.getGreen());

    }

    @Test
    public void testgetBlue() {
        assertEquals(16, color.getBlue());
    }


    public void testgetHexValue() {

    }


    @AfterEach
    public void tearDown() {
        color = null;
    }


}