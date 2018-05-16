package com.ui;

import com.sun.awt.AWTUtilities;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeautyFrame extends JFrame{
	public  static final int screenWidth, screenHeight;
	public static final int totalWidth;
	public static final int totalHeight;
	int titleBarPanelHeight = 50;
	JPanel titleBarPanel;
	JPanel MasterPane;

	static {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.width;
		screenHeight = screenSize.height;
		totalWidth = (int) Math.round(screenWidth * 0.7);
		totalHeight = (int) Math.round(screenHeight * 0.9);
	}
	public BeautyFrame() {
		this.setLayout(new BorderLayout());
		initComponents();
		initIcon();
		this.setUndecorated(true);
		this.setResizable(false);

		this.setSize(totalWidth, totalHeight);
		this.setLocationRelativeTo(this.getOwner());
		this.setVisible(true);

		DragWindowMouseListeber listener = new DragWindowMouseListeber(this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);

	}

	/**
	 * 初始化窗体内组件
	 */
	public void initComponents() {
		//标题栏
		titleBarPanel = new JPanel();
		titleBarPanel.setPreferredSize(new Dimension(totalWidth, titleBarPanelHeight));
		titleBarPanel.setBackground(new Color(107, 155, 184));
		titleBarPanel.setLayout(null);
		this.getContentPane().add(titleBarPanel, BorderLayout.NORTH);
		//显示面板
		MasterPane = new JPanel();
		MasterPane.setPreferredSize(new Dimension(totalWidth, totalHeight - titleBarPanelHeight));
		MasterPane.setBackground(new Color(249, 249, 249));
		this.getContentPane().add(MasterPane, BorderLayout.SOUTH);
		//标题文字
		JLabel titleLabel = new JLabel("主页啊哈哈哈哈哈哈");
		titleLabel.setFont(new Font("华文新魏", Font.PLAIN, 30));
		int weight = titleLabel.getText().length()*30;
		titleLabel.setForeground(Color.BLACK);
		int titleHeight = (int) Math.round(titleBarPanelHeight * 0.6);
		titleLabel.setBounds((totalWidth - weight )/ 2, (int) Math.round(titleBarPanelHeight * 0.2), weight, titleHeight);
		titleBarPanel.add(titleLabel);
	}

	/**
	 * 设置图标
	 */
	public void initIcon() {
		JButton exitButton = new JButton();
		int closeButtonWidth = 50;
		int closeButtonHeight = 50;
		exitButton.setBounds(totalWidth - closeButtonWidth, 0, closeButtonWidth, closeButtonHeight);
		//ImageIcon iconClose = new ImageIcon("img/close.png");
		//exitButton.initIcon(iconClose);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		titleBarPanel.add(exitButton);

		JButton miniButton = new JButton();
		miniButton.setBounds(totalWidth - closeButtonWidth*2, 0, closeButtonWidth, closeButtonHeight);
		//ImageIcon iconMini = new ImageIcon("img/mini.png");
		//miniButton.initIcon(iconMini);
		miniButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		titleBarPanel.add(miniButton);

/*		JLabel logo = new JLabel();
		//ImageIcon iconLogo = new ImageIcon("img/logo.png");
		//logo.initIcon(iconLogo);
		logo.setBounds(totalWidth / 2 - 300 / 2 - closeButtonWidth, 0, closeButtonWidth, closeButtonHeight);
		titleBarPanel.add(logo);*/

		JPanel iconPanel = new JPanel();
		iconPanel.setBounds(totalWidth - closeButtonWidth*2 -20, 20, closeButtonWidth, closeButtonHeight);

	}

	/**
	 * 绘制圆角窗体
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		AWTUtilities.setWindowShape(this,
				new RoundRectangle2D.Double(0.0D, 0.0D, this.getWidth(),
						this.getHeight(), 26.0D, 26.0D));
	}

	/**
	 *鼠标拖动窗体的监听器
	 */
	private class DragWindowMouseListeber extends MouseAdapter{
		private Point pressed = null;
		BeautyFrame home;
		public DragWindowMouseListeber(BeautyFrame home) {
			this.home = home;
		}
		@Override
		public void mousePressed(MouseEvent event) {
			super.mousePressed(event);
			if(event.getModifiers() == MouseEvent.BUTTON1_MASK){
				int pressedX = event.getX();
				int pressedY = event.getY();
				if(pressedX >= 0 && pressedX <= totalWidth && pressedY >= 0 && pressedY <= titleBarPanelHeight){
					pressed = event.getPoint();
				}
				else{
					pressed = null;
				}
			}
		}
		@Override
		public void mouseDragged(MouseEvent event) {
			super.mouseDragged(event);
			if(event.getModifiers() == MouseEvent.BUTTON1_MASK){
				if(pressed != null){
					Point dragged = event.getPoint();
					Point location = home.getLocation();
					int x = location.x + dragged.x - pressed.x;
					int y = location.y + dragged.y - pressed.y;
					home.setLocation(x, y);
				}
			}
		}
	}

}
