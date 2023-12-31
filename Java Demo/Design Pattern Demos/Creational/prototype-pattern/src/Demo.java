import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 10;
        circle.radius = 15;
        circle.color = "Green";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        PrintStream op = System.out;
        shapes.stream()
                .forEach(shape -> shapesCopy.add(shape.clone()));

        // now compare the things
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                op.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    op.println(i + ": And they are identical (yay!)");
                } else {
                    op.println(i + ": But they are not identical (booo!)");
                }
            } else {
                op.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}