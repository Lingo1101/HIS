package com.ui.patient;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HealthyReadTxt002 extends JFrame{
    int screenWidth,screenHeight;
    static int totalWidth;
    static int totalHeight;

    JTextArea textArea = new JTextArea();
    JScrollPane jScrollPane = new JScrollPane();
    JPanel jPanel = new JPanel();

    public HealthyReadTxt002(){
        String filePath = "F:\\texta.txt";
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {//判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                StringBuffer stringBuffer = new StringBuffer();
                while ((lineTxt = bufferedReader.readLine()) != null) {//一行一行的读
                    stringBuffer.append(lineTxt + "\n"  );
                }
                textArea.setFont(new Font("宋体",Font.PLAIN,20));
                textArea.setText(stringBuffer.toString());
                textArea.setLineWrap(true);
                jScrollPane.add(textArea);
                jPanel.add(textArea);
                jScrollPane.setViewportView(jPanel);
                getContentPane().add(jScrollPane);
                read.close();
            }else {
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e){
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取主显示器屏幕大小即获取PC屏幕尺寸
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        //按屏幕尺寸固定比例设置软件尺寸
        totalWidth = (int) Math.round(screenWidth * 0.7);
        totalHeight = (int) Math.round(screenHeight * 0.9);//round是四舍五入
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        jPanel.setBounds(0,0,totalWidth,totalHeight);
        textArea.setBounds(0,0,totalWidth,totalHeight);
        int bottomInset = screenInsets.bottom;
        this.setResizable(false);
        this.setTitle("读取文件内容");
        this.setSize(totalWidth,totalHeight);
        this.setLocation(Math.round((screenWidth - totalWidth) / 2), Math.round((screenHeight - bottomInset - totalHeight) / 2));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//使关闭按钮只关闭当前窗体
        this.setVisible(true);
    }
    public static void main (String[] args){
        HealthyReadTxt001 R = new HealthyReadTxt001();
    }
}
