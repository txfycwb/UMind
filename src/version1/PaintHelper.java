package version1;

import java.awt.*;

class PaintHelper {
	
	public static Graphics graphics=null;
	
	public PaintHelper(Graphics g)
	{
		this.graphics=g;	
	}
	
	public static void PainteLine(ConnectLine connectLine)
	{
		graphics.setColor(connectLine.getColor());
		
	}
	public static void PainteTheme()
	{
		
	}
	

	

}
