package com.ui.patient;

import com.utils.BeautifulFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 科室分类
 */
public class DepartClassify extends JFrame{
    static int totalWidth;
    static int totalHeight;
    public String[] id  = {"","","","","","","","","",""};
    public String[] KSjj  = {"","","","","","","","","",""};
    public int s;

    JLabel label = new JLabel(" ",JLabel.CENTER);
    JLabel labelpicture001 = new JLabel(new ImageIcon("Images/NK001.png"));
    JLabel labelpicture002 = new JLabel(new ImageIcon("Images/WK001.png"));
    JLabel labelpicture003 = new JLabel(new ImageIcon("Images/ZK001.png"));
    JLabel labelpicture004 = new JLabel(new ImageIcon("Images/YJ001.png"));
    JLabel kong = new JLabel();
    JToolBar toolBar = new JToolBar();
    JButton Dbutton = new JButton();
    JPanel panel = new JPanel();
    JButton[] Xbutton = {new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
            new JButton(), new JButton(),new JButton(),new JButton()};
    public static void main(String[] args){
        DepartClassify departClassify = new DepartClassify();
    }

    //构造函数
    public DepartClassify(){
        totalWidth = BeautifulFrame.frameWidth*2/3;
        totalHeight = BeautifulFrame.frameHeight*4/5;
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int bottomInset = screenInsets.bottom;
        this.setSize(totalWidth, totalHeight);
        //获取任务栏高度,以便将软件位置初始化为屏幕正中央

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Dbutton.setFont(new Font("黑体",Font.PLAIN,20));
        label.setFont(new Font("黑体",Font.PLAIN,40));
        label.setForeground(Color.CYAN);
        Dbutton.setBorderPainted(false);
        Dbutton.setOpaque(false);
        label.setBounds(0,0,totalWidth,50);
        toolBar.setBounds(0,50,totalWidth,30);
        toolBar.add(Dbutton);
        panel.setBounds(0,80,totalWidth,100);

        this.add(toolBar);
        this.add(panel);
        this.add(label);
        this.add(kong);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(this.getOwner());
        this.setVisible(true);

        //按钮事件，点击按钮出现所对应的科室简介
        Xbutton[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce xinXueGuanNK = new DepartIntroduce();
                String nfmkid = id[0];
                String nfmkname = KSjj[0];
                xinXueGuanNK.getKSID(nfmkid);
                xinXueGuanNK.getname(nfmkname);
            }
        });
        Xbutton[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce ShenbingneiNK = new DepartIntroduce();
                String smnkid = id[1];
                String smnkname = KSjj[1];
                ShenbingneiNK.getKSID(smnkid);
                ShenbingneiNK.getname(smnkname);
            }
        });
        Xbutton[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DepartIntroduce neifenmike = new DepartIntroduce();
                String xxgneid = id[2];
                String xxgname = KSjj[2];
                neifenmike.getKSID(xxgneid);
                neifenmike.getname(xxgname);
            }
        });
    }
    //获取科室简介ID
    public void getid(String[] ID){
        for (int i = 0;i < 3;i ++){
            id[i] = ID[i];
        }
    }
    //获取内，外，专，医科室
    public void getKSJJ(String[] KSJJ){
        for (int i = 0;i < 3;i ++){
            KSjj[i] = KSJJ[i];
        }
    }
    //显示内，外，专，医所所对应的图片
    public void getDbutton(String _str){
        Dbutton.setText(_str);
        if(Dbutton.getText().equals("内科")) {
            labelpicture001.setBounds(100, 200, 800, 600);
            this.add(labelpicture001);
        }
        if(Dbutton.getText().equals("外科")){
            labelpicture002.setBounds(100, 200, 800, 600);
            this.add(labelpicture002);
        }
        if(Dbutton.getText().equals("专科")){
            labelpicture003.setBounds(100, 200, 800, 600);
            this.add(labelpicture003);
        }
        if(Dbutton.getText().equals("医技")){
            labelpicture004.setBounds(100, 200, 800, 600);
            this.add(labelpicture004);
        }
    }
    //显示大标题
    public void getlabel(String _str){
        label.setText(_str);
    }
    //获取内，外，专，医所对应的科室数目
    public void gets(int _str){
        s = _str;
    }
    //显示内，外，专，医所对应的科室
    public void getName(String[] xb){
        for (int i = 0;i < s;i ++){
            Xbutton[i].setText(xb[i]);
        }
        for(int i = 0;i < s ;i ++){
            Xbutton[i].setPreferredSize(new Dimension(120,30));
            Xbutton[i].setBorderPainted(false);
            panel.add(Xbutton[i]);
        }
    }
}
