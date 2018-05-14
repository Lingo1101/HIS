package com.ui.patient;

import com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于预约科室检查的类
 */
public class BookReigserKS extends JFrame{
    int screenWidth,screenHeight;
    static int totalWidth;
    static int totalHeight;
    public String patientId1;//病人ID
    public String patients;//所预约科室的总人数
    public String departID;//所预约科室的ID
    public static String XmId = null ;
    public static String PriId;//所预约科室的项目ID

    JTextField[] jTextFields = {new JTextField("354"),new JTextField("767"),new JTextField("765"),new JTextField("354")};
    JLabel[]     jLabelsName = {new JLabel("用户ID："),new JLabel("用户名："),new JLabel("用户性别："),
                 new JLabel("身份证号："),new JLabel("预约科室："),new JLabel("预约项目："),
                 new JLabel("预约时间："),new JLabel("预约排号：")};

    JComboBox   Ldepart ;
    JButton      Confirmbutton = new JButton("确认预约");
    JComboBox    Check = new JComboBox();
    JPanel       jPanelA = new JPanel();
    JPanel       jPanelB = new JPanel();
    JPanel       jPanelC = new JPanel();
    JPanel       jPanelD = new JPanel();
    JLabel       jLabel =  new JLabel(new ImageIcon("Images/YY001.jpg"));
    TextField    time = new TextField();
    JTextField   Ksname = new JTextField();
    JTextField   BookNumber = new JTextField();

    public BookReigserKS(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取主显示器屏幕大小即获取PC屏幕尺寸
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        //按屏幕尺寸固定比例设置软件尺寸
        totalWidth = (int) Math.round(screenWidth * 0.7);
        totalHeight = (int) Math.round(screenHeight * 0.9);//round是四舍五入
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int bottomInset = screenInsets.bottom;
        this.setLocation(Math.round((screenWidth - totalWidth) / 2), Math.round((screenHeight - bottomInset - totalHeight) / 2));
        this.setSize(totalWidth + 16, totalHeight);
        //获取任务栏高度,以便将软件位置初始化为屏幕正中央
        BookNumber.setFont(new Font("宋体",Font.PLAIN,15));
        jPanelA.setLayout(null);   jPanelB.setLayout(null);
        jPanelA.setBounds(340,200,totalWidth - 340,totalHeight - 200);
        jPanelB.setBounds(250,200,90,totalHeight - 200);
        jPanelC.setBounds(0,0,totalWidth,200);
        jPanelD.setBounds(0,200,250,totalHeight - 200);
        jPanelA.setBackground(Color.getHSBColor(0,100,240));
        jPanelB.setBackground(Color.getHSBColor(0,100,240));
        jPanelD.setBackground(Color.cyan);
        jLabelsName[4].setBounds(30,210,100,30);
        jLabelsName[5].setBounds(30,250,100,30);
        jLabelsName[6].setBounds(30,290,100,30);
        jLabelsName[7].setBounds(30,330,100,30);
        Check.setBounds(10,250,200,30);
        time.setBounds(10,290,200,30);
        BookNumber.setBounds(10,330,200,30);
        Ksname.setBounds(10,210,200,30);
        Confirmbutton.setBounds(60,380,100,30);

        for (int i = 0;i < 4;i ++){
            jLabelsName[i].setBounds(30,50 + 40 * i,200,30);
        }
        for(int i = 0;i < 8;i ++){
            jPanelB.add(jLabelsName[i]);
        }
        for (int i = 0;i < 4;i ++){
            jTextFields[i].setBounds(10,50 + 40 * i,200,30);
        }

        jPanelA.add(Check);
        jPanelA.add(Ksname);
        jPanelA.add(Confirmbutton);
        jPanelA.add(time);
        jPanelA.add(BookNumber);
        jPanelC.add(jLabel);
        getPatients();
        this.add(jPanelA);
        this.add(jPanelB);
        this.add(jPanelC);
        this.add(jPanelD);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);

        //选择时间time事件
        time.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new YyTime(time);
            }
        });
        new ChooseBox(this);

        //科室项目事件：更新科室项目(还没实现)
        Check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getproject();
            }
        });
        new ChooseBox(this);

        //确定约事件:将病人预约的内容插入数据库
        Confirmbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Gid();
                String strSQL;
                strSQL = "Insert into AppointmentCheckInfo(CheckNum,PatientID,ProjectID) values('"+ patients + "','"+ jTextFields[0].getText().trim() +"','"+ PriId +"')";
                Map<String, Object> maps = new HashMap<>();
                try{
                    JDBCUtils.updateByPreparedStatement(strSQL, null);//更新数据库内容
                }catch (Exception e3){
                    e3.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "恭喜你预约成功！！！");
                Ksname.setText("");
                Check.removeAllItems();
                time.setText("");
                int number = Integer.parseInt(patients) + 1;
                BookNumber.setText("您当前的排号数是：" + number );
            }
        });
    }

    /**
     * main函数
     * @param args
     */
    public static void main(String[] args){
        BookReigserKS bookReigserKS = new BookReigserKS();
    }
    /**
     * 获取病人ID
     */
    public void getUserID(String _str){
        this.patientId1 = _str;
        getIfos();
    }
    /**
     * 获取病人基本信息
     */
    public void getIfos() {
         String strSQL;
         Map<String, Object> maps = new HashMap<>();
         strSQL = "select * from PatientInfo where PatientID = '"+ patientId1 +"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jTextFields[0].setText(maps.get("PatientID".toUpperCase()).toString());
        jTextFields[1].setText(maps.get("PatientName".toUpperCase()).toString());
        jTextFields[2].setText(maps.get("GENDER".toUpperCase()).toString());
        jTextFields[3].setText(maps.get("IDNumber".toUpperCase()).toString());
        for(int i = 0;i < 4;i ++) {
            jPanelA.add(jTextFields[i]);
         }
    }
    /**
     * 获取排号
     */
    public void getPatients(){
        String sql = "select * from AppointmentCheckInfo ";
        List<Map<String, Object>> lists;
        try {
            lists = JDBCUtils.findModeResult(sql, null);
            if(lists.size() == 0) {
                patients = 1 + "";//int转string
                BookNumber.setText("您当前的排号数是：" + patients );
            } else {
                for (int i = 1; i <= lists.size(); i++) {
                    patients = i + 1 +"";//int转string
                    BookNumber.setText("您当前的排号数是：" + patients);
                }
            }
        }catch (Exception e){ }
    }
    /**
     * 更新ComboBox里的内容
     */
    public void getproject(){
        Check.removeAllItems();
        addChoices();
    }
    public void addChoices() {
        String sql = "select ProjectName from HspPriceInfo where DepartID = '" + XmId + "' ";
        try {
            List<Map<String, Object>> modeResult = JDBCUtils.findModeResult(sql, null);
            for(Map<String, Object> maps : modeResult) {
                Check.addItem(maps.get("ProjectName".toUpperCase()));
            }
        }catch (SQLException e2){
            e2.printStackTrace();
        }
    }
    /**
     * 获取所选科室对应的项目的ID
     */
    public static void Did(String _str){
        XmId = _str;
    }
    /**
     * 获取所选科室对应的项目的PriceID
     */
    public void Gid(){
        String priceid = "select * from HspPriceInfo where ProjectName = '" + Check.getSelectedItem().toString() +"'";
        Map<String, Object> maps = new HashMap<>();
        try{
            //单条记录用findSimpleResult
            maps = JDBCUtils.findSimpleResult(priceid, null);
            PriId =  maps.get("ProjectID".toUpperCase()).toString();
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

}
