package tutorialgame;

import java.awt.*;

public class FastEnemy extends GameObject {
    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        velX = 15 ;
        velY = 5 ;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 10, 10);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 70) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.blue, 10, 10, 0.05f, handler));
        collision();
    }
    private  void  collision(){
        for (int i = 0; i < handler.obiect.size(); i++) {

            GameObject tempObject = handler.obiect.get(i);

            if(tempObject.getId()== ID.EnemyBossBullet){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(this);

                }
            }
        }
    }


    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y, 10, 10);

    }
}
