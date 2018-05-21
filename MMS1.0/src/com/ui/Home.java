package com.ui;

import com.ui.Login.Logining;
import com.ui.patient.PatientHome;
import com.utils.BeautifulButton;
import com.utils.BeautifulFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private BeautifulFrame frame;
    private BeautifulButton loginButton;
    private JPanel masterPanel;
    private JPanel titleCenter;
    private Logining logining;
    private JPanel titleRight;

    public Home() {
        this.initComponents();

        frame.setVisible(true);

        //---loginButton---
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed();
            }
        });
    }

    public void initComponents() {
        frame = new BeautifulFrame();
        loginButton  = new BeautifulButton("未登录");
        masterPanel = frame.getMasterPane();
        titleCenter = frame.getTitleCenter();
        titleRight = frame.getTitleRight();

        //---titleCenter---
        titleCenter.setLayout(new BorderLayout());
        titleCenter.add(loginButton, BorderLayout.EAST);

    }

    private void loginActionPerformed() {
        if(logining == null) {
            //----logining----
            logining = new Logining(masterPanel);
            frame.getLayeredPane().add(logining, JLayeredPane.MODAL_LAYER);
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
