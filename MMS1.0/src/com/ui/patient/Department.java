package com.ui.patient;

import com.utils.BeautifulFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 科室导航
 */
public class Department extends JFrame{
    int screenWidth,screenHeight;
    static int totalWidth;
    static int totalHeight;

    JToolBar toolBarNeike = new JToolBar();
    JButton nieke = new JButton("内科");
    JPanel panelnieke = new JPanel();
    JButton[] buttonsneike = {new JButton("心血管内科"),new JButton("肾病内科"),new JButton("内分泌科"),
            new JButton("消化内科"),new JButton("神经内科"),new JButton("心呼吸内科"),};

    JToolBar toolBarwaike = new JToolBar();
    JButton waike = new JButton("外科");
    JPanel panelwaike = new JPanel();
    JButton[] buttonswaike = {new JButton("普通外科"),new JButton("心胸外科"),new JButton("神经外科"),
            new JButton("骨科"),new JButton("放射性治疗"),new JButton("泌尿外科"),};

    JToolBar toolBarzhaunke = new JToolBar();
    JButton zhaunke = new JButton("专科");
    JPanel panelzhaunke = new JPanel();
    JButton[] buttonszhaunke = {new JButton("儿科"),new JButton("眼科"),new JButton("中西结合科"),
            new JButton("耳鼻喉科"),new JButton("口腔科"),new JButton("皮肤科"),new JButton("空勤科")
            ,new JButton("感染内科"),new JButton("麻醉科"),new JButton("干部病房一科")};

    JToolBar toolBaryiji = new JToolBar();
    JButton yiji = new JButton("医技");
    JPanel panelyiji = new JPanel();
    JButton[] buttonsyiji = {new JButton("门诊科"),new JButton("急诊科"),new JButton("保健科"),
            new JButton("体检中心"),new JButton("临床药理科"),new JButton("医学工程科")};

    JLabel label = new JLabel("科室导航",JLabel.CENTER);
    JLabel kong  = new JLabel("        ");


