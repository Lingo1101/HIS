package com.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 美化的按钮
 * @author dutz
 */
public class BeautifulButton extends JButton {
    private ImageIcon normalStyle;
    private ImageIcon armeStyle;
    private int weight;
    private int height;
    private boolean enter = false;

    public BeautifulButton(String text) {
        this.setFont(new Font("宋体", Font.PLAIN, 20));
        this.setText(text);
        addMouseSysle();
    }

    public BeautifulButton(ImageIcon normalStyle, ImageIcon armeStyle, int weight, int height) {
        this.normalStyle = normalStyle;
        this.armeStyle = armeStyle;
        this.weight = weight;
        this.height = height;
        addMouseSysle();
    }
    public void addMouseSysle() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                enter = false;
                BeautifulButton.this.setForeground(Color.BLACK);
                BeautifulButton.this.repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                BeautifulButton.this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                BeautifulButton.this.setForeground(Color.white);
                enter = true;
                BeautifulButton.this.repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        super.paintComponent(g);
        if(normalStyle == null || armeStyle == null) {
            return;
        }
        if (enter) {
            g.drawImage(armeStyle.getImage(), 0, 0, weight, height ,null);
        } else {
            g.drawImage(normalStyle.getImage(), 0, 0, weight, height ,null);
        }
    }

    @Override
    public void setText(String text) {
        super.setText(text + "▼");
    }
}