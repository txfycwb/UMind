package version1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * 用于构造主窗口，菜单栏
 */
public class MainWindow {
	private JFrame frame;//主窗口，不使用
	private Container frameContainer;//，主窗口容器，不使用
	private JPanel pan;//所有组件均加入此容器，使用绝对布局
	public static void main(String args[]) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.createWindow();
		//mainWindow.test();
	}
	/*
	 * 创建窗口
	 */
	public void createWindow() {
		this.frame =new JFrame("UMind");
		this.frameContainer=frame.getContentPane();
		frame.setSize(1600,900);
		frame.setLocation(-10,0);
		createMenu();
		createPanel();
		frame.addWindowListener(new MyWindowListener());
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
		//“编辑”的设置
		JMenuItem shear = new JMenuItem("剪切");
		JMenuItem copy = new JMenuItem("复制");
		menuEdit.add(shear);
		menuEdit.add(copy);
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
	public void createPanel() {
		this.pan =new JPanel();
		this.pan.setLayout(null);//采取绝对布局
		this.pan.setBackground(Color.WHITE);//采取绝对布局
		this.pan.setSize(3000,3000);//采取绝对布局
		JScrollPane scrollPane=new JScrollPane(this.pan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.pan.setPreferredSize(scrollPane.getViewport().getPreferredSize());
		this.frameContainer.add(scrollPane);
	}
	/*
	 * 用于测试的方法,可随意更改
	 */
	public void test() {
		JLabel l1=new JLabel("大家好");
		JLabel l2=new JLabel("hi,everyon");
		l1.setBounds(0, 100, 100, 100);
		l2.setBounds(1000, 2000, 100, 100);
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
