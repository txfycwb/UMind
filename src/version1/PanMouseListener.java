package version1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 *Panel的鼠标事件处理类
*/
class PanMouseListener extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		clearBoxs();
		int clickType =e.getButton();
		if(clickType==e.BUTTON3) {//右键点击
			PaintePanel.rightClickMenu.componentE=e;//传递产生右键菜单的组件位置，确定新建主题的位置
			PaintePanel.rightClickMenu.rightMenuForPan.show(MainWindow.pan, e.getX(), e.getY());;
		}
		else if(e.getClickCount()==2)//双击
		{
			ThemeLabel themeLabel1=new ThemeLabel(e.getX(),e.getY());
			MainWindow.allThemeLabel.add(themeLabel1);
			MainWindow.pan.add(themeLabel1);
			MainWindow.frame.repaint();
		}
	}
	public void clearBoxs() {
		if(PaintePanel.rightClickMenu!=null) {
			PaintePanel.rightClickMenu.fontTypeBox.setVisible(false);
			PaintePanel.rightClickMenu.fontColorBox.setVisible(false);
			PaintePanel.rightClickMenu.fontSizeBox.setVisible(false);
		}
	}
}
