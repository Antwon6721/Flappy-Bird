/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


/**
 *
 * @author 641580
 */
public class Bird extends Sprite{
    
    private ImageIcon ii;
    private Image img;
    
    private static final int SPEED = 3;
    private static final Color COLOR = Color.WHITE;
    public int t = 0;

    public Bird(int x, int y) {
        super(SPEED, x, y, 0, -4, 51, 36, COLOR);
        ii = new ImageIcon(getClass().getResource("Bird.png"));
        img = ii.getImage();
    }
    
    @Override
     public void draw(Graphics g) {
         g.setColor(super.getColor());
        g.drawImage(img, super.getX(), super.getY(), super.getWidth(), super.getHeight(), null);
        if(this.alive == false){
            g.setColor(new Color(0, 0, 0));
            g.drawString("Would You like to play again press ENTER", 530, 465);
        }
        
    }
     
    
    public void gravity() {
        if(super.getVy() > 16){
            super.setVy(16);
        }
        super.setVy(super.getVy() + .3);
    }
}

