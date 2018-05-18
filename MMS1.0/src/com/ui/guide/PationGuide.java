package com.ui.guide;

import com.ui.Home_old;
import com.ui.guide.search.SearchPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.ArrayList;

public class PationGuide extends JFrame implements ActionListener {
    JPanel rightPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JLabel title = new JLabel();
    JScrollPane firstPanel = new JScrollPane();
    JScrollPane secondPanel = new JScrollPane();
    JScrollPane thirdPanel = new JScrollPane();
    JScrollPane fourthPanel = new JScrollPane();
    JScrollPane fifthPanel = new JScrollPane();

    JTextPane first = new JTextPane();
    JPanel second = new JPanel();
    JPanel third = new JPanel();
    JTextPane fourth = new JTextPane();
    JPanel fifth = new JPanel();

    String encoding = "GBK";
    JTextArea text = new JTextArea(0,90);
    JLabel picS = new JLabel(new ImageIcon("pho/导医平面.jpg"));
    JLabel picSe = new JLabel(new ImageIcon("pho/科室分布.jpg"));
    JPanel ePanel = new JPanel();

    java.util.List<JScrollPane> list = new ArrayList<>();

    /*Constructor*/
    public PationGuide(){
        super("就医指南");
        this.setSize(Home_old.WIDTH, Home_old.HEIGHT);
        this.setLocationRelativeTo(this.getOwner());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        JTextArea copyright = new JTextArea("地址：湖北省武汉市武珞路627号，乘2号线在宝通寺站下，C1出口出站前行20米即可  "
                +"电话：027-50773333(总机) 公交路线：公汽804、608、806、703、518、540等直达医院");
        text.setTabSize(4);
        text.setFont(new Font("宋体", Font.BOLD, 18));
        text.setLineWrap(true);// 激活自动换行功能
        text.setWrapStyleWord(true);// 激活断行不断字功能
        text.setSelectedTextColor(Color.RED);

        ImageIcon bg = new ImageIcon("pho/title.png");
        title.setIcon(bg);
        title.setHorizontalAlignment(0);
        title.setOpaque(true);
        title.setBackground(Color.WHITE);
        title.setForeground(Color.RED);
        title.setFont(new Font("黑体", Font.PLAIN, 26));
        title.setBorder(BorderFactory.createEtchedBorder());

        leftPanel.setBackground(Color.LIGHT_GRAY);//copyright.setFont(new Font("黑体", Font.PLAIN, 12));
        rightPanel.setLayout(null);
        rightPanel.setSize((int) ((Home_old.WIDTH-leftPanel.getWidth())/1.3), Home_old.HEIGHT-title.getHeight());
        rightPanel.setBackground(Color.WHITE);

        ImageIcon p1 = new ImageIcon("pho/科室分布.jpg");
        ImageIcon p3 = new ImageIcon("pho/导医平面.jpg");
        picS.setIcon(p1);
        picSe.setIcon(p3);

        picS.setOpaque(true);
        picSe.setOpaque(true);

        //添加到list里
        list.add(firstPanel);
        list.add(secondPanel);
        list.add(thirdPanel);
        list.add(fourthPanel);
        list.add(fifthPanel);

        JButton an1 = new JButton("就诊须知");
        JButton an2 = new JButton("科室分布");
        JButton an3 = new JButton("快速检索");
        JButton an4 = new JButton("住院须知");
        JButton an5 = new JButton("导医平面");

        an1.setIcon(new ImageIcon("pho/an1.png"));
        an2.setIcon(new ImageIcon("pho/an2.png"));
        an3.setIcon(new ImageIcon("pho/an3.png"));
        an4.setIcon(new ImageIcon("pho/an4.png"));
        an5.setIcon(new ImageIcon("pho/an5.png"));

        an1.addActionListener(this);
        an2.addActionListener(this);
        an3.addActionListener(this);
        an4.addActionListener(this);
        an5.addActionListener(this);

        an1.setActionCommand("jz");
        an2.setActionCommand("ks");
        an3.setActionCommand("ly");
        an4.setActionCommand("zy");
        an5.setActionCommand("dy");

        an1.setFont(new Font("黑体",Font.PLAIN,20));
        an2.setFont(new Font("黑体",Font.PLAIN,20));
        an3.setFont(new Font("黑体",Font.PLAIN,20));
        an4.setFont(new Font("黑体",Font.PLAIN,20));
        an5.setFont(new Font("黑体",Font.PLAIN,20));

        leftPanel.add(an1);
        leftPanel.add(an2);
        leftPanel.add(an3);
        leftPanel.add(an4);
        leftPanel.add(an5);
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));//竖着排列

        this.add(title,BorderLayout.NORTH);
        this.add(leftPanel,BorderLayout.WEST);
        this.add(rightPanel,BorderLayout.CENTER);
        this.add(ePanel,BorderLayout.EAST);//只占位，不实现
        this.add(copyright,BorderLayout.SOUTH);
        this.setVisible(true);

        //初始化每个textpanel
        setFirst();
        setSecond();
        setThird();
        setFourth();
        setFifth();
    }

    private void setFirst() {
            firstPanel.setBounds(0, 0, rightPanel.getWidth(), rightPanel.getHeight());
            //first.setBackground(Color.red);
            rightPanel.add(firstPanel);
            firstPanel.setViewportView(first);
            first.setContentType("text/html");
            String filepath = "D:\\java学习/就诊须知.txt";
            File file = new File(filepath);
            try{
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                            new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader br = new BufferedReader(read);
                    String lineTxt = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    while((lineTxt = br.readLine()) != null){
                        stringBuffer.append(lineTxt+"<br>");
                    }
                    first.setText("<h2>" + stringBuffer.toString() + "</h2>");
                    first.setEditable(false);
                    br.close();
                }
            }catch (FileNotFoundException a){
                System.out.println("找不到指定文件");
            }catch (IOException a){
                System.out.println("文件读取错误");
            }
            firstPanel.setVisible(false);
    }
    private void setSecond() {
        secondPanel.setBounds(0, 0, rightPanel.getWidth(), rightPanel.getHeight());
        second.add(picS);
        rightPanel.add(secondPanel);
        secondPanel.setViewportView(second);
        secondPanel.setVisible(false);
    }
    private void setThird() {
        thirdPanel.setBounds(0, 0, rightPanel.getWidth(), rightPanel.getHeight());
        rightPanel.add(thirdPanel);
        thirdPanel.setViewportView(third);
        SearchPanel searchPanel = new SearchPanel();
        third.add(searchPanel);
        searchPanel.repaint();
        thirdPanel.setVisible(false);
    }
    private void setFourth() {
            fourth.setContentType("text/html");
            fourthPanel.setBounds(0, 0, rightPanel.getWidth(), rightPanel.getHeight());
            fourthPanel.setBackground(Color.WHITE);
            rightPanel.add(fourthPanel);
            fourthPanel.setViewportView(fourth);
            fourthPanel.setBounds(0, 0, rightPanel.getWidth(), rightPanel.getHeight());
            String filepath = "D:\\java学习/住院须知.txt";
            File file = new File(filepath);
            try{
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                            new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader br = new BufferedReader(read);
                    String lineTxt = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    while((lineTxt = br.readLine()) != null){
                        lineTxt = "<h2>" + lineTxt + "</h2>";
                        stringBuffer.append(lineTxt+"<br>");
                        text.setEditable(false);
                    }
                    fourth.setText(stringBuffer.toString());
                    br.close();

                }
            }catch (FileNotFoundException a){
                System.out.println("找不到指定文件");
            }catch (IOException a){
                System.out.println("文件读取错误");
            }
            fourthPanel.setVisible(false);
    }
    private void setFifth() {
        fifthPanel.setBounds(0, 0, rightPanel.getWidth(), rightPanel.getHeight());
        fifth.add(picSe);
        rightPanel.add(fifthPanel);
        fifthPanel.setViewportView(fifth);
        fifthPanel.setVisible(false);
    }
    /*实现接口ActionListener */
    public void actionPerformed(ActionEvent e) {
        for(JScrollPane jScrollPane : list) {
            jScrollPane.setVisible(false);
        }
        /*1*/
        if(e.getActionCommand().equals("jz")){
            firstPanel.setVisible(true);
        }
        /*2*/
        if(e.getActionCommand().equals("ks")){
            secondPanel.setVisible(true);
        }
        /*3*/
        if(e.getActionCommand().equals("ly")){
            thirdPanel.setVisible(true);
        }
        /*4*/
        if(e.getActionCommand().equals("zy")){
            fourthPanel.setVisible(true);
        }
        /*5*/
        if(e.getActionCommand().equals("dy")) {
            fifthPanel.setVisible(true);
        }
    }
}
