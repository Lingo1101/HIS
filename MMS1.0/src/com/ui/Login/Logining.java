/*
 * Created by JFormDesigner on Fri May 18 16:46:35 CST 2018
 */

package com.ui.Login;

import java.awt.*;
import javax.swing.*;

/**
 * @author du
 */
public class Logining extends JPanel {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 600);
        jFrame.getContentPane().setLayout(null);
        Logining logining = new Logining();
        logining.setLocation(0, 0);
        jFrame.getContentPane().add(logining);
        jFrame.setLocationRelativeTo(jFrame.getOwner());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }
    public Logining() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        userID = new JTextField();
        userName = new JComboBox();
        password = new JPasswordField();
        submit = new JButton();
        showPassword = new JCheckBox();

        //======== this ========
        this.setSize(350, 300);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.add(userName);
        userName.setBounds(10, 50, 100, 50);
        userName.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));
        this.add(userID);
        userID.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
        userID.setBounds(110, 50, 230, 50);
        this.add(password);
        password.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        password.setBounds(10, 100, 330, 50);

        //---- showPassword ----
        showPassword.setText("显示密码");
        showPassword.setBackground(Color.white);
        showPassword.setFont(new Font("宋体", Font.PLAIN, 20));
        add(showPassword);
        showPassword.setBounds(10, 150, 150, 50);

        //---- submit ----
        submit.setText("登陆");
        submit.setBackground(Color.red);
        submit.setFont(new Font("宋体", Font.PLAIN, 20));
        submit.setForeground(Color.white);
        add(submit);
        submit.setBounds(10, 200, 330, 50);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField userID;
    private JComboBox userName;
    private JPasswordField password;
    private JButton submit;
    private JCheckBox showPassword;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
