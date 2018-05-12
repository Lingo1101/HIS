package com.view.Doctor;

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
public class DoctorHome extends JFrame {
    private String doctorID;
    public DoctorHome(String doctorID) {
        this.doctorID =doctorID;
        initComponents();
        setSize(800, 800);
        selete("SELECT InpatientInfo.HspID,InpatientInfo.PatientID,DepartID," +
                "DoctorID,NurseID,BedID,InHspTimes,PatientName,GENDER,IDNumber," +
                "PhoneNumber from InpatientInfo,PatientInfo where" +
                " InpatientInfo.PatientID=PatientInfo.PatientID and " +
                "DoctorID='" + doctorID + "'", "InpatientInfo");
        this.setLocationRelativeTo(getOwner());
        setVisible(true);

    }

    private void table1MouseClicked(MouseEvent e) //   单击调用编辑窗口
    {
        // TODO add your code here
        if (e.getButton() == MouseEvent.BUTTON1) {
            //通过点击位置找到点击为表格中的行
            int focusedRowIndex = table1.rowAtPoint(e.getPoint());
            if (focusedRowIndex == -1) {
                return;
            }
            //将表格所选项设为当前右键点击的行
            table1.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
            int row = table1.getSelectedRow();
            if(row < 0) {
                JOptionPane.showMessageDialog(null, "选择要查看病历的病人");
                return;
            }
            String ID = (String) table1.getValueAt(row, 0);
            new Add(ID, doctorID);

        }


    }

    private void menu3ActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void menu3MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void scrollPane1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu3 = new JMenu();
        menu4 = new JMenu();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

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

            //======== menu3 ========
            {
                menu3.setText("\u60a3\u8005\u4fe1\u606f\u7f16\u8f91");
                menu3.addActionListener(e -> {
			menu3ActionPerformed(e);
			menu3ActionPerformed(e);
		});
                menu3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu3MouseClicked(e);
                    }
                });
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u7cfb\u7edf\u8bbe\u7f6e");
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scrollPane1MouseClicked(e);
                }
            });

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 30, 745, 225);

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

    void selete(String sqlString, String value) {
        if (value == "InpatientInfo") {
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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
