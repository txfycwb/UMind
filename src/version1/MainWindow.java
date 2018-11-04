package version1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/*
 * 用于构造主窗口，菜单栏
 */
public class MainWindow implements ActionListener{
	private JFrame frame;//主窗口，不使用
	private Container frameContainer;//，主窗口容器，不使用
	private JPanel pan;//所有组件均加入此容器，使用绝对布局
	private JTextArea textArea;
	
	
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
		//注册监听
		openFile.addActionListener(this);
		openFile.setActionCommand("open");
		saveFile.addActionListener(this);
		saveFile.setActionCommand("save");
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
		/***********************第一次代码**********************/
//	    JTextArea text=new JTextArea();
//		this.pan =new JPanel();
//		this.pan.setLayout(null);//采取绝对布局
//		this.pan.setBackground(Color.WHITE);//采取绝对布局
//		this.pan.setSize(3000,3000);//采取绝对布局
//		JScrollPane scrollPane=new JScrollPane(this.pan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		this.pan.setPreferredSize(scrollPane.getViewport().getPreferredSize());
//		this.frameContainer.add(scrollPane);
		
		/***********************加文本域做测试*****************/
		this.textArea=new JTextArea(3000,1500);
		this.pan =new JPanel();
		this.pan.setLayout(null);//采取绝对布局
		this.pan.setBackground(Color.WHITE);//采取绝对布局
		textArea.setTabSize(4);
		textArea.setFont(new Font("标楷体", Font.BOLD, 16));
		textArea.setLineWrap(false);// 激活自动换行功能
		textArea.setWrapStyleWord(false);// 激活断行不断字功能
		textArea.setBackground(Color.WHITE);
		
		JScrollPane scrollPane=new JScrollPane(this.textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("save"))
		{
			//创建文件存储位置选择框
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setDialogTitle("选择文件夹");
			fileChooser.showOpenDialog(null);
			fileChooser.setVisible(true);
			
			//得到文件存储位置
			String saveLocation=fileChooser.getSelectedFile().getAbsolutePath();
			
			//文件存储
			
			FileWriter fileWriter=null;
		    BufferedWriter bufferedWriter=null;
		    
		    
			try {
				fileWriter=new FileWriter(saveLocation);
				bufferedWriter=new BufferedWriter(fileWriter);
				/*String str=ta.getText();
				 * //从JTextArea获得文本 String str1[]=str.split("\n");
				 *  for(String s:str1){ bw.write(s); bw.newLine(); bw.flush(); *
				 */
				String totalText=this.textArea.getText();
				String []text=totalText.split("\r\n");
				for(String s:text) {
					bufferedWriter.write(s+"\r\n");
				}
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		}
		else if(command.equals("open")) {
			//创建文件存储位置选择框
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setDialogTitle("选择文件夹");
			fileChooser.showOpenDialog(null);
			fileChooser.setVisible(true);
			
			//得到文件打开位置
			String openLocation=fileChooser.getSelectedFile().getAbsolutePath();
			//打开文件
			FileReader fileReader=null;
			BufferedReader bufferedReader=null;
			
			try {
				fileReader=new FileReader(openLocation);
				bufferedReader=new BufferedReader(fileReader);
				
				String text=null;
				String totalText="";
				
				while((text=bufferedReader.readLine())!=null) {
					totalText=totalText+text+"\r\n";
				}
				
				textArea.setText(totalText);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				///测试github********************
				
			}
		}
		
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
