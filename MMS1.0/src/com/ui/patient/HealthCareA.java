package com.ui.patient;

import com.utils.BeautifulFrame;

import javax.swing.*;
import java.awt.*;

/**
 * 医疗保健
 */
public class HealthCareA extends JFrame{
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
        totalWidth = BeautifulFrame.frameWidth*2/3;
        totalHeight = BeautifulFrame.frameHeight*4/5;
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int bottomInset = screenInsets.bottom;
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
        this.setLocationRelativeTo(this.getOwner());
        this.setVisible(true);

    }
    public static void main(String[] args){
        HealthCareA healthCareA = new HealthCareA();
    }
}

