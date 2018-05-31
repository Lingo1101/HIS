package com.ui.Doctor;

import com.ui.patient.YyTime;
import com.utils.BeautifulFrame;
import com.utils.JDBCUtils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class NewPatient extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private String doctorID;
    private JLabel label;
    private JTextArea textArea;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private  TextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private Vector<String> items;
    private Vector<String> items_1;
    private JComboBox comboBox;
//    private JComboBox comboBox_1;
    private JComboBox comboBox_2;
    private JComboBox comboBox_3;
    private JComboBox comboBox_4;
    private JComboBox comboBox_5;
    private JComboBox comboBox_6;
    private JTable table;


    /**
     * Create the dialog.
     */
    public NewPatient(String doctorID) {
        this.doctorID = doctorID;
        setFont(new Font("Dialog", Font.PLAIN, 20));
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setToolTipText("");
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            label = new JLabel("新增患者信息");
            label.setBounds(49, 5, 723, 42);
            label.setFont(new Font("楷体", Font.PLAIN, 36));
            label.setForeground(Color.RED);
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }
        JLabel hspID = new JLabel("住院号");
        hspID.setBounds(20, 94, 60, 24);
        hspID.setFont(new Font("宋体", Font.PLAIN, 20));
        hspID.setForeground(Color.BLACK);

        textField = new JTextField();
        textField.setBounds(109, 91, 106, 30);
        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        textField.setColumns(10);

        JLabel name = new JLabel("姓名");
        name.setBounds(340, 94, 40, 24);
        name.setFont(new Font("宋体", Font.PLAIN, 20));
        name.setForeground(Color.BLACK);

        textField_1 = new JTextField();
        textField_1.setBounds(395, 91, 106, 30);
        textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_1.setColumns(10);

        JLabel gender = new JLabel("性别");
        gender.setBounds(617, 94, 40, 24);
        gender.setFont(new Font("宋体", Font.PLAIN, 20));
        gender.setForeground(Color.BLACK);

        JLabel depart = new JLabel("所属科室");
        depart.setBounds(20, 139, 80, 24);
        depart.setFont(new Font("宋体", Font.PLAIN, 20));
        depart.setForeground(Color.BLACK);

        JLabel doctor = new JLabel("主治");
        doctor.setBounds(340, 139, 40, 24);
        doctor.setFont(new Font("宋体", Font.PLAIN, 20));
        doctor.setForeground(Color.BLACK);

        JLabel bedID = new JLabel("床号");
        bedID.setBounds(617, 184, 40, 24);
        bedID.setFont(new Font("宋体", Font.PLAIN, 20));
        bedID.setForeground(Color.BLACK);

        textField_4 = new JTextField();
        textField_4.setBounds(672, 181, 106, 30);
        textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_4.setColumns(10);

        getComDepartName();
        comboBox = new JComboBox(items);
        comboBox.setBounds(109, 136, 112, 30);
        comboBox.setFont(new Font("宋体", Font.PLAIN, 20));

        textField_6 = new JTextField(getComDoctorName());
        textField_6.setBounds(395, 136, 106, 30);
        textField_6.setFont(new Font("宋体", Font.PLAIN, 20));
        contentPanel.add(textField_6);

        JLabel label_5 = new JLabel("出生日期");
        label_5.setBounds(20, 184, 80, 24);
        label_5.setFont(new Font("宋体", Font.PLAIN, 20));

        Date d1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d1);
        comboBox_2 = new JComboBox();
        comboBox_2.setBounds(106, 226, 225, 30);
        comboBox_2.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_2.setModel(new DefaultComboBoxModel(
                new String[] { dateNowStr }));

        JLabel lblNewLabel = new JLabel("入院时间");
        lblNewLabel.setBounds(20, 229, 80, 24);
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel.setForeground(Color.BLACK);

        JLabel label_6 = new JLabel("年龄");
        label_6.setBounds(389, 184, 40, 24);
        label_6.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel label_7 = new JLabel("岁");
        label_7.setBounds(505, 184, 20, 24);
        label_7.setFont(new Font("宋体", Font.PLAIN, 20));

        table = new JTable();
        table.setBounds(790, 281, 0, 0);

        textField_3 = new TextField();
        textField_3.setBounds(106, 181, 194, 32);
        textField_3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new YyTime(textField_3);
            }
        });

        textField_3.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String age = String.valueOf(2017 - Integer.parseInt(textField_3
                        .getText().substring(0, 4)));
                textField_2.setText(age);
            }
        });
        textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_3.setText("1990-1-1");
        textField_3.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(444, 181, 55, 30);
        textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_2.setColumns(10);

        comboBox_3 = new JComboBox();
        comboBox_3.setBounds(675, 91, 106, 30);
        comboBox_3.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_3
                .setModel(new DefaultComboBoxModel(new String[] { "男", "女" }));

        JLabel label_2 = new JLabel("\u7535\u8BDD\u53F7\u7801");
        label_2.setBounds(389, 229, 80, 24);
        label_2.setFont(new Font("宋体", Font.PLAIN, 20));

        textField_7 = new JTextField();
        textField_7.setBounds(475, 226, 222, 30);
        textField_7.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_7.setColumns(10);

        JLabel label_3 = new JLabel("入院诊断");
        label_3.setBounds(20, 278, 80, 24);
        label_3.setFont(new Font("宋体", Font.PLAIN, 20));

        comboBox_4 = new JComboBox();
        comboBox_4.setBounds(106, 275, 425, 30);
        comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "风热感冒",
                "骨折", "口腔溃疡" }));
        comboBox_4.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel label_4 = new JLabel("病区");
        label_4.setBounds(558, 278, 40, 24);
        label_4.setFont(new Font("宋体", Font.PLAIN, 20));

        comboBox_5 = new JComboBox();
        comboBox_5.setBounds(604, 275, 177, 30);
        comboBox_5.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "内科病区" }));

        JLabel label_10 = new JLabel("\u75C5\u4EBA\u53F7");
        label_10.setBounds(20, 323, 80, 24);
        label_10.setFont(new Font("宋体", Font.PLAIN, 20));
        label_10.setHorizontalAlignment(SwingConstants.TRAILING);

        textField_8 = new JTextField();
        textField_8.setBounds(106, 320, 158, 30);
        textField_8.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_8.setColumns(10);

        JLabel label_11 = new JLabel("身份证");
        label_11.setBounds(340, 323, 60, 24);
        label_11.setFont(new Font("宋体", Font.PLAIN, 20));

        textField_9 = new JTextField();
        textField_9.setBounds(406, 320, 351, 30);
        textField_9.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_9.setColumns(10);

        JLabel label_30 = new JLabel("入院情况");
        label_30.setBounds(20, 56, 109, 26);
        label_30.setFont(new Font("宋体", Font.PLAIN, 22));
        contentPanel.setLayout(null);
        contentPanel.add(label_5);
        contentPanel.add(depart);
        contentPanel.add(hspID);
        contentPanel.add(lblNewLabel);
        contentPanel.add(textField);
        contentPanel.add(comboBox);
        contentPanel.add(textField_3);
        contentPanel.add(comboBox_2);
        contentPanel.add(name);
        contentPanel.add(doctor);
        contentPanel.add(textField_1);
        contentPanel.add(label_6);
        contentPanel.add(textField_2);
        contentPanel.add(label_7);
        contentPanel.add(bedID);
        contentPanel.add(textField_4);
        contentPanel.add(gender);
        contentPanel.add(comboBox_3);
        contentPanel.add(label_2);
        contentPanel.add(textField_7);
        contentPanel.add(label_10);
        contentPanel.add(label_3);
        contentPanel.add(comboBox_4);
        contentPanel.add(label_4);
        contentPanel.add(comboBox_5);
        contentPanel.add(textField_8);
        contentPanel.add(label_11);
        contentPanel.add(textField_9);
        contentPanel.add(table);
        contentPanel.add(label);
        contentPanel.add(label_30);

        JLabel address = new JLabel("地址");
        address.setHorizontalAlignment(SwingConstants.TRAILING);
        address.setFont(new Font("宋体", Font.PLAIN, 20));
        address.setBounds(20, 375, 80, 24);
        contentPanel.add(address);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("宋体", Font.PLAIN, 20));
        textField_5.setColumns(10);
        textField_5.setBounds(106, 372, 651, 30);
        contentPanel.add(textField_5);

        JLabel nurse = new JLabel("护士");
        nurse.setForeground(Color.BLACK);
        nurse.setFont(new Font("宋体", Font.PLAIN, 20));
        nurse.setBounds(617, 139, 40, 24);
        contentPanel.add(nurse);

        getComNurseName();
        comboBox_6 = new JComboBox(items_1);
        comboBox_6.setFont(new Font("宋体", Font.PLAIN, 20));
        comboBox_6.setBounds(672, 136, 111, 30);
        contentPanel.add(comboBox_6);

        JLabel label_9 = new JLabel("诊断原因：");
        label_9.setFont(new Font("宋体", Font.PLAIN, 20));
        label_9.setBounds(19, 432, 110, 21);
        contentPanel.add(label_9);

        textArea = new JTextArea();
        textArea.setBounds(20, 468, 769, 176);
        contentPanel.add(textArea);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("保存");
                okButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        savePatient();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("退出");
                cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }

        this.setResizable(false);
        int totalWidth = BeautifulFrame.frameWidth*2/3;
        int totalHeight = BeautifulFrame.frameHeight*4/5;
        this.setSize(totalWidth, totalHeight);
        this.setLocationRelativeTo(this.getOwner());
        this.setVisible(true);
    }

    /**
     * 保存病人记录
     */
    private void savePatient() {
        // 完整性检查
        if (check() == false) {
            JOptionPane.showMessageDialog(null, "请输入所有的项目");
            return;
        }

        String pID = this.getPatientID();
        String pName = this.getPName();
        String gender = this.getGender();
        String birthday = this.getBirthday();
        String iDNumber = this.getIDNumber();
        String phoneNumber = this.getTel();
        String address = this.getAddress();

        String hspId = this.getHspID();
        String departID = this.getDepartName();
        String doctorID = this.getDoctorName();
        String nurseID = this.getNurseName();
        String bedID = this.getBedId();
        String inHspTime = this.getInHspTime();
        String admissionReason = this.getDiagnosis();

        String strSQL1 = "insert into PatientInfo(PatientID,PatientName,GENDER,BIRTHDAY,IDNumber,PhoneNumber,Address) " +
                "values('" + pID + "','" + pName + "','" + gender + "','" + birthday
                + "','" + iDNumber + "','" + phoneNumber + "','" + address + "')";
        String strSQL2 = "insert into InpatientInfo(HspID,PatientID,DepartID,DoctorID,NurseID,BedID,InHspTimes,AdmissionReason) " +
                "values('" + hspId + "','" + pName + "','" + departID + "','" + doctorID
                + "','" + nurseID + "','" + bedID + "','" + inHspTime + "','" + admissionReason + "')";
        try {
            System.out.println(strSQL1);

            JDBCUtils.updateByPreparedStatement(strSQL2, null);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "检查是否连接数据库");
            return;
        }
        JOptionPane.showMessageDialog(null, "添加成功！");
    }

    /**
     * 检查所有需要填入的项是否已经填满
     *
     * @return boolean
     */
    private boolean check() {
        if (this.textField.getText().trim().equals("")
                || this.textField_1.getText().trim().equals("")
                || this.textField_5.getText().trim().equals("")
                || this.textField_6.getText().trim().equals("")
                || this.textField_7.getText().trim().equals("")
                || this.textField_8.getText().trim().equals("")
                || this.textField_9.getText().trim().equals("")
                || ((String) this.comboBox_3.getSelectedItem()).trim().equals("")
                || ((String) this.comboBox.getSelectedItem()).trim().equals("")
                || ((String) this.comboBox_2.getSelectedItem()).trim().equals("")
                || ((String) this.comboBox_4.getSelectedItem()).trim().equals("")
                || ((String) this.comboBox_5.getSelectedItem()).trim().equals("")
                || ((String) this.comboBox_6.getSelectedItem()).trim().equals("")
                || this.textField_4.getText().trim().equals("")
                || this.textField_3.getText().trim().equals("")
                || this.textArea.getText().trim().equals(""))
            return false;
        else
            return true;
    }

    /*******************************************************
    得到输入的各项值
     ******************************************************/
    private String getHspID() {
        return this.textField.getText().trim();
    }

    private String getPName() {
        return this.textField_1.getText().trim();
    }

    private String getBirthday() {
        String birthday = this.textField_3.getText().trim();
        Calendar cal = Calendar.getInstance();
        int nowYear = cal.get(Calendar.YEAR);
        return birthday;
    }

    private String getBedId() {
        return this.textField_4.getText().trim();
    }

    private String getAddress() {
        return this.textField_5.getText().trim();
    }

    private String getDoctorName() {
        return this.textField_6.getText().trim();
    }

    private String getTel() {
        return this.textField_7.getText().trim();
    }

    private String getPatientID() {
        return this.textField_8.getText().trim();
    }

    private String getIDNumber() {
        return this.textField_9.getText().trim();
    }

    private String getDepartName() {
        return (String) comboBox.getSelectedItem();
    }

    private String getInHspTime() {
        return (String) comboBox_2.getSelectedItem();
    }

    private String getGender() {
        return (String) comboBox_3.getSelectedItem();
    }

    private String getInDiagnosis() {
        return (String) comboBox_4.getSelectedItem();
    }

    private String getWard() {
        return (String) comboBox_5.getSelectedItem();
    }

    private String getNurseName() {
        return (String) comboBox_6.getSelectedItem();
    }

    private String getDiagnosis() {
        return this.textArea.getText().trim();
    }


    /******************************************************
    设置从数据中取到的各项值
     *****************************************************/
    public void setIDEditEnable(boolean b) {
        this.textField.setEnabled(b);
    }

    public void setHspID(String id) {
        this.textField.setText(id);
    }

    public void setHspName(String name) {
        this.textField_1.setText(name);
    }

    public void setGender(String gender) {
        this.comboBox_3.setSelectedItem(gender);
    }

    public void setDoctorName(String doctorname) {
        this.comboBox.setSelectedItem(doctorname);
    }

    public void setBedId(String bedID) {
        this.textField_4.setText(bedID);
    }

    public void setBirthday(String birthday) {
        this.textField_3.setText(birthday);
    }

    public void getComDepartName() {
        items = new Vector<String>();
        String strSQL3 = "SELECT * FROM DepartInfo where PostID like '%postt%';";
        List<Map<String, Object>> lists = new ArrayList<>();
        try {
            lists = JDBCUtils.findModeResult(strSQL3, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Map<String, Object> maps : lists) {
            items.add(maps.get("DEPARTID".toUpperCase()).toString());
        }

    }

    public String getComDoctorName() {
        String strSQL4 = "SELECT EmployeeName FROM EmployeeInfo where EmployeeID = '" + doctorID + "'";
        Map<String, Object> maps = new HashMap<>();

        try {
            maps = JDBCUtils.findSimpleResult(strSQL4, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps.get("EmployeeName".toUpperCase()).toString();
    }

    public void getComNurseName() {
        items_1 = new Vector<String>();
        String strSQL4 = "SELECT * FROM EmployeeInfo where EmployeeID like '%N%';";

        List<Map<String, Object>> lists = new ArrayList<>();
        try {
            lists = JDBCUtils.findModeResult(strSQL4, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Map<String, Object> maps : lists) {
            items_1.add(maps.get("EmployeeID".toUpperCase()).toString());
        }
    }
}

