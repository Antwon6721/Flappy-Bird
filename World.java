/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.input.KeyCode;
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
    
    public World() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/60);
        bird = new Bird(200, 100);
        topPipe = new Pipe(1600, 0, true);
        bottomPipe = new Pipe(1600, 500, false);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        topPipe.update();
        topPipe.draw(g);
        bottomPipe.update();
        bottomPipe.draw(g);
        g.drawString("" + bird.getScore(), 200, 200);
        if(bird.isAlive() == true){
            bird.gravity();
            bird.collideWorldBounds(1440,840);
            bird.collide(topPipe, bottomPipe);
            bird.update();
            bird.draw(g);
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
