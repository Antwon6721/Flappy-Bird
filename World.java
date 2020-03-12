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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author 641580
 */
public class World extends JPanel{
    private Timer timer;
    private Bird bird;
    private Pipe topPipe;
    private Pipe bottomPipe;
    private ImageIcon ii;
    private Image img;
     private ImageIcon yy;
    private Image im;
    
    public World() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/60);
        bird = new Bird(200, 100);
        topPipe = new Pipe(1600, 0, true);
        bottomPipe = new Pipe(1600, 550, false);
        ii = new ImageIcon(getClass().getResource("Background.png"));
        img = ii.getImage();
        yy = new ImageIcon(getClass().getResource("Game Over.png"));
        im = yy.getImage();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        g.drawImage(img, 0, 0, 1440, 840, null);
        topPipe.update();
        topPipe.draw(g);
        bottomPipe.update();
        bottomPipe.draw(g);
        bird.draw(g);
        if(bird.isAlive() == true){
            bird.gravity();
            bird.collideWorldBounds(1440,840);
            bird.collide(topPipe, bottomPipe);
            bird.update();
            
        }
        g.setColor(new Color(0, 125, 0));
        g.fillRoundRect(40, 35, 73, 21, 8, 8);
        g.fillRoundRect(40, 35, 73 + (int) Math.log10(bird.getScore()) * 7, 21, 8, 8);
        g.setColor(new Color(255, 255, 255));
        g.drawString("SCORE: " + bird.getScore(), 50, 50);
       if (bird.isAlive() == false){
            g.drawImage(im, 500, 350, 300, 100, null);
       }
    }
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.setVy(-8);
            bird.setY(bird.getY() - 1);
        }
    }
}
