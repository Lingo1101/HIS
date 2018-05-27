package com.ui.Doctor;

import com.utils.JDBCUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/*
 * Created by JFormDesigner on Wed Mar 28 09:29:43 CST 2018
 */


/**
 * @author dasdfaf
 */
public class DoctorHome extends JPanel {
    String ID = null;

    public DoctorHome(String doctorID) {
        this.doctorID = doctorID;
        initComponents();
        this.setVisible(true);
        selete("SELECT InpatientInfo.HspID,InpatientInfo.PatientID,DepartID," +
                "DoctorID,NurseID,BedID,InHspTimes,PatientName,GENDER,IDNumber," +
                "PhoneNumber from InpatientInfo,PatientInfo where" +
                " InpatientInfo.PatientID=PatientInfo.PatientID and " +
                "DoctorID='" + doctorID + "'");

    }

    private void table1MouseClicked(MouseEvent e) //   单击调用编辑窗口
    {
        if (e.getButton() == MouseEvent.BUTTON1) {
            //通过点击位置找到点击为表格中的行
            int focusedRowIndex = table1.rowAtPoint(e.getPoint());
            if (focusedRowIndex == -1) {
                return;
            }
            table1.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
            int row = table1.getSelectedRow();
            if(row < 0) {
                JOptionPane.showMessageDialog(null, "选择要查看病历的病人");
                return;
            }
            ID = (String) table1.getValueAt(row, 0);
        }
        if (null != ID && e.getButton() == MouseEvent.BUTTON3) {
            new Add(ID, doctorID);
        }




    }

    private void menu6MouseClicked(MouseEvent e) {
        int row = table1.getSelectedRow();
        if(row < 0) {
            JOptionPane.showMessageDialog(null, "未选择修改项");
        } else {
            String ID = (String) table1.getValueAt(row, 0);
            new PatientManagement(ID, doctorID);
        }

    }

    private void initComponents() {
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

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu3 = new JMenu();
        menu4 = new JMenu();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("数据首页");
                menu1.setFont(new Font("宋体", Font.PLAIN, 20));

                //---- menuItem1 ----
                JMenuItem menuItem1 = new JMenuItem();
                menuItem1.setText("刷新");
                menuItem1.setFont(new Font("宋体", Font.PLAIN, 20));
                menuItem1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
System.out.println("刷新数据");
                    }
                });
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("患者管理");
                menu2.setFont(new Font("宋体", Font.PLAIN, 20));
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("患者信息编辑");
                menu3.setFont(new Font("宋体", Font.PLAIN, 20));
                menu3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu6MouseClicked(e);
                    }
                });
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("系统设置");
                menu4.setFont(new Font("宋体", Font.PLAIN, 20));
            }
            menuBar1.add(menu4);
        }
        upPanel.add(menuBar1, BorderLayout.CENTER);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        downPanel.add(scrollPane1);
        scrollPane1.setBounds(10, 30, 745, 225);
    }

    private void selete(String sqlString) {
        if(null == doctorID) {
            return;
        }
        String[] col = {"病人ID","姓名" ,"性别","身份证号","电话号码","住院号", "科室",
                "医生", "护士", "床位号","入院时间"};
        DefaultTableModel dfm = new DefaultTableModel(col, 0); // 定义一个表的模板
        table1 = (JTable) this.scrollPane1.getViewport().getComponent(0);
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult(sqlString, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String patientID = maps.get("PatientID".toUpperCase()).toString();
        String  patientName= maps.get("PatientName".toUpperCase()).toString();
        String gender= maps.get("GENDER".toUpperCase()).toString();
        String  idNumber= maps.get("IDNumber".toUpperCase()).toString();
        String phoneNumber= maps.get("PhoneNumber".toUpperCase()).toString();
        String id = maps.get("HspID".toUpperCase()).toString();
        String departID= maps.get("DepartID".toUpperCase()).toString();
        String doctorID = maps.get("DoctorID".toUpperCase()).toString();
        String nurseID= maps.get("NurseID".toUpperCase()).toString();
        String bedID = maps.get("BedID".toUpperCase()).toString();
        String  inHspTimes= maps.get("InHspTimes".toUpperCase()).toString();
        String[] str_row = {patientID,patientName,gender,idNumber,phoneNumber,id,departID, doctorID,  nurseID,  bedID,inHspTimes}; // 将一行的数据存在str_row
        dfm.addRow(str_row);
        table1.setModel(dfm);

    }

    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
    private JScrollPane scrollPane1;
    private JTable table1;
    private String doctorID;
    private JPanel upPanel;
    private JPanel downPanel;

}
