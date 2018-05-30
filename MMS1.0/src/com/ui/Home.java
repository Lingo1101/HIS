package com.ui;

import com.ui.Login.Session;
import com.ui.Login.Logined;
import com.ui.Login.Logining;
import com.ui.guide.PationGuide;
import com.utils.BeautifulButton;
import com.utils.BeautifulFrame;
import com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 主页面 组合所有界面
 * @author dutz
 */
public class Home {
    private BeautifulFrame frame;
    private BeautifulButton loginButton;
    private JPanel masterPanel;
    private JPanel titleCenter;
    private Logining logining;
    private JPanel titleRight;
    private PationGuide pationGuide;
    private JLabel titleLabel;
    private Logined logined;

    public Home() {
            JDBCUtils.connect();    //初始化时就连接数据库 去掉需要操作时有的卡顿
            this.initComponents();
            frame.setVisible(true);
            //---loginButton---
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginActionPerformed();
                }
            });
            //------------titleLabel--------------------
            titleLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    masterPanel.removeAll();
                    masterPanel.add(pationGuide, BorderLayout.CENTER);
                    masterPanel.updateUI();
                }
            });
    }

    public void initComponents() {
        frame = new BeautifulFrame();
        loginButton  = new BeautifulButton("未登录");
        masterPanel = frame.getMasterPane();
        titleCenter = frame.getTitleCenter();
        titleRight = frame.getTitleRight();
        titleLabel = frame.getTitleLabel();

        //---titleCenter---
        titleCenter.setLayout(new BorderLayout());
        titleCenter.add(loginButton, BorderLayout.EAST);

        //----patientHome-----
        pationGuide = new PationGuide();
        masterPanel.add(pationGuide, BorderLayout.CENTER);

    }

    private void loginActionPerformed() {
        if(null == Session.user) {
            toLogin();
        } else {
            toExit();
        }
    }

    private void toLogin() {
        if (null == logining) {
            logining = new Logining(this);
            frame.getLayeredPane().add(logining, JLayeredPane.POPUP_LAYER);
            Point titleRightPoint = titleRight.getLocation();
            Point loginingPoint = new Point(titleRightPoint.x - logining.getWidth(), titleRightPoint.y + 60);
            logining.setLocation(loginingPoint);
        } else if(logining.isVisible()) {
            logining.setVisible(false);
            logining = null;
        } else {
            logining.setVisible(true);
        }
    }

    private void toExit() {
        if (null == logined) {
            logined = new Logined(this);
            frame.getLayeredPane().add(logined, JLayeredPane.POPUP_LAYER);
            Point titleRightPoint = titleRight.getLocation();
            Point loginingPoint = new Point(titleRightPoint.x - logined.getWidth(), titleRightPoint.y + 60);
            logined.setLocation(loginingPoint);
        } else if(logined.isVisible()) {
            logined.setVisible(false);
            logined = null;
        } else {
            logined.setVisible(true);
        }
    }

    public BeautifulButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(BeautifulButton loginButton) {
        this.loginButton = loginButton;
    }

    public JPanel getMasterPanel() {
        return masterPanel;
    }

    public void setMasterPanel(JPanel masterPanel) {
        this.masterPanel = masterPanel;
    }
}
