import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    private int width = 0;
    private int height = 0;

    public ImageProxy(String filename) {
        this.filename = filename;
        try (InputStream stream = new File(filename).toURI().toURL().openStream()) {
            try (ImageInputStream input = ImageIO.createImageInputStream(stream)) {
                ImageReader reader = ImageIO.getImageReaders(input).next();
                try {
                    reader.setInput(input);
                    int width = reader.getWidth(0);
                    int height = reader.getHeight(0);
                } finally {
                    reader.dispose();
                }
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics graphics, int x, int y) {
        if (realImage == null)
            realImage = new RealImage(filename);

        realImage.draw(graphics, x, y);
    }

    @Override
    public BufferedImage getBufferedImage() {
        return realImage.getBufferedImage();
    }
}
