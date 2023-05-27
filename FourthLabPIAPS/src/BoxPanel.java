import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoxPanel extends JPanel {
    private int boxX;
    private int boxY;
    private Image image;
    private boolean shouldLoadImg = false;

    public BoxPanel() {
        image = new ImageProxy("TestImage.jpg");
        boxX = 0;
        boxY = 0;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    shouldLoadImg = true;
                    image.draw(getGraphics(), boxX, boxY);
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                boxX = e.getX();
                boxY = e.getY();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(shouldLoadImg) {
            image.draw(g, boxX, boxY);
        }else {
            g.setColor(Color.BLACK);
            g.fillRect(boxX, boxY, 64, 50);
        }
    }
}
