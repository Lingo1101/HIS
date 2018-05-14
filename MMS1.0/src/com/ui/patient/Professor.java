package com.ui.patient;

import com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 专家荟萃界面
 */
public class Professor extends JFrame {
    int screenWidth,screenHeight;
    static int totalWidth;
    static int totalHeight;

    JTabbedPane Department = new JTabbedPane();
    JPanel PInternalt = new JPanel();
    JPanel PInternalt01 = new JPanel();
    JPanel PInternalt001 = new JPanel();
    JPanel PInternalt02 = new JPanel();
    JPanel PInternalt002 = new JPanel();
    JPanel PInternalt03 = new JPanel();
    JPanel PInternalt003 = new JPanel();
    JPanel PInternalt04 = new JPanel();
    JPanel PInternalt004 = new JPanel();

    JPanel PSurgical = new JPanel();
    JPanel PSurgical01 = new JPanel();
    JPanel PSurgical001 = new JPanel();
    JPanel PSpecialist = new JPanel();
    JPanel PSpecialist01 = new JPanel();
    JPanel PSpecialist001 = new JPanel();
    JPanel PMedical = new JPanel();
    JPanel PMedical01 = new JPanel();
    JPanel PMedical001 = new JPanel();
    JPanel PSelect = new JPanel();

    JLabel label = new JLabel(new ImageIcon("Images/doctor.jpg"));
    JLabel lb001 = new JLabel(new ImageIcon("Images/D001.jpg"));
    JLabel lb002 = new JLabel(new ImageIcon("Images/D002.jpg"));
    JLabel lb003 = new JLabel(new ImageIcon("Images/D003.jpg"));
    JLabel lb004 = new JLabel(new ImageIcon("Images/D004.jpg"));
    JLabel lb011 = new JLabel(new ImageIcon("Images/D005.jpg"));
    JLabel lb021 = new JLabel(new ImageIcon("Images/D006.jpg"));
    JLabel lb031 = new JLabel(new ImageIcon("Images/D007.jpg"));

