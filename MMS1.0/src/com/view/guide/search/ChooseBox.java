package com.view.guide.search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * 搜索框
 */
public class ChooseBox extends JPopupMenu{

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 600);
        jFrame.getContentPane().setLayout(new FlowLayout());
        //===================使用用例========================
        Search search = new Search();
        jFrame.getContentPane().add(search);
        //==================================================
        jFrame.setLocationRelativeTo(jFrame.getOwner());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private Search search;
    private boolean isAdd = false;

    public ChooseBox(Search search) {
        this.search = search;
        JMenuItem menuItem1 = new JMenuItem("查询病人信息");
        JMenuItem menuItem2 = new JMenuItem("查询费用");
        JMenuItem menuItem3 = new JMenuItem("查询医嘱");
        menuItem1.setFont(search.textField.getFont());
        menuItem2.setFont(search.textField.getFont());
        menuItem3.setFont(search.textField.getFont());
        this.add(menuItem1);
        this.add(menuItem2);
        this.add(menuItem3);
        search.choiceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ButtonClick(e);
            }
        });
        java.util.List<JMenuItem> list = new ArrayList<>();
        list.add(menuItem1);
        list.add(menuItem2);
        list.add(menuItem3);
        for(JMenuItem jMenuItem : list) {
            jMenuItem.addActionListener((e) -> {
                ChooseBox.this.search.textField.setText("");
                ChooseBox.this.search.chooseText = jMenuItem.getText();
                ChooseBox.this.search.backgroundText = jMenuItem.getText();
                ChooseBox.this.search.textField.repaint();
            });
        }
    }

    private void ButtonClick(MouseEvent e) {
        if (!isAdd) {
            search.getRootPane().getLayeredPane().add(ChooseBox.this, JLayeredPane.DRAG_LAYER);
        }
        int x = caculateChooseBoxPoint().x;
        int y = caculateChooseBoxPoint().y;
        this.show(search.getRootPane(), x, y);
    }

    private Point caculateChooseBoxPoint() {
        int x = 0;
        int y = 0;
        Container parent = search;
        while(parent != search.getRootPane()) {
            x += parent.getX();
            y += parent.getY();
            parent = parent.getParent();
        }
        y += search.getHeight();
        x += search.getWidth();
        return new Point(x, y);

    }
}
