/*
 * Created by JFormDesigner on Fri May 18 16:46:35 CST 2018
 */

package com.ui.Login;

import com.ui.Doctor.DoctorHome;
import com.ui.Nurse.NurseHome;
import com.ui.patient.PatientHome;
import com.utils.JDBCUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 * @author du
 */
public class Logining extends JPanel {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 600);
        jFrame.getContentPane().setLayout(null);
        Logining logining = new Logining(null);
        logining.setLocation(0, 0);
        jFrame.getContentPane().add(logining);
        jFrame.setLocationRelativeTo(jFrame.getOwner());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }

    public Logining(JPanel masterPanel) {
        this.masterPanel = masterPanel;
        initComponents();
        passwordCheckBox.addActionListener(e -> {showPasswordActionPerformed(e); });
        //==================测试===========================================
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userNameComnoBox.getSelectedItem().toString().equals("病人")) {
                    masterPanel.removeAll();
                    PatientHome patientHome = new PatientHome(null);
                    masterPanel.add(patientHome, BorderLayout.CENTER);
                    masterPanel.repaint();
                } else {
                    masterPanel.removeAll();
                    masterPanel.repaint();
                }
            }
        });
        //===============================================================================
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

        userNameComnoBox.addItem("病人");
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
        String strUserName;
        String strUserID;
        String strPassword;
        switch(userNameComnoBox.getSelectedItem().toString().trim()) {
            case "医生":
                strUserName = "Doctor";
                break;
            case "护士":
                strUserName = "Nurse";
                break;
            default:
                strUserName = "Patient";
                break;
        }
        strUserID = userIDField.getText().trim();
        strPassword = String.valueOf(passwordField.getPassword()).trim();

        if (userIDField.getText().trim().equals("")) // 判断是否用户名和密码都为空
        {
            JOptionPane.showMessageDialog(null, "用户名不可为空!");
            return;
        }
        if (passwordField.equals("")) {
            JOptionPane.showMessageDialog(null, "密码不可为空!");
            return;
        }

        if(isTrueUser()) {
            switch (strUserName) {
                case "Doctor":
                   new DoctorHome("D201821205");
                    break;
                case "Nurse":
                    new NurseHome("N201821102");

                    break;
                default:
                    new PatientHome(strUserName);
                    break;
            }
        }

    }

    //判断是否为正确的用户
    public boolean isTrueUser() {
        String strSQL;
        Map<String, Object> maps = new HashMap<>();
        strSQL = "select * from UserInfo where UserName = '"+ userNameComnoBox +"'and PassWord = '"+ passwordField +"'and UserID = '"+ userIDField +"'";
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

    private JComboBox<String> userNameComnoBox;
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JCheckBox passwordCheckBox;
    private JPanel masterPanel;
}
