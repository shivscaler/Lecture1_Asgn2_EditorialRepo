import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point();
    }

    @Test
    void xExists(){
        try {
            Field xField = point.getClass().getDeclaredField("x");
            assertEquals(xField.getType().toString(), "int");
        } catch (NoSuchFieldException e) {
            fail("x not found");
        }
    }

    @Test
    void yExists(){
        try {
            Field yField = point.getClass().getDeclaredField("y");
            assertEquals(yField.getType().toString(), "int");
        } catch (NoSuchFieldException e) {
            fail("y not found");
        }
    }
}


class RectangleTest {

    private Rectangle rectangle;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        rectangle = new Rectangle();
    }

    @Test
    void topLeftExists(){
        try {
            Field topLeftField = rectangle.getClass().getDeclaredField("topLeft");
            assertEquals(topLeftField.getType().toString(), "class Point");
        } catch (NoSuchFieldException e) {
            fail("topLeft not found");
        }
    }

    @Test
    void heightExists(){
        try {
            Field heightField = rectangle.getClass().getDeclaredField("height");
            assertEquals(heightField.getType().toString(), "int");
        } catch (NoSuchFieldException e) {
            fail("height not found");
        }
    }

    @Test
    void widthExists(){
        try {
            Field widthField = rectangle.getClass().getDeclaredField("width");
            assertEquals(widthField.getType().toString(), "int");
        } catch (NoSuchFieldException e) {
            fail("width not found");
        }
    }

    @Test
    void getBottomRight(){
        Point p = new Point();
        p.x = 3;
        p.y = 4;
        rectangle.topLeft = p;
        rectangle.width = 5;
        rectangle.height = 6;

        Point bottomRight = rectangle.getBottomRight();

        assertEquals(8, bottomRight.x);
        assertEquals(10, bottomRight.y);
    }

    @Test
    void getArea(){
        rectangle.width = 10;
        rectangle.height = 5;

        int area = rectangle.getArea();

        assertEquals(50, area);
    }

    @Test
    void getParameter(){
        rectangle.width = 10;
        rectangle.height = 5;

        int parameter = rectangle.getParameter();

        assertEquals(30, parameter);
    }

}
