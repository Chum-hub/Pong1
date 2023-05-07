import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paddle extends JComponent {
    public int x;
    public int y;
    public final int width = 10;
    public final int height = 70;
    public final int maxY;
    public final int minY;
    public Color color;
    Timer timer = new Timer(5, null);

    Paddle(int x, int y, String name, int maxY, int minY, Color color) {
        this.x = x;
        this.y = y;
        this.maxY = maxY;
        this.minY = minY;
        this.color = color;
        this.setName(name);
        setBounds(x, y, width, height);
        setFocusable(true);
    }

    public void move(String value) {
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (value.equals("Up")) {
                    y = y <= minY ? y : y - 4;
                } else {
                    y = y >= maxY ? y : y + 4;
                }
                repaint();
            }
        });
        timer.start();
    }

    public void stop() {
        this.timer.stop();
        timer = new Timer(10, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