    public static void main(String[] args){
        Department department = new Department();
    }
    public Department(){
        totalWidth = BeautifulFrame.frameWidth*2/3;
        totalHeight = BeautifulFrame.frameHeight*4/5;
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int bottomInset = screenInsets.bottom;
        this.setSize(totalWidth, totalHeight);
        //获取任务栏高度,以便将软件位置初始化为屏幕正中央

        panelnieke.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelwaike.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelzhaunke.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelyiji.setLayout(new FlowLayout(FlowLayout.LEFT));
        nieke.setFont(new Font("黑体",Font.PLAIN,20));
        waike.setFont(new Font("黑体",Font.PLAIN,20));
        zhaunke.setFont(new Font("黑体",Font.PLAIN,20));
        yiji.setFont(new Font("黑体",Font.PLAIN,20));
        label.setFont(new Font("黑体",Font.PLAIN,40));
        label.setForeground(Color.CYAN);
        nieke.setBorderPainted(false);
        nieke.setOpaque(false);
        waike.setBorderPainted(false);
        waike.setOpaque(false);
        zhaunke.setBorderPainted(false);
        zhaunke.setOpaque(false);
        yiji.setBorderPainted(false);
        yiji.setOpaque(false);

        label.setBounds(0,0,totalWidth,50);
        toolBarNeike.setBounds(0,50,totalWidth,30);
        toolBarNeike.add(nieke);
        panelnieke.setBounds(0,80,totalWidth,100);
        for(int i = 0;i < 6;i ++){
            buttonsneike[i].setPreferredSize(new Dimension(120,30));
            buttonsneike[i].setBorderPainted(false);
            panelnieke.add(buttonsneike[i]);
        }

        toolBarwaike.setBounds(0,180,totalWidth,30);
        toolBarwaike.add(waike);
        panelwaike.setBounds(0,210,totalWidth,100);
        for(int i = 0;i < 6;i ++){
            buttonswaike[i].setPreferredSize(new Dimension(120,30));
            buttonswaike[i].setBorderPainted(false);
            panelwaike.add(buttonswaike[i]);
        }

        toolBarzhaunke.setBounds(0,310,totalWidth,30);
        toolBarzhaunke.add(zhaunke);
        panelzhaunke.setBounds(0,340,totalWidth,100);
        for(int i = 0;i < 10;i ++){
            buttonszhaunke[i].setPreferredSize(new Dimension(120,30));
            buttonszhaunke[i].setBorderPainted(false);
            panelzhaunke.add(buttonszhaunke[i]);
        }

        toolBaryiji.setBounds(0,440,totalWidth,30);
        toolBaryiji.add(yiji);
        panelyiji.setBounds(0,470,totalWidth,100);
        for(int i = 0;i < 6;i ++){
            buttonsyiji[i].setPreferredSize(new Dimension(120,30));
            buttonsyiji[i].setBorderPainted(false);
            panelyiji.add(buttonsyiji[i]);
        }

        this.add(toolBarNeike);
        this.add(panelnieke);
        this.add(toolBarwaike);
        this.add(panelwaike);
        this.add(toolBarzhaunke);
        this.add(panelzhaunke);
        this.add(toolBaryiji);
        this.add(panelyiji);
        this.add(label);
        this.add(kong);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(this.getOwner());
        this.setVisible(true);
        //内科事件
        buttonsneike[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce xinXueGuanNK = new DepartIntroduce();
                String nfmkid = "K201821107";
                String nfmkname = "心血管内科简介";
                xinXueGuanNK.getKSID(nfmkid);
                xinXueGuanNK.getname(nfmkname);
            }
        });
        buttonsneike[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce ShenbingneiNK = new DepartIntroduce();//调用科室简介
                String smnkid = "K201821201";
                String smnkname = "肾病内科简介";
                ShenbingneiNK.getKSID(smnkid);
                ShenbingneiNK.getname(smnkname);
            }
        });
        buttonsneike[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce neifenmike = new DepartIntroduce();
                String xxgneid = "K201821202";
                String xxgname = "内分泌科简介";
                neifenmike.getKSID(xxgneid);
                neifenmike.getname(xxgname);
            }
        });
        //外科事件
        buttonswaike[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce xinXueGuanNK = new DepartIntroduce();
                String nfmkid = "K201821211";
                String nfmkname = "普通外科简介";
                xinXueGuanNK.getKSID(nfmkid);
                xinXueGuanNK.getname(nfmkname);
            }
        });
        buttonswaike[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce ShenbingneiNK = new DepartIntroduce();
                String smnkid = "K201821212";
                String smnkname = "心胸外科简介";
                ShenbingneiNK.getKSID(smnkid);
                ShenbingneiNK.getname(smnkname);
            }
        });
        buttonswaike[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce neifenmike = new DepartIntroduce();
                String xxgneid = "K201821213";
                String xxgname = "神经外科简介";
                neifenmike.getKSID(xxgneid);
                neifenmike.getname(xxgname);
            }
        });
        //专科事件
        buttonszhaunke[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce xinXueGuanNK = new DepartIntroduce();
                String nfmkid = "K201821217";
                String nfmkname = "儿科简介";
                xinXueGuanNK.getKSID(nfmkid);
                xinXueGuanNK.getname(nfmkname);
            }
        });
        buttonszhaunke[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce ShenbingneiNK = new DepartIntroduce();
                String smnkid = "K201821218";
                String smnkname = "眼科简介";
                ShenbingneiNK.getKSID(smnkid);
                ShenbingneiNK.getname(smnkname);
            }
        });
        buttonszhaunke[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce neifenmike = new DepartIntroduce();
                String xxgneid = "K201821219";
                String xxgname = "中西结合科简介";
                neifenmike.getKSID(xxgneid);
                neifenmike.getname(xxgname);
            }
        });
        //医技科
        buttonsyiji[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce xinXueGuanNK = new DepartIntroduce();
                String nfmkid = "K201821228";
                String nfmkname = "门诊部简介";
                xinXueGuanNK.getKSID(nfmkid);
                xinXueGuanNK.getname(nfmkname);
            }
        });
        buttonsyiji[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce ShenbingneiNK = new DepartIntroduce();
                String smnkid = "K201821229";
                String smnkname = "急诊科简介";
                ShenbingneiNK.getKSID(smnkid);
                ShenbingneiNK.getname(smnkname);
            }
        });
        buttonsyiji[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce neifenmike = new DepartIntroduce();
                String xxgneid = "K201821230";
                String xxgname = "保健科简介";
                neifenmike.getKSID(xxgneid);
                neifenmike.getname(xxgname);
            }
        });

        //内科按钮事件
        nieke.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartClassify departClassify = new DepartClassify();
                String Dbutton = "内科";
                String label = "科室简介";
                String[] Ksjj = {"心血管内科简介","肾病内科简介","内分泌科简介","消化内科简介","神经内科简介","心呼吸内科简介"};
                String[] Xbutton = {"心血管内科","肾病内科","内分泌科","消化内科","神经内科","心呼吸内科"};
                String[] Id = {"K201821107","K201821201","K201821202"};
                int s = 6;
                departClassify.getDbutton(Dbutton);
                departClassify.getlabel(label);
                departClassify.gets(s);
                departClassify.getName(Xbutton);
                departClassify.getid(Id);
                departClassify.getKSJJ(Ksjj);
            }
        });
        //外科按钮事件
        waike.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartClassify departClassify = new DepartClassify();
                String Dbutton = "外科";
                String label = "科室简介";
                String[] Ksjj = {"普通外科简介","心胸外科简介","神经外科简介","骨科简介","放射性治疗简介","泌尿外科简介"};
                String[] Xbutton = {"普通外科","心胸外科","神经外科","骨科","放射性治疗","泌尿外科"};
                String[] Id = {"K201821211","K201821212","K201821213"};
                int s = 6;
                departClassify.getDbutton(Dbutton);
                departClassify.getlabel(label);
                departClassify.gets(s);
                departClassify.getName(Xbutton);
                departClassify.getid(Id);
                departClassify.getKSJJ(Ksjj);
            }
        });
        //专科按钮事件
        zhaunke.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartClassify departClassify = new DepartClassify();
                String Dbutton = "专科";
                String label = "科室简介";
                String[] Ksjj = {"儿科简介","眼科简介","中西结合科简介","耳鼻喉科简介","口腔科简介","皮肤科简介",
                        "空勤科简介","感染内科简介","麻醉科简介","干部病房一科简介"};
                String[] Xbutton = {"儿科","眼科","中西结合科","耳鼻喉科","口腔科","皮肤科","空勤科","感染内科","麻醉科","干部病房一科"};
                String[] Id = {"K201821217","K201821218","K201821219"};
                int s = 10;
                departClassify.gets(s);
                departClassify.getName(Xbutton);
                departClassify.getDbutton(Dbutton);
                departClassify.getlabel(label);
                departClassify.getid(Id);
                departClassify.getKSJJ(Ksjj);
            }
        });
        //医技按钮事件
        yiji.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartClassify departClassify = new DepartClassify();
                String Dbutton = "医技";
                String label = "科室简介";
                String[] Ksjj = {"门诊科简介","急诊科简介","保健科简介","体检中心简介","临床药理科简介","医学工程科简介"};
                String[] Xbutton = {"门诊科","急诊科","保健科","体检中心","临床药理科","医学工程科"};
                String[] Id = {"K201821228","K201821229","K201821230"};
                int s = 6;
                //将数据传到类departClassify，调用departClassify
                departClassify.getDbutton(Dbutton);
                departClassify.getlabel(label);
                departClassify.gets(s);
                departClassify.getName(Xbutton);
                departClassify.getid(Id);
                departClassify.getKSJJ(Ksjj);
            }
        });


    }
}
