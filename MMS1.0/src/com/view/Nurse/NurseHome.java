package com.view.Nurse;

import com.utils.JDBCUtils;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
 * Created by JFormDesigner on Wed Mar 28 09:35:09 CST 2018
 */


/**
 * @author dasdfaf
 */
public class NurseHome extends JFrame {
    public static int n=0;
    private String ID;
    private Container c;

    public NurseHome(String nurseID) {
        super("护士界面");
        initComponents();
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c=getContentPane();
//        c.setLayout(new FlowLayout());
        c.setLayout(new GridLayout(5,5,3,4));
        selete("SELECT InpatientInfo.HspID,InpatientInfo.PatientID," +
                "DepartID,DoctorID,NurseID,BedID,InHspTimes,PatientName,GENDER," +
                "IDNumber,PhoneNumber from InpatientInfo,PatientInfo " +
                "where InpatientInfo.PatientID=PatientInfo.PatientID " +
                "and NurseID='"+ nurseID + "'","InpatientInfo");
        this.setLocationRelativeTo(getOwner());
        setVisible(true);
    }
//  获取当前护士管理患者人数
    void selete(String sqlString, String value) {
        if (value == "InpatientInfo") {
        c=getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.LEFT));
        List<Map<String, Object>> lists = new ArrayList<>();
        try {
            lists = JDBCUtils.findModeResult(sqlString, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(lists.size());
        for(Map<String, Object> maps : lists) {

            String patientID = maps.get("PatientID".toUpperCase()).toString();
            this.ID = patientID;
            String patientName = maps.get("PatientName".toUpperCase()).toString();
            String gender = maps.get("GENDER".toUpperCase()).toString();
            String bedID = maps.get("BedID".toUpperCase()).toString();
            JTextPane b = new JTextPane();
            b.setText("姓名：" + patientName + "\n" + "病人ID：" + patientID + "\n" + "性别：" + gender + "\n" + "病床号：" + bedID + "");
            b.setBackground(getMyColor(patientID));
            b.setSize(50, 40);
            c.add(b);
            n++;
        }

        }
    }
// 窗口按钮变色
    private Color getMyColor(String patientID) {
        String a="select IsExecuted from DoctorsAdviceInfo where PatientID='"+ patientID+"'";
        String aaaa = "";
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult(a, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        aaaa = maps.get("IsExecuted".toUpperCase()).toString();

        if(aaaa.equals("否")) {
            return Color.red;
        }
        else{
            return Color.green;
        }

    }

    private void initComponents () {
                // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                menuBar1 = new JMenuBar();
                menu1 = new JMenu();
                menu2 = new JMenu();

                //======== this ========
                Container contentPane = getContentPane();
                contentPane.setLayout(null);

                //======== menuBar1 ========
                {

                    //======== menu1 ========
                    {
                        menu1.setText("\u6570\u636e\u9996\u9875");
                    }
                    menuBar1.add(menu1);

                    //======== menu2 ========
                    {
                        menu2.setText("\u60a3\u8005\u7ba1\u7406");
                    }
                    menuBar1.add(menu2);
                }
                setJMenuBar(menuBar1);

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
            private JMenuBar menuBar1;
            private JMenu menu1;
            private JMenu menu2;
            // JFormDesigner - End of variables declaration  //GEN-END:variables
        }
