import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    //private Thread thread;
    Player set1 = new Player(250,50,15);
    Player set2 = new Player(50,350,15);
    Player set3 = new Player(450,350,15);

    //Player[] points = new Player[1000];
    ArrayList<Player> points = new ArrayList<Player>(1500);
    int m = 0;



    public GamePanel() {
        setPreferredSize(new Dimension(800, 550));

        setFocusable(true);
        setPoint(points, 1500);

        JSlider slide = new JSlider(0, 3000, 1500);
        slide.setPaintTrack(true);
        //slide.setPaintTicks(true);
        //slide.setPaintLabels(true);
        slide.setMajorTickSpacing(100);
        slide.setMinorTickSpacing(10);
        JLabel l = new JLabel();
        l.setText("Value = " + slide.getValue());
        slide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ArrayList<Player> r =  points;
                points.removeAll(r);
                setPoint(points,slide.getValue());

                repaint();
                l.setText("Value = " + slide.getValue());
            }
        });
        add(l);
        add(slide);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.clearRect(0, 0, 800, 550);

        set1.draw(g);
        set2.draw(g);
        set3.draw(g);


        for(int i = 0; i < points.size(); i++) {
            points.get(i).draw(g);
        }
    }
    public void help(Graphics g) {
        points.get(m).draw(g);
        m++;
        repaint();
    }
    public void setPoint(ArrayList<Player> p, int num) {
        int x1,x2,y1,y2;
        x1 = 200;
        y1 = 100;
        y2 = 0;
        x2 = 0;
        for(int i = 0; i < num; i++) {
            int pick = (int)(Math.random()*3+1);

            if(pick==1) {x2 = 250; y2 = 50;}
            if(pick==2) {x2 = 50; y2 = 350;}
            if(pick==3) {x2 = 450; y2 = 350;}
            int x = (x2+x1)/2;
            int y = (y2+y1)/2;
            p.add(new Player(x,y,5));
            x1 = p.get(i).getx();
            y1 = p.get(i).gety();
        }
    }


}
