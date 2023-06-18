package Resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Resources {
    public static Image homescreenBackground, fire, fire2, gray, left, left2, right, right2, test, buttonBackground;

    public static void initializeResources() {
        try {
            homescreenBackground = ImageIO.read(new File("src/Resource/74202751.jpg"));
            fire = ImageIO.read(new File("src/Resource/fire.png"));
            fire2 = ImageIO.read(new File("src/Resource/fire2.png"));
            gray = ImageIO.read(new File("src/Resource/gray.png"));
            left = ImageIO.read(new File("src/Resource/left.png"));
            left2 = ImageIO.read(new File("src/Resource/left2.png"));
            right = ImageIO.read(new File("src/Resource/right.png"));
            right2 = ImageIO.read(new File("src/Resource/right2.png"));
            test = ImageIO.read(new File("src/Resource/test.png"));
            buttonBackground = ImageIO.read(new File("src/Resource/35808389.png"));
        } catch (IOException e) {
            System.out.println("Error Oucccured");
        }
    }


}
