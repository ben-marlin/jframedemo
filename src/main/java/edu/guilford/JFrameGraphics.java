package edu.guilford;

// Example program for Project 11

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameGraphics extends JFrame {

    public JFrameGraphics() {
        setTitle("Drawing Example"); // Set the title of the JFrame

        setSize(400, 400); // Sets size of JFrame in pixels
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tells JFrame to end program when it's closed
        
        setLocationRelativeTo(null);
        
        DrawingPanel panel = new DrawingPanel();
        panel.setBackground(Color.LIGHT_GRAY); // Set the background color of the panel
        add(panel);
    }

    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
    
            // Draw a blue rectangle 
            g.setColor(Color.BLUE);
            g.fillRect(50, 50, 100, 100);  // x, y, width, height
    
            // Draw a red circle
            g.setColor(Color.RED);
            g.fillOval(200, 50, 150, 100);  // x, y, width, height
    
            // Draw a yellow rounded rectangle
            g.setColor(Color.YELLOW);
            g.fillRoundRect(100, 200, 200, 100, 50, 50);  // x, y, width, height, arcWidth, arcHeight
    
            // Print text in black
            g.setColor(Color.BLACK);
            g.drawString("your name here", 150, 350);  // text, x, y
        }
    }

    public static void main(String[] args) {
        JFrameGraphics frame = new JFrameGraphics();
        frame.setVisible(true);
    }
}
