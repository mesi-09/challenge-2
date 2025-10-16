
package bouncingtextapplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {

    private Thread thread;
    private int x = 0; // Starting position
    private String text = "Meseret Gete"; // Your name
    private int textWidth = 0;
    private boolean running = false;

    @Override
    public void init() {
        setSize(500, 200); // Applet size
        setBackground(Color.BLACK); // Background color
        setForeground(Color.CYAN); // Text color
    }

    @Override
    public void start() {
        if (thread == null) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void stop() {
        running = false;
        thread = null;
    }

    @Override
    public void run() {
        // Calculate text width after applet is shown
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}

        textWidth = getFontMetrics(getFont()).stringWidth(text);

        while (running) {
            x += 10; // Move text to the right
            if (x > getWidth()) {
                x = -textWidth; // Reset when hitting right edge
            }

            repaint(); // Request redraw

            try {
                Thread.sleep(100); // Pause for smooth animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(text, x, 100); // Draw text at current x position
    }
}

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
