package com.ui.patient;
import com.utils.JDBCUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
/**
 * @author ddd zhaung 主窗体函数，用于实现主要功能的操作界面
 */
//比如 你在这改了代码 保存下 然后 打开github的那个
public class PatientHome extends JPanel {
    int screenWidth,screenHeight;
    static int totalWidth;
    static int totalHeight;
    public static String patientId;

    JPanel PshowImage = new JPanel();//显示推送图片的panel
    JPanel PpatientIfoShowL = new JPanel();//显示病人基本信息的panel
    JPanel PpatientIfoShowR = new JPanel();//显示病人基本信息的panel
    JPanel DoctorRemind = new JPanel();//显示医嘱的panel
    JPanel SelectPatientIfos = new JPanel();//添加查询病例控件的panel
    JPanel PMedRecordInfo = new JPanel();//显示病例的panel

    JLabel SelectClinic = new JLabel("病例查询:");//查询病例按钮
    JTextField TuserID = new JTextField("P201821101");//病例查询ID
    JButton BselectIfo = new JButton(new ImageIcon("Images/search3.png"));
    JButton BClose = new JButton(new ImageIcon("Images/return.png"));//关闭病例查询按钮

    JLabel[] lab = {new JLabel("用户ID",JLabel.CENTER),new JLabel("",JLabel.CENTER),
            new JLabel("用户名",JLabel.CENTER),new JLabel("",JLabel.CENTER),new JLabel("用户性别",JLabel.CENTER),
            new JLabel("",JLabel.CENTER), new JLabel("出生日期",JLabel.CENTER),new JLabel("",JLabel.CENTER),
            new JLabel("身份证号",JLabel.CENTER),new JLabel("",JLabel.CENTER), new JLabel("电话号码",JLabel.CENTER),
            new JLabel("",JLabel.CENTER), new JLabel("家庭住址",JLabel.CENTER),new JLabel("",JLabel.CENTER)};
    JTextArea textArea = new JTextArea();//显示病例的JTextArea
    JScrollPane jScrollPane = new JScrollPane();//病例超出滚动条


    //构造函数
    public PatientHome(String _str) {
        this.patientId = _str;
        initComponents();
        getIfos();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取主显示器屏幕大小即获取PC屏幕尺寸
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        //按屏幕尺寸固定比例设置软件尺寸
        totalWidth = (int) Math.round(screenWidth * 0.7);
        totalHeight = (int) Math.round(screenHeight * 0.9);//round是四舍五入
        /**
         * 添加推送图片
         */
        ShowImagePanel t = new ShowImagePanel();
        PshowImage.setPreferredSize(new Dimension(200, 100));
        PshowImage.add(t, BorderLayout.CENTER);
        this.add(PshowImage, BorderLayout.NORTH);


        SelectPatientIfos.setLayout(null);
        PpatientIfoShowL.setLayout(new GridLayout(18,1,5,5));
        PpatientIfoShowR.setLayout(new GridLayout(18,1,5,5));
        DoctorRemind.setLayout(new GridLayout(18,1,5,5));
        for (int i = 0;i < 13;){
            PpatientIfoShowL.add(lab[i]);
            i = i+2;
        }
        for (int i = 1;i < 14;){
            PpatientIfoShowR.add(lab[i]);
            i = i+2;
        }
        PshowImage.setBackground(Color.cyan);
        PpatientIfoShowL.setBackground(Color.getHSBColor(0,100,240));
        PpatientIfoShowR.setBackground(Color.getHSBColor(0,100,240));
        PMedRecordInfo.setBackground(Color.getHSBColor(0,100,240));
        textArea.setBackground(Color.getHSBColor(0,100,240));
        DoctorRemind.setBackground(Color.lightGray);
        SelectPatientIfos.setBackground(Color.lightGray);
        PshowImage.setBounds(0,0,totalWidth,totalHeight/5);
        PpatientIfoShowL.setBounds(0,(totalHeight/5 ) + 105,(totalWidth/4)/3,(4*totalHeight/5)-2);
        PpatientIfoShowR.setBounds((totalWidth/4)/3 + 2,(totalHeight/5 ) + 105,totalWidth/6 - 2,(4*totalHeight/5)-2);
        //显示医生嘱咐panel
        DoctorRemind.setBounds((totalWidth/4) + 2,(totalHeight/5 ) + 2,(3*totalWidth/4) - 2,(4*totalHeight/5)-2);
        SelectPatientIfos.setBounds(0,(totalHeight/5 ) + 2,totalWidth/4,100);
        //显示病人医嘱panel，要通过查询才会显示
        PMedRecordInfo.setBounds((totalWidth/4) + 2,(totalHeight/5 ) + 2,(3*totalWidth/4) - 2,(4*totalHeight/5)-2);
        jScrollPane.setBounds((totalWidth/4) + 2,(totalHeight/5 ) + 2,(3*totalWidth/4) - 2,(4*totalHeight/5)-2);
        textArea.setBounds((totalWidth/4) + 2,(totalHeight/5 ) + 2,(3*totalWidth/4) - 2,(4*totalHeight/5)-2);
        BClose.setBounds(170,10,50,30);
        TuserID.setBounds(35,50,120,30);
        BselectIfo.setBounds(170,50,50,30);
        SelectClinic.setBounds(35,10,120,30);
        SelectClinic.setFont(new Font("华文新魏",Font.PLAIN, 25));
        textArea.setFont(new Font("华文新魏",Font.PLAIN, 15));
        PMedRecordInfo.setVisible(false);
        SelectPatientIfos.add(BClose);
        SelectPatientIfos.add(SelectClinic);
        SelectPatientIfos.add(TuserID);
        SelectPatientIfos.add(BselectIfo);
        this.add(PMedRecordInfo);
        this.add(SelectPatientIfos);
        this.add(PshowImage);
        this.add(PpatientIfoShowL);
        this.add(PpatientIfoShowR);
        this.add(DoctorRemind);
        //关闭病例查询事件
        BClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PMedRecordInfo.setVisible(false);
                PatientHome.this.repaint();

            }
        });
        //病例查询事件
        BselectIfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText("");
                String patientId1 = TuserID.getText().trim();
                String ChiefComplaints0 = "",MedID0 = "";
                String strSQLa;
                strSQLa = "select * from MedRecordInfo where PatientID = '"+ patientId1 +"'";
                Map<String, Object> maps = new HashMap<>();
                try {
                    maps = JDBCUtils.findSimpleResult(strSQLa, null);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                MedID0 = maps.get("PatientID".toUpperCase()).toString();
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
                jScrollPane.add(textArea);
                PMedRecordInfo.add(textArea);
                jScrollPane.setViewportView(PMedRecordInfo);
                PatientHome.this.add(jScrollPane);

                PMedRecordInfo.setVisible(true);
                if (!TuserID.getText().trim().equals(MedID0)){
                    //若用户IP输入是否正确，提示
                    JOptionPane.showConfirmDialog(null,"用户ID输入有误！！！","信息",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (TuserID.getText().trim().equals("")){
                    //若用户IP输入是否为空，提示
                    JOptionPane.showConfirmDialog(null,"用户ID不能为空！！！","信息",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        });
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
     * 查询病人基本信息方法
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
        lab[13].setText(maps.get("ADDRESS".toUpperCase()).toString());

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
        bookReigserKS.getUserID(patientId);
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
        this.setLayout(null);

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
}