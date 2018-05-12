package com.view.patient;

import com.view.patient.HealthyReadTxt001;
import com.view.patient.HealthyReadTxt002;
import com.view.patient.HealthyReadTxt003;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *推送界面图片显示
 */
public class ShowImagePanel extends JPanel{
    MyLable ShowImage = new MyLable();
    MyLable equ = new MyLable();
    JLabel NextImage = new JLabel(new ImageIcon("Images/next.jpg"));
    JLabel LastImage = new JLabel(new ImageIcon("Images/last.jpg"));
    ImageIcon a = new ImageIcon("Images/P004.jpg");
    ImageIcon b = new ImageIcon("Images/P005.jpg");
    ImageIcon c = new ImageIcon("Images/P006.jpg");
    ImageIcon[] AllImages = {a, b, c};
    int currentImg=0;
    TastThread m_thread1 = new TastThread();

    JLabel Addword = new JLabel();
    JTextField[] Addnumber = {new JTextField("1"),new JTextField("2"),new JTextField("3")};
    JPanel pa = new JPanel();
    String[] word = {"瑞典Helix精神医疗中心","波兰Krakow保健中心","美国基督教医院"};

    /**
     *
     */
    public ShowImagePanel() {
        pa.setLayout(new BorderLayout());
        pa.setOpaque(false);//将面板设置成透明
        for(int i = 0;i < 3;i ++){
            Addnumber[i].setBorder(null);//去掉文本框的边框
        }
        for(int i = 0;i < 3;i ++){
            Addnumber[i].setHorizontalAlignment(JTextField.CENTER);//让文本框里的内容居中
        }
        Addword.setFont(new Font("宋体", Font.PLAIN, 25));
        Addnumber[0].setFont(new Font("宋体", Font.PLAIN, 15));
        Addnumber[1].setFont(new Font("宋体", Font.PLAIN, 15));
        Addnumber[2].setFont(new Font("宋体", Font.PLAIN, 15));
        Addword.setForeground(Color.RED);
        ShowImage.setFont(new Font("宋体", Font.PLAIN, 18));
        ShowImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//使鼠标箭头变成其他形状
        this.setPreferredSize(new Dimension(200, 100));
        this.setLayout(new BorderLayout());
        this.add(ShowImage, BorderLayout.CENTER);
        ShowImage.setLayout(new BorderLayout());
        LastImage.setPreferredSize(new Dimension(60, 60));
        NextImage.setPreferredSize(new Dimension(60, 60));
        ShowImage.add(NextImage, BorderLayout.EAST);
        NextImage.setVisible(false);
        ShowImage.add(LastImage, BorderLayout.WEST);
        LastImage.setVisible(false);
        Addnumber[0].setBounds(830,10,15,15);
        Addnumber[1].setBounds(860,10,15,15);
        Addnumber[2].setBounds(890,10,15,15);
        for(int i = 0;i < 3;i ++){
            pa.add(Addnumber[i]);
        }
        pa.add(Addword,BorderLayout.CENTER);
        ShowImage.add(pa,BorderLayout.SOUTH);

        this.add(ShowImage);
        this.setVisible(true);
        m_thread1.start();

        ShowImage.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                LastImage.setVisible(true);
                NextImage.setVisible(true);
                ShowImage.setImageIcon(AllImages[currentImg]);
                m_thread1.m_bdone = false;//关闭线程
                m_thread1 = null;

            }

            public void mouseExited(MouseEvent e) {
                LastImage.setVisible(false);
                NextImage.setVisible(false);
                m_thread1 = new TastThread();
                m_thread1.start();//重新启动线程

            }
            public void  mouseClicked(MouseEvent e){
                switch(currentImg) {
                    case 0:
                        HealthyReadTxt001 healthyReadTxt001 = new HealthyReadTxt001();
                        break;
                    case 1:
                        HealthyReadTxt002 healthyReadTxt002 = new HealthyReadTxt002();
                        break;
                    case 2:
                        HealthyReadTxt003 healthyReadTxt003 = new HealthyReadTxt003();
                        break;
                }
            }
        });

        LastImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentImg--;
                if (currentImg >= 3) {
                    currentImg = 0;
                }
                if (currentImg < 0) {
                    currentImg = 2;
                }
                ShowImage.setImageIcon(AllImages[currentImg]);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                LastImage.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LastImage.setVisible(false);
            }
        });

        NextImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentImg++;
                if (currentImg >= 3) {
                    currentImg = 0;
                }
                if (currentImg < 0) {
                    currentImg = 2;
                }
                ShowImage.setImageIcon(AllImages[currentImg]);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                NextImage.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                NextImage.setVisible(false);
            }
        });
    }
    private class TastThread extends Thread{
        public boolean m_bdone = true;
        public void run(){
            while(m_bdone) {
                currentImg++;
                if(currentImg>=3) {
                    currentImg=0;
                }
                if(currentImg < 0) {
                    currentImg=2;
                }
                ShowImage.setImageIcon(AllImages[currentImg]);
                Addword.setText(word[currentImg]);
                if(currentImg == 0){
                    Addnumber[0].setBackground(Color.white);
                }
                else { Addnumber[0].setBackground(Color.CYAN);}
                if(currentImg == 1){
                    Addnumber[1].setBackground(Color.white);
                }
                else { Addnumber[1].setBackground(Color.CYAN);}
                if(currentImg == 2){
                    Addnumber[2].setBackground(Color.white);
                }
                else { Addnumber[2].setBackground(Color.CYAN);}

                try {
                    Thread.sleep(3000);//延时两秒
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private class MyLable extends JLabel {
        ImageIcon imageIcon = new ImageIcon();
        public void setImageIcon(ImageIcon imageIcon) {
            this.imageIcon = imageIcon;
            repaint();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imageIcon.getImage(),0,0,getSize().width, getSize().height, this);
        }
    }
}
