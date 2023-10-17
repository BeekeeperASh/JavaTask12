import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    protected Color color;
    protected int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    abstract void draw(Graphics g);
}

class RectangleShape extends Shape {
    private int width, height;

    public RectangleShape(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

class CircleShape extends Shape {
    private int diameter;

    public CircleShape(Color color, int x, int y, int diameter) {
        super(color, x, y);
        this.diameter = diameter;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}

class DrawingWindow extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    private static final int SHAPE_COUNT = 20;

    private Shape[] shapes;

    public DrawingWindow() {
        setTitle("Random Shapes");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        generateRandomShapes();
    }

    private void generateRandomShapes() {
        shapes = new Shape[SHAPE_COUNT];
        Random random = new Random();

        for (int i = 0; i < SHAPE_COUNT; i++) {
            int x = random.nextInt(WINDOW_WIDTH);
            int y = random.nextInt(WINDOW_HEIGHT);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            if (i % 2 == 0) {
                int width = random.nextInt(100) + 50;
                int height = random.nextInt(100) + 50;
                shapes[i] = new RectangleShape(color, x, y, width, height);
            } else {
                int diameter = random.nextInt(100) + 50;
                shapes[i] = new CircleShape(color, x, y, diameter);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingWindow window = new DrawingWindow();
            window.setVisible(true);
        });
    }
}
