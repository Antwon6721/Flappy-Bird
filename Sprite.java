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

/**
 *
 * @author 641580
 */
public abstract class Sprite {
    private int height, width, x, y;
    private double vx, vy;
    private Rectangle bounds;
    private Color color;
    private int speed;
    
      public Sprite(int speed,int x, int y, double vx, double vy, int width, int height, Color color) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.vy = vy;
        this.vx = vx;
        this.width = width;
        this.height = height;
        this.color = color;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
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
    
    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Color getColor() {
        return color;
    }

   
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void update() {
        x += vx;
        y += vy;
        if (x < -100) {
            x = 1600;
        }
    }
    public abstract void draw(Graphics g);
    
}
