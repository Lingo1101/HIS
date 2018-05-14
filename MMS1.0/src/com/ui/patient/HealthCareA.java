package com.ui.patient;

import javax.swing.*;
import java.awt.*;

/**
 * 医疗保健
 */
public class HealthCareA extends JFrame{
    int screenWidth,screenHeight;
    static int totalWidth;
    static int totalHeight;
    JToolBar TMentalHeath = new JToolBar();
    JButton  BMental = new JButton("心里健康");
    JToolBar TPreHealth = new JToolBar();
    JButton  BPre = new JButton("预防保健");
    JToolBar TVommonSense = new JToolBar();
    JButton  BTVommon = new JButton("急救常识");

    JLabel label = new JLabel("医疗保健",JLabel.CENTER);
    JLabel kong = new JLabel("  ");

    public HealthCareA(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取主显示器屏幕大小即获取PC屏幕尺寸
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        //按屏幕尺寸固定比例设置软件尺寸
        totalWidth = (int) Math.round(screenWidth * 0.7);
        totalHeight = (int) Math.round(screenHeight * 0.9);//round是四舍五入
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int bottomInset = screenInsets.bottom;
        this.setLocation(Math.round((screenWidth - totalWidth) / 2), Math.round((screenHeight - bottomInset - totalHeight) / 2));
        this.setSize(totalWidth, totalHeight);
        //获取任务栏高度,以便将软件位置初始化为屏幕正中央

        label.setBounds(0,0,totalWidth,50);
        TMentalHeath.setBounds(0,50,totalWidth,30);
        TPreHealth.setBounds(0,130,totalWidth,30);
        TVommonSense.setBounds(0,210,totalWidth,30);
        label.setFont(new Font("黑体",Font.PLAIN,40));
        label.setForeground(Color.CYAN);
        BMental.setBorderPainted(false);
        BMental.setOpaque(false);
        BPre.setBorderPainted(false);
        BPre.setOpaque(false);
        BTVommon.setBorderPainted(false);
        BTVommon.setOpaque(false);
        TMentalHeath.add(BMental);
        TPreHealth.add(BPre);
        TVommonSense.add(BTVommon);

        this.add(TMentalHeath);
        this.add(TPreHealth);
        this.add(TVommonSense);
        this.add(label);
        this.add(kong);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);

    }
    public static void main(String[] args){
        HealthCareA healthCareA = new HealthCareA();
    }
}

