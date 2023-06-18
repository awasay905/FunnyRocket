package Screens;

import Main.Board;
import Resource.Resources;
import UiComponents.Button;
import UiComponents.onCLick;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StartScreen extends Screen {
    Image background;
    Button[] buttons = new Button[5];


    public StartScreen() {
        super();
        background = Resources.homescreenBackground;
        buttons[0] = new Button(236, 94, 528, 145, Resources.buttonBackground, Resources.buttonBackground, "TITLE OF GAME", -1, new onCLick() {
            @Override
            public void onClick() {
                System.out.println("Clicked");
                Board.currentScreen = new GameplayScreen();
            }
        });
        buttons[1] = new Button(391, 263, 217, 48, Resources.buttonBackground, Resources.buttonBackground, "New Game", -1, new onCLick() {
            @Override
            public void onClick() {
                System.out.println("Clicked");
                Board.currentScreen = new GameplayScreen();
            }
        });
        buttons[2] = new Button(391, 335, 217, 48, Resources.buttonBackground, Resources.buttonBackground, "Resume Game", -1, new onCLick() {
            @Override
            public void onClick() {
                System.out.println("Clicked");
                Board.currentScreen = new GameplayScreen();
            }
        });
        buttons[3] = new Button(391, 407, 217, 48, Resources.buttonBackground, Resources.buttonBackground, "HIghscore", -1, new onCLick() {
            @Override
            public void onClick() {
                System.out.println("Clicked");
                Board.currentScreen = new GameplayScreen();
            }
        });
        buttons[4] = new Button(391, 479, 217, 48, Resources.buttonBackground, Resources.buttonBackground, "Exit", -1, new onCLick() {
            @Override
            public void onClick() {
                System.out.println("Clicked");
                Board.currentScreen = new GameplayScreen();
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        for (Button b : buttons) {
            b.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Button b : buttons) {
            b.mouseClicked(e);
        }
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
