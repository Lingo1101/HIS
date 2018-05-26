package com.ui.patient;

import com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * 科室简介
 */
public class DepartIntroduce extends JFrame{

    int screenWidth,screenHeight;
    static int totalWidth;
    static int totalHeight;
    public static String ksid;

    JTextArea DeFtextArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane();
    JPanel panel = new JPanel();
    JButton button = new JButton(new ImageIcon("Images/return.png"));
    JLabel label = new JLabel(" ",JLabel.CENTER);

    /**
     * main函数
     * @param args
     */
    public static void main(String[] args){
        DepartIntroduce xinXueGuanNK = new DepartIntroduce();
    }

    /**
     * 构造函数
     */
    public DepartIntroduce(){
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
        this.setUndecorated(true);//让Frame窗口失去边框和标题栏的修饰
        panel.setLayout(new BorderLayout());
        label.setFont(new Font("黑体",Font.PLAIN,30));
        DeFtextArea.setFont(new Font("黑体",Font.PLAIN,20));
        button.setBorderPainted(false);
        button.setOpaque(false);
        DeFtextArea.setLineWrap(true);//自动换行
        scrollPane.add(DeFtextArea);
        panel.add(label);
        panel.add(button,BorderLayout.EAST);
        this.add(panel,BorderLayout.NORTH);
        this.add(DeFtextArea,BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
    }
    //获取科室ID
    public void getKSID(String _str){
        this.ksid = _str;
        getnr();
    }
    //获取科室名称
    public void getname(String _str){
        label.setText(_str);
    }
    //获取科室简介内容
    public void getnr(){
        String strSQL;
        Map<String, Object> maps = new HashMap<>();
        strSQL = "select Introduce from DepartInfo where DEPARTID = '"+ ksid +"'";
        try{
            maps = JDBCUtils.findSimpleResult(strSQL, null);
            DeFtextArea.setText(maps.get("Introduce".toUpperCase()).toString());
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
}

