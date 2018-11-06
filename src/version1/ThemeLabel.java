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
	private int ThemeLabelX;
	private int ThemeLabelY;
	private int ThemeSizeX=Constent.ThemeSizeX;
	private int ThemeSizeY=Constent.ThemeSizeY;
	private Color color=Color.BLUE;
	
	public ThemeLabel(int x,int y)
	{
		this.ThemeLabelX=x;
		this.ThemeLabelY=y;
		this.setFont(new Font("方正舒体",Font.ROMAN_BASELINE,35));
		this.setText("主题");
		this.setSize(20, 15);
		this.setBounds(this.ThemeLabelX,this.ThemeLabelY,this.ThemeSizeX,this.ThemeSizeY);
		this.setForeground(Color.BLUE);
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.BLUE));
		this.setVisible(true);
		
		/********设置拖动的监听************/
		DragThemeLabelListener dragListener=new DragThemeLabelListener(this);
		this.addMouseMotionListener(dragListener);
		this.addMouseListener(dragListener);

	}
}

/***********监听拖动**********/
class DragThemeLabelListener implements MouseInputListener{

	int ThemeX=0;
	int ThemeY=0;
	ThemeLabel themeLabel=null;
	
	public DragThemeLabelListener(ThemeLabel themeLabel)
	{
		this.themeLabel=themeLabel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.ThemeX=e.getX();
		this.ThemeY=e.getY();
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=e.getX();
		int y=e.getY();

		this.themeLabel.setBounds(x-this.ThemeX+this.themeLabel.getX(), y-this.ThemeY+this.themeLabel.getY(), Constent.ThemeSizeX, Constent.ThemeSizeY);
        this.themeLabel.setVisible(true);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	
}

