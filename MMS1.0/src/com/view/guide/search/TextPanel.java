package com.view.guide.search;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 显示心信息
 */
public class TextPanel extends JPanel {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 600);
        jFrame.getContentPane().setLayout(new FlowLayout());
        //===================使用用例========================
        TextPanel targetPannel = new TextPanel();
        jFrame.getContentPane().add(targetPannel);
        //==================================================
        jFrame.setLocationRelativeTo(jFrame.getOwner());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //=========================================================
        new GetInfo(targetPannel.textPane, "PATIENTINFO", "PATIENTID","P201821101");
        jFrame.setVisible(true);
    }


    private JTextPane textPane;

    public JScrollPane getPaneScrollPane() {
        return paneScrollPane;
    }

    private JScrollPane paneScrollPane;

    public TextPanel() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),
               "搜索结果", TitledBorder.LEFT,TitledBorder.TOP,new Font("华文新魏",Font.PLAIN,26)));
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        paneScrollPane = new JScrollPane(textPane);
        paneScrollPane.setPreferredSize(new Dimension(700, 600));
        add(paneScrollPane);
    }

    public JTextPane getTextPane() {
        return textPane;
    }
}