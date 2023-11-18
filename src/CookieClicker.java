import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

public class CookieClicker extends JFrame implements ActionListener {
    //The number of cursors, grandmas, and farms the player bought
    int cursors = 0;
    int gms = 0;
    int farms = 0;


    //You increase in a number of cookies every few seconds depending on how many of the cursors, grandmas, and farms
    //bought
    Timer t = new Timer();
    TimerTask cookieUp = new TimerTask(){

        @Override
        public void run() {
            cookies += (1 * cursors + 5 * gms + 10 * farms);
            cookieLabel.setText("Cookies: " + cookies);
        }
    };

    JButton button;
    JButton cbut;
    JButton gbut;
    JButton fbut;
    JLabel cookieLabel;
    JLabel storeLabel;
    int cookies;

    CookieClicker() {

        //cookiesIncreased
        t.scheduleAtFixedRate(cookieUp, 1000, 1000);

        //imageIcon for cookie png

        ImageIcon image = new ImageIcon("cookie.png");
        Image resize = image.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        image = new ImageIcon(resize);

        ImageIcon backround = new ImageIcon("ccback.jpg");

        //cookieLabel
        cookieLabel = new JLabel();
        cookieLabel.setBounds(125, 50, 400, 50);
        cookieLabel.setText("Cookies: " + cookies);
        cookieLabel.setFont(new Font("MV Boli", Font.PLAIN, 50));

        //label for store
        storeLabel = new JLabel();
        storeLabel.setText("Cursors: " + cursors + "  Grandmas: " + gms + " Farms: " + farms);
        storeLabel.setBounds(50, 330, 400, 80);
        storeLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
        storeLabel.setBorder(BorderFactory.createTitledBorder("Store"));
        storeLabel.setOpaque(true);

        //button for clicking
        button = new JButton();
        button.setBounds(75, 140, 350, 150);
        button.addActionListener(this);
        button.setText("click for cookies");
        button.setFocusable(false);
        button.setIcon(image);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(10);
        button.setForeground(Color.RED);
        button.setOpaque(true);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //button for cursor
        cbut = new JButton();
        cbut.setBounds(110, 410, 50, 50);
        cbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookies >= 10) {
                    cursors++;
                    storeLabel.setText("Cursors: " + cursors + "  Grandmas: " + gms + " Farms: " + farms);
                    cookies -= 10;
                    cookieLabel.setText("Cookies: " + cookies);
                }
            }
        });
        cbut.setText("Cursor");
        cbut.setFocusable(false);
        cbut.setHorizontalTextPosition(JButton.CENTER);
        cbut.setVerticalTextPosition(JButton.BOTTOM);
        cbut.setFont(new Font("Comic Sans", Font.BOLD, 10));
        cbut.setIconTextGap(10);
        cbut.setForeground(Color.black);
        cbut.setOpaque(true);
        cbut.setBackground(Color.LIGHT_GRAY);
        cbut.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        gbut = new JButton();
        gbut.setBounds(225, 410, 50, 50);
        gbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookies >= 100) {
                    gms++;
                    storeLabel.setText("Cursors: " + cursors + "  Grandmas: " + gms + " Farms: " + farms);
                    cookies -=100;
                    cookieLabel.setText("Cookies: " + cookies);
                }
            }
        });
        gbut.setText("Grandma");
        gbut.setFocusable(false);
        gbut.setHorizontalTextPosition(JButton.CENTER);
        gbut.setVerticalTextPosition(JButton.BOTTOM);
        gbut.setFont(new Font("Comic Sans", Font.BOLD, 8));
        gbut.setIconTextGap(10);
        gbut.setForeground(Color.black);
        gbut.setOpaque(true);
        gbut.setBackground(Color.LIGHT_GRAY);
        gbut.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        fbut = new JButton();
        fbut.setBounds(335, 410, 50, 50);
        fbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookies >= 1000) {
                    farms++;
                    cookies -=1000;
                    storeLabel.setText("Cursors: " + cursors + "  Grandmas: " + gms + " Farms: " + farms);
                    cookieLabel.setText("Cookies: " + cookies);
                }
            }
        });
        fbut.setText("Farm");
        fbut.setFocusable(false);
        fbut.setHorizontalTextPosition(JButton.CENTER);
        fbut.setVerticalTextPosition(JButton.BOTTOM);
        fbut.setFont(new Font("Comic Sans", Font.BOLD, 10));
        fbut.setIconTextGap(10);
        fbut.setForeground(Color.black);
        fbut.setOpaque(true);
        fbut.setBackground(Color.LIGHT_GRAY);
        fbut.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        //frame

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.add(button);
        this.add(cookieLabel);
        this.add(storeLabel);
        this.add(cbut);
        this.add(gbut);
        this.add(fbut);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        cookies++;
        cookieLabel.setText("Cookies: " + cookies);

        if (cookies == 15) {

        }


    }
}


