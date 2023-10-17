import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;

public class SpriteAnimationExample extends JFrame {
    private JLabel animationLabel;
    private Timer timer;
    private static final int FRAME_WIDTH = 1300;
    private static final int FRAME_HEIGHT = 1300;
    private static final int FRAME_COUNT = 5;
    private int currentFrame = 0;

    public SpriteAnimationExample() {
        setTitle("Sprite Animation Example");
        setSize(2000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        animationLabel = new JLabel();
        add(animationLabel);

        int delay = 1000;
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame();
            }
        });

        displayFrame();

        timer.start();
    }

    private void displayFrame() {
        ImageIcon spriteIcon = new ImageIcon("C:\\Users\\alvsh\\Downloads\\animation-sprite-sheet-of-bomb-explosion-sequence\\2204_w053_n004_20a_p1_20.jpg");
        Image spriteImage = spriteIcon.getImage();
        Image frameImage = createImage(new FilteredImageSource(spriteImage.getSource(),
                new CropImageFilter(currentFrame * FRAME_WIDTH + 200, 350, FRAME_WIDTH, FRAME_HEIGHT)));

        ImageIcon frameIcon = new ImageIcon(frameImage.getScaledInstance(FRAME_WIDTH, FRAME_HEIGHT, Image.SCALE_DEFAULT));
        animationLabel.setIcon(frameIcon);
    }

    private void updateFrame() {
        currentFrame++;

        if (currentFrame >= FRAME_COUNT) {
            currentFrame = 0;
        }

        displayFrame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SpriteAnimationExample animationExample = new SpriteAnimationExample();
            animationExample.setVisible(true);
        });
    }
}
