package com.view;

import com.utils.JDBCUtils;
import com.view.Doctor.DoctorHome;
import com.view.Nurse.NurseHome;
import com.view.patient.PatientHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/*
 * Created by JFormDesigner on Wed Mar 28 08:04:14 CST 2018
 */


/**
 * @author dasdfaf
 */
public class Login extends JFrame {
    String userID="", userName="", password="";

    public Login(){
        initComponents();
        setTitle("登录");
        setSize(500, 500);
        this.setLocationRelativeTo(getOwner());
        setVisible(true);

    }

    private void button1ActionPerformed(ActionEvent e) {

        JPasswordField jpf=new JPasswordField(10);
        jpf.setEchoChar('.');

        userID= textField1.getText().trim();
        switch(comboBox1.getSelectedItem().toString().trim()) {
            case "医生":
                userName = "Doctor";
                break;
            case "护士":
                userName = "Nurse";
                break;
            default:
                userName = "Patient";
                break;
        }
        password= passwordField1.getText().trim();

        if (textField1.getText().trim().equals("")) // 判断是否用户名和密码都为空
        {
            JOptionPane.showMessageDialog(null, "用户名不可为空!");
            return;
        }
        if (passwordField1.equals("")) {
            JOptionPane.showMessageDialog(null, "密码不可为空!");
            return;
        }



        if(isTrueUser()) {
            switch (userName) {
                case "Doctor":
                    new DoctorHome("D201821205");
                    dispose();
                    break;
                case "Nurse":
                    new NurseHome("N201821102");
                    dispose();
                    break;
                default:
                    new PatientHome();
                    dispose();
                    break;
            }
        }

    }

    public boolean isTrueUser() {
        String strSQL;
        Map<String, Object> maps = new HashMap<>();
        strSQL = "select * from UserInfo where UserName = '"+userName+"'and PassWord = '"+password+"'and UserID = '"+userID+"'";
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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        checkBox1 = new JCheckBox();
        comboBox1 = new JComboBox<>();
        passwordField1 = new JPasswordField();

        //======== this ========
        setTitle("\u533b\u751f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u8eab\u4efd\uff1a");
        contentPane.add(label1);
        label1.setBounds(165, 120, 75, 25);

        //---- label2 ----
        label2.setText("\u7528\u6237ID\uff1a");
        contentPane.add(label2);
        label2.setBounds(175, 155, 50, label2.getPreferredSize().height);

        //---- textField1 ----
        textField1.setText("N201821102");
        contentPane.add(textField1);
        textField1.setBounds(235, 150, 90, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u7528\u6237\u5bc6\u7801\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(165, 190), label3.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(170, 260), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(285, 260), button2.getPreferredSize()));

        //---- checkBox1 ----
        checkBox1.setText("\u663e\u793a\u5bc6\u7801");
        contentPane.add(checkBox1);
        checkBox1.setBounds(new Rectangle(new Point(350, 185), checkBox1.getPreferredSize()));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u533b\u751f",
            "\u62a4\u58eb",
            "\u75c5\u4eba"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(235, 120, 90, comboBox1.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(235, 185, 90, passwordField1.getPreferredSize().height);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JCheckBox checkBox1;
    private JComboBox<String> comboBox1;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
