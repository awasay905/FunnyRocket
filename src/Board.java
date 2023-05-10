import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class Board extends JPanel implements ActionListener , KeyListener {

    private final int BOARD_WIDTH = 400;
    private final int BOARD_HEIGHT = 720;
    private final int DELAY = 25;
    private Timer timer;
    int i = 0;

    private int x,y;
    private boolean left, right, up, down;
    private Image img, fire,fire2, l,l2, r,r2, current;
    public Board() {
        initBoard();
        x=200;
        y=BOARD_HEIGHT-100-100;
        try {
            img = ImageIO.read(new File("src/test.png")).getScaledInstance(40, 100, Image.SCALE_SMOOTH);
            fire = ImageIO.read(new File("src/fire.png")).getScaledInstance(40, 100, Image.SCALE_SMOOTH);
            l = ImageIO.read(new File("src/left.png")).getScaledInstance(40, 100, Image.SCALE_SMOOTH);
            r = ImageIO.read(new File("src/right.png")).getScaledInstance(40, 100, Image.SCALE_SMOOTH);

            fire2 = ImageIO.read(new File("src/fire2.png")).getScaledInstance(40, 100, Image.SCALE_SMOOTH);
            l2 = ImageIO.read(new File("src/left2.png")).getScaledInstance(40, 100, Image.SCALE_SMOOTH);
            r2 = ImageIO.read(new File("src/right2.png")).getScaledInstance(40, 100, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initBoard() {
    	addKeyListener(this);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setFocusable(true);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(0,0,BOARD_WIDTH, BOARD_HEIGHT);
        g.setColor(Color.green.darker());
        g.fillOval(BOARD_WIDTH/2 - 1000/2, BOARD_HEIGHT-100, 1000, 300);
       g.drawImage(current, x, y, null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        repaint();
        moveRocket();
        i++;
        if (i%3==0) {

            if (right) current = r2;
            else if (left) current = l2;
            else if (up) current = fire2;
            else current = img;
        }
        else {
            if (right) current = r;
            else if (left) current = l;
            else if (up) current = fire;
            else current = img;
        }
    }

    public void moveRocket(){
        if (up) y-=3;
        if (down) {
            if ( y+3 < BOARD_HEIGHT-100-85)y+=3;
        }
        if (right) x+=3;
        if (left) x-=3;
        if (!up && y+2 < BOARD_HEIGHT-100-85)y+=2;
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
}