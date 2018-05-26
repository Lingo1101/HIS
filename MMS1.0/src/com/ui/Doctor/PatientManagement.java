package com.ui.Doctor;

import com.utils.JDBCUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed May 09 09:29:44 CST 2018
 */



/**
 * @author dasdfaf
 */
public class PatientManagement extends JFrame {
    private static String patientID;      // 用于赋PatientID的值
    private static String DoctorID;      //用于赋DoctorID的值
    private static String getPatientID() {
        return patientID;
    }
    private static String getDoctorID() {
        return DoctorID;
    }

    private static void setPatientID(String patientID) {
        PatientManagement.patientID = patientID;
    }
    private static void setDoctorID(String DoctorID) {
        PatientManagement.DoctorID = DoctorID;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public PatientManagement(String patientID ,String DoctorID) {
        initComponents();
        setTitle("患者编辑");
        setSize(500, 500);
        setLocation(100, 100);

//       病人基本信息自动显示

        setPatientID(patientID);
        setDoctorID(DoctorID);
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult("select * from PatientInfo where PatientID='" +  patientID + "'", null);
            textField1.setText(maps.get("PatientID".toUpperCase()).toString());
            textField2.setText(maps.get("PatientName".toUpperCase()).toString());
            textField3.setText(maps.get("GENDER".toUpperCase()).toString());
            textField4.setText(maps.get("BIRTHDAY".toUpperCase()).toString());
            textField5.setText(maps.get("IDNumber".toUpperCase()).toString());
            textField6.setText(maps.get("PhoneNumber".toUpperCase()).toString());
            textField7.setText(maps.get("Address".toUpperCase()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

//         病人基本信息编辑修改，可运行

    private void button1ActionPerformed(ActionEvent e) {
        String strSQL = "update PatientInfo set PatientName = '" + textField2.getText().trim() + "' where PatientID = '" + patientID+ "'";
        String strSQL1 = "update PatientInfo set GENDER = '" + textField3.getText().trim() + "' where PatientID = '" + patientID+ "'";
        String strSQL2= "update PatientInfo set BIRTHDAY= '" + textField4.getText().trim() + "' where PatientID = '" + patientID+ "'";
        String strSQL3 = "update PatientInfo set IDNumber = '" + textField5.getText().trim() + "' where PatientID = '" + patientID+ "'";
        String strSQL4 = "update PatientInfo set PhoneNumber = '" + textField6.getText().trim() + "' where PatientID = '" + patientID+ "'";
        String strSQL5 = "update PatientInfo set Address = '" + textField7.getText().trim() + "' where PatientID = '" + patientID+ "'";
        try {
            JDBCUtils.updateByPreparedStatement(strSQL, null);
            JDBCUtils.updateByPreparedStatement(strSQL2, null);
            JDBCUtils.updateByPreparedStatement(strSQL3, null);
            JDBCUtils.updateByPreparedStatement(strSQL4, null);
            JDBCUtils.updateByPreparedStatement(strSQL5, null);
        } catch (Exception er) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "检查是否连接数据库");
            return;
        }
        JOptionPane.showMessageDialog(null, "修改成功！");
        dispose();
    }
//    ++++++++ 删除病人（有问题 因为涉及的表较多，运行的时候说检查是否连接数据库，未实现）
    private void button2ActionPerformed(ActionEvent e) {
        String cmdText = "DELETE from InPatientInfo where PatientID = '" + textField1.getText().trim() + "'";
        String cmdText1 = "DELETE from PatientInfo where PatientID = '" + textField1.getText().trim() + "'";
        String cmdText2 = "DELETE from AppointmentCheckInfo where PatientID = '" + textField1.getText().trim() + "'";
        String cmdText3 = "DELETE from DoctorsAdviceInfo where PatientID = '" + textField1.getText().trim() + "'";
        String cmdText4 = "DELETE from MedRecordInfo where PatientID = '" + textField1.getText().trim() + "'";
        String cmdText5 = "DELETE from HspCostsInfo where PatientID = '" + textField1.getText().trim() + "'";


        try {JDBCUtils.updateByPreparedStatement(cmdText, null);
            JDBCUtils.updateByPreparedStatement(cmdText1, null);
            JDBCUtils.updateByPreparedStatement(cmdText2, null);
            JDBCUtils.updateByPreparedStatement(cmdText3, null);
            JDBCUtils.updateByPreparedStatement(cmdText4, null);
            JDBCUtils.updateByPreparedStatement(cmdText5, null);
        } catch (Exception er) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "检查是否连接数据库");
            return;
        }
        JOptionPane.showMessageDialog(null, "删除成功！");
        dispose();

    }
//    “取消” 按钮
    private void button3ActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        label7 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label8 = new JLabel();
        textField8 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u75c5\u4ebaID\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(5, 15), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(60, 10, 75, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(140, 15), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(180, 10, 75, textField2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(265, 15), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(300, 10, 105, textField3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u51fa\u751f\u5e74\u6708\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(0, 50), label4.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(60, 45, 115, textField4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(225, 50), label5.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(300, 45, 135, textField5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        contentPane.add(label6);
        label6.setBounds(5, 85, label6.getPreferredSize().width, 30);
        contentPane.add(textField6);
        textField6.setBounds(60, 90, 115, textField6.getPreferredSize().height);

        //---- label7 ----
        label7.setText("\u5730      \u5740\uff1a");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(5, 135), label7.getPreferredSize()));
        contentPane.add(textField7);
        textField7.setBounds(60, 130, 335, textField7.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u7f16\u8f91\u75c5\u4eba");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 180), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u5220\u9664\u75c5\u4eba");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(175, 180), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u53d6\u6d88");
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(295, 180), button3.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u5de5\u4f5c\u5355\u4f4d\uff1a");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(220, 90), label8.getPreferredSize()));
        contentPane.add(textField8);
        textField8.setBounds(300, 85, 130, textField8.getPreferredSize().height);

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
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JLabel label7;
    private JTextField textField7;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label8;
    private JTextField textField8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
