package com.ui.patient;
import com.utils.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.util.List;

/**
 * @author ddd zhaung 主窗体函数，用于实现主要功能的操作界面
 */
public class PatientHome extends JPanel {

    public static void main(String[] args) {
        String s = "xx省xx市xx区xx街道xx号";
        Pattern p = Pattern.compile("区.*");
        Matcher m = p.matcher(s);
        if(m.find()) {
            String s1 = m.group().substring(1);
            System.out.println(s1);
        }
    }

    public PatientHome(String _str) {
        this.patientId = _str;
        initComponents();
        getIfos();
        patientCases();
        showImage();
        advicePanel();
        downLeftDownL.setLayout(new GridLayout(10,1,5,5));
        downLeftDownR.setLayout(new GridLayout(10,1,5,5));
        for (int i = 0;i < 13;){
            downLeftDownL.add(lab[i]);
            i = i+2;
        }
        for (int i = 1;i < 14;){
            downLeftDownR.add(lab[i]);
            i = i+2;
        }
        for(JLabel jLabel : lab) {
            jLabel.setFont(new Font("华文新魏",Font.PLAIN, 18));

        }

        map = new HashMap<>();
        map.put(patientId, advicePanel);
        canNotify = new AlonePatientMonitor(patientId, map);
        new Thread(() -> {
            while(map.size() != 0) {
                canNotify.excute();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void showImage() {
        ShowImagePanel t = new ShowImagePanel();
        PshowImage.setPreferredSize(new Dimension(0, BeautifulFrame.frameHeight/5));
        PshowImage.add(t, BorderLayout.CENTER);
        this.add(PshowImage, BorderLayout.NORTH);
        PshowImage.setBackground(Color.cyan);
    }

    /**
     * 病人病例信息
     */
    private void patientCases() { ;
        String patientId1 = patientId;
        String strSQLa;
        strSQLa = "select * from MedRecordInfo where PatientID = '"+ patientId1 +"'";
        Map<String, Object> maps = new HashMap<>();
        try {
            maps = JDBCUtils.findSimpleResult(strSQLa, null);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        textArea.append("病人ID    ：" + maps.get( "PatientID".toUpperCase()) + "\n");
        textArea.append("主诉        ：" + maps.get("ChiefComplaints".toUpperCase()) + "\n");
        textArea.append("现病史    ：" + maps.get("PresentIllness".toUpperCase()) + "\n");
        textArea.append("既往史    ：" + maps.get("PastHistory".toUpperCase()) + "\n");
        textArea.append("婚育史    ：" + maps.get("MarriageHistory".toUpperCase()) + "\n");
        textArea.append("月经史    ：" + maps.get("MenstrualHistory".toUpperCase()) + "\n");
        textArea.append("家族史    ：" + maps.get("FamilyHistory".toUpperCase()) + "\n");
        textArea.append("体格检查：" + maps.get("PhysicalExamination".toUpperCase()) + "\n");
        textArea.append("专科检查：" + maps.get("SpecialistInspection".toUpperCase()) + "\n");
        textArea.append("辅助检查：" + maps.get("AuxiliaryInspection".toUpperCase()) + "\n");
        textArea.append("鉴别诊断：" + maps.get("DifferentialDiagnosis".toUpperCase()) + "\n");
        textArea.append("辅助诊断：" + maps.get("InitialDiagnosis".toUpperCase()) + "\n");
        textArea.append("初步诊断：" + maps.get("AssessmentPlan".toUpperCase()) + "\n");
        textArea.append("诊断计划：" + maps.get("DoctorsAdviceID".toUpperCase()) + "\n");
        textArea.setLineWrap(true);
        textArea.setBackground(Color.getHSBColor(0,100,240));
        textArea.setFont(new Font("华文新魏",Font.PLAIN, 20));
        downRight.add(textArea, BorderLayout.CENTER);
        jScrollPane.setViewportView(textArea);
        downRight.add(jScrollPane, BorderLayout.CENTER);
    }
    //专家事件
    private void ProfessorMouseClicked(MouseEvent e) {
        new Professor();
    }
    //科室事件
    private void DepartmentGuideMouseClicked(MouseEvent e) {
        new Department();
    }

    /**
     * 病人基本信息方法
     */
    public void getIfos(){
        if(null == patientId) {
            return;
        }
        String strSQL;
        Map<String, Object> maps = new HashMap<>();
        strSQL = "select * from PatientInfo where PatientID = '"+ patientId +"'";
        try {
            maps = JDBCUtils.findSimpleResult(strSQL, null);
            if(0 == maps.size()) {
                return;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        lab[1].setText(maps.get("PATIENTID".toUpperCase()).toString());
        lab[3].setText(maps.get("PATIENTNAME".toUpperCase()).toString());
        lab[5].setText(maps.get("GENDER".toUpperCase()).toString());
        lab[7].setText(maps.get("BIRTHDAY".toUpperCase()).toString());
        lab[9].setText(maps.get("IDNUMBER".toUpperCase()).toString());
        lab[11].setText(maps.get("PHONENUMBER".toUpperCase()).toString());
        String adress = maps.get("ADDRESS".toUpperCase()).toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        Pattern pattern = Pattern.compile(".*区");
        Matcher matcher = pattern.matcher(adress);
        if(matcher.find()) {
            stringBuffer.append(matcher.group());
        }
        stringBuffer.append("<br>");

        Pattern p = Pattern.compile("区.*");
        Matcher m = p.matcher(adress);
        if(m.find()) {
            String s1 = m.group().substring(1);
            stringBuffer.append(s1);
        }
        stringBuffer.append("<br>");
        stringBuffer.append("</html>");
        lab[13].setText(stringBuffer.toString());

    }

    private void advicePanel() {
        String sql = "select * from DoctorsAdviceInfo where PatientID=?";
        List params = new ArrayList();
        params.add(patientId);
        Map<String, Object> map = new HashMap<>();
        try {
            map = JDBCUtils.findSimpleResult(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<h2 align='center'>");
        stringBuffer.append(map.get("MedicalContent".toUpperCase()).toString());
        stringBuffer.append("<hr>");
        stringBuffer.append(map.get("EffectiveTime".toUpperCase()).toString());
        stringBuffer.append("<h2>");
        advicePanel.setText(stringBuffer.toString());
        advicePanel.setBackground(AdviceUtils.getMyColor(patientId));
    }

    //内科事件
    private void menu1MouseClicked(MouseEvent e) {
        DepartClassify departClassify = new DepartClassify();
        String Dbutton = "内科";
        String label = "科室简介";
        String[] Ksjj = {"心血管内科简介","肾病内科简介","内分泌科简介","消化内科简介","神经内科简介","心呼吸内科简介"};
        String[] Xbutton = {"心血管内科","肾病内科","内分泌科","消化内科","神经内科","心呼吸内科"};
        String[] Id = {"K201821107","K201821201","K201821202"};
        int s = 6;
        departClassify.getDbutton(Dbutton);
        departClassify.getlabel(label);
        departClassify.gets(s);
        departClassify.getName(Xbutton);
        departClassify.getid(Id);
        departClassify.getKSJJ(Ksjj);
    }
    //外科事件
    private void SurgicalMouseClicked(MouseEvent e) {
        DepartClassify departClassify = new DepartClassify();
        String Dbutton = "外科";
        String label = "科室简介";
        String[] Ksjj = {"普通外科简介","心胸外科简介","神经外科简介","骨科简介","放射性治疗简介","泌尿外科简介"};
        String[] Xbutton = {"普通外科","心胸外科","神经外科","骨科","放射性治疗","泌尿外科"};
        String[] Id = {"K201821211","K201821212","K201821213"};
        int s = 6;
        departClassify.getDbutton(Dbutton);
        departClassify.getlabel(label);
        departClassify.gets(s);
        departClassify.getName(Xbutton);
        departClassify.getid(Id);
        departClassify.getKSJJ(Ksjj);
    }
    //专科事件
    private void SpecialistMouseClicked(MouseEvent e) {
        DepartClassify departClassify = new DepartClassify();
        String Dbutton = "专科";
        String label = "科室简介";
        String[] Ksjj = {"儿科简介","眼科简介","中西结合科简介","耳鼻喉科简介","口腔科简介","皮肤科简介",
                "空勤科简介","感染内科简介","麻醉科简介","干部病房一科简介"};
        String[] Xbutton = {"儿科","眼科","中西结合科","耳鼻喉科","口腔科","皮肤科","空勤科","感染内科","麻醉科","干部病房一科"};
        String[] Id = {"K201821217","K201821218","K201821219"};
        int s = 10;
        departClassify.gets(s);
        departClassify.getName(Xbutton);
        departClassify.getDbutton(Dbutton);
        departClassify.getlabel(label);
        departClassify.getid(Id);
        departClassify.getKSJJ(Ksjj);
    }
    //医技事件
    private void MedicalMouseClicked(MouseEvent e) {
        DepartClassify departClassify = new DepartClassify();
        String Dbutton = "医技";
        String label = "科室简介";
        String[] Ksjj = {"门诊科简介","急诊科简介","保健科简介","体检中心简介","临床药理科简介","医学工程科简介"};
        String[] Xbutton = {"门诊科","急诊科","保健科","体检中心","临床药理科","医学工程科"};
        String[] Id = {"K201821228","K201821229","K201821230"};
        int s = 6;
        departClassify.getDbutton(Dbutton);
        departClassify.getlabel(label);
        departClassify.gets(s);
        departClassify.getName(Xbutton);
        departClassify.getid(Id);
        departClassify.getKSJJ(Ksjj);
    }
    // 医疗保健
    private void HealthCareMouseClicked(MouseEvent e) {
        new HealthCareA();
    }
    //科室预约
    private void BookReigserMouseClicked(MouseEvent e) {
        BookReigserKS bookReigserKS =new BookReigserKS();
        bookReigserKS.getUserID();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        HomePage = new JMenu();
        MedicalGuide = new JMenu();
        menuItem1 = new JMenuItem();
        DepartmentGuide = new JMenu();
        Internalt = new JMenu();
        Surgical = new JMenu();
        Specialist = new JMenu();
        Medical = new JMenu();
        HealthCare = new JMenu();
        MentalHeath = new JMenuItem();
        PreHealth = new JMenuItem();
        VommonSense = new JMenuItem();
        Professor = new JMenu();
        InternaltPhy = new JMenuItem();
        SurgicalPhy = new JMenuItem();
        SpecialistPhy = new JMenuItem();
        MedicalPhy = new JMenuItem();
        WordSelect = new JMenu();
        BookReigser = new JMenu();

        //======== this ========
        this.setLayout(new BorderLayout());
        Color myColor = Color.getHSBColor(0,100,240);

        //========downPanel==============
        downpanel = new JPanel();
        this.add(downpanel, BorderLayout.CENTER);
        downpanel.setLayout(new BorderLayout());

        //========downLeft==============
        downLeft = new JPanel();
        downpanel.add(downLeft, BorderLayout.WEST);
        downLeft.setPreferredSize(new Dimension(BeautifulFrame.frameWidth/4, 0));
        downLeft.setLayout(new BorderLayout());

        //========downRight==============
        downRight = new JPanel();
        downpanel.add(downRight, BorderLayout.CENTER);
        downRight.setLayout(new BorderLayout());

        //========advicePanel==============
        advicePanel = new JTextPane();
        advicePanel.setPreferredSize(new Dimension(0, BeautifulFrame.frameHeight/5));
        advicePanel.setEditable(false);
        advicePanel.setContentType("text/html");
        downLeft.add(advicePanel, BorderLayout.NORTH);

        //========downLeftDown==============
        downLeftDown = new JPanel();
        downLeft.add(downLeftDown, BorderLayout.CENTER);
        downLeftDown.setLayout(new BorderLayout());

        //========downLeftDownL==============
        downLeftDownL = new JPanel();
        downLeftDownL.setBackground(myColor);
        downLeftDownL.setPreferredSize(new Dimension(BeautifulFrame.frameWidth/12, 0));
        downLeftDown.add(downLeftDownL, BorderLayout.WEST);

        //========downLeftDownR==============
        downLeftDownR = new JPanel();
        downLeftDownR.setBackground(myColor);
        downLeftDown.add(downLeftDownR, BorderLayout.CENTER);


        //======== menuBar1 ========
        {
            menuBar1.setBackground(new Color(204, 204, 255));

            //======== MedicalGuide ========
            {
                MedicalGuide.setText("\u5c31\u533b\u6307\u5357");
                MedicalGuide.setFont(new Font("宋体", Font.PLAIN, 20));

                //---- menuItem1 ----
                menuItem1.setText("\u5c31\u8bca\u987b\u77e5");
                menuItem1.setFont(new Font("宋体", Font.PLAIN, 20));
                MedicalGuide.add(menuItem1);
            }
            menuBar1.add(MedicalGuide);

            //======== DepartmentGuide ========
            {
                DepartmentGuide.setText("\u79d1\u5ba4\u5bfc\u822a");
                DepartmentGuide.setFont(new Font("宋体", Font.PLAIN, 20));
                DepartmentGuide.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DepartmentGuideMouseClicked(e);
                    }
                });

                //======== Internalt ========
                {
                    Internalt.setText("\u5185\u79d1");
                    Internalt.setFont(new Font("宋体", Font.PLAIN, 20));
                    Internalt.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            menu1MouseClicked(e);
                        }
                    });
                }
                DepartmentGuide.add(Internalt);

                //======== Surgical ========
                {
                    Surgical.setText("\u5916\u79d1");
                    Surgical.setFont(new Font("宋体", Font.PLAIN, 20));
                    Surgical.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            SurgicalMouseClicked(e);
                        }
                    });
                }
                DepartmentGuide.add(Surgical);

                //======== Specialist ========
                {
                    Specialist.setText("\u4e13\u79d1");
                    Specialist.setFont(new Font("宋体", Font.PLAIN, 20));
                    Specialist.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            SpecialistMouseClicked(e);
                        }
                    });
                }
                DepartmentGuide.add(Specialist);

