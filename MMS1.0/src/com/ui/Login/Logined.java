package com.ui.Login;

import com.ui.Doctor.DoctorHome;
import com.ui.Home;
import com.ui.Nurse.NurseHome;
import com.ui.guide.PationGuide;
import com.ui.patient.PatientHome;
import com.utils.BeautifulButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登陆后的界面
 * @author dutz
 */
public class Logined extends JPanel {
    private Home home;

    public Logined(Home home) {
        this.home = home;
        initComponents();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed();
            }
        });
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userButtonActionPerformed();
            }
        });
    }

    public void initComponents() {
        userButton = new BeautifulButton("你好");
        exitButton = new JButton("退出登陆");

        //======== this ========
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.setSize(300, 200);
        this.setBackground(Color.lightGray);
        this.setLayout(null);

        //-------------userButton----------
        userButton.setText(Session.user.toString());
        userButton.setFont(new Font("宋体", Font.PLAIN, 22));
        add(userButton);
        userButton.setBounds(10, 50, 280, 50);

        //---- submitButton ----
        exitButton.setFont(new Font("宋体", Font.PLAIN, 22));
        exitButton.setBackground(Color.red);
        exitButton.setForeground(Color.white);
        add(exitButton);
        exitButton.setBounds(10, 120, 280, 50);
    }

    private void exitButtonActionPerformed() {
        Session.user = null;
        Session.loginedHome = null;
        home.getMasterPanel().removeAll();
        home.getMasterPanel().add(new PationGuide(), BorderLayout.CENTER);
        home.getMasterPanel().updateUI();
        this.setVisible(false);
        home.getLoginButton().setText("未登录");
    }

    private void userButtonActionPerformed() {
        String userName = Session.user.getUserName();
        home.getMasterPanel().removeAll();
        switch (userName) {
            case "医生":
                DoctorHome doctorHome = (DoctorHome)Session.loginedHome;
                home.getMasterPanel().add(doctorHome, BorderLayout.CENTER);
                home.getMasterPanel().updateUI();
                break;
            case "护士":
                NurseHome nurseHome = (NurseHome)Session.loginedHome;
                home.getMasterPanel().add(nurseHome, BorderLayout.CENTER);
                home.getMasterPanel().updateUI();
                break;
            case "病人":
                PatientHome patientHome = (PatientHome)Session.loginedHome;
                home.getMasterPanel().add(patientHome, BorderLayout.CENTER);
                home.getMasterPanel().updateUI();
                break;
        }
        this.setVisible(false);
    }

    private BeautifulButton userButton;
    private JButton exitButton;
}
