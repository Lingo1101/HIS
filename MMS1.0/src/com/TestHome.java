package com;

import com.utils.BeautifulButton;
import com.utils.BeautifulFrame;

import javax.swing.*;
import java.awt.*;

public class TestHome {
    private BeautifulFrame frame;
    private BeautifulButton loginButton;
    private JPanel titleCenter;

    public TestHome() {
        this.initComponents();
        titleCenter.setLayout(new BorderLayout());
        titleCenter.add(loginButton, BorderLayout.EAST);
        frame.setVisible(true);
    }

    public void initComponents() {
        frame = new BeautifulFrame();
        loginButton  = new BeautifulButton("未登录");
        titleCenter = frame.getTitleCenter();
    }
}