                //======== Medical ========
                {
                    Medical.setText("医技");
                    Medical.setFont(new Font("宋体", Font.PLAIN, 20));
                    Medical.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            MedicalMouseClicked(e);
                        }
                    });
                }
                DepartmentGuide.add(Medical);
            }
            menuBar1.add(DepartmentGuide);

            //======== HealthCare ========
            {
                HealthCare.setText("医疗保健");
                HealthCare.setFont(new Font("宋体", Font.PLAIN, 20));
                HealthCare.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        HealthCareMouseClicked(e);
                    }
                });

                //---- MentalHeath ----
                MentalHeath.setText("心理健康");
                MentalHeath.setFont(new Font("宋体", Font.PLAIN, 20));
                HealthCare.add(MentalHeath);

                //---- PreHealth ----
                PreHealth.setText("预防保健");
                PreHealth.setFont(new Font("宋体", Font.PLAIN, 20));
                HealthCare.add(PreHealth);

                //---- VommonSense ----
                VommonSense.setText("急救常识");
                VommonSense.setFont(new Font("宋体", Font.PLAIN, 20));
                HealthCare.add(VommonSense);
            }
            menuBar1.add(HealthCare);

            //======== Professor ========
            {
                Professor.setText("专家荟萃");
                Professor.setFont(new Font("宋体", Font.PLAIN, 20));
                Professor.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ProfessorMouseClicked(e);
                    }
                });

                //---- InternaltPhy ----
                InternaltPhy.setText("内科专家");
                InternaltPhy.setFont(new Font("宋体", Font.PLAIN, 20));
                Professor.add(InternaltPhy);

                //---- SurgicalPhy ----
                SurgicalPhy.setText("外科专家");
                SurgicalPhy.setFont(new Font("宋体", Font.PLAIN, 20));
                Professor.add(SurgicalPhy);

                //---- SpecialistPhy ----
                SpecialistPhy.setText("专科专家");
                SpecialistPhy.setFont(new Font("宋体", Font.PLAIN, 20));
                Professor.add(SpecialistPhy);

                //---- MedicalPhy ----
                MedicalPhy.setText("医技专家");
                MedicalPhy.setFont(new Font("宋体", Font.PLAIN, 20));
                Professor.add(MedicalPhy);

            }
            menuBar1.add(Professor);

            //======== WordSelect ========
            {
                WordSelect.setText("业务查询");
                WordSelect.setFont(new Font("宋体", Font.PLAIN, 20));
            }
            menuBar1.add(WordSelect);

            //======== BookReigser ========
            {
                BookReigser.setText("预约挂号");
                BookReigser.setFont(new Font("宋体", Font.PLAIN, 20));
                BookReigser.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        BookReigserMouseClicked(e);
                    }
                });
            }
            menuBar1.add(BookReigser);
        }
        PshowImage.setLayout(new BorderLayout());
        menuBar1.setPreferredSize(new Dimension(0, 30));
        this.PshowImage.add(menuBar1, BorderLayout.NORTH);

    }

    private JMenuBar menuBar1;
    private JMenu HomePage;
    private JMenu MedicalGuide;
    private JMenuItem menuItem1;
    private JMenu DepartmentGuide;
    private JMenu Internalt;
    private JMenu Surgical;
    private JMenu Specialist;
    private JMenu Medical;
    private JMenu HealthCare;
    private JMenuItem MentalHeath;
    private JMenuItem PreHealth;
    private JMenuItem VommonSense;
    private JMenu Professor;
    private JMenuItem InternaltPhy;
    private JMenuItem SurgicalPhy;
    private JMenuItem SpecialistPhy;
    private JMenuItem MedicalPhy;
    private JMenu WordSelect;
    private JMenu BookReigser;
    public static String patientId;
    JPanel PshowImage = new JPanel();//显示推送图片的panel
    JLabel[] lab = {new JLabel("用户ID",JLabel.CENTER),new JLabel("",JLabel.CENTER),
            new JLabel("用户名",JLabel.CENTER),new JLabel("",JLabel.CENTER),new JLabel("用户性别",JLabel.CENTER),
            new JLabel("",JLabel.CENTER), new JLabel("出生日期",JLabel.CENTER),new JLabel("",JLabel.CENTER),
            new JLabel("身份证号",JLabel.CENTER),new JLabel("",JLabel.CENTER), new JLabel("电话号码",JLabel.CENTER),
            new JLabel("",JLabel.CENTER), new JLabel("家庭住址",JLabel.CENTER),new JLabel("",JLabel.CENTER)};
    JTextArea textArea = new JTextArea();//显示病例的JTextArea
    JScrollPane jScrollPane = new JScrollPane();//病例超出滚动条
    private JPanel downpanel;
    private JPanel downLeft;
    private JPanel downRight;
    private JTextPane advicePanel;
    private JPanel downLeftDown;
    private JPanel downLeftDownL;
    private JPanel downLeftDownR;
    private CanNotify canNotify;
    private Map<String, JTextPane> map;
}