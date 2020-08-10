package tutorialgame;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {
    private Handler handler;
    Random r = new Random();

    private Color col;

    public MenuParticle(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        velX = (r.nextInt(15 - -5)+ -5) ;
        velY = (r.nextInt(15 - -5)+ -5) ;

        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));


    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 10, 10);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 70) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, col, 25, 25, 0.05f, handler));
    }


    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x, (int)y, 25, 25);

    }
}
