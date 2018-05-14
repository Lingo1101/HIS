package com.ui.guide.search;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

/**
 * 提示框
 */
public class TipBox extends JList<String> {

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
        //##################################################
        //new TipBox(search.textField, new TestStartegy());      //####
        //###################################################
    }

    private JTextField textField;
    private CondicateStrategy strategy;
    private boolean isAdd = false;

    public TipBox(JTextField textField, CondicateStrategy strategy) {
        this.textField = textField;
        this.strategy = strategy;
        this.setFont(textField.getFont());
        this.textField.getDocument().addDocumentListener(new MyDocumentListener());
        this.textField.addKeyListener(new MyKeyListener());
        this.addMouseListener(new MyMouseClickListener());
        this.setFixedCellHeight((int)(this.getFont().getSize()* 1.5));
        this.setVisible(false);
    }

    private Point caculateTipBoxPoint() {
        int x = 0;
        int y = 0;
        Container parent = textField;
        while(parent != textField.getRootPane()) {
            x += parent.getX();
            y += parent.getY();
            parent = parent.getParent();
        }
        y += textField.getHeight();
        return new Point(x, y);

    }

    private void textChanged() {
        if(!isAdd) {
            this.setBounds(new Rectangle(caculateTipBoxPoint(),
                    new Dimension((int)textField.getPreferredSize().getWidth(), 0)));
            textField.getRootPane().getLayeredPane().add(this, JLayeredPane.DRAG_LAYER);
            isAdd = true;
        }
        if(this.textField.isEnabled()) {
            String prefix= this.textField.getText();
            TipBox.this.setVisible(false);
            if(!prefix.isEmpty()) {
                List<String> condicate = this.strategy.matchPrefix(prefix);
                if(!condicate.isEmpty()) {
                    TipBox.this.setListData(new Vector<>(condicate));
                    TipBox.this.setSize(this.getWidth(), this.getFixedCellHeight() * condicate.size());
                    TipBox.this.setVisible(true);
                }

            }
        }
    }

    private  class MyMouseClickListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            String value = TipBox.this.getSelectedValue();
            TipBox.this.textField.setText(value);
            TipBox.this.setVisible(false);
        }
    }

    private class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            int index = TipBox.this.getSelectedIndex();
            switch (keyCode) {
               case KeyEvent.VK_DOWN :
                   if(index < TipBox.this.getLastVisibleIndex()) {
                       TipBox.this.setSelectedIndex(++index);
                   } else if(index == TipBox.this.getLastVisibleIndex()) {
                       TipBox.this.textField.setText(TipBox.this.textField.getText());
                   }
                    break;
               case KeyEvent.VK_UP:
                   if(index > TipBox.this.getFirstVisibleIndex()) {
                       TipBox.this.setSelectedIndex(--index);
                   } else if(index == TipBox.this.getFirstVisibleIndex()) {
                       TipBox.this.textField.setText(TipBox.this.textField.getText());
                   }
                   break;
               case KeyEvent.VK_ENTER:
                   String value = TipBox.this.getSelectedValue();
                   if(value != null) {
                       textField.setText(value);
                       TipBox.this.setVisible(false);
                   }
                   break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class MyDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            TipBox.this.textChanged();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            TipBox.this.textChanged();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            TipBox.this.textChanged();
        }
    }
}
