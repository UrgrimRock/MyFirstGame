package tutorialgame;

import java.awt.*;

public class HUD {

    public static float Health = 100;

    private float greenValue = 255;

    private int score = 0;
    private int level = 1;

    public void  tick(){
        Health = Game.clamp(Health, 0, 200);
        greenValue = Game.clamp(greenValue, 0, 255);

        greenValue = Health*2;
        score++;


    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15,15, 200, 32);
        g.setColor(new Color(75, 255, 0));
        g.fillRect(15, 15, (int)Health * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15,15, 200, 32);

        g.drawString("Score: " + score, 10, 70 );
        g.drawString("Level: " + level, 10, 110);

    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;

    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }


}