    JLabel []Doctor001 ={new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
            ,new JLabel(),new JLabel(),new JLabel()} ;
    JLabel []Doctor002 = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
            ,new JLabel(),new JLabel(),new JLabel()};
    JLabel []Doctor003 = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
            ,new JLabel(),new JLabel(),new JLabel()};
    JLabel []Doctor004 = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
            ,new JLabel(),new JLabel(),new JLabel()};
    JLabel []Doctor010 = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
            ,new JLabel(),new JLabel(),new JLabel()};
    JLabel []Doctor020 = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
            ,new JLabel(),new JLabel(),new JLabel()};
    JLabel []Doctor030 = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()
            ,new JLabel(),new JLabel(),new JLabel()};
    public static void main(String[] args){
        Professor professor = new Professor();
    }
    public Professor(){

        PInternalt.setLayout(new GridLayout(2,2,10,10));
        PInternalt01.setLayout(new GridLayout(1,2,1,1));
        PInternalt001.setLayout(new GridLayout(10,1,1,1));
        PInternalt02.setLayout(new GridLayout(1,2,1,1));
        PInternalt002.setLayout(new GridLayout(10,1,1,1));
        PInternalt03.setLayout(new GridLayout(1,2,1,1));
        PInternalt003.setLayout(new GridLayout(10,1,1,1));
        PInternalt04.setLayout(new GridLayout(1,2,1,1));
        PInternalt004.setLayout(new GridLayout(10,1,1,1));

        PSurgical.setLayout(new GridLayout(2,2,10,10));
        PSurgical01.setLayout(new GridLayout(1,2,1,1));
        PSurgical001.setLayout(new GridLayout(10,1,1,1));

        PSpecialist.setLayout(new GridLayout(2,2,10,10));
        PSpecialist01.setLayout(new GridLayout(1,2,1,1));
        PSpecialist001.setLayout(new GridLayout(10,1,1,1));

        PMedical.setLayout(new GridLayout(2,2,10,10));
        PMedical01.setLayout(new GridLayout(1,2,1,1));
        PMedical001.setLayout(new GridLayout(10,1,1,1));
        //*****************************查询数据库信息
        String Did001 = "D201821101";
        String Did002 = "D201821102";
        String Did003 = "D201821103";
        String Did004 = "D201821104";
        String Did011 = "D201821105";
        String Did021 = "N201821201";
        String Did031 = "N201821202";
        String strSQL001;
        String strSQL002;
        String strSQL003;
        String strSQL004;
        String strSQL011;
        String strSQL021;
        String strSQL031;
        ResultSet rs001;
        ResultSet rs002;
        ResultSet rs003;
        ResultSet rs004;
        ResultSet rs011;
        ResultSet rs021;
        ResultSet rs031;
        /**
         * 查询医生基本信息
         */
        strSQL001 = "select * from EmployeeInfo where EmployeeID = '"+Did001+"'";
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult(strSQL001, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Doctor001[0].setText("专  家  ID：  " + maps.get("EmployeeID".toUpperCase()));
        Doctor001[1].setText("科  室  ID：  " + maps.get("DEPARTID".toUpperCase()));
        Doctor001[2].setText("岗  位  ID：  " + maps.get("PostID".toUpperCase()));
        Doctor001[3].setText("专家姓名： " + maps.get("EmployeeName".toUpperCase()));
        Doctor001[4].setText("专家性别： " + maps.get("GENDER".toUpperCase()));
        Doctor001[5].setText("专家学历： " + maps.get("EDUCATION".toUpperCase()));
        Doctor001[6].setText("出生日期： " + maps.get("BIRTHDAY".toUpperCase()));
        Doctor001[7].setText("身份证号： " + maps.get("IDNumber".toUpperCase()));
        Doctor001[8].setText("电话号码： " + maps.get("PhoneNumber".toUpperCase()));
        Doctor001[9].setText("家庭住址： " + maps.get("Address".toUpperCase()));

        for(int i = 0;i < 10;i++){
            PInternalt001.add(Doctor001[i]);
        }
        //*******
        strSQL002 = "select * from EmployeeInfo where EmployeeID = '"+Did002+"'";

        try {
            maps = JDBCUtils.findSimpleResult(strSQL002, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Doctor002[0].setText("专  家  ID：  " + maps.get("EmployeeID".toUpperCase()));
        Doctor002[1].setText("科  室  ID：  " + maps.get("DEPARTID".toUpperCase()));
        Doctor002[2].setText("岗  位  ID：  " + maps.get("PostID".toUpperCase()));
        Doctor002[3].setText("专家姓名： " + maps.get("EmployeeName".toUpperCase()));
        Doctor002[4].setText("专家性别： " + maps.get("GENDER".toUpperCase()));
        Doctor002[5].setText("专家学历： " + maps.get("EDUCATION".toUpperCase()));
        Doctor002[6].setText("出生日期： " + maps.get("BIRTHDAY".toUpperCase()));
        Doctor002[7].setText("身份证号： " + maps.get("IDNumber".toUpperCase()));
        Doctor002[8].setText("电话号码： " + maps.get("PhoneNumber".toUpperCase()));
        Doctor002[9].setText("家庭住址： " + maps.get("Address".toUpperCase()));

        for(int i = 0;i < 10;i++) {
            PInternalt002.add(Doctor002[i]);
        }

        //**********
        strSQL003 = "select * from EmployeeInfo where EmployeeID = '"+Did003+"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL003, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Doctor003[0].setText("专  家  ID：  " + maps.get("EmployeeID".toUpperCase()));
        Doctor003[1].setText("科  室  ID：  " + maps.get("DEPARTID".toUpperCase()));
        Doctor003[2].setText("岗  位  ID：  " + maps.get("PostID".toUpperCase()));
        Doctor003[3].setText("专家姓名： " + maps.get("EmployeeName".toUpperCase()));
        Doctor003[4].setText("专家性别： " + maps.get("GENDER".toUpperCase()));
        Doctor003[5].setText("专家学历： " + maps.get("EDUCATION".toUpperCase()));
        Doctor003[6].setText("出生日期： " + maps.get("BIRTHDAY".toUpperCase()));
        Doctor003[7].setText("身份证号： " + maps.get("IDNumber".toUpperCase()));
        Doctor003[8].setText("电话号码： " + maps.get("PhoneNumber".toUpperCase()));
        Doctor003[9].setText("家庭住址： " + maps.get("Address".toUpperCase()));

        for(int i = 0;i < 10;i++){
            PInternalt003.add(Doctor003[i]);
        }
        //*******
        strSQL004 = "select * from EmployeeInfo where EmployeeID = '"+Did004+"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL004, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Doctor004[0].setText("专  家  ID：  " + maps.get("EmployeeID".toUpperCase()));
        Doctor004[1].setText("科  室  ID：  " + maps.get("DEPARTID".toUpperCase()));
        Doctor004[2].setText("岗  位  ID：  " + maps.get("PostID".toUpperCase()));
        Doctor004[3].setText("专家姓名： " + maps.get("EmployeeName".toUpperCase()));
        Doctor004[4].setText("专家性别： " + maps.get("GENDER".toUpperCase()));
        Doctor004[5].setText("专家学历： " + maps.get("EDUCATION".toUpperCase()));
        Doctor004[6].setText("出生日期： " + maps.get("BIRTHDAY".toUpperCase()));
        Doctor004[7].setText("身份证号： " + maps.get("IDNumber".toUpperCase()));
        Doctor004[8].setText("电话号码： " + maps.get("PhoneNumber".toUpperCase()));
        Doctor004[9].setText("家庭住址： " + maps.get("Address".toUpperCase()));

        for(int i = 0;i < 10;i++){
            PInternalt004.add(Doctor004[i]);
        }

        //**********
        strSQL011 = "select * from EmployeeInfo where EmployeeID = '"+Did011+"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL011, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Doctor010[0].setText("专  家  ID：  " + maps.get("EmployeeID".toUpperCase()));
        Doctor010[1].setText("科  室  ID：  " + maps.get("DEPARTID".toUpperCase()));
        Doctor010[2].setText("岗  位  ID：  " + maps.get("PostID".toUpperCase()));
        Doctor010[3].setText("专家姓名： " + maps.get("EmployeeName".toUpperCase()));
        Doctor010[4].setText("专家性别： " + maps.get("GENDER".toUpperCase()));
        Doctor010[5].setText("专家学历： " + maps.get("EDUCATION".toUpperCase()));
        Doctor010[6].setText("出生日期： " + maps.get("BIRTHDAY".toUpperCase()));
        Doctor010[7].setText("身份证号： " + maps.get("IDNumber".toUpperCase()));
        Doctor010[8].setText("电话号码： " + maps.get("PhoneNumber".toUpperCase()));
        Doctor010[9].setText("家庭住址： " + maps.get("Address".toUpperCase()));

        for(int i = 0;i < 10;i++){
            PSurgical001.add(Doctor010[i]);
        }
        //**********
        strSQL021 = "select * from EmployeeInfo where EmployeeID = '"+Did021+"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL021, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Doctor020[0].setText("专  家  ID：  " + maps.get("EmployeeID".toUpperCase()));
        Doctor020[1].setText("科  室  ID：  " + maps.get("DEPARTID".toUpperCase()));
        Doctor020[2].setText("岗  位  ID：  " + maps.get("PostID".toUpperCase()));
        Doctor020[3].setText("专家姓名： " + maps.get("EmployeeName".toUpperCase()));
        Doctor020[4].setText("专家性别： " + maps.get("GENDER".toUpperCase()));
        Doctor020[5].setText("专家学历： " + maps.get("EDUCATION".toUpperCase()));
        Doctor020[6].setText("出生日期： " + maps.get("BIRTHDAY".toUpperCase()));
        Doctor020[7].setText("身份证号： " + maps.get("IDNumber".toUpperCase()));
        Doctor020[8].setText("电话号码： " + maps.get("PhoneNumber.toUpperCase()"));
        Doctor020[9].setText("家庭住址： " + maps.get("Address".toUpperCase()));

        for(int i = 0;i < 10;i++){
            PMedical001.add(Doctor020[i]);
        }
        //**********
        strSQL031 = "select * from EmployeeInfo where EmployeeID = '"+Did031+"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL031, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Doctor030[0].setText("专  家  ID：  " + maps.get("EmployeeID".toUpperCase()));
        Doctor030[1].setText("科  室  ID：  " + maps.get("DEPARTID".toUpperCase()));
        Doctor030[2].setText("岗  位  ID：  " + maps.get("PostID".toUpperCase()));
        Doctor030[3].setText("专家姓名： " + maps.get("EmployeeName".toUpperCase()));
        Doctor030[4].setText("专家性别： " + maps.get("GENDER".toUpperCase()));
        Doctor030[5].setText("专家学历： " + maps.get("EDUCATION".toUpperCase()));
        Doctor030[6].setText("出生日期： " + maps.get("BIRTHDAY".toUpperCase()));
        Doctor030[7].setText("身份证号： " + maps.get("IDNumber".toUpperCase()));
        Doctor030[8].setText("电话号码： " + maps.get("PhoneNumber".toUpperCase()));
        Doctor030[9].setText("家庭住址： " + maps.get("Address".toUpperCase()));

        for(int i = 0;i < 10;i++){
            PSpecialist001.add(Doctor030[i]);
        }
        //****************************查询数据库信息


        Department.add("内科专家",PInternalt);  Department.add("外科专家",PSurgical);
        Department.add("专科专家",PSpecialist);  Department.add("医技专家",PMedical);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取主显示器屏幕大小即获取PC屏幕尺寸
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        //按屏幕尺寸固定比例设置软件尺寸
        totalWidth = (int) Math.round(screenWidth * 0.7);
        totalHeight = (int) Math.round(screenHeight * 0.9);//round是四舍五入
        this.setSize(totalWidth, totalHeight);
        //获取任务栏高度,以便将软件位置初始化为屏幕正中央
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int bottomInset = screenInsets.bottom;
        PSelect.add(label);
        PInternalt01.add(lb001);
        PInternalt01.add(PInternalt001);
        PInternalt02.add(lb002);
        PInternalt02.add(PInternalt002);
        PInternalt03.add(lb003);
        PInternalt03.add(PInternalt003);
        PInternalt04.add(lb004);
        PInternalt04.add(PInternalt004);
        PInternalt.add(PInternalt01);
        PInternalt.add(PInternalt02);
        PInternalt.add(PInternalt03);
        PInternalt.add(PInternalt04);

        PSurgical01.add(lb011);
        PSurgical01.add(PSurgical001);

        PMedical01.add(lb021);
        PMedical01.add(PMedical001);

        PSpecialist01.add(lb031);
        PSpecialist01.add(PSpecialist001);
        PSurgical.add(PSurgical01);
        PMedical.add(PMedical01);
        PSpecialist.add(PSpecialist01);
        this.add(PSelect,BorderLayout.NORTH);
        this.add(Department,BorderLayout.CENTER);
        this.setTitle("专家荟萃");
        this.setLocation(Math.round((screenWidth - totalWidth) / 2), Math.round((screenHeight - bottomInset - totalHeight) / 2));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);

    }
}
