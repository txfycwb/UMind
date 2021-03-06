package version1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;
/*
 * 本类 在主窗口菜单 创建“文件”菜单项是实例化
 * 负责构造文本选择框
 *     实现文本保存和打开的事件监听
 */
public class AddFileChooser implements ActionListener{
	private JMenuItem openFile;
	private JMenuItem saveFile;
	public AddFileChooser(JMenuItem openFile,JMenuItem saveFile) {
		this.openFile=openFile;
		this.saveFile=saveFile;
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		File file =null;
		JFileChooser fileChooser =new JFileChooser();
		int result =0;
		if(e.getSource()==this.openFile) {//设置“打开文件”选项的文件选择框内容，实现打开操作
			fileChooser.setApproveButtonText("确定");
			fileChooser.setDialogTitle("打开文件");
			result =fileChooser.showOpenDialog(MainWindow.frame);
			if(result == JFileChooser.APPROVE_OPTION) {//选择了确定键
				file = fileChooser.getSelectedFile();
			}else if(result == JFileChooser.CANCEL_OPTION) {//选择了取消键
				
			}else if(result == JFileChooser.ERROR_OPTION) {//出错了
				
			}
			if(file!=null) {
				
			}
		}else if(e.getSource()==this.saveFile) {//设置“保存文件”选项的文件选择框内容，实现保存操作
			result =fileChooser.showSaveDialog(MainWindow.frame);
			if(result == JFileChooser.APPROVE_OPTION) {//选择了确定键
				file = fileChooser.getSelectedFile();
			}else if(result == JFileChooser.CANCEL_OPTION) {//选择了取消键
				
			}else if(result == JFileChooser.ERROR_OPTION) {//出错了
				
			}
			if(file!=null) {
				
			}
		}
		
	}
}
