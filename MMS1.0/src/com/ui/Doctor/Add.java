package com.ui.Doctor;

import com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/*
 * Created by JFormDesigner on Wed Apr 04 08:57:29 CST 2018
 */


/**
 * @author dasdfaf
 */
public class Add extends JFrame {
    private static String patientID;
    private static ResultSet rs;
    private JScrollPane scrollPane;
    private static String getPatientID() {
        return patientID;
    }

    private static void setPatientID(String patientID) {
        Add.patientID = patientID;
    }

    public Add(String patientID, String pass) {
        
        setPatientID(patientID);

        initComponents();
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult("select * from PatientInfo where PatientID='" +  patientID + "'", null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        textField1.setText(maps.get("PatientName".toUpperCase()).toString());
        textField2.setText(maps.get("PatientID".toUpperCase()).toString());
        textField3.setText(maps.get("Address".toUpperCase()).toString());
        textField9.setText(maps.get("GENDER".toUpperCase()).toString());
        textField7.setText(maps.get("IDNumber".toUpperCase()).toString());
        textField8.setText(maps.get("BIRTHDAY".toUpperCase()).toString());
        textField10.setText(maps.get("PhoneNumber".toUpperCase()).toString());
        textField23.setText(pass);
        setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }
// 编辑患者信息，下医嘱
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String a=textField4.getText().trim();
        String b=textField5.getText().trim();
        String c=textField6.getText().trim();
        String Pid=textField2.getText().trim();
        String strSQL = "insert into MedRecordInfo(PatientID,ChiefComplaints,PresentIllness,PastHistory,MarriageHistory,MenstrualHistory,FamilyHistory,PhysicalExamination,SpecialistInspection,AuxiliaryInspection,DifferentialDiagnosis,InitialDiagnosis,AssessmentPlan,DoctorsAdviceID) values('"+
                textField2.getText().trim() + "','" + textField4.getText().trim() + "','"+ textField11.getText().trim() +"','"+ textField12.getText().trim() +"','"+ textField13.getText().trim() +"','"+ textField14.getText().trim() +"','"+ textField15.getText().trim() +"','"+ textField16.getText().trim() +"','"+ textField17.getText().trim() +"','"+ textField18.getText().trim() +"','"+ textField20.getText().trim() +"','"+ textField21.getText().trim() +"','"+ textField5.getText().trim() +"','"+ textField22.getText().trim() +"')";
        String strSQL2= "insert into DoctorsAdviceInfo(DoctorsAdviceID,EmployeeID,PatientID,MedicalContent,IsExecuted,EffectiveTime) values('"+ textField22.getText().trim() + "','" + textField23.getText().trim() + "','" + textField2.getText().trim() + "','" + textField6.getText().trim() + "','" + comboBox1.getSelectedItem() + "','" + textField19.getText().trim() + "')";
        try {
            System.out.println(strSQL);
            System.out.println(strSQL2);
            JDBCUtils.updateByPreparedStatement(strSQL2, null);
            JDBCUtils.updateByPreparedStatement(strSQL, null);


        } catch (SQLException er) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(null, "插入数据类型有误");
            return;
        }
        JOptionPane.showMessageDialog(null, "添加成功！");
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        label14 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textField4 = new JTextField();
        label8 = new JLabel();
        textField5 = new JTextField();
        label9 = new JLabel();
        textField6 = new JTextField();
        label10 = new JLabel();
        textField7 = new JTextField();
        label11 = new JLabel();
        textField8 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        textField9 = new JTextField();
        textField10 = new JTextField();
        label1 = new JLabel();
        textField11 = new JTextField();
        label12 = new JLabel();
        textField12 = new JTextField();
        label13 = new JLabel();
        textField13 = new JTextField();
        label15 = new JLabel();
        textField14 = new JTextField();
        label16 = new JLabel();
        textField15 = new JTextField();
        label17 = new JLabel();
        textField16 = new JTextField();
        label18 = new JLabel();
        textField17 = new JTextField();
        label2 = new JLabel();
        textField18 = new JTextField();
        label20 = new JLabel();
        textField20 = new JTextField();
        label21 = new JLabel();
        textField21 = new JTextField();
        label22 = new JLabel();
        textField22 = new JTextField();
        label19 = new JLabel();
        textField19 = new JTextField();
        label23 = new JLabel();
        comboBox1 = new JComboBox<>();
        label24 = new JLabel();
        textField23 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(500, 600));

            //======== panel1 ========
            {
                panel1.setPreferredSize(new Dimension(1000, 600));
                panel1.setMinimumSize(new Dimension(400, 600));
                panel1.setLayout(null);

                //---- label14 ----
                label14.setText("\u59d3\u540d\uff1a");
                panel1.add(label14);
                label14.setBounds(new Rectangle(new Point(10, 10), label14.getPreferredSize()));
                panel1.add(textField1);
                textField1.setBounds(50, 10, 55, 25);

                //---- label3 ----
                label3.setText("\u75c5\u4ebaID\uff1a");
                panel1.add(label3);
                label3.setBounds(120, 15, 49, 17);
                panel1.add(textField2);
                textField2.setBounds(180, 10, 90, 25);

                //---- label4 ----
                label4.setText("\u5730\u5740\uff1a");
                panel1.add(label4);
                label4.setBounds(5, 80, 36, 17);
                panel1.add(textField3);
                textField3.setBounds(50, 80, 250, 25);

                //---- label5 ----
                label5.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
                panel1.add(label5);
                label5.setBounds(400, 15, 60, 17);

                //---- label6 ----
                label6.setText("\u6027\u522b\uff1a");
                panel1.add(label6);
                label6.setBounds(285, 15, 36, 17);

                //---- label7 ----
                label7.setText("\u4e3b\u8bc9\uff1a");
                panel1.add(label7);
                label7.setBounds(0, 180, 36, 17);
                panel1.add(textField4);
                textField4.setBounds(30, 200, 495, 60);

                //---- label8 ----
                label8.setText("\u8bca\u7597\u8ba1\u5212\uff1a");
                panel1.add(label8);
                label8.setBounds(0, 1140, 70, 20);
                panel1.add(textField5);
                textField5.setBounds(35, 1165, 490, 70);

                //---- label9 ----
                label9.setText("\u533b\u5631\uff1a");
                panel1.add(label9);
                label9.setBounds(5, 1230, 36, 30);
                panel1.add(textField6);
                textField6.setBounds(35, 1260, 490, 65);

                //---- label10 ----
                label10.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
                panel1.add(label10);
                label10.setBounds(5, 50, 60, 17);
                panel1.add(textField7);
                textField7.setBounds(70, 45, 140, 25);

                //---- label11 ----
                label11.setText("\u51fa\u751f\u65e5\u671f\uff1a");
                panel1.add(label11);
                label11.setBounds(245, 50, 60, 17);
                panel1.add(textField8);
                textField8.setBounds(315, 50, 130, 25);

                //---- button1 ----
                button1.setText("\u786e\u5b9a");
                button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});
                panel1.add(button1);
                button1.setBounds(160, 1350, 60, 25);

                //---- button2 ----
                button2.setText("\u53d6\u6d88");
                button2.addActionListener(e -> button2ActionPerformed(e));
                panel1.add(button2);
                button2.setBounds(310, 1350, 60, 25);
                panel1.add(textField9);
                textField9.setBounds(330, 10, 60, 25);
                panel1.add(textField10);
                textField10.setBounds(460, 10, 95, 25);

                //---- label1 ----
                label1.setText("\u73b0\u72b6\u53f2\uff1a");
                panel1.add(label1);
                label1.setBounds(0, 260, 48, 17);
                panel1.add(textField11);
                textField11.setBounds(30, 280, 495, 65);

                //---- label12 ----
                label12.setText("\u65e2\u5f80\u53f2\uff1a");
                panel1.add(label12);
                label12.setBounds(0, 350, 48, 17);
                panel1.add(textField12);
                textField12.setBounds(35, 370, 495, 55);

                //---- label13 ----
                label13.setText("\u5a5a\u80b2\u53f2\uff1a");
                panel1.add(label13);
                label13.setBounds(0, 430, 48, 17);
                panel1.add(textField13);
                textField13.setBounds(35, 450, 495, 60);

                //---- label15 ----
                label15.setText("\u6708\u7ecf\u53f2\uff1a");
                panel1.add(label15);
                label15.setBounds(0, 515, label15.getPreferredSize().width, 15);
                panel1.add(textField14);
                textField14.setBounds(35, 535, 495, 60);

                //---- label16 ----
                label16.setText("\u5bb6\u65cf\u53f2\uff1a");
                panel1.add(label16);
                label16.setBounds(new Rectangle(new Point(0, 595), label16.getPreferredSize()));
                panel1.add(textField15);
                textField15.setBounds(35, 615, 495, 60);

                //---- label17 ----
                label17.setText("\u4f53\u683c\u68c0\u67e5\uff1a");
                panel1.add(label17);
                label17.setBounds(new Rectangle(new Point(0, 680), label17.getPreferredSize()));
                panel1.add(textField16);
                textField16.setBounds(35, 700, 495, 55);

                //---- label18 ----
                label18.setText("\u4e13\u79d1\u68c0\u67e5\uff1a");
                panel1.add(label18);
                label18.setBounds(new Rectangle(new Point(0, 760), label18.getPreferredSize()));
                panel1.add(textField17);
                textField17.setBounds(35, 780, 490, 60);

                //---- label2 ----
                label2.setText("\u8f85\u52a9\u68c0\u67e5\uff1a");
                panel1.add(label2);
                label2.setBounds(new Rectangle(new Point(0, 845), label2.getPreferredSize()));
                panel1.add(textField18);
                textField18.setBounds(35, 870, 490, 65);

                //---- label20 ----
                label20.setText("\u9274\u522b\u8bca\u65ad\uff1a");
                panel1.add(label20);
                label20.setBounds(new Rectangle(new Point(0, 945), label20.getPreferredSize()));
                panel1.add(textField20);
                textField20.setBounds(35, 965, 490, 65);

                //---- label21 ----
                label21.setText("\u521d\u6b65\u8bca\u65ad\uff1a");
                panel1.add(label21);
                label21.setBounds(new Rectangle(new Point(0, 1035), label21.getPreferredSize()));
                panel1.add(textField21);
                textField21.setBounds(35, 1065, 490, 70);

                //---- label22 ----
                label22.setText("\u533b\u5631ID\uff08*\uff09\uff1a");
                panel1.add(label22);
                label22.setBounds(new Rectangle(new Point(355, 85), label22.getPreferredSize()));
                panel1.add(textField22);
                textField22.setBounds(445, 80, 85, textField22.getPreferredSize().height);

                //---- label19 ----
                label19.setText("\u533b\u5631\u671f\u9650\uff1a");
                panel1.add(label19);
                label19.setBounds(new Rectangle(new Point(5, 115), label19.getPreferredSize()));
                panel1.add(textField19);
                textField19.setBounds(70, 110, 115, textField19.getPreferredSize().height);

                //---- label23 ----
                label23.setText("\u533b\u5631\u662f\u5426\u6267\u884c\uff1a");
                panel1.add(label23);
                label23.setBounds(new Rectangle(new Point(200, 115), label23.getPreferredSize()));

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u5426",
                    "\u662f"
                }));
                panel1.add(comboBox1);
                comboBox1.setBounds(new Rectangle(new Point(295, 115), comboBox1.getPreferredSize()));

                //---- label24 ----
                label24.setText("\u533b\u751fID\uff1a");
                panel1.add(label24);
                label24.setBounds(new Rectangle(new Point(385, 115), label24.getPreferredSize()));
                panel1.add(textField23);
                textField23.setBounds(445, 115, 80, textField23.getPreferredSize().height);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            scrollPane1.setViewportView(panel1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JLabel label14;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField4;
    private JLabel label8;
    private JTextField textField5;
    private JLabel label9;
    private JTextField textField6;
    private JLabel label10;
    private JTextField textField7;
    private JLabel label11;
    private JTextField textField8;
    private JButton button1;
    private JButton button2;
    private JTextField textField9;
    private JTextField textField10;
    private JLabel label1;
    private JTextField textField11;
    private JLabel label12;
    private JTextField textField12;
    private JLabel label13;
    private JTextField textField13;
    private JLabel label15;
    private JTextField textField14;
    private JLabel label16;
    private JTextField textField15;
    private JLabel label17;
    private JTextField textField16;
    private JLabel label18;
    private JTextField textField17;
    private JLabel label2;
    private JTextField textField18;
    private JLabel label20;
    private JTextField textField20;
    private JLabel label21;
    private JTextField textField21;
    private JLabel label22;
    private JTextField textField22;
    private JLabel label19;
    private JTextField textField19;
    private JLabel label23;
    private JComboBox<String> comboBox1;
    private JLabel label24;
    private JTextField textField23;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
