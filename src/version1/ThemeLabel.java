/**
 * 
 */
package version1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * @author sheng
 *
 */
public class ThemeLabel extends JLabel {
	
	private Icon LabelIcon;
	private ThemeLabel NextThemeLabel; 
	private int ThemeLabelX=100;
	private int ThemeLabelY=100;
	private int ThemeSizeX=500;
	private int ThemeSizeY=100;
	private Color color=Color.BLUE;
	
	public ThemeLabel(PaintePanel pan,ComponentMouseListener componetRightMouseLis)
	{
		this.setText("主题");
		this.setBounds(this.ThemeLabelX,this.ThemeLabelY,this.ThemeSizeX,this.ThemeSizeY);
		this.setForeground(Color.BLUE);
		this.setFont(new Font("a",Font.ROMAN_BASELINE,35));
		this.addMouseListener(componetRightMouseLis);
		pan.add(this);
	}
	
}
