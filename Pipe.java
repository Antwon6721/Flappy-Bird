/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 641580
 */
public class Pipe extends Sprite{
    
    private ImageIcon ii;
    private Image img;
    private static final int SPEED = 3;
    private static final Color COLOR = Color.RED;

 
    public Pipe(int x , int y, boolean topPipe) {
       super(SPEED, x, y, -5, 0, 60, 360, COLOR);
        if (topPipe){
            ii = new ImageIcon(getClass().getResource("Pipe Top.png"));
            img = ii.getImage();
        }
        else{
            ii = new ImageIcon(getClass().getResource("Pipe Bottom.png"));
            img = ii.getImage();
        }
    
    }
     @Override
    public void draw(Graphics g) {
     g.drawImage(img, super.getX(), super.getY(), super.getWidth(), super.getHeight(), null);
    }
    
    public void changeSpeed() {
    }
}
