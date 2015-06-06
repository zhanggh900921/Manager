import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.zhtelecom.common.topograph.TopoLink;
import com.zhtelecom.common.topograph.TopoNode;
import com.zhtelecom.common.topograph.TopoSysConfig;


public class IdentityClient implements Runnable{

	public final int IDENTITY_TOPOLOGY = 12;
	public final int IDENTITY_ROUTING = 13;
	public final int IDENTITY_FLOW = 14;
	public final int IDENTITY_SUBNET = 15;
		
		private Socket s;
		
		private DataInputStream dis = null;
		
		private DataOutputStream dos = null;
		
		ManagmentServer ms;
		
		IdentityTopology t = null;
		
		
		ArrayList<int[]> arrays = new ArrayList<int[]>();
		
		int routeNum = 0;
		
		
		public IdentityClient(Socket s,ManagmentServer ms, DataInputStream dis, DataOutputStream dos) {
			this.s = s;
			this.ms = ms;
			this.dis = dis;
			this.dos = dos;
			
			System.out.println("a client has connected!");
			
		}

		
		public void receiveMsg() {             //接收客户端发来的拓扑信息和路径信息
			
			try {
				int type = dis.readInt();
				
				if(type == IDENTITY_TOPOLOGY)  {		
															
					if(t.topologyArray == null) {	
						
						t.drawTopology();
						
					}
					else {
						t.updataTopology();
						//System.out.println("topology updata");
					}
				}
				else if(type == IDENTITY_ROUTING) {					
					
					int[] a = receiveArray(dis);
					
					arrays.add(a);				
					
					routingDisplay(a,a[0]);

				}
				else if(type == IDENTITY_FLOW) {
										
					ms.di.setIdentityFlow(receiveFlow(dis));

				}
				
				else if(type == IDENTITY_SUBNET) {
					t.drawSubTopology();
				}
			} catch (IOException e) {
				System.out.println("client has exit");
				try {
					dis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			} 
			
		}
		
		
		
		public int[] receiveArray(DataInputStream dis) {   //接收一个矩阵
			int[] a;
			
			try {
				int arrayLength = dis.readInt();
				a = new int [arrayLength];
				for(int i = 0;i<arrayLength;i++) {
						a[i] = dis.readInt();
						//System.out.print(a[i]);
					} 
				return a;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
					
		}
		
		public int[][] receiveFlow(DataInputStream dis) {       //接收一个整数矩阵
			int[][] a;
			
			try {
				int arrayLength = dis.readInt();
				a = new int [arrayLength][2];
				for(int i = 0;i<arrayLength;i++) {
					for(int j=0;j<2;j++) {
						a[i][j] = dis.readInt();
					//	System.out.print(a[i][j]+ " ");
					}
					//System.out.println();
				}
				return a;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
					
		}
		
		
		public void sendArray(int[] r) {              //接收一个数组
			try {
				dos.writeInt(r.length);
				for(int i = 0;i<r.length;i++) {
						dos.writeInt(r[i]);
					} 
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		public void setRouting(int n1,int n2,int i,int num) {            //设定两节点之间的一条链路为路由链路
			
			TopoLink link1 = null;
			TopoLink link2 = null;
			
			TopoNode node1 = t.nodes.get(n1);
			TopoNode node2 = t.nodes.get(n2);	
			
			int subNum = t.subTopology[num][0];
			
			TopoNode subNode1 = (TopoNode) t.subGraphs.get(subNum).get(n1);
			TopoNode subNode2 = (TopoNode) t.subGraphs.get(subNum).get(n2);	
			
			if(n1<n2) {
				link1 = new TopoLink("Step"+i+" / "+"iline"+n1+n2, node1, node2);
				t.source.removeTopoDataByUserID("iline"+n1+n2);
				
				link2 = new TopoLink("Step"+i+" / "+"i"+subNum+"line"+n1+n2, subNode1, subNode2);
				t.source.removeTopoDataByUserID("i"+subNum+"Line"+n1+n2);
				
			}
			else if(n2<n1) {
				link1 = new TopoLink("Step"+i+" / "+"iline"+n2+n1, node1, node2);
				t.source.removeTopoDataByUserID("iline"+n2+n1);	
				
				link2 = new TopoLink("Step"+i+" / "+"i"+subNum+"line"+n2+n1, subNode1, subNode2);
				t.source.removeTopoDataByUserID("i"+subNum+"Line"+n2+n1);
			}
			link1.addAlarm("alarm1", TopoSysConfig.AlarmSeverity_Critical);
			link2.addAlarm("alarm2", TopoSysConfig.AlarmSeverity_Critical);
			
			t.source.addTopoData(link2, t.subNet[num]);
			
			t.source.addTopoData(link1, t.net);
			
		}
			
			public void routingDisplay (int [] r,int num) {                //设定接收到的数组中的一整条链路为路由链路
				int subNum = 0;
				for(int i=0;i<t.subTopology.length;i++) {
					if(num == t.subTopology[i][0]) {
						subNum = i;
					}
				}
				
				for(int i =1 ; i<r.length-1;i++) {
					setRouting(r[i], r[i+1], i,subNum);
				}
			}
			
			public void clearRouting(int n1,int n2,int i,int num) {        //清除两节点之间的路由链路
				
				TopoLink link1 = null;
				TopoLink link2 = null;
				
				TopoNode node1 = t.nodes.get(n1);
				TopoNode node2 = t.nodes.get(n2);	
				
				int subNum = t.subTopology[num][0];
				
				TopoNode subNode1 = (TopoNode) t.subGraphs.get(subNum).get(n1);
				TopoNode subNode2 = (TopoNode) t.subGraphs.get(subNum).get(n2);	
				
					if(n1<n2) {
						link1 = new TopoLink("iline"+n1+n2, node1, node2);
						t.source.removeTopoDataByUserID("Step"+i+" / "+"iline"+n1+n2);
						
						link2 = new TopoLink("i"+subNum+"Line"+n1+n2, subNode1, subNode2);
						t.source.removeTopoDataByUserID("Step"+i+" / "+"i"+subNum+"line"+n1+n2);
					}
					else if(n2<n1) {
						link1 = new TopoLink("iline"+n2+n1, node1, node2);
						t.source.removeTopoDataByUserID("Step"+i+" / "+"iline"+n2+n1);	
						
						link2 = new TopoLink("i"+subNum+"Line"+n2+n1, subNode1, subNode2);
						t.source.removeTopoDataByUserID("Step"+i+" / "+"i"+subNum+"line"+n2+n1);
					}
					link1.setShowArrow(false);
					t.source.addTopoData(link1, t.net);
					
					link2.setShowArrow(false);
					t.source.addTopoData(link2, t.subNet[num]);
					
				}
			
			public void routingErase (int [] r,int num) {                 //清除数组中的一整条路由链路
				int subNum = 0;
				for(int i=0;i<t.subTopology.length;i++) {
					if(num == t.subTopology[i][0]) {
						subNum = i;
					}
				}
		
				for(int i =1 ; i<r.length-1;i++) {
					clearRouting(r[i], r[i+1], i,subNum);
				}
			}
			
			
			
			public void routingChange (int [] r1,int[] r2,int num) {       //将一条路由链路改变为另外一条链路
				
				routingErase (r1,num);
				routingDisplay (r2,num);
				
				for(int i=0;i<arrays.size();i++) {
					if(arrayEqual( r1,arrays.get(i))) {
						 arrays.remove(i);
						 arrays.add(r2);
						 break;
					}
				}
																			
			}
			
			public boolean arrayEqual(int [] r1,int[] r2) {         //判定两个数组是否相等
				int i;
				if(r1.length != r2.length) {
					return false;
				}
				else {
					for(i=0;i<r1.length;i++) {
						if(r1[i]!=r2[i]) {
							break;
						}
					}
					if(i==r1.length) {
						return true;
					}
				}
				return false;
			}
		
		public void agreeForwarding() {                                  //同意已经接收到链路下发控制器
			for(int i=0;i<arrays.size();i++) {							//先发送OK，再将各个数组信息发送
				if(arrays.get(i)!=null) {
				
					routingErase(arrays.get(i),arrays.get(i)[0]);
					
					try {
						dos.writeUTF("OK");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					sendArray(arrays.get(i));
					
					System.out.println(arrays.size());
				}

			}
			
			for(int i=0;i<arrays.size();i++) {								

				arrays.remove(i);
			}
		}
		
		public void run() {                                               //线程主方法，不停地接收客户端发来的数据
			
			t = new IdentityTopology(dis,ms);
				
				while(true) {
					
					receiveMsg();																														

			    }	
		}

}
