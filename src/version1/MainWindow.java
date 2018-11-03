package version1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * ���ڹ��������ڣ��˵���
 */
public class MainWindow {
	private JFrame frame;//�����ڣ���ʹ��
	private Container frameContainer;//����������������ʹ��
	private JPanel pan;//��������������������ʹ�þ��Բ���
	public static void main(String args[]) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.createWindow();
		//mainWindow.test();
	}
	/*
	 * ��������
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
	 * �����˵������뵽�����϶�,�������Ƿ��Ϳ�ݴ򿪷�ʽ,
	 * ��������Ӧ�¼�������δ��ɣ�
	 */
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("�ļ�");
		JMenu menuEdit = new JMenu("�༭");
		JMenu menuTool = new JMenu("����");
		JMenu menuStyle = new JMenu("���");
		//���ļ���������
		JMenuItem openFile =new JMenuItem("��",'O');
		JMenuItem saveFile =new JMenuItem("����",'S');
		openFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK));
		saveFile.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.Event.CTRL_MASK));
		menuFile.add(openFile);
		menuFile.add(saveFile);
		//���༭��������
		JMenuItem shear = new JMenuItem("����");
		JMenuItem copy = new JMenuItem("����");
		menuEdit.add(shear);
		menuEdit.add(copy);
		//�����ߡ�������
		
		//����񡱵�����
		
		//���ļ����ȼ���JMenuBar
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuTool);
		menuBar.add(menuStyle);
		this.frame.setJMenuBar(menuBar);
	}
	/*
	 * ����JPanel pan�����Ϲ���
	 * ��pan�м����ʹ��add����
	 * ����þ��Բ��֣�pan���������ʹ��setBounds������λ
	 */
	public void createPanel() {
		this.pan =new JPanel();
		this.pan.setLayout(null);//��ȡ���Բ���
		this.pan.setBackground(Color.WHITE);//��ȡ���Բ���
		this.pan.setSize(3000,3000);//��ȡ���Բ���
		JScrollPane scrollPane=new JScrollPane(this.pan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.pan.setPreferredSize(scrollPane.getViewport().getPreferredSize());
		this.frameContainer.add(scrollPane);
	}
	/*
	 * ���ڲ��Եķ���,���������
	 */
	public void test() {
		JLabel l1=new JLabel("��Һ�");
		JLabel l2=new JLabel("hi,everyon");
		l1.setBounds(0, 100, 100, 100);
		l2.setBounds(1000, 2000, 100, 100);
		pan.add(l2);
		pan.add(l1);
	}
}
/*
 * �����¼�������
 */
class MyWindowListener extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(1);
	}
}
