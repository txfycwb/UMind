package version1;
import java.awt.*;
import java.awt.event.*;
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
	public static ComponentMouseListener componetRightMouseLis;//组件的右键菜单监听器
	public static ThemeLabel Centertheme;
	public static void main(String args[]) {
		MainWindow mainWindow = new MainWindow();
		//mainWindow.createWindow();
		mainWindow.test();
	}
	/*
	 * 创建窗口、主菜单、放置组件的pan、及右键菜单
	 */
	public  MainWindow() {
		/******初始化pan*********/
		this.pan=new PaintePanel();
		this.pan.CreatBox();
		/*****frame初始化*************/
		this.frame =new JFrame("UMind");
		this.frame.setSize(Constent.frameLength,Constent.frameWidth);
		this.frame.setLocation(Constent.frameLocationX,Constent.frameLOcationY);
		/********

		 */
		componetRightMouseLis=new ComponentMouseListener();
		/******contanier初始化*********/
		this.frameContainer=frame.getContentPane();
		//this.rightClickMenu=new RightClickMenu();
		
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
		JMenuItem paste = new JMenuItem("粘贴");
		JMenuItem delete = new JMenuItem("删除");
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
	public void createPanel() {
		
		this.frameContainer.add(pan.getScrollPane());
//		this.rightClickMenu.createBoxs();//建造字体类型、颜色、大小下拉框，必须已有pan后才能建立
	}
	/*
	 * 用于测试的方法,可随意更改
	 */
	public void test() {
		Centertheme = new ThemeLabel(pan,componetRightMouseLis);
		Centertheme.setText("中心主题");
		
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
/*
 *Panel的鼠标事件处理类
*/
class PanMouseListener extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		int clickType =e.getButton();
		if(clickType==e.BUTTON3) {//右键点击
			PaintePanel.rightClickMenu.rightMenuForPan.show(MainWindow.pan, e.getX(), e.getY());;
		}
		else if(clickType==e.BUTTON1)
		{
			
		}
		else if(clickType==e.MOUSE_DRAGGED)
		{
			
		}
	}
}
/*
 * 组件的鼠标事件处理类
 */
class ComponentMouseListener extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		int clickType =e.getButton();
		if(clickType==e.BUTTON3) {//右键点击
			PaintePanel.rightClickMenu.rightMenuForComponent.show(MainWindow.pan, e.getX()+((Component)e.getSource()).getX(), e.getY()+((Component)e.getSource()).getX());;
			PaintePanel.rightClickMenu.componentE=e;//传递产生右键菜单的组件位置，确定Box的位置
		}
	}
}