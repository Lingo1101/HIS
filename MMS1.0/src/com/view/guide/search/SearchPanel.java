package com.view.guide.search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SearchPanel extends JPanel{

    public SearchPanel() {
        this.setPreferredSize(new Dimension(800, 700));
        this.setLayout(new BorderLayout());
        search = new Search();
        textPanel = new TextPanel();
        this.add(textPanel, BorderLayout.SOUTH);
        this.add(search, BorderLayout.NORTH);
        search.searchButton.addActionListener(e -> { doClick(e);});

    }

    private void doClick(ActionEvent e) {
        String table = null;
        if(search.chooseText.equals("查询病人信息")) {
            table = "PATIENTINFO";
        } else if(search.chooseText.equals("查询费用")) {
            table = "COSTSCHEDULE";
        } else {
            table = "DOCTORSADVICEINFO";
        }
        String key = "PATIENTID";
        String value = search.textField.getText();
        new GetInfo(textPanel.getTextPane(), table ,key, value);
    }

    public Search search = null;
    private TextPanel textPanel = null;
}
