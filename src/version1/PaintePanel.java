package version1;
import java.awt.Color;
import java.awt.Container;

import javax.swing.*;
/*************单独抽出JPanel,便于画画*************/
class PaintePanel extends JPanel {
	
	public static RightClickMenu rightClickMenu=null;
	
	JScrollPane scrollPane=null;
	
	public PaintePanel()
	{ 
		/********添加右键组件***********/
		this.rightClickMenu=new RightClickMenu();
		this.add(rightClickMenu.rightMenuForPan);
		
		/****************添加滚轴****************/
		this.scrollPane=new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.addMouseListener(new PanMouseListener());
		
		/*********设置PaintePanel属性******/
		this.setBackground(Color.WHITE);//背景颜色为白色
		this.setSize(Constent.paintePanelLength,Constent.paintPanelWidth);
		this.setLayout(null);
		
		/*****************根据scrollpane设置合适大小************/
		this.setPreferredSize(scrollPane.getViewport().getPreferredSize());
	}
	
	public void CreatBox()
	{
		this.rightClickMenu.createBoxs();
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public RightClickMenu getRightClickMenu() {
		return rightClickMenu;
	}


}
