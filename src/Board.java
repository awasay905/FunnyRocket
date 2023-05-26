import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener, KeyListener {

    private final int BOARD_WIDTH = 400;
    private final int BOARD_HEIGHT = 720;
    private final int ROCKET_WIDTH = 30;
    private final int ROCKET_HEIGHT = 120;
    private final Star[] stars = new Star[100];
    int i = 0;
    int suny = 100;
    int rockety;
    private int x, y;
    private boolean left, right, up, down;
    private int groundx = 0;
    private int groundHeight = 100;
    private int groundy = BOARD_HEIGHT - groundHeight;
    private Color c1 = Color.RED.darker().darker(), c2 = Color.ORANGE.darker().darker(), c3 = Color.YELLOW.darker().darker();

    public Board() {
        initBoard();
        x = BOARD_WIDTH / 2 - ROCKET_WIDTH / 2;
        y = BOARD_HEIGHT - groundHeight - ROCKET_HEIGHT;
        rockety = y;

        for (int j = 0; j < stars.length; j++) {
            stars[j] = new Star((int) (Math.random() * BOARD_WIDTH), (int) (Math.random() * BOARD_HEIGHT));
        }
    }

    private void initBoard() {
        addKeyListener(this);
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
        if (!(rockety < -50)) g.setColor(Color.blue);
        else g.setColor(Color.blue.darker());
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        g.setColor(Color.green.darker());
        drawGround(g);
        drawLaunchPad(g);
        drawSun(g);
        drawStars(g);
        drawRocket(g);

        g.drawString("Height : " + (500 - rockety), 0, 30);
        // g.drawImage(current, x, y, null);
    }

    private void drawStars(Graphics g) {
        if (rockety < -50) {
            for (Star s : stars) {
                s.drawStar(g);
                if (s.y > BOARD_HEIGHT) s = new Star((int) (Math.random() * BOARD_WIDTH), 0);
            }
        }
    }

    private void drawSun(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(300, suny, 40, 40);
        g.setColor(Color.YELLOW);
        g.fillOval(300 + 3, suny + 3, 40 - 6, 40 - 6);
    }

    private void drawGround(Graphics g) {
        g.setColor(Color.green.darker());
        g.fillRect(groundx, groundy, BOARD_WIDTH, groundHeight);
        g.setColor(Color.darkGray);
        g.fillRect(groundx, groundy, BOARD_WIDTH, 10);
    }

    private void drawRocket(Graphics g) {
        g.setColor(Color.red.darker().darker());
        g.fillPolygon(new int[]{x, x + ROCKET_WIDTH / 2, x + ROCKET_WIDTH}, new int[]{y + 24, y, y + 24}, 3);
        g.setColor(Color.GRAY);
        g.fillRect(x, y + 24, ROCKET_WIDTH, 12 * 7);
        g.setColor(Color.BLACK.brighter());
        g.fillPolygon(new int[]{x, x + ROCKET_WIDTH, x + ROCKET_WIDTH + 7, x - 7}, new int[]{y + 12 * 9, y + 12 * 9, y + 12 * 10, y + 12 * 10}, 4);
        drawFlames(g);
    }

    private void drawFlames(Graphics g) {
        if (left) {
            g.setColor(c1);

            g.fillPolygon(new int[]{x, x + ROCKET_WIDTH / 2 - 10 + ROCKET_WIDTH / 3, x + ROCKET_WIDTH / 2 + ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 + ROCKET_WIDTH / 3, x + ROCKET_WIDTH}, new int[]{y + 12 * 10, y + 12 * 12, y + 12 * 13, y + 12 * 12, y + 12 * 10}, 5);

            g.setColor(c2);
            g.fillPolygon(new int[]{x + 5, x + ROCKET_WIDTH / 2 - 10 + 5 + ROCKET_WIDTH / 3, x + ROCKET_WIDTH / 2 + ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 - 5 + ROCKET_WIDTH / 3, x + ROCKET_WIDTH - 5}, new int[]{y + 12 * 10, y + 12 * 11 + 5, y + 12 * 12, y + 12 * 11 + 5, y + 12 * 10}, 5);

            g.setColor(c3);
            g.fillPolygon(new int[]{x + 10, x + ROCKET_WIDTH / 2 - 10 + 10 + ROCKET_WIDTH / 3, x + ROCKET_WIDTH / 2 + ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 - 10 + ROCKET_WIDTH / 3, x + ROCKET_WIDTH - 10}, new int[]{y + 12 * 10, y + 12 * 11 - 4, y + 12 * 11, y + 12 * 11 - 4, y + 12 * 10}, 5);
            return;
        }
        if (right) {
            g.setColor(c1);

            g.fillPolygon(new int[]{x, x + ROCKET_WIDTH / 2 - 10 - ROCKET_WIDTH / 3, x + ROCKET_WIDTH / 2 - ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 - ROCKET_WIDTH / 3, x + ROCKET_WIDTH}, new int[]{y + 12 * 10, y + 12 * 12, y + 12 * 13, y + 12 * 12, y + 12 * 10}, 5);

            g.setColor(c2);
            g.fillPolygon(new int[]{x + 5, x + ROCKET_WIDTH / 2 - 10 + 5 - ROCKET_WIDTH / 3, x + ROCKET_WIDTH / 2 - ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 - 5 - ROCKET_WIDTH / 3, x + ROCKET_WIDTH - 5}, new int[]{y + 12 * 10, y + 12 * 11 + 5, y + 12 * 12, y + 12 * 11 + 5, y + 12 * 10}, 5);

            g.setColor(c3);
            g.fillPolygon(new int[]{x + 10, x + ROCKET_WIDTH / 2 - 10 + 10 - ROCKET_WIDTH / 3, x + ROCKET_WIDTH / 2 - ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 - 10 - ROCKET_WIDTH / 3, x + ROCKET_WIDTH - 10}, new int[]{y + 12 * 10, y + 12 * 11 - 4, y + 12 * 11, y + 12 * 11 - 4, y + 12 * 10}, 5);
            return;
        }
        if (up) {
            g.setColor(c1);
            g.fillPolygon(new int[]{x, x + ROCKET_WIDTH / 2 - 10, x + ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10, x + ROCKET_WIDTH}, new int[]{y + 12 * 10, y + 12 * 12, y + 12 * 13, y + 12 * 12, y + 12 * 10}, 5);

            g.setColor(c2);
            g.fillPolygon(new int[]{x + 5, x + ROCKET_WIDTH / 2 - 10 + 5, x + ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 - 5, x + ROCKET_WIDTH - 5}, new int[]{y + 12 * 10, y + 12 * 11 + 5, y + 12 * 12, y + 12 * 11 + 5, y + 12 * 10}, 5);

            g.setColor(c3);
            g.fillPolygon(new int[]{x + 10, x + ROCKET_WIDTH / 2 - 10 + 10, x + ROCKET_WIDTH / 2, x + ROCKET_WIDTH / 2 + 10 - 10, x + ROCKET_WIDTH - 10}, new int[]{y + 12 * 10, y + 12 * 11 - 4, y + 12 * 11, y + 12 * 11 - 4, y + 12 * 10}, 5);

        }

    }

    private void drawLaunchPad(Graphics g) {
        g.setColor(Color.red.darker());
        g.fillRect(groundx + BOARD_WIDTH / 2 - 40 / 2, groundy, 40, 8);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        repaint();
        moveRocket();
        i++;
        if (i % 3 == 0) {
            c1 = Color.RED.darker();
            c2 = Color.ORANGE.darker();
            c3 = Color.YELLOW.darker();
        } else {
            c1 = Color.RED.darker();
            c2 = Color.YELLOW.darker();
            c3 = Color.BLUE.darker();
        }
    }

    public void moveRocket() {
        if (up) {
            y -= 3;
            rockety -= 3; // do seperatly

            System.out.println("moving up");
            if (rockety < -50) {
                for (int j = 0; j < stars.length; j++) {
                    stars[j].y++;
                    // if (stars[j].y > BOARD_HEIGHT) stars[j]= new Star((int)(Math.random()*BOARD_WIDTH),0);
                    if (stars[j].y > BOARD_HEIGHT) {
                        stars[j].x = (int) (Math.random() * BOARD_WIDTH);
                        stars[j].y = 0;
                    }

                }
            }
        }
        if (down) {
            if (y + 3 <= BOARD_HEIGHT - groundHeight - ROCKET_HEIGHT) {
                rockety += 3;
                y += 3;
            }

            if (rockety < -50) {
                for (int j = 0; j < stars.length; j++) {
                    stars[j].y--;
                    if (stars[j].y < 0) {
                        //stars[j] = new Star((int) (Math.random() * BOARD_WIDTH), BOARD_HEIGHT);
                        stars[j].x = (int) (Math.random() * BOARD_WIDTH);

                        stars[j] .y = BOARD_HEIGHT;

                    }
                }
            }
        }
        if (right) x += 3;
        if (left) x -= 3;
        if (!up && rockety + 2 <= BOARD_HEIGHT - groundHeight - ROCKET_HEIGHT) {
            rockety += 2;
            y += 2;

            if (rockety < -50) {
                for (int j = 0; j < stars.length; j++) {
                    stars[j].y--;
                    if (stars[j].y < 0) stars[j] = new Star((int) (Math.random() * BOARD_WIDTH), BOARD_HEIGHT);
                }
            }

            if (rockety > 80 && groundy > BOARD_HEIGHT - groundHeight) {
                groundy += rockety;
            }
        }


        if (rockety < 80) {
            y = 80;
            if (rockety < 0) {
                suny -= rockety;
            }
        }

        if (rockety > 0) {
            if (suny >= BOARD_HEIGHT) suny = BOARD_HEIGHT - rockety;
            if (rockety >= 80) {
                groundy = BOARD_HEIGHT - groundHeight;
            } else {
                groundy = BOARD_HEIGHT - rockety;
            }
        }

        if (y > BOARD_HEIGHT - ROCKET_HEIGHT) {
            y = BOARD_HEIGHT - ROCKET_HEIGHT;
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
}