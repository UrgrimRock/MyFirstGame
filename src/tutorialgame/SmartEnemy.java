package tutorialgame;

import java.awt.*;

public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject player;

    SmartEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.obiect.size(); i++) {
            if(handler.obiect.get(i).getId()== ID.Player) player = handler.obiect.get(i);
        }

    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
    public void tick(){
        x += velX;
        y += velY;

        //Can change the speed to make it chase faster or slower
        int speed = 5;


        //Finds the difference between the player's location and the enemy location
        float xDif = player.getX() - x;
        float yDif = player.getY() - y;

        // difference/absolute value of difference will yield 1 or negative 1 depending on if it's positive or negative. Then multiply by the speed.
        // this leads to an enemy that can only follow in 8 directions, but it still follows the player accurately.
        velX = (int) (xDif/Math.abs((double) xDif) * speed);
        velY = (int) (yDif/Math.abs((double) yDif) * speed);

        //if (y <= 0 || y >= Game.HEIGHT - 70) velY *= -1;
        //if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.05f, handler));
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
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 16, 16);

    }
}
