package tutorialgame;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
    private Handler handler;
    Random r = new Random();

    public EnemyBossBullet(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        //velX = (r.nextInt(5 - -5)+ -5);
        velX = 0;
        velY = -6;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 5, 5);
    }

    public void tick() {
        x += velX;
        y += velY;

        //if (y <= 0 || y >= Game.HEIGHT - 70) velY *= -1;
        //if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
//        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 5, 5, 0.05f, handler));
        if(y >= Game.HEIGHT) handler.removeObject(this);
        collision();

    }
    private  void  collision(){
        for (int i = 0; i < handler.obiect.size(); i++) {

            GameObject tempObject = handler.obiect.get(i);

            if(tempObject.getId()== ID.BasicEnemy || tempObject.getId()== ID.FastEnemy || tempObject.getId()== ID.BFEnemy || tempObject.getId()== ID.SmartEnemy||tempObject.getId()==ID.EnemyBoss){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(this);

                }
            }
        }
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 5, 5);

    }
}
