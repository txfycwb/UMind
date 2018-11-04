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
		String[] fontTypes = {"粗体","斜体"};
		String[] fontColors = {"黑色","蓝色","蓝绿","深灰","灰色","绿色","淡灰","品红","橙色","粉色","红色","白色","黄色"};
		String[] fontSize = {"10","15","20","25","30","35","40"};
		//fontTypeBox设置
			fontTypeBox=new JComboBox(fontTypes);
			fontTypeBox.setMaximumRowCount(4);//最多显示4个选项
			fontTypeBox.setBounds(2500, 2500, 100, 20);
			fontTypeBox.setVisible(false);
			MainWindow.pan.add(fontTypeBox);
		//fontColorBox设置
			fontColorBox=new JComboBox(fontColors);
			fontColorBox.setMaximumRowCount(4);
			fontColorBox.setBounds(2500, 2500, 100, 20);
			fontColorBox.setVisible(false);
			MainWindow.pan.add(fontColorBox);
		//fontSizeBox设置
			fontSizeBox=new JComboBox(fontSize);
			fontSizeBox.setMaximumRowCount(4);
			fontSizeBox.setBounds(2500, 2500, 100, 20);
			fontSizeBox.setVisible(false);
			MainWindow.pan.add(fontSizeBox);
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
