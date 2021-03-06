package version1;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
/*
 * 用于构造主窗口，菜单栏
 * 更新日志：
 * MWv1.01 新增了 Panel的鼠标事件处理类 的 右键点击 的事件监听 ————118行
 * 		     新增了 组件的鼠标事件处理类 的 右键点击 的事件监听 ————129行
 *         新增了右键菜单栏的构建
 */
public class MainWindow {
	public static JFrame frame;//主窗口，不使用
	public static Container frameContainer;//，主窗口容器，不使用
	public static PaintePanel pan;//所有组件均加入此容器，使用绝对布局
	public static RightClickMenu rightClickMenu;//右键菜单的及其子菜单的事件监听
	public static ArrayList<ThemeLabel> allThemeLabel;//集中所有主题组件,暂时还未使用
	public static void main(String args[]) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.test();
		
	}
	/*
	 * 创建窗口、主菜单、放置组件的pan、及右键菜单
	 */
	public  MainWindow() {
		/*********获取图片路径**********/
		int length=((new File("xxx.txt")).getAbsolutePath()).toString().length();
		Constent.imagesPath=((new File("xxx.txt")).getAbsolutePath()).toString().substring(0,length-8)+"\\images\\";
		System.out.print(Constent.imagesPath);
		/*****初始化allThemeLabel*****/
		allThemeLabel=new ArrayList<ThemeLabel>();
		/******初始化pan*********/
		this.pan=new PaintePanel();
		this.pan.CreatBox();
		/*****frame初始化*************/
		this.frame =new JFrame("UMind");
		this.frame.setSize(Constent.frameLength,Constent.frameWidth);
		this.frame.setLocation(Constent.frameLocationX,Constent.frameLOcationY);
		/******contanier初始化*********/
		this.frameContainer=frame.getContentPane();
		/*********加入菜单与滚轴*******/
		createMenu();
		createScrollPanel();
		/*********加入监听*******/
		frame.addWindowListener(new MyWindowListener());
		/*********主窗口可见*******/
		frame.setVisible(true);
	}
	/*
	 * 创建菜单并加入到窗口上端,设置助记符和快捷打开方式,
	 * 及加入相应事件监听（未完成）
	 */
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("文件");
		JMenu menuEdit = new JMenu("编辑");
		JMenu menuTool = new JMenu("工具");
		JMenu menuStyle = new JMenu("风格");
		//“文件”的设置
		JMenuItem openFile =new JMenuItem("打开",'O');
		JMenuItem saveFile =new JMenuItem("保存",'S');
		openFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK));
		saveFile.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.Event.CTRL_MASK));
		menuFile.add(openFile);
		menuFile.add(saveFile);
		new AddFileChooser(openFile,saveFile);//构造文本选择框
		//“编辑”的设置
		JMenuItem shear = new JMenuItem("剪切",new ImageIcon(Constent.imagesPath+"editMenu\\1.png"));
		JMenuItem copy = new JMenuItem("复制",new ImageIcon(Constent.imagesPath+"editMenu\\2.png"));
		JMenuItem paste = new JMenuItem("粘贴",new ImageIcon(Constent.imagesPath+"editMenu\\3.png"));
		JMenuItem delete = new JMenuItem("删除",new ImageIcon(Constent.imagesPath+"editMenu\\4.png"));
		menuEdit.add(shear);
		menuEdit.add(copy);
		menuEdit.add(paste);
		menuEdit.add(delete);
		//“工具”的设置
		
		//“风格”的设置
		
		//“文件”等加入JMenuBar
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuTool);
		menuBar.add(menuStyle);
		this.frame.setJMenuBar(menuBar);
	}
	/*
	 * 创建JPanel pan并加上滚轴
	 * 向pan中加组件使用add方法
	 * 因采用绝对布局，pan中组件必须使用setBounds方法定位
	 */
	public void createScrollPanel() {
		
		this.frameContainer.add(pan.getScrollPane());
//		this.rightClickMenu.createBoxs();//建造字体类型、颜色、大小下拉框，必须已有pan后才能建立
	}
	/*
	 * 用于测试的方法,可随意更改
	 */
	public void test() {
		System.out.println();
		JLabel l1=new JLabel("大计划abc");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("等线",Font.PLAIN,20));
		ComponentMouseListener t1=new ComponentMouseListener(l1);
		l1.addMouseListener(t1);
		l1.addMouseMotionListener(t1);
		Icon icon1 =new ImageIcon(Constent.imagesPath+"arrow\\1.png");//"]images\\jiantou\\arrow_down_left@16@2x.png"
		l1.setIcon(icon1);
		JLabel l2=new JLabel("hi,everyon");
		l1.setBounds(0, 100, 100, 100);
		l2.setBounds(2000, 2000, 100, 100);
		ComponentMouseListener t2=new ComponentMouseListener(l2);
		l2.addMouseMotionListener(t2);
		l2.addMouseListener(t2);
		pan.add(l2);
		pan.add(l1);
	}
}
/*
 * 窗口事件处理类
 */
class MyWindowListener extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(1);
	}
}
