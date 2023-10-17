import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDisplay extends JFrame {
    private JLabel imageLabel;

    public ImageDisplay(String imagePath) {
        setTitle("Image Display");
        setSize(2000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        add(imageLabel);

        displayImage(imagePath);
    }

    private void displayImage(String imagePath) {
        try {
            File file = new File(imagePath);
            BufferedImage image = ImageIO.read(file);

            ImageIcon imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String path = "C:\\Users\\alvsh\\OneDrive\\Изображения\\Saved Pictures\\fe98bd023477d92f411994258c5f0033.jpeg";

        SwingUtilities.invokeLater(() -> {
            ImageDisplay imageDisplay = new ImageDisplay(path);
            imageDisplay.setVisible(true);
        });
    }
}
