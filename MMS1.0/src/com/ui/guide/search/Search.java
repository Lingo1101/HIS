package com.ui.guide.search;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 搜索栏
 */
public class Search extends JPanel{
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //===================使用用例========================
        Search selectField = new Search();
        //==================================================
        jFrame.setSize(1000, 600);
        jFrame.getContentPane().setLayout(new FlowLayout());
        jFrame.getContentPane().add(selectField);
        jFrame.setLocationRelativeTo(jFrame.getOwner());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        //===================================================
        jFrame.getContentPane().requestFocus();

    }

    public Search() {
        this.setPreferredSize(selectSize);
        this.choiceButton.setPreferredSize(new Dimension(selectSize.height,selectSize.height));
        this.textField.setPreferredSize(new Dimension(selectSize.width-selectSize.height*2,selectSize.height));
        this.searchButton.setPreferredSize(new Dimension(selectSize.height, selectSize.height));
        this.setLayout(new BorderLayout());
        this.add(textField, BorderLayout.WEST);
        this.add(searchButton, BorderLayout.CENTER);
        this.add(choiceButton, BorderLayout.EAST);
        this.textField.getDocument().addDocumentListener(new MyDocumentListener());
        //============================================================
        new TipBox(this.textField, new PatientStartegy());
        new ChooseBox(this);
    }

    private class MyPanel extends JPanel {

        ImageIcon imageIcon1 = new ImageIcon("img/下拉正常.jpg" );
        ImageIcon imageIcon2 = new ImageIcon("img/下拉激活.png");
        private boolean enter = false;

        public MyPanel() {
            super();
            this.setFont(new Font("华文新魏", Font.PLAIN, selectSize.height/2));
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    enter = false;
                    Search.this.choiceButton.repaint();
                }
            });
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    MyPanel.this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    enter = true;
                    Search.this.choiceButton.repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            if(enter) {
                g.drawImage(imageIcon2.getImage(), 0, 0, this.getSize().height, this.getSize().height, this);
            } else {
                g.drawImage(imageIcon1.getImage(), 0, 0, this.getSize().height, this.getSize().height, this);
            }
        }
    }


    private class MyButton extends JButton implements MouseListener{
        ImageIcon imageIcon1 = new ImageIcon("img/搜索正常.jpg");
        ImageIcon imageIcon2 = new ImageIcon("img/搜索激活.jpg");
        Image offScreenImage = null;
        private boolean enter = false;

        public MyButton() {
            super();
            this.setBackground(Color.white);
            Dimension size = this.getPreferredSize();
            size.width = size.height = selectSize.height;
            this.setPreferredSize(size);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            this.addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (enter) {
                g.drawImage(imageIcon2.getImage(), 0, 0, this.getSize().height, this.getSize().height, this);
            } else {
                g.drawImage(imageIcon1.getImage(), 0, 0, this.getSize().height, this.getSize().height, this);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            enter = true;
            Search.this.searchButton.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            enter = false;
            Search.this.searchButton.repaint();
        }
    }


    private class MyTextField extends JTextField {
        public MyTextField() {
            super();
            this.setFont(new Font("华文新魏", Font.PLAIN, selectSize.height/2));
            MatteBorder border = new MatteBorder(0, 0, 0, 0, Color.white);
            setBorder(border);

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Color c = g.getColor();
            g.setColor(Color.lightGray);
            g.drawString(backgroundText, 0, selectSize.height * 2 / 3);
            g.setColor(c);
        }
    }

    private class MyDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {

            Search.this.backgroundText = "";
            Search.this.textField.repaint();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            Search.this.backgroundText = "";
            Search.this.textField.repaint();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            Search.this.backgroundText = "";
            Search.this.textField.repaint();
        }
    }

    Dimension selectSize = new Dimension(800, 50);
    JButton searchButton = new MyButton();
    JPanel choiceButton = new MyPanel();
    JTextField textField = new MyTextField();
    String backgroundText = "查询病人信息";
    String chooseText = "查询病人信息";

}
