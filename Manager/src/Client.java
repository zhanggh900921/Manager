import java.io.*;
import java.net.*;


public class Client {
	
	public final int CONTENT_CONTROLLER = 1;
	public final int CONTENT_TOPOLOGY = 2;
	public final int CONTENT_ROUTING = 3;
	public final int CONTENT_FLOW = 4;
	public final int CONTENT_SUBNET = 5;
	

	DataOutputStream dos = null;
	DataInputStream dis = null;
	double[][] topology1 = {{0,0,1,1,0,0,0,0,0,0},
						{0,0,0,1,0,0,0,1,0,0},
						{1,0,0,0,1,0,0,0,0,0},
						{1,1,0,0,1,0,1,0,0,0},
						{0,0,1,1,0,1,0,0,0,0},
						{0,0,0,0,1,0,1,0,0,1},
						{0,0,0,1,0,1,0,1,0,1},
						{0,1,0,0,0,0,1,0,1,0},
						{0,0,0,0,0,0,0,1,0,1},
						{0,0,0,0,0,0,1,0,1,0}};
	
	int[][] topology2 = {{43,1,2,3,4,5,6,7,8,0,0},
						{33,2,4,7,8,9,10,0,0,0,0},
						{44,2,4,5,6,7,8,9,10,0,0}};
	
	int[][] topology3 = {{43,10},
						{33,20},
						{44,20}};
	
	int[] routing1 = {0,1,4,7,8};
	int[] routing2 = {1,2,4,5};
	int[] routing3 = {2,3,5,6};    //第一个数为子网类型
	
	public static void main(String[] args) {
		new Client().start();
		
	}
	
	private void start() {
		connect();
		sendInit();
		

		
		sendType(CONTENT_TOPOLOGY);
		
		sendMatrix(topology1);
		
		sendType(CONTENT_SUBNET);
		
		sendSubMatrix(topology2);
		
		sendType(CONTENT_FLOW);
		
		sendSubMatrix(topology3);
		
		while(true);
		
//		while(true) {
			

		
//			try {
//				Thread.sleep(30000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//			sendType(CONTENT_ROUTING);
//			
//			sendArray(routing1);
//			
//			sendType(CONTENT_FLOW);
//			
//			try {
//				dos.writeInt(20);
//				dos.writeInt(20);
//				dos.writeInt(20);
//				dos.writeInt(20);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			
//			
//			
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			sendType(CONTENT_ROUTING);
//			
//			sendArray(routing2);
//			
//			sendType(CONTENT_FLOW);
//			
//			try {
//				dos.writeInt(16);
//				dos.writeInt(17);
//				dos.writeInt(18);
//				dos.writeInt(16);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			sendType(CONTENT_ROUTING);
//			
//			sendArray(routing3);
//			
//			sendType(CONTENT_FLOW);
//			
//			try {
//				dos.writeInt(16);
//				dos.writeInt(30);
//				dos.writeInt(53);
//				dos.writeInt(10);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		
//		}				
		
		
	}

	public void connect() {
		
		try {
			Socket s = new Socket("219.223.195.99", 8886);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			System.out.println("connected!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public void sendInit() {
		try {
			dos.writeInt(CONTENT_CONTROLLER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendType(int dataType) {
		try {
			dos.writeInt(dataType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMatrix(double[][] r) {
		try {
			dos.writeInt(r.length);
			for(int i = 0;i<r.length;i++)
				for(int j=0;j<r[i].length;j++) {
					dos.writeDouble(r[i][j]);
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void sendSubMatrix(int[][] r) {
		try {
			dos.writeInt(r.length);
			for(int i = 0;i<r.length;i++)
				for(int j=0;j<r[i].length;j++) {
					dos.writeInt(r[i][j]);
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	

	
	public void sendArray(int[] r) {
		try {
			dos.writeInt(r.length);
			for(int i = 0;i<r.length;i++) {
					dos.writeInt(r[i]);
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
