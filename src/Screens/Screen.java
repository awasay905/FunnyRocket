package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public abstract class Screen extends JPanel implements ActionListener, KeyListener, MouseListener {
    protected final int BOARD_WIDTH = 1000;
    protected final int BOARD_HEIGHT = 600;
    protected boolean isActive;

    public Screen() {
        addKeyListener(this);
        addMouseListener(this);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setFocusable(true);

        int DELAY = 25;
        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }
}
