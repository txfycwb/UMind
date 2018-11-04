/*连接线类
 * 11-4
 * wangxianke
 */
package version1;

import java.awt.*;

class ConnectLine {
    
	int startX,StartY,endX,endY;
	int width;
	Color color;
	
	public ConnectLine(int startX,int StartY,int endX,int endY)
	{
		this.startX=startX;
		this.StartY=StartY;
		this.endX=endX;
		this.endY=endY;
		this.width=10;
		this.color=Color.BLUE;
		
	}
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return StartY;
	}

	public void setStartY(int startY) {
		StartY = startY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	

}
