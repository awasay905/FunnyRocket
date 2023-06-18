package Screens;

import Main.Board;
import Main.Rocket;
import Resource.Resources;
import UiComponents.Button;
import UiComponents.onCLick;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;

public class GameplayScreen extends Screen {
    public Rocket rocket = new Rocket();
    int i = 0;
    boolean engineStarted = false;
    int tankSize = 300;
    int engineStartUp = 0;
    private int fuel = 300;
    private Button button;
    private int x, y;
    private boolean left, right, up, down;
    private Image img, fire, fire2, l, l2, r, r2, current;


    public GameplayScreen() {
        x = 200;
        y = BOARD_HEIGHT - 100 - 100;

        img = Resources.test.getScaledInstance(40, 100, Image.SCALE_SMOOTH);
        fire = Resources.fire.getScaledInstance(40, 100, Image.SCALE_SMOOTH);
        l = Resources.left.getScaledInstance(40, 100, Image.SCALE_SMOOTH);
        r = Resources.right.getScaledInstance(40, 100, Image.SCALE_SMOOTH);

        fire2 =Resources.fire2.getScaledInstance(40, 100, Image.SCALE_SMOOTH);
        l2 = Resources.left2.getScaledInstance(40, 100, Image.SCALE_SMOOTH);
        r2 = Resources.right2.getScaledInstance(40, 100, Image.SCALE_SMOOTH);

        button = new Button(20, 20, 20, 20,Resources.test,Resources.test, "Back", -1, new onCLick() {
            @Override
            public void onClick() {
                System.out.println("Clicked");
                Board.currentScreen = Screens.startScreen;
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        g.setColor(Color.green.darker());
        g.fillOval(BOARD_WIDTH / 2 - 1000 / 2, BOARD_HEIGHT - 100, 1000, 300);
        g.drawImage(current, x, y, null);
        button.draw(g);
        drawFuelPanel(g);
    }

    public void drawFuelPanel(Graphics g) {
        double percentage = 0;
        if (!engineStarted) {
            percentage = (engineStartUp / 250.0) * 100;
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            g.drawString("Starting Engine", 150, 100);
            g.setColor(Color.BLACK);
            g.fillRect(50, 50, 25, 200);
            g.setColor(Color.RED);
            g.fillRect(52, 250 - (int) (percentage) * 2, 23, (int) (percentage) * 2);
        } else {
            percentage = ((tankSize - fuel) / (tankSize * 1.0)) * 100;
            g.setColor(Color.BLACK);
            g.fillRect(50, 50, 25, 200);
            g.setColor(Color.GREEN);
            g.fillRect(51, 50 + (int) (percentage) * 2, 23, 200 - (int) (percentage) * 2);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        moveRocket();
        i++;
        if (i % 3 == 0) {
            if (right) current = r2;
            else if (left) current = l2;
            else if (up) current = fire2;
            else current = img;
        } else {
            if (right) current = r;
            else if (left) current = l;
            else if (up) current = fire;
            else current = img;
        }
    }

    public void moveRocket() {
        if (up && !engineStarted) {
            engineStartUp++;
            if (engineStartUp > 250) {
                engineStarted = true;
                System.out.println("Engine started");
            }
            ;
            return;
        }
        if (up && fuel > 0) {
            y -= 3;
        }
        if (down) {
            if (y + 3 < BOARD_HEIGHT - 100 - 85) y += 3;
        }
        if (right) x += 3;
        if (left) x -= 3;
        if (!up && y + 2 < BOARD_HEIGHT - 100 - 85) y += 2;
        if (engineStarted && up) {
            if (fuel > 0) fuel--;
            System.out.println(fuel);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        button.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
