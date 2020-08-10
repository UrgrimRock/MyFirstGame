package tutorialgame;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;
    private int scoreKeep = 0;
    private int scoreKeep2 = 0;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }
        public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32,32);
    }

    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH -50);
        y = Game.clamp(y, 0, Game.HEIGHT -85);
        //handler.addObject(new Trail(x, y, ID.Trail, Color.black, 32, 32, 0.05f, handler));
        scoreKeep++;
        scoreKeep2++;
        HUD hud = new HUD();

        if(scoreKeep >= 10){
            if (scoreKeep2<100){
                handler.addObject(new EnemyBossBullet((int)x+10, (int)y-10, ID.EnemyBossBullet, handler));
                scoreKeep =0;
            }
            else if (scoreKeep2>=100&scoreKeep2<200){
                handler.addObject(new EnemyBossBullet((int)x+5, (int)y-5, ID.EnemyBossBullet, handler));
                handler.addObject(new EnemyBossBullet((int)x+10, (int)y-10, ID.EnemyBossBullet, handler));
                scoreKeep =0;
            }
            else if (scoreKeep2>=200){
                handler.addObject(new EnemyBossBullet((int)x+0, (int)y-0, ID.EnemyBossBullet, handler));
                handler.addObject(new EnemyBossBullet((int)x+10, (int)y-10, ID.EnemyBossBullet, handler));
                handler.addObject(new EnemyBossBullet((int)x+20, (int)y-20, ID.EnemyBossBullet, handler));
                scoreKeep =0;

            }
        }



        //int spawn = r.nextInt(5);
        //if(spawn==0) handler.addObject(new EnemyBossBullet((int)x+10, (int)y-10, ID.BasicEnemy, handler));

        collision();

    }
    private  void  collision(){
        for (int i = 0; i < handler.obiect.size(); i++) {

            GameObject tempObject = handler.obiect.get(i);

            if(tempObject.getId()== ID.BasicEnemy || tempObject.getId()== ID.FastEnemy || tempObject.getId()== ID.BFEnemy || tempObject.getId()== ID.SmartEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.Health -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 32, 25);

    }
}
