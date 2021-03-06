/**
 * 
 */
package version1;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.MouseInputListener;

/**
 * @author sheng
 *
 */
public class ThemeLabel extends JLabel {
	
	private Icon LabelIcon;
	private ThemeLabel NextThemeLabel; 
	private int ThemeSizeX=Constent.ThemeSizeX;
	private int ThemeSizeY=Constent.ThemeSizeY;
	private Color color=Color.BLUE;
	
	public ThemeLabel(int x,int y)
	{
		this.setFont(new Font("方正舒体",Font.ROMAN_BASELINE,35));
		this.setText("主题");
		this.setBounds(x,y,this.ThemeSizeX,this.ThemeSizeY);
		this.setForeground(Color.BLUE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE,Constent.LabelThickness));
		this.setBackground(Color.BLUE);
		this.setVisible(true);
		
		
		/********设置鼠标的监听************/
		ComponentMouseListener componentMouseListener=new ComponentMouseListener(this);
		this.addMouseListener(componentMouseListener);//加入鼠标事件监听
		this.addMouseMotionListener(componentMouseListener);
	}
}