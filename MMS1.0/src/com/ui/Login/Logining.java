/*
 * Created by JFormDesigner on Fri May 18 16:46:35 CST 2018
 */

package com.ui.Login;

import com.sun.awt.AWTUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
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
        passwordCheckBox.addActionListener(e -> {showPasswordActionPerformed(e); });
    }

    private void initComponents() {
        userID = new JTextField();
        userName = new JComboBox<>();
        password = new JPasswordField();
        submit = new JButton();
        passwordCheckBox = new JCheckBox();

        //======== this ========
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.setSize(350, 300);
        this.setBackground(Color.lightGray);
        this.setLayout(null);

        userName.addItem("病人");
        userName.addItem("医生");
        userName.addItem("护士");
        this.add(userName);
        userName.setBackground(Color.white);
        userName.setFont(new Font("宋体", Font.PLAIN, 22));
        userName.setBounds(10, 50, 100, 50);
        userName.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));

        this.add(userID);
        userID.setFont(new Font("宋体", Font.PLAIN, 22));
        userID.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
        userID.setBounds(110, 50, 230, 50);

        this.add(password);
        password.setFont(new Font("宋体", Font.PLAIN, 22));
        password.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        password.setBounds(10, 100, 330, 50);

        //---- showPassword ----
        passwordCheckBox.setText("显示密码");
        passwordCheckBox.setBackground(Color.lightGray);
        passwordCheckBox.setFont(new Font("宋体", Font.PLAIN, 22));
        add(passwordCheckBox);
        passwordCheckBox.setBounds(10, 150, 150, 50);

        //---- submit ----
        submit.setText("登录");
        submit.setBackground(Color.red);
        submit.setFont(new Font("宋体", Font.PLAIN, 22));
        submit.setForeground(Color.white);
        add(submit);
        submit.setBounds(10, 200, 330, 50);
    }

    private void showPasswordActionPerformed(ActionEvent e) {

        if (passwordCheckBox.isSelected()){
            password.setEchoChar('\0');
        }
        else{
            password.setEchoChar('*');
        }
    }

    private JTextField userID;
    private JComboBox<String> userName;
    private JPasswordField password;
    private JButton submit;
    private JCheckBox passwordCheckBox;
}
