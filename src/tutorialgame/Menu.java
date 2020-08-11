package tutorialgame;

import javax.sound.sampled.SourceDataLine;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();


    public Menu(Game game,Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (game.gameState == Game.STATE.Menu) {

            if (mouseOver(mx, my, 150, 150, 300, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                //handler.clearEnemys();
                //handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.EnemyBoss, handler ));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }
            if (mouseOver(mx, my, 150, 250, 300, 64)) {
                game.gameState = Game.STATE.Help;
            }

            if (mouseOver(mx, my, 150, 350, 300, 64)) {
                System.exit(1);
            }
            if (mouseOver(mx, my, 150, 450, 300, 64)) {
                game.gameState = Game.STATE.Kalkulator;
            }
        }
        if(game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 150, 350, 300, 64)) {
                game.gameState = Game.STATE.Menu;
            }
        }
        if(game.gameState == Game.STATE.Kalkulator) {

            if (mouseOver(mx, my, 50, 200, 130, 130)) {
                System.out.println(7);
            }if (mouseOver(mx, my, 50, 350, 130, 130)) {
                System.out.println(4);
            }if (mouseOver(mx, my, 50, 500, 130, 130)) {
               System.out.println(1);
            }if (mouseOver(mx, my, 200, 200, 130, 130)) {
               System.out.println(8);
            }if (mouseOver(mx, my, 200, 350, 130, 130)) {
               System.out.println(5);
            }if (mouseOver(mx, my, 200, 500, 130, 130)) {
               System.out.println(2);
            }if (mouseOver(mx, my, 350, 200, 130, 130)) {
               System.out.println(9);
            }if (mouseOver(mx, my, 350, 350, 130, 130)) {
                System.out.println(6);
            }if (mouseOver(mx, my, 350, 500, 130, 130)) {
                System.out.println(3);
            }if (mouseOver(mx, my, 800, 360, 130, 65)) {
                System.out.println("x");
            }if (mouseOver(mx, my, 800, 440, 130, 65)) {
                System.out.println("-");
            }if (mouseOver(mx, my, 800, 520, 130, 65)) {
                System.out.println("+");
            }if (mouseOver(mx, my, 800, 600, 130, 65)) {
                System.out.println("=");
            }


            if (mouseOver(mx, my, 150, 640, 300, 64)) {
                game.gameState = Game.STATE.Menu;
            }

        }
        if(game.gameState == Game.STATE.End){
            if( mouseOver(mx, my,150, 350, 300, 64 )){
                game.gameState = Game.STATE.Game;
                handler.clearEnemys();
                hud.setLevel(1);
                hud.setScore(0);
            }
            if( mouseOver(mx, my,150, 450, 300, 64)){
                game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
            }
        }



    }

    public void mouseReleased(MouseEvent e) {
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            } else return false;
        }else return false;
    }


    public void tick(){

    }
    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawRect(150, 150, 300, 64);
            g.drawString("Play", 270, 190);


            g.drawRect(150, 250, 300, 64);
            g.drawString("Help", 270, 290);


            g.drawRect(150, 350, 300, 64);
            g.drawString("Quit", 270, 390);

            g.drawRect(150, 450, 300, 64);
            g.drawString("Kalkulator", 235, 490);
        }
        else if(game.gameState == Game.STATE.Help) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            g.setFont(fnt3);
            g.drawString("Use WASD to move", 150, 200);


            g.setFont(fnt2);
            g.drawRect(150, 350, 300, 64);
            g.drawString("<==Back", 240, 390);
        }else if(game.gameState == Game.STATE.Kalkulator) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);
            Font fnt4 = new Font("arial", 1, 100);

            g.setFont(fnt);
            g.setColor(Color.white);
            //g.drawString("Help", 240, 70);

            g.setFont(fnt3);
            //g.drawString("Use WASD to move HUJU", 150, 200);


            g.setFont(fnt2);
            g.setColor(Color.black);
            g.drawRect(50, 50, 900, 80);
            g.setColor(Color.WHITE);
            g.fillRect(50, 50, 900, 80);
            g.setFont(fnt4);
            g.setColor(Color.WHITE);
            g.fillRect(50, 200, 130, 130);
            g.fillRect(50, 350, 130, 130);
            g.fillRect(50, 500, 130, 130);
            g.fillRect(200, 200, 130, 130);
            g.fillRect(200, 350, 130, 130);
            g.fillRect(200, 500, 130, 130);
            g.fillRect(350, 350, 130, 130);
            g.fillRect(350, 500, 130, 130);
            g.fillRect(350, 200, 130, 130);
            g.fillRect(800, 360, 130, 65);
            g.fillRect(800, 440, 130, 65);
            g.fillRect(800, 520, 130, 65);
            g.fillRect(800, 600, 130, 65);
            g.setColor(Color.black);
            g.drawRect(50, 200, 130, 130);
            g.drawString("7", 90, 300);
            g.drawRect(50, 350, 130, 130);
            g.drawString("4", 90, 450);
            g.drawRect(50, 500, 130, 130);
            g.drawString("1", 90, 600);
            g.drawRect(200, 200, 130, 130);
            g.drawString("8", 240, 300);
            g.drawRect(200, 350, 130, 130);
            g.drawString("5", 240, 450);
            g.drawRect(200, 500, 130, 130);
            g.drawString("2", 240, 600);
            g.drawRect(350, 200, 130, 130);
            g.drawString("9", 390, 300);
            g.drawRect(350, 350, 130, 130);
            g.drawString("6", 390, 450);
            g.drawRect(350, 500, 130, 130);
            g.drawString("3", 390, 600);
            g.drawRect(800, 360, 130, 65);
            g.drawString("x",835, 420 );
            g.drawRect(800, 440, 130, 65);
            g.drawString("-",845, 500 );
            g.drawRect(800, 520, 130, 65);
            g.drawString("+",835, 587 );
            g.drawRect(800, 600, 130, 65);
            g.drawString("=",835, 667 );


            g.setFont(fnt2);
            g.drawRect(150, 640, 300, 64);
            g.drawString("<==Back", 240, 680);

        }else if(game.gameState == Game.STATE.End) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("GAME OVER", 240, 70);

            g.setFont(fnt3);
            g.drawString("Your score: " + hud.getScore(), 150, 200);


            g.setFont(fnt2);
            g.drawRect(150, 350, 300, 64);
            g.drawString("Try Again", 240, 390);

            g.setFont(fnt2);
            g.drawRect(150, 450, 300, 64);
            g.drawString("Back to Menu", 220, 490);
        }



    }

}
