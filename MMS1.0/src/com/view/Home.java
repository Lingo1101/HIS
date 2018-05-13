package com.view;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.view.guide.PationGuide;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
/*
 * Created by JFormDesigner on Wed Mar 21 09:18:36 CST 2018
 */


/**
 * @author dasdfaf
 */
public class Home extends JFrame {

    //主界面图片更换

    JLabel ShowImage= new JLabel();
    JLabel Addword = new JLabel();
    ImageIcon a = new ImageIcon("pictures/04.jpg");
    ImageIcon b = new ImageIcon("pictures/6.jpg");
    ImageIcon c = new ImageIcon("pictures/7.jpg");
    ImageIcon[] AllImages = {a, b, c};
    TastThread m_thread1;
    int currentImg=0;
    public static final int WIDTH = 1500;
    public static final int HEIGHT = 900;

    public Home() {
        initComponents();
        launch();
        this.setTitle("广州军区武汉总医院");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.setLocationRelativeTo(getOwner());
        this.setResizable(false);
        this.setVisible(true ) ;
    }
    //启用线程
    public void launch() {
        m_thread1 = new TastThread();
        m_thread1.start();
    }

    private void thisPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void LoginButtonListener(ActionEvent e) // 登录按钮
    {
        new Login();
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel4 = new JPanel();
        separator1 = new JToolBar.Separator();
        panel3 = new JPanel();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu3 = new JMenu();
        menu4 = new JMenu();
        menu5 = new JMenu();
        menu6 = new JMenu();
        menu7 = new JMenu();
        menu8 = new JMenu();
        menu9 = new JMenu();
        menu10 = new JMenu();
        menu11 = new JMenu();
        menu12 = new JMenu();
        menu13 = new JMenu();
        panel2 = new JPanel();
        loginButton = new JButton();
        guideButton = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        addPropertyChangeListener(e -> thisPropertyChange(e));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel4 ========
        {
            panel4 = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    Color c = g.getColor();
                    ImageIcon imageIcon = new ImageIcon("pictures/1.png");
                    g.setColor(Color.white);
                    g.fillRect(0, 0, 1500, 100);
                    g.drawImage(imageIcon.getImage(), 350, 0, 800, 100, null);
                    g.setColor(c);
                }
            };
            panel4.setPreferredSize(new Dimension(1000, 100));
            panel4.add(separator1);
        }
        contentPane.add(panel4, BorderLayout.NORTH);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());

            //======== menuBar1 ========
            {
                menuBar1.setBackground(new Color(0, 102, 51));

                //======== menu1 ========
                {
                    menu1.setText("\u9996\u9875");
                }
                menuBar1.add(menu1);

                //======== menu2 ========
                {
                    menu2.setText("\u533b\u9662\u72b6\u51b5");
                }
                menuBar1.add(menu2);

                //======== menu3 ========
                {
                    menu3.setText("\u65b0\u95fb\u72b6\u6001");
                }
                menuBar1.add(menu3);

                //======== menu4 ========
                {
                    menu4.setText("\u5c31\u533b\u6307\u5357");
                }
                menuBar1.add(menu4);

                //======== menu5 ========
                {
                    menu5.setText("\u79d1\u5ba4\u5bfc\u822a");
                }
                menuBar1.add(menu5);

                //======== menu6 ========
                {
                    menu6.setText("\u4e13\u5bb6\u835f\u8403");
                }
                menuBar1.add(menu6);

                //======== menu7 ========
                {
                    menu7.setText("\u79d1\u7814\u6559\u5b66");
                }
                menuBar1.add(menu7);

                //======== menu8 ========
                {
                    menu8.setText("\u62a4\u7406\u56ed\u5730");
                }
                menuBar1.add(menu8);

                //======== menu9 ========
                {
                    menu9.setText("\u533b\u9662\u4fe1\u606f\u5316");
                }
                menuBar1.add(menu9);

                //======== menu10 ========
                {
                    menu10.setText("\u4e3a\u5175\u670d\u52a1");
                }
                menuBar1.add(menu10);

                //======== menu11 ========
                {
                    menu11.setText("\u533b\u7597\u4fdd\u5065");
                }
                menuBar1.add(menu11);

                //======== menu12 ========
                {
                    menu12.setText("\u4eba\u529b\u8d44\u6e90");
                }
                menuBar1.add(menu12);

                //======== menu13 ========
                {
                    menu13.setText("\u9884\u7ea6\u6302\u53f7");
                }
                menuBar1.add(menu13);
            }
            panel3.add(menuBar1, BorderLayout.NORTH);

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout(5, 1));
                panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),
                        "搜索结果", TitledBorder.LEFT,TitledBorder.TOP,new Font("华文新魏",Font.PLAIN,26)));
                //---- button6 ----
                loginButton.setText("登陆");
                loginButton.setPreferredSize(new Dimension(100, 40));
                loginButton.setFont(new Font("宋体", Font.BOLD, 20));
                loginButton.addActionListener(e -> LoginButtonListener(e));
                panel2.add(loginButton);

                //---- guideButton ----
                guideButton.setText("就医指导");
                guideButton.setPreferredSize(new Dimension(100, 40));
                guideButton.setFont(new Font("宋体", Font.BOLD, 20));
                guideButton.addActionListener(e -> button4ActionPerformed(e));
                guideButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new PationGuide();
                    }
                });
                panel2.add(guideButton);


                //---- button1 ----
                button1.setText("\u7f51\u7edc\u533b\u9662");
                button1.setPreferredSize(new Dimension(100, 40));
                button1.setFont(new Font("宋体", Font.BOLD, 20));
                //未实现
                button1.setBackground(new Color(204, 204, 255));
                panel2.add(button1);

                //---- button2 ----
                button2.setText("\u533b\u9662\u6982\u51b5");
                button2.setPreferredSize(new Dimension(100, 40));
                button2.setFont(new Font("宋体", Font.BOLD, 20));
                //未实现
                button2.setBackground(new Color(204, 204, 255));
                panel2.add(button2);

                //---- button3 ----
                button3.setText("\u670d\u52a1\u7279\u8272");
                button3.setPreferredSize(new Dimension(100, 40));
                button3.setFont(new Font("宋体", Font.BOLD, 20));
                //未实现
                button3.setBackground(new Color(204, 204, 255));
                panel2.add(button3);
            }
            panel3.add(panel2, BorderLayout.EAST);
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel4;
    private JToolBar.Separator separator1;
    private JPanel panel3;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
    private JMenu menu5;
    private JMenu menu6;
    private JMenu menu7;
    private JMenu menu8;
    private JMenu menu9;
    private JMenu menu10;
    private JMenu menu11;
    private JMenu menu12;
    private JMenu menu13;
    private JPanel panel2;
    private JButton loginButton;
    private JButton guideButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    //    延时换图
 class TastThread extends Thread{
        public boolean m_bdone = false;
        public void run() {
            while (true) {
                currentImg++;
                if (currentImg >= 3) {
                    currentImg = 0;
                }
                if (currentImg < 0) {
                    currentImg = 2;
                }
               ShowImage.setIcon(AllImages[currentImg]);
                panel3.add(ShowImage);

                try {
                    Thread.sleep(2000);//延时两秒
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (m_bdone) {

                    break;
                }

            }
        }
    }

}
