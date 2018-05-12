package com.view;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.view.guide.PationGuide;

import javax.swing.*;
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

    public Home() {
        initComponents();
        setTitle("广州军区武汉总医院");
        setSize(800, 800);
        setLocation(100, 100);
        setVisible(true);
        //主界面菜单栏上面添加图片
        JLabel jLabel = new JLabel( new ImageIcon("pictures/1.png"));
        panel4.add(jLabel);

        this.add(panel3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        this.setLocationRelativeTo(getOwner());
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
        button6 = new JButton();
        button4 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        addPropertyChangeListener(e -> thisPropertyChange(e));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel4 ========
        {
            panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
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
                panel2.setLayout(new FormLayout(
                    "default",
                    "fill:default, 14*($lgap, default)"));

                //---- button6 ----
                button6.setText("\u767b\u5f55");
                button6.addActionListener(e -> LoginButtonListener(e));
                panel2.add(button6, CC.xy(1, 5));

                //---- button4 ----
                button4.setText("\u5c31\u533b\u6307\u5357");
                button4.setHorizontalAlignment(SwingConstants.RIGHT);
                button4.setBackground(new Color(204, 204, 255));
                button4.addActionListener(e -> button4ActionPerformed(e));
                panel2.add(button4, CC.xy(1, 7));
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new PationGuide();
                    }
                });

                //---- button1 ----
                button1.setText("\u7f51\u7edc\u533b\u9662");
                button1.setHorizontalAlignment(SwingConstants.RIGHT);
                button1.setBackground(new Color(204, 204, 255));
                panel2.add(button1, CC.xy(1, 9));

                //---- button2 ----
                button2.setText("\u533b\u9662\u6982\u51b5");
                button2.setHorizontalAlignment(SwingConstants.RIGHT);
                button2.setBackground(new Color(204, 204, 255));
                panel2.add(button2, CC.xy(1, 11));

                //---- button3 ----
                button3.setText("\u670d\u52a1\u7279\u8272");
                button3.setHorizontalAlignment(SwingConstants.RIGHT);
                button3.setBackground(new Color(204, 204, 255));
                panel2.add(button3, CC.xy(1, 13));
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
    private JButton button6;
    private JButton button4;
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
