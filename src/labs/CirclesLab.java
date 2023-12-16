package labs;

import draw.Drawable;

import java.awt.Color;

public class CirclesLab {

    public static <Viewer> void testDrawable(Viewer display, Drawable circles) throws Exception {
        // Set Location to (50, 50)
        circles.setLocation(50, 50);

        // Clear then Pause for 250 milliseconds
        display.notify();
        display.wait(250);

        // Move location by (50, 0) and draw Yellow Circles
        circles.setLocation(circles.getX() + 50, circles.getY());
        circles.setColor();
        circles.draw();

        // Move location by (0, 100) and draw RED Circles
        circles.setLocation(circles.getX(), circles.getY() + 100);
        circles.setColor();
        circles.draw();

        // Move location by (0, 100) and draw Circles with Fillable AZUL
        circles.setLocation(circles.getX(), circles.getY() + 100);

        // Pause for 250 milliseconds
        display.wait(250);
    }

    public static void testFillable(Display display, Fillable circles) throws Exception {
        // Set Location to (40, 40)
        circles.setLocation(40, 40);

        // Pause for 250 milliseconds
        display.pause(250);

        // Draw fillable RED Circles then move (-25,40)
        circles.setFillColor();
        circles.fill();
        circles.setLocation(circles.getX() - 25, circles.getY() + 40);

        // Draw fillable WHITE Circles then move (50,-50)
        circles.setFillColor();
        circles.fill();
        circles.setLocation(circles.getX() + 50, circles.getY() - 50);

        // Draw fillable AZUL Circles
        circles.setFillColor();
        circles.fill();

        // Pause for 250 milliseconds
        display.pause(250);
    }

    public static void main(String[] args) throws Exception {
        Display display01 = new Display(50, 50, 600, 600);
        Display display02 = new Display(800, 50, 400, 600);
        display01.setBackground(Color.BLACK);
        display02.setBackground(Color.BLACK);

        // Create Circles of a Fillable Type with graphics object 1
        Fillable fillableCircles = new FillableCircle(null);

        // Use testFillable to draw Fillable Circles
        testFillable(display01, fillableCircles);

        // Create Circles of a Drawable Type with graphics object 2
        Drawable drawableCircles = new DrawableCircle(null);

        // Use testDrawable to draw Open Drawable Circles
        testDrawable(display02, drawableCircles);
    }
}