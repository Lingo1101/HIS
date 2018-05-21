package com.ui;

import com.ui.Login.Logining;
import com.ui.guide.PationGuide;
import com.ui.patient.PatientHome;
import com.utils.BeautifulButton;
import com.utils.BeautifulFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {
    private BeautifulFrame frame;
    private BeautifulButton loginButton;
    private JPanel masterPanel;
    private JPanel titleCenter;
    private Logining logining;
    private JPanel titleRight;
    private PationGuide pationGuide;
    private JLabel titleLabel;

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

        //------------titleLabel--------------------
        titleLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                masterPanel.removeAll();
                masterPanel.add(pationGuide, BorderLayout.CENTER);
                masterPanel.repaint();
            }
        });
    }

    public void initComponents() {
        frame = new BeautifulFrame();
        loginButton  = new BeautifulButton("未登录");
        masterPanel = frame.getMasterPane();
        titleCenter = frame.getTitleCenter();
        titleRight = frame.getTitleRight();
        titleLabel = frame.getTitleLabel();

        //---titleCenter---
        titleCenter.setLayout(new BorderLayout());
        titleCenter.add(loginButton, BorderLayout.EAST);

        //----patientHome-----
        pationGuide = new PationGuide();
        masterPanel.add(pationGuide, BorderLayout.CENTER);

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
