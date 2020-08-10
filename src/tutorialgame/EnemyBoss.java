package tutorialgame;

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject {
    private Handler handler;
    private int timer = 100;
    private int timer2 = 50;
    Random r = new Random();

    public EnemyBoss(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        velX = 0 ;
        velY = 1 ;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 156, 156);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(timer<=0) velY =0;
        else timer--;

        if(timer <=0) timer2--;
        if(timer2 <=0){
            if (velX == 0) velX = 5;
            if(velX >0)
                velX+=0.05f;
            else if (velX <0)
                velX -=0.005f;

            velX = Game.clamp(velX, -50, 50);

            int spawn = r.nextInt(10);
            if(spawn==0) handler.addObject(new EnemyBossBullet((int)x+100, (int)y+100, ID.BasicEnemy, handler));
            collision();
        }

        //if (y <= 0 || y >= Game.HEIGHT - 141) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 160) velX *= -1;
        //handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.05f, handler));
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
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 156, 156);

    }
}
