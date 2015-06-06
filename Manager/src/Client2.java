import java.io.*;
import java.net.*;


public class Client2 {
	
	public final int IDENTITY_CONTROLLER = 11;
	public final int IDENTITY_TOPOLOGY = 12;
	public final int IDENTITY_ROUTING = 13;
	public final int IDENTITY_FLOW = 14;
	public final int IDENTITY_SUBNET = 15;

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
	
	int[][] topology2 = {{11,1,2,3,4,5,6,7,8,0,0},
						{22,1,3,4,5,6,7,10,0,0,0},
						{33,2,4,7,8,9,10,0,0,0,0},
						{44,2,4,5,6,7,8,9,10,0,0}};
	
	int[][] topology3 = {{11,10},
						{22,15},
						{33,20},
						{44,20}};
	
	int[][] topology4 = {{11,100},
						{22,150},
						{33,200},
						{44,200}};
	
	int[] routing1 = {11,3,1,4,7};
	int[] routing2 = {1,2,4,5};
	int[] routing3 = {2,3,5,6};    //第一个数为子网类型
	
	public static void main(String[] args) {
		new Client2().start();
		
	}
	
	private void start() {
		connect();
		sendInit();
		
		sendType(IDENTITY_TOPOLOGY);
		
		sendMatrix(topology1);
		
		sendType(IDENTITY_SUBNET);
		
		sendSubMatrix(topology2);
		
		sendType(IDENTITY_FLOW);
		
		sendSubMatrix(topology3);
		
//		sendType(IDENTITY_ROUTING);
		
//		sendArray(routing1);
//		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		sendType(IDENTITY_FLOW);
		
		sendSubMatrix(topology4);
//		sendType(IDENTITY_ROUTING);
//		
//		sendArray(routing2);
//		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		sendType(IDENTITY_ROUTING);
//		
//		sendArray(routing3);
		
//		while(true);
		
//		while(true) {

			
//			sendType(IDENTITY_FLOW);
//			
//			try {
//				dos.writeInt(10);
//				dos.writeInt(12);
//				dos.writeInt(14);
//				dos.writeInt(15);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		
//			
//
//			
//			sendType(IDENTITY_FLOW);
//			
//			try {
//				dos.writeInt(21);
//				dos.writeInt(14);
//				dos.writeInt(11);
//				dos.writeInt(12);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		
//		}
		
		//sendType(IDENTITY_ROUTING);
		
		//sendArray(routing1);
		
		while(true);
		
//		try {
//			Thread.sleep(30000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		sendType(IDENTITY_ROUTING);
//		
//		sendArray(routing2);
//		
//		try {
//			Thread.sleep(30000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		sendType(IDENTITY_ROUTING);
//		
//		sendArray(routing3);
//		
//		sendType(IDENTITY_ROUTING);
//		
//		sendArray(routing4);
			

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
			dos.writeInt(IDENTITY_CONTROLLER);
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
