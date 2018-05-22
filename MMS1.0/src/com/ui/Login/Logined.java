package com.ui.Login;

import com.ui.Home;
import com.ui.guide.PationGuide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logined extends JPanel {
    private Home home;

    public Logined(Home home) {
        this.home = home;
        initComponents();
        exitLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed();
            }
        });
    }

    public void initComponents() {
        message = new JLabel("你好");
        exitLogin = new JButton("退出登陆");

        //======== this ========
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.setSize(300, 200);
        this.setBackground(Color.lightGray);
        this.setLayout(null);

        //-------------message----------
        message.setText(Session.user.toString());
        message.setFont(new Font("宋体", Font.PLAIN, 22));
        add(message);
        message.setBounds(10, 50, 280, 50);

        //---- submitButton ----
        exitLogin.setFont(new Font("宋体", Font.PLAIN, 22));
        exitLogin.setBackground(Color.red);
        exitLogin.setForeground(Color.white);
        add(exitLogin);
        exitLogin.setBounds(10, 120, 280, 50);
    }

    private void exitButtonActionPerformed() {
        Session.user = null;
        home.getMasterPanel().removeAll();
        home.getMasterPanel().add(new PationGuide(), BorderLayout.CENTER);
        home.getMasterPanel().updateUI();
        this.setVisible(false);
        home.getLoginButton().setText("未登录");
    }

    private JLabel message;
    private JButton exitLogin;
}
