import java.awt.*;

public class Star {
    int x, y;
    int size;

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = (int)(Math.random()*3)+2;
    }

    public void drawStar(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,size,size);
    }
}
