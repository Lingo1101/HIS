/*
 * Created by JFormDesigner on Fri May 18 16:46:35 CST 2018
 */

package com.ui.Login;

import com.model.User;
import com.ui.Doctor.DoctorHome;
import com.ui.Home;
import com.ui.Nurse.NurseHome;
import com.ui.patient.PatientHome;
import com.utils.JDBCUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.*;

/**
 * 未登录的界面
 * @author dutz
 */
public class Logining extends JPanel {

    public Logining(Home home) {
        this.home = home;
        masterPanel = home.getMasterPanel();
        initComponents();
        passwordCheckBox.addActionListener(e -> {showPasswordActionPerformed(e); });
        submitButton.addActionListener(e -> {submitButtonActionPerformed(e);});
        userIDField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyActionPerformed(e);
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyActionPerformed(e);
            }
        });

    }

    private void initComponents() {
        userIDField = new JTextField();
        userNameComnoBox = new JComboBox<>();
        passwordField = new JPasswordField();
        submitButton = new JButton();
        passwordCheckBox = new JCheckBox();

        //======== this ========
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        this.setSize(350, 300);
        this.setBackground(Color.lightGray);
        this.setLayout(null);

        userNameComnoBox.addItem("患者");
        userNameComnoBox.addItem("医生");
        userNameComnoBox.addItem("护士");
        this.add(userNameComnoBox);
        userNameComnoBox.setBackground(Color.white);
        userNameComnoBox.setFont(new Font("宋体", Font.PLAIN, 22));
        userNameComnoBox.setBounds(10, 50, 100, 50);
        userNameComnoBox.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));

        this.add(userIDField);
        userIDField.setFont(new Font("宋体", Font.PLAIN, 22));
        userIDField.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
        userIDField.setBounds(110, 50, 230, 50);

        this.add(passwordField);
        passwordField.setFont(new Font("宋体", Font.PLAIN, 22));
        passwordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        passwordField.setBounds(10, 100, 330, 50);

        //---- showPassword ----
        passwordCheckBox.setText("显示密码");
        passwordCheckBox.setBackground(Color.lightGray);
        passwordCheckBox.setFont(new Font("宋体", Font.PLAIN, 22));
        add(passwordCheckBox);
        passwordCheckBox.setBounds(10, 150, 150, 50);

        //---- submitButton ----
        submitButton.setText("登录");
        submitButton.setBackground(Color.red);
        submitButton.setFont(new Font("宋体", Font.PLAIN, 22));
        submitButton.setForeground(Color.white);
        add(submitButton);
        submitButton.setBounds(10, 200, 330, 50);
    }

    private void submitButtonActionPerformed(ActionEvent e) {
        if(isTrueUser()) {
            try {
                masterPanel.removeAll();
                switch (userNameComnoBox.getSelectedItem().toString()) {
                    case "医生":
                        DoctorHome doctorHome = new DoctorHome(userIDField.getText().toString().trim());
                        Session.loginedHome = doctorHome;
                        masterPanel.add(doctorHome, BorderLayout.CENTER);
                        masterPanel.updateUI();
                        break;
                    case "护士":
                        NurseHome nurseHome = new NurseHome(userIDField.getText().toString().trim());
                        Session.loginedHome = nurseHome;
                        masterPanel.add(nurseHome, BorderLayout.CENTER);
                        masterPanel.updateUI();
                        break;
                    case "患者":
                        PatientHome patientHome = new PatientHome(userIDField.getText().toString().trim());
                        Session.loginedHome = patientHome;
                        masterPanel.add(patientHome, BorderLayout.CENTER);
                        masterPanel.updateUI();
                        break;
                }
            } finally {
                home.getLoginButton().setText(userNameComnoBox.getSelectedItem().toString());
                //初始化User
                Session.user = new User();
                Session.user.setUserName(userNameComnoBox.getSelectedItem().toString());
                Session.user.setUserID(userIDField.getText());
                this.setVisible(false);
            }
        }

    }

    //判断是否为正确的用户
    public boolean isTrueUser() {
        String userName = userNameComnoBox.getSelectedItem().toString();
        String password = String.valueOf(passwordField.getPassword()).trim();
        String userID = userIDField.getText().toString().trim();
        switch (userName) {
            case "医生":
                userName = "Doctor";
                break;
            case "护士":
                userName = "Nurse";
                break;
            case "患者":
                userName = "Patient";
                break;
        }
        String strSQL;
        Map<String, Object> maps = new HashMap<>();
        strSQL = "select * from UserInfo where UserName = '"+ userName
                +"'and PassWord = '"+ password +"'and UserID = '"+ userID +"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL, null);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        if(maps.size() != 0) {
            return true;
        }
        return false;
    }

    /**
     * 显示密码监听
     * @param e
     */
    private void showPasswordActionPerformed(ActionEvent e) {
        if (passwordCheckBox.isSelected()){
            passwordField.setEchoChar('\0');
        }
        else{
            passwordField.setEchoChar('*');
        }
    }

    private void KeyActionPerformed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ENTER) {
            submitButton.doClick();
        }
    }

    private JComboBox<String> userNameComnoBox;
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JCheckBox passwordCheckBox;
    private Home home;
    private JPanel masterPanel;
}
