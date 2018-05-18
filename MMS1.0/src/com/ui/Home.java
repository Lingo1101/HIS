package com.ui;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ui.Login.Logining;
import com.utils.BeautifulButton;
import com.utils.BeautifulFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private BeautifulFrame frame;
    private BeautifulButton loginButton;
    private JPanel titleCenter;
    private Logining logining;
    private JPanel titleRight;

    public Home() {
        this.initComponents();
        frame.setVisible(true);
    }

    public void initComponents() {
        frame = new BeautifulFrame();
        loginButton  = new BeautifulButton("未登录");
        titleCenter = frame.getTitleCenter();
        titleRight = frame.getTitleRight();

        //---loginButton---
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginListener();
            }
        });

        //---titleCenter---
        titleCenter.setLayout(new BorderLayout());
        titleCenter.add(loginButton, BorderLayout.EAST);

    }

    private void loginListener() {
        if(logining == null) {
            //----logining----
            logining = new Logining();
            frame.getLayeredPane().add(logining, JLayeredPane.DRAG_LAYER);
            Point titleRightPoint = titleRight.getLocation();
            Point loginingPoint = new Point(titleRightPoint.x - logining.getWidth(), titleRightPoint.y + 60);
            logining.setLocation(loginingPoint);
        } else if(logining.isVisible()) {
            logining.setVisible(false);
        } else {
            logining.setVisible(true);
        }

    }

}
