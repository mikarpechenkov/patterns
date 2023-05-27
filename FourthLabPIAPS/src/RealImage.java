import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RealImage implements Image {
    private BufferedImage image;

    public RealImage(String filename) {
        loadImage(filename);
    }

    private void loadImage(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public void draw(Graphics graphics, int x, int y) {
        if (image != null) {
            graphics.drawImage(image, x, y, null);
        }
    }

    @Override
    public BufferedImage getBufferedImage() {
        return image;
    }
}
