package com.utils;

import com.sun.awt.AWTUtilities;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

/**
 * beautilful Frame
 */
public class BeautifulFrame extends JFrame{
	public  static final int screenWidth, screenHeight;
	public static final int frameWidth;
	public static final int frameHeight;
	private int titleBarPanelHeight = 50;
	private JPanel titleBarPanel;
	private JPanel MasterPane;
	private JLabel titleLabel;
	private JPanel titleLeft;
	private JPanel titleCenter;
	private JPanel titleRight;

	static {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.width;
		screenHeight = screenSize.height;
		frameWidth = (int) Math.round(screenWidth * 0.7);
		frameHeight = (int) Math.round(screenHeight * 0.9);
	}
	public BeautifulFrame() {
		this.setLayout(new BorderLayout());
		initComponents();
		initTitleBar();
		this.setUndecorated(true);
		this.setResizable(false);
		this.setSize(frameWidth, frameHeight);
		this.setLocationRelativeTo(this.getOwner());
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
		titleBarPanel.setPreferredSize(new Dimension(frameWidth, titleBarPanelHeight));
		titleBarPanel.setBackground(new Color(107, 155, 184));
		titleBarPanel.setLayout(new BorderLayout());
		this.getContentPane().add(titleBarPanel, BorderLayout.NORTH);
		//显示面板
		MasterPane = new JPanel();
		MasterPane.setPreferredSize(new Dimension(frameWidth, frameHeight - titleBarPanelHeight));
		MasterPane.setBackground(new Color(249, 249, 249));
		this.getContentPane().add(MasterPane, BorderLayout.SOUTH);

	}

	/**
	 * 标题栏布置
	 */
	public void initTitleBar() {
		//titleLeft
		titleLeft = new JPanel();
		titleLeft.setPreferredSize(new Dimension(frameWidth/6, titleBarPanelHeight));
		titleLeft.setLayout(new FlowLayout());
		titleLeft.setBackground(Color.red);
		//titleCenter
		titleCenter = new JPanel();
		titleCenter.setBackground(Color.yellow);
		//titleRight
		titleRight = new JPanel();
		titleRight.setPreferredSize(new Dimension(frameWidth/12, titleBarPanelHeight));
		titleRight.setLayout(new FlowLayout());
		titleRight.setBackground(Color.green);
		//添加
		titleBarPanel.add(titleLeft, BorderLayout.WEST);
		titleBarPanel.add(titleCenter, BorderLayout.CENTER);
		titleBarPanel.add(titleRight, BorderLayout.EAST);
		//标题文字
		titleLabel = new JLabel("主页");
		titleLabel.setFont(new Font("华文新魏", Font.PLAIN, 30));
		titleLabel.setForeground(Color.BLACK);
		titleLeft.add(titleLabel);

		titleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				titleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});

		//按钮
		ImageIcon icoMin = new ImageIcon("img/最小化.png");
		ImageIcon icoMin2 = new ImageIcon("img/最小化2.png");
		BeautifulButton miniButton = new BeautifulButton(icoMin, icoMin2,titleBarPanelHeight*2/3,
				titleBarPanelHeight*2/3);
		miniButton.setPreferredSize(new Dimension(titleBarPanelHeight*2/3,
				titleBarPanelHeight*2/3));
		titleRight.add(miniButton);

		ImageIcon iconClose = new ImageIcon("img/关闭.png");
		ImageIcon iconClose2 = new ImageIcon("img/关闭2.png");
		BeautifulButton exitButton = new BeautifulButton(iconClose, iconClose2,titleBarPanelHeight*2/3,
				titleBarPanelHeight*2/3);
		exitButton.setPreferredSize(new Dimension(titleBarPanelHeight*2/3,
				titleBarPanelHeight*2/3));
		titleRight.add(miniButton);
		titleRight.add(exitButton);

		//按钮事件
		miniButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});


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
		BeautifulFrame home;
		public DragWindowMouseListeber(BeautifulFrame home) {
			this.home = home;
		}
		@Override
		public void mousePressed(MouseEvent event) {
			super.mousePressed(event);
			if(event.getModifiers() == MouseEvent.BUTTON1_MASK){
				int pressedX = event.getX();
				int pressedY = event.getY();
				if(pressedX >= 0 && pressedX <= frameWidth && pressedY >= 0 && pressedY <= titleBarPanelHeight){
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

	public int getTitleBarPanelHeight() {
		return titleBarPanelHeight;
	}

	public JPanel getTitleBarPanel() {
		return titleBarPanel;
	}

	public JPanel getMasterPane() {
		return MasterPane;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public JPanel getTitleLeft() {
		return titleLeft;
	}

	public JPanel getTitleCenter() {
		return titleCenter;
	}

	public JPanel getTitleRight() {
		return titleRight;
	}
}
