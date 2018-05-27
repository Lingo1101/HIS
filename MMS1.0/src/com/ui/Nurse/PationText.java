package com.ui.Nurse;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

import com.utils.JDBCUtils;
/*
 * Created by JFormDesigner on Sat Apr 14 22:05:36 CST 2018
 */
/**
 * @author lllllllh
 */
public class PationText extends JFrame {

    public static final int WEIGHT = 800,HEIGHT = 600;
    JPanel topPanel=new JPanel();
    JPanel basePanel=new JPanel();
    JPanel leftPanel=new JPanel();
    JLabel leftLabel=new JLabel();
    JPanel rightPanel=new JPanel();

    JLabel pationID=new JLabel("病人ID");
    JLabel name=new JLabel("姓名");
    JTextField tID=new JTextField(20);
    JTextField tname=new JTextField(20);

    JTextArea leftText=new JTextArea();

    NurseHome nurseHome = null;
    JTextPane jTextPane = null;


    public PationText(JTextPane jTextPane, NurseHome nurseHome) {
        initComponents();
        this.nurseHome = nurseHome;
        this.jTextPane = jTextPane;
        String thisPatientID = parse(jTextPane);
        //数据库读取数据
        String aa = thisPatientID;
        this.patientID = aa;
        String sqlid,sqlname,sqlmedicalcontent;
        sqlname="select * from PatientInfo where PatientID ='"+aa+"'";
        sqlid = "select * from DoctorsAdviceInfo where PatientID = '" +aa + "'";
        sqlmedicalcontent ="select * from DoctorsAdviceInfo where PatientID = '" +aa + "'";
        Map<String, Object> maps = new HashMap<>();
        try{
            maps = JDBCUtils.findSimpleResult(sqlid, null);
            tID.setText(maps.get("PatientID".toUpperCase()).toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            maps = JDBCUtils.findSimpleResult(sqlname, null);
            tname.setText(maps.get("PatientName".toUpperCase()).toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            maps = JDBCUtils.findSimpleResult(sqlmedicalcontent, null);
            String s = maps.get("MedicalContent".toUpperCase()).toString();
            s = "    " + s + "\n\n ";
            leftText.append(s);
            leftText.setLineWrap(true);
        }catch (Exception e){
            e.printStackTrace();
        }

        this.setTitle("秘书备忘");
        this.setSize(WEIGHT,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                PationText.this.dispose();
            }
        });

        topPanel.setLayout(new FlowLayout());
        topPanel.setSize((int) WEIGHT, HEIGHT);
        topPanel.setBackground(Color.gray);
        topPanel.add(pationID);
        topPanel.add(tID);
        topPanel.add(name);
        topPanel.add(tname);

        basePanel.setLayout(new BorderLayout());
        basePanel.setPreferredSize(new Dimension(9999,9999));
        basePanel.add(leftPanel,BorderLayout.CENTER);
        basePanel.add(rightPanel,BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(topPanel,BorderLayout.NORTH );
        this.add(basePanel,BorderLayout.CENTER);

        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(leftText);
        leftText.setFont(new Font("华文新魏",Font.PLAIN,18));

        JButton b1=new JButton("    执行     ");

        b1.addActionListener(e ->{actionPerformed(e);});

        b1.setFont(new Font("黑体",Font.PLAIN,20));

        rightPanel.add(b1);
        rightPanel.setBackground(Color.lightGray);
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));

    }

    private void actionPerformed(ActionEvent e) {
        String sql = "update DoctorsAdviceInfo set isExecuted='是' where PatientID='"+ patientID  +
            "' ";
        try {
            JDBCUtils.updateByPreparedStatement(sql, null);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        jTextPane.setBackground(nurseHome.getMyColor(patientID));
        nurseHome.updateUI();
        this.dispose();
    }

    /**
     * 正则匹配病人ID
     * @param jTextPane
     * @return
     */
    private String parse(JTextPane jTextPane) {
        String s = jTextPane.getText();
        String result = null;
        Pattern p = Pattern.compile("P\\d+");
        Matcher m = p.matcher(s);
        if(m.find()) {
            result = m.group();
        }
        return  result;
    }


    private void initComponents() {
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        pack();
        setLocationRelativeTo(getOwner());

    }

    private String patientID=null;
}

