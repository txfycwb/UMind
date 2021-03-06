package version1;

import java.awt.Component;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

/*
 * 组件的鼠标事件处理类
 */

class ComponentMouseListener implements MouseInputListener{

	int ThemeX=0;
	int ThemeY=0;
	JLabel Label=null;
	boolean isClickRightAndDrag =false;
	public ComponentMouseListener(JLabel themeLabel)
	{
		this.Label=themeLabel;
	}

	public ComponentMouseListener(ThemeLabel themeLabel) {
		this.Label=themeLabel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton()==e.BUTTON1) {
			this.ThemeX=e.getX();
			this.ThemeY=e.getY();
			isClickRightAndDrag=true;
		}	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		clearBoxs();
		if(e.getButton()==e.BUTTON1) {
			int x=e.getX();
			int y=e.getY();
			this.Label.setBounds(x-this.ThemeX+this.Label.getX(), y-this.ThemeY+this.Label.getY(), Constent.ThemeSizeX, Constent.ThemeSizeY);
	        this.Label.setVisible(true);
	        isClickRightAndDrag=false;
		}	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(isClickRightAndDrag) {
			this.Label.setVisible(false);
			int x=e.getX();
			int y=e.getY();
			this.Label.setBounds(x-this.ThemeX+this.Label.getX(), y-this.ThemeY+this.Label.getY(), Constent.ThemeSizeX, Constent.ThemeSizeY);
	        this.Label.setVisible(true);
			MainWindow.pan.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clearBoxs();
		int clickType =e.getButton();
		if(clickType==e.BUTTON3) {//右键点击
			PaintePanel.rightClickMenu.rightMenuForComponent.show(MainWindow.pan, e.getX()+this.Label.getX(), e.getY()+this.Label.getY());;
			PaintePanel.rightClickMenu.componentE=e;//传递产生右键菜单的组件位置，确定Box的位置
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	public void clearBoxs() {
		if(PaintePanel.rightClickMenu!=null) {
			PaintePanel.rightClickMenu.fontTypeBox.setVisible(false);
			PaintePanel.rightClickMenu.fontColorBox.setVisible(false);
			PaintePanel.rightClickMenu.fontSizeBox.setVisible(false);
		}
	}

}

//class EnhanceDrag extends Thread{
//	JLabel Label=null;
//	MouseEvent e=null;
//	boolean flag=false;
//	int ThemeX=0;
//	int ThemeY=0;
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(flag) {
//			int x=e.getX();
//			int y=e.getY();
//			this.Label.setBounds(x-this.ThemeX+this.Label.getX(), y-this.ThemeY+this.Label.getY(), Constent.ThemeSizeX, Constent.ThemeSizeY);
//	        this.Label.setVisible(true);
//	        System.out.println("run");
//		}
//	}
//	
//}