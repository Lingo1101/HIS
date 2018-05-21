package com.ui.Nurse;

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
public class NurseHome extends JPanel {

    public NurseHome(String nurseID) {
        initComponents();
        setSize(1000,1000);

        downPanel.setLayout(new GridLayout(5,5,3,4));
        if(null != nurseID) {
            selete("SELECT InpatientInfo.HspID,InpatientInfo.PatientID," +
                    "DepartID,DoctorID,NurseID,BedID,InHspTimes,PatientName,GENDER," +
                    "IDNumber,PhoneNumber from InpatientInfo,PatientInfo " +
                    "where InpatientInfo.PatientID=PatientInfo.PatientID " +
                    "and NurseID='" + nurseID + "'", "InpatientInfo");
        }

    }
    // 获取当前护士管理患者人数
    void selete(String sqlString, String value) {
        if (value == "InpatientInfo") {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        List<Map<String, Object>> lists = new ArrayList<>();
        try {
            lists = JDBCUtils.findModeResult(sqlString, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
            downPanel.add(b);
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
            menuBar1 = new JMenuBar();
            menu1 = new JMenu();
            menu2 = new JMenu();

            //======== this ========
            this.setLayout(new BorderLayout());

            //----------upPanel------------------
            upPanel = new JPanel();
            upPanel.setLayout(new BorderLayout());
            upPanel.setPreferredSize(new Dimension(100, 50));
            this.add(upPanel, BorderLayout.NORTH);

            //---------downPanel------------------
            downPanel = new JPanel();
            downPanel.setLayout(new BorderLayout());
            this.add(downPanel, BorderLayout.CENTER);

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
            upPanel.add(menuBar1, BorderLayout.CENTER);
    }

            private JMenuBar menuBar1;
            private JMenu menu1;
            private JMenu menu2;
            public static int n=0;
            private String ID;
            private JPanel downPanel;
            private JPanel upPanel;

        }
