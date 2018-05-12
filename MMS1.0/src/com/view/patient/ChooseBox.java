package com.view.patient;

import com.utils.JDBCUtils;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseBox extends JPanel{
    public String departID;
    public String[] kk = new String[4];
    JTextField jTextField = null;
    JScrollPane jScrollPane = new JScrollPane();
    public ChooseBox(BookReigserKS bookReigserKS){
        if(null == bookReigserKS) {
            this.jTextField = new JTextField();
        } else {
            this.jTextField = bookReigserKS.Ksname;
        }
        //查询数据库节点
        String sql = "select * from DepartInfo ";
        try {

            List<Map<String, Object>> modeResult = JDBCUtils.findModeResult(sql, null);
            // 创建没有父节点和子节点、但允许有子节点的树节点，并使用指定的用户对象对它进行初始化。
            // public DefaultMutableTreeNode(Object userObject)
            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("内科");
            node1.add(new DefaultMutableTreeNode(modeResult.get(6).get("DEPARTNAME").toString()));
            node1.add(new DefaultMutableTreeNode(modeResult.get(7).get("DEPARTNAME").toString()));
            node1.add(new DefaultMutableTreeNode(modeResult.get(8).get("DEPARTNAME").toString()));
            node1.add(new DefaultMutableTreeNode(modeResult.get(9).get("DEPARTNAME").toString()));
            node1.add(new DefaultMutableTreeNode(modeResult.get(10).get("DEPARTNAME").toString()));
            node1.add(new DefaultMutableTreeNode(modeResult.get(11).get("DEPARTNAME").toString()));
            node1.add(new DefaultMutableTreeNode(modeResult.get(12).get("DEPARTNAME").toString()));

            DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("外科");
            node2.add(new DefaultMutableTreeNode(modeResult.get(17).get("DEPARTNAME").toString()));
            node2.add(new DefaultMutableTreeNode(modeResult.get(18).get("DEPARTNAME").toString()));
            node2.add(new DefaultMutableTreeNode(modeResult.get(19).get("DEPARTNAME").toString()));
            node2.add(new DefaultMutableTreeNode(modeResult.get(20).get("DEPARTNAME").toString()));
            node2.add(new DefaultMutableTreeNode(modeResult.get(21).get("DEPARTNAME").toString()));
            node2.add(new DefaultMutableTreeNode(modeResult.get(22).get("DEPARTNAME").toString()));

            DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("专科");
            node3.add(new DefaultMutableTreeNode(modeResult.get(23).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(24).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(25).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(26).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(27).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(28).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(29).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(30).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(31).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(32).get("DEPARTNAME").toString()));
            node3.add(new DefaultMutableTreeNode(modeResult.get(33).get("DEPARTNAME").toString()));


            DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("医技");
            node4.add(new DefaultMutableTreeNode(modeResult.get(34).get("DEPARTNAME").toString()));
            node4.add(new DefaultMutableTreeNode(modeResult.get(35).get("DEPARTNAME").toString()));
            node4.add(new DefaultMutableTreeNode(modeResult.get(36).get("DEPARTNAME").toString()));
            node4.add(new DefaultMutableTreeNode(modeResult.get(37).get("DEPARTNAME").toString()));
            node4.add(new DefaultMutableTreeNode(modeResult.get(38).get("DEPARTNAME").toString()));
            //node4.add(new DefaultMutableTreeNode(modeResult.get(39).get("DEPARTNAME").toString()));

            DefaultMutableTreeNode top = new DefaultMutableTreeNode("选择科室");
            top.add(node1);
            top.add(node2);
            top.add(node3);
            top.add(node4);
            JTree tree = new JTree(top);
            tree.setFont(new Font("宋体",Font.PLAIN,15));
            // 添加选择事件
            tree.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                    if (node == null)
                        return;
                    Object object = node.getUserObject();
                    if (node.isLeaf()) {
                        ChooseBox.this.jTextField.setText(object.toString());//文本框显示所选内容
                        /**
                         * 获取所选科室对应的项目的ID
                         */
                        String departId = "select DEPARTID from DepartInfo where DEPARTNAME = '" +object.toString() +"'";
                        Map<String, Object> maps = new HashMap<>();
                        try{
                            maps = JDBCUtils.findSimpleResult(departId, null);
                            departID = maps.get("DEPARTID".toUpperCase()).toString();

                        }catch (SQLException e1){
                            e1.printStackTrace();
                        }

                        ChooseBox.this.setVisible(false);
                        ChooseBox.this.jScrollPane.setVisible(false);
                        bookReigserKS.setVisible(true);
                        /**
                         * 获得所选科室对应的项目放到数组
                         */
                        String a = "K201821206";
                        String sql = "select ProjectName from HspPriceInfo where DepartID = '" + a + "' ";
                        try {

                            List<Map<String, Object>> modeResult = JDBCUtils.findModeResult(sql, null);
                            for(int i = 0;i < 4; i++){
                                kk[i] = modeResult.get(i).get("ProjectName".toUpperCase()).toString();
                            }
                            BookReigserKS.getproject(kk);
                        }catch (Exception e2){
                            e2.printStackTrace();
                        }
                    }
                }
            });
            tree.setBounds(0,0,250,300);
            this.add(tree);

        } catch(SQLException e) {
            e.printStackTrace();
        }
        //this.setSize(500, 500);
        this.setVisible(false);
        this.jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!ChooseBox.this.isVisible()) {
                    ChooseBox.this.jScrollPane = new JScrollPane(ChooseBox.this);
                    jScrollPane.setBounds(210, 210, 150, 100);
                    jTextField.getParent().add(jScrollPane);
                    ChooseBox.this.setVisible(true);
                    bookReigserKS.setVisible(true);
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 600);
        jFrame.getContentPane().setLayout(new FlowLayout());
        //===================使用用例========================
        ChooseBox chooseBox = new ChooseBox(null);
        jFrame.getContentPane().add(chooseBox);
        //==================================================
        jFrame.setLocationRelativeTo(jFrame.getOwner());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
       // ChooseBox chooseBox = new ChooseBox(null);
    }
}
