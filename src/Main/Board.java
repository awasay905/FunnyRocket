package Main;

import Screens.GameplayScreen;
import Screens.Screen;
import Screens.Screens;
import Screens.StartScreen;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class Board extends Screen {
    public static Screen currentScreen = Screens.startScreen;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentScreen != null) currentScreen.paintComponent(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (currentScreen != null) currentScreen.actionPerformed(e);
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (currentScreen != null) currentScreen.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (currentScreen != null) currentScreen.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'g') currentScreen = new GameplayScreen();
        if (currentScreen != null) currentScreen.keyPressed(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (currentScreen != null) currentScreen.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (currentScreen != null) currentScreen.mousePressed(e);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (currentScreen != null) currentScreen.mouseReleased(e);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (currentScreen != null) currentScreen.mouseEntered(e);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (currentScreen != null) currentScreen.mouseExited(e);

    }
}