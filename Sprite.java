/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 641580
 */
public abstract class Sprite {
    private int height, width, x, y, score;
    private double vx, vy;
    private Rectangle bounds;
    private Color color;
    private int speed;
    boolean alive = true;
    int d = 0;
    private ImageIcon ii;
    private Image img;
    
      public Sprite(int speed,int x, int y, double vx, double vy, int width, int height, Color color) {
        this.speed = speed;
        this.score = 0;
        this.x = x;
        this.y = y;
        this.vy = vy;
        this.vx = vx;
        this.width = width;
        this.height = height;
        this.color = color;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height); 
        ii = new ImageIcon(getClass().getResource("Game Over.png"));
        img = ii.getImage();
    }
      
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public void die() {
        this.alive = false;
        
    }
     
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    

    public double getVy() {
        return vy;
    }

    public void setVy(double vy){
        this.vy = vy;
    }
    

    public Color getColor() {
        return color;
    }

   
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void collideWorldBounds(int cWidth, int cHeight) {
        if (this.y <= 0) {
            this.vy = 0;
            this.y++;
        }
        if (this.y + this.height >= cHeight) {
            this.vy = 0;
            this.y = cHeight - this.height;
        }
    }
    
    public Rectangle getBounds() {
        return bounds;
    }
    
     public void collide(Sprite topPipe, Sprite bottomPipe) {
        if (this.bounds.intersects(topPipe.getBounds()) || this.bounds.intersects(bottomPipe.getBounds())) {
            this.vx = 0;
            this.vy = 0;
            topPipe.vx = 0;
            bottomPipe.vx = 0;
            this.die();
        }
        if(topPipe.x + topPipe.width == this.x){
           System.out.println("Pass");
           this.setScore(this.getScore() + 1);
        }
    }
     
    
    public void update() {
        x += vx;
        y += vy;
        if (x < -100) {
            x = 1600;
        }
        
      this.bounds = new Rectangle(x, y, width, height);
    }
    public abstract void draw(Graphics g);
    
}
