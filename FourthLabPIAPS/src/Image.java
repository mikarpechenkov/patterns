import java.awt.*;
import java.awt.image.BufferedImage;

public interface Image {
    int getWidth();

    int getHeight();

    void draw(Graphics graphics, int x, int y);
    BufferedImage getBufferedImage();
}
