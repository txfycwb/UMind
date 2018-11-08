package version1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
/*
 * 右键菜单的构造
 * 鉴于pan内操作和组件内操作差别较大，故设有两种右键菜单，一种在pan内右键显示，令一种在组件内右键显示
 * 更新日志：
 * RCMv1.00 增加了本类
 * 			字体修改用JComboBox实现
 */
public class RightClickMenu {
	public JPopupMenu rightMenuForPan;
	public JPopupMenu rightMenuForComponent;
	public JComboBox fontTypeBox;
	public JComboBox fontColorBox;
	public JComboBox fontSizeBox;
	public MouseEvent componentE;//保存产生右键菜单的组件位置，确定Box的位置
	public RightClickMenu() {
		this.rightMenuForPan = new JPopupMenu();
		this.rightMenuForComponent = new JPopupMenu();
		// pan内右键菜单构造
			JMenuItem createTheme = new JMenuItem("新建主题");
			JMenuItem createConnect = new JMenuItem("新建连接");
			rightMenuForPan.add(createTheme);
			rightMenuForPan.add(createConnect);
		// 组件内右键菜单构造
			JMenu menuCreate =new JMenu("新增");
			JMenu menuEdit =new JMenu("编辑");
			JMenu menuIcon =new JMenu("图标");
			JMenu menuFont =new JMenu("文字");
			JMenuItem link =new JMenuItem("链接");
			//"新增"的修改
			JMenuItem remark = new JMenuItem("备注");
			menuCreate.add(remark);
			//"编辑"的修改
			JMenuItem shear = new JMenuItem("剪切");
			JMenuItem copy = new JMenuItem("复制");
			JMenuItem paste = new JMenuItem("粘贴");
			JMenuItem delete = new JMenuItem("删除");
			menuEdit.add(shear);
			menuEdit.add(copy);
			menuEdit.add(paste);
			menuEdit.add(delete);
			//"文字"的修改
			JMenuItem fontType = new JMenuItem("字体");
			JMenuItem fontColor = new JMenuItem("颜色");
			JMenuItem fontSize = new JMenuItem("大小");
			menuFont.add(fontType);
			menuFont.add(fontColor);
			menuFont.add(fontSize);
			fontType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fontTypeBox.setBounds(((Component)componentE.getSource()).getX(), ((Component)componentE.getSource()).getY(),100, 20);
					fontColorBox.setVisible(false);
					fontSizeBox.setVisible(false);
					fontTypeBox.setVisible(true);
				}
			});
			fontColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fontColorBox.setBounds(((Component)componentE.getSource()).getX(), ((Component)componentE.getSource()).getY(),100, 20);
					fontSizeBox.setVisible(false);
					fontTypeBox.setVisible(false);
					fontColorBox.setVisible(true);
				}
			});
			fontSize.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fontSizeBox.setBounds(((Component)componentE.getSource()).getX(), ((Component)componentE.getSource()).getY(),100, 20);
					fontTypeBox.setVisible(false);
					fontColorBox.setVisible(false);
					fontSizeBox.setVisible(true);
				}
			});
			//"图标"的修改
			//一级菜单的的修改
			rightMenuForComponent.add(menuCreate);
			rightMenuForComponent.add(menuEdit);
			rightMenuForComponent.add(menuIcon);
			rightMenuForComponent.add(menuFont);
			rightMenuForComponent.add(link);
	}
	public void createBoxs() {
		String[] fontTypes = {"楷体","仿宋","华文彩云","华文新魏","华文琥珀","华文行楷","微软雅黑","方正姚体","等线"};
		String[] fontColors = {"黑色","蓝色","蓝绿","深灰","灰色","绿色","淡灰","品红","橙色","粉色","红色","白色","黄色"};
		String[] fontSize = {"10","15","20","25","30","35","40"};
		//fontTypeBox设置
			fontTypeBox=new JComboBox(fontTypes);
			fontTypeBox.setMaximumRowCount(4);//最多显示4个选项
			fontTypeBox.setBounds(2500, 2500, 100, 20);
			fontTypeBox.setVisible(false);
			MainWindow.pan.add(fontTypeBox);
			/***********加入改变字体选项的事件监听*********/
			fontTypeBox.addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==ItemEvent.SELECTED) {
						String fontType =(String) e.getItem();
						JLabel label=(JLabel)(componentE.getSource());
						Font tempFont =label.getFont();
						label.setFont(new Font(fontType,tempFont.getStyle(),tempFont.getSize()));
						fontTypeBox.setVisible(false);
					}
				}
			});
		//fontColorBox设置
			fontColorBox=new JComboBox(fontColors);
			fontColorBox.setMaximumRowCount(4);
			fontColorBox.setBounds(2500, 2500, 100, 20);
			fontColorBox.setVisible(false);
			MainWindow.pan.add(fontColorBox);
			/***********加入改变字体颜色的事件监听*********/
			fontColorBox.addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==ItemEvent.SELECTED) {
						String fontColor =(String) e.getItem();
						JLabel label=(JLabel)(componentE.getSource());
						Color tempColor =parseColor(fontColor);
						if(tempColor!=null) {
							label.setForeground(tempColor);
						}
						fontColorBox.setVisible(false);
					}
				}
			});
		//fontSizeBox设置
			fontSizeBox=new JComboBox(fontSize);
			fontSizeBox.setMaximumRowCount(4);
			fontSizeBox.setBounds(2500, 2500, 100, 20);
			fontSizeBox.setVisible(false);
			MainWindow.pan.add(fontSizeBox);
			/***********加入改变字大小选项的事件监听*********/
			fontSizeBox.addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==ItemEvent.SELECTED) {
						String fontSize =(String) e.getItem();
						JLabel label=(JLabel)(componentE.getSource());
						Font tempFont =label.getFont();
						label.setFont(new Font(tempFont.getName(),tempFont.getStyle(),Integer.parseInt(fontSize)));
						fontTypeBox.setVisible(false);
					}
				}
			});
	}
	
	public Color parseColor(String color) {
		if("黑色".equals(color)) {
			return Color.BLACK;
		}
		if("蓝色".equals(color)) {
			return Color.BLUE;
		}
		if("蓝绿".equals(color)) {
			return Color.CYAN;
		}
		//"蓝色","蓝绿","深灰","灰色","绿色","淡灰","品红","橙色","粉色","红色","白色","黄色"
		if("深灰".equals(color)) {
			return Color.DARK_GRAY;
		}
		if("灰色".equals(color)) {
			return Color.GRAY;
		}
		if("绿色".equals(color)) {
			return Color.GREEN;
		}
		if("淡灰".equals(color)) {
			return Color.LIGHT_GRAY;
		}
		if("品红".equals(color)) {
			return Color.MAGENTA;
		}
		if("橙色".equals(color)) {
			return Color.ORANGE;
		}
		if("粉色".equals(color)) {
			return Color.PINK;
		}
		if("红色".equals(color)) {
			return Color.RED;
		}
		if("白色".equals(color)) {
			return Color.WHITE;
		}
		if("黄色".equals(color)) {
			return Color.YELLOW;
		}
		return null;
	}
}

class fontMouseListener extends MouseAdapter {
	int lastClickX;
	int lastClickY;
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==e.BUTTON1) {
			lastClickX=e.getX();
			lastClickY=e.getY();
		}
	}
}
