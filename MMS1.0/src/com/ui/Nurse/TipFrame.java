/*
 * Created by JFormDesigner on Mon May 28 22:00:20 CST 2018
 */

package com.ui.Nurse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import javax.swing.*;

/**
 * @author dutz
 */
public class TipFrame extends JFrame {

    public TipFrame(String patientID, Map<String, int[]> map, List<Map<String, int[]>> patientTime,
                    Map<String, JTextPane> patientPane, TimeTest timeTest) {
        this.patientID = patientID;
        this.map = map;
        this.patientTime = patientTime;
        this.patientPane = patientPane;
        this.timeTest = timeTest;
        initComponents();
        this.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClickActionPerformed();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                dispose();
                timeTest.run();
            }
        });
    }

    public  void ClickActionPerformed() {
        patientPane.get(patientID).setBackground(Color.yellow);
        patientTime.remove(map);
        patientPane.remove(patientID);
        dispose();
        timeTest.run();
    }

    private void initComponents() {
        button1 = new JButton();
        jTextPane = new JTextPane();
        jPanel = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setSize(400, 230);
        this.setResizable(false);
        this.setTitle("提醒");

        //====jTextPane=====
        jTextPane.setEditable(false);
        jTextPane.setContentType("text/html");
        jTextPane.setText("<hr><h2 align='center'>" + "请注意执行" + patientID + "的医嘱" + "</h2><hr>" );
        contentPane.add(jTextPane, BorderLayout.CENTER);

        //==========jpanel==========
        jPanel.setPreferredSize(new Dimension(0, 100));
        jPanel.setBackground(Color.white);
        jPanel.setLayout(new FlowLayout());
        contentPane.add(jPanel, BorderLayout.SOUTH);

        //---- button1 ----
        button1.setText("知道了");
        button1.setFont(new Font("宋体", Font.PLAIN, 20));
        button1.setPreferredSize(new Dimension(100, 50));
        jPanel.add(button1);


        setLocationRelativeTo(getOwner());

    }

    private JButton button1;
    private JTextPane jTextPane;
    private JPanel jPanel;
    private String patientID = null;
    private List<Map<String, int[]>> patientTime;
    private Map<String, JTextPane> patientPane;
    private Map<String, int[]> map;
    TimeTest timeTest;
}
