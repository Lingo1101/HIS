package com.ui.Nurse;

import com.utils.AdviceUtils;
import com.utils.JDBCUtils;
import com.utils.ManyPatientMonitor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * 标题放在了upPanel
 * 内容放在了downPanel
 */
public class NurseHome extends JPanel {

    public NurseHome(String nurseID) {
        initComponents();
        if(null != nurseID) {
            selete("SELECT InpatientInfo.HspID,InpatientInfo.PatientID," +
                    "DepartID,DoctorID,NurseID,BedID,InHspTimes,PatientName,GENDER," +
                    "IDNumber,PhoneNumber from InpatientInfo,PatientInfo " +
                    "where InpatientInfo.PatientID=PatientInfo.PatientID " +
                    "and NurseID='" + nurseID + "'");
        }
        manyPatientMonitor = new ManyPatientMonitor(patientTime, patientPane);
        new Thread(() -> {
            while(patientPane.size() != 0) {
                manyPatientMonitor.excute();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    // 获取当前护士管理患者人数
    void selete(String sqlString) {
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
            JTextPane jTextPane = new JTextPane();
            jTextPane.setEditable(false);
            jTextPane.setText("姓名：" + patientName + "\n" + "病人ID：" + patientID + "\n" + "性别：" + gender + "\n" + "病床号：" + bedID + "");
            jTextPane.setBackground(AdviceUtils.getMyColor(patientID));
            jTextPane.setSize(50, 40);
            downPanel.add(jTextPane);
            n++;

            if(jTextPane.getBackground() == Color.red) {
                Map<String, int[]> map = new HashMap<>();
                map.put(patientID, AdviceUtils.getTime(patientID));
                patientTime.add(map);

                patientPane.put(patientID, jTextPane);
            }

            jTextPane.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textPanelMouseClicked(jTextPane);
                }
            });
            jTextPane.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    jTextPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });
        }
    }

    //点击病人块 弹出执行框
    private void textPanelMouseClicked(JTextPane jTextPane) {
        new PationText(jTextPane, this);
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
            downPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            this.add(downPanel, BorderLayout.CENTER);

            //======== menuBar1 ========
            {
                //======== menu1 ========
                {
                    menu1.setText("\u6570\u636e\u9996\u9875");
                    menu1.setFont(new Font("宋体", Font.PLAIN, 20));
                }
                menuBar1.add(menu1);

                //======== menu2 ========
                {
                    menu2.setText("\u60a3\u8005\u7ba1\u7406");
                    menu2.setFont(new Font("宋体", Font.PLAIN, 20));
                }
                menuBar1.add(menu2);
            }
            upPanel.add(menuBar1, BorderLayout.CENTER);
    }

    private class PatientThread implements Runnable {
        @Override
        public void run() {

        }
    }

    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    public static int n=0;
    private String ID;
    private JPanel downPanel;
    private JPanel upPanel;
    private List<Map<String, int[]>> patientTime = new ArrayList<>();
    private Map<String, JTextPane> patientPane = new HashMap<>();
    private ManyPatientMonitor manyPatientMonitor;

}
