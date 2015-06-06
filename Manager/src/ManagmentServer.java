import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;

import com.zhtelecom.common.topograph.TopoDataSource;
import com.zhtelecom.common.topograph.TopoGraphView;


public class ManagmentServer {
	
	public final int CONTENT_CONTROLLER = 1;
	public final int IDENTITY_CONTROLLER = 11;
	
	DisplayInterface di = new DisplayInterface(this);
	
	private DataInputStream dis = null;
	
	private DataOutputStream dos = null;
	
	Socket s = null;
	
	ContentClient c = null;
	
	IdentityClient i = null;

	public static void main(String[] args) {
		new ManagmentServer().launchFrame();      //服务器的主线程
	}
	
	public void launchFrame() {                   //开启一个界面并等待客户端连接
		di.display();

		WaitConnect();
		
	}
	
	public void WaitConnect() {              //启动TCP的server，等待客户端连接，为内容和身份各起一个线程
		
		

		try {
			ServerSocket ss = new ServerSocket(8886);
			while(true) {
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				
				int networkType = dis.readInt();

				if(networkType == CONTENT_CONTROLLER) {
					di.ta.setText(di.ta.getText()+"The content network has been added."+"\n");	
					
					c = new ContentClient(s,this,dis,dos);
					
					new Thread(c).start();
							
				}
				else if(networkType == IDENTITY_CONTROLLER) {
					di.ta.setText(di.ta.getText()+"The identity network has been added."+"\n");
					
					i = new IdentityClient(s,this,dis,dos);
					
					new Thread(i).start();
				}
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				s.close();
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		} 
		
	}	

}
