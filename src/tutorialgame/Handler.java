package tutorialgame;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> obiect = new LinkedList<GameObject>();

    public void tick(){
        for (int i = 0; i < obiect.size(); i++) {
            GameObject tempObject = obiect.get(i);

            tempObject.tick();
        }
    }
    public void render(Graphics g   ){
        for (int i = 0; i < obiect.size(); i++) {
            GameObject tempObject = obiect.get(i);

            tempObject.render(g);
        }
    }


    public void addObject(GameObject object){
        this.obiect.add(object);
    }
    public  void removeObject(GameObject object){
        this.obiect.remove(object);
    }
    public void clearEnemys(){
        for (int i = 0; i < obiect.size(); i++) {
            GameObject tempObject = obiect.get(i);

            if(tempObject.getId()== ID.Player)
            {
                obiect.clear();
                addObject(new  Player((int)tempObject.getX(),(int)tempObject.getY(),ID.Player,this));
            }
        }
    }

}
