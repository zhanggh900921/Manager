import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.zhtelecom.common.topograph.*;



public class IdentityTopology{
	
	Map<Integer,TopoNode> nodes = new HashMap<Integer,TopoNode>();
	
	HashMap<Integer, HashMap> subGraphs = new HashMap<Integer,HashMap>();

	DataInputStream dis = null;
	
	static double[][] topologyArray = null;
	
	static int[][] subTopology = null;
	

	ManagmentServer ms;
	
	TopoNetwork net;
	
	TopoNetwork[] subNet;
	
	TopoDataSource source;
	

	
	public IdentityTopology(DataInputStream dis,ManagmentServer ms) {    
		this.dis = dis;
		this.ms = ms;
        
       
    	net = new TopoNetwork("面向身份网络"); //定义网络
    	
    	net.setXY(160, 285);
             
    	source = ms.di.topoView.getTopoDataSource(); //获取数据源
    	source.addTopoData(net); //把网络1加入到根视图下       
	}
	
	public void drawTopology() {	               //画网络拓扑
		
			topologyArray = receiveMatrix(dis);
			drawRouter(topologyArray);		
			drawLink(topologyArray);
			
			topoTree();						
		
	}
	
	public void drawSubTopology() {
		
		subTopology = receiveSubMatrix(dis);
		int subNum = subTopology.length;
		subNet = new TopoNetwork[subNum];
		for(int i =0;i<subNum;i++) {
			subNet[i] = new TopoNetwork("身份逻辑网"+subTopology[i][0]); //定义网络
	    	subNet[i].setXY(50+i*100, 370);
	    	source.addTopoData(subNet[i]); 
	    	drawSubObject(subTopology[i],subTopology[i][0],subNet[i]);
		}
				
	}
	
	public void drawSubObject(int[] r,int num,TopoNetwork subNet) {
		
		HashMap<Integer,TopoNode> subNodes = new HashMap<Integer,TopoNode>();
		
		for(int i=1; i<r.length;i++) {
			if(r[i]!=0) {
				TopoNode node= new TopoNode("i"+num+"Router"+r[i]);
				node.setXY(i*60+60, i*60+60);
				subNodes.put(r[i], node);
				node.setImageIconFromTopoFile("router1.png");  
				source.addTopoData(node, subNet);
			}
									
		}
		
		subGraphs.put(num, subNodes);
		
		for(int i=1; i<r.length;i++)
			for(int j=1; j<r.length;j++) {
				if(r[i]!=0&&r[j]!=0) {
					if(r[i]<r[j] && topologyArray[r[i]-1][r[j]-1]!=0) {
						TopoLink link = new TopoLink("i"+num+"Line"+r[i]+r[j], subNodes.get(r[i]), subNodes.get(r[j])); //通过起点终点，创建链接
						link.setShowArrow(false);	
						try{
				        source.addTopoData(link, subNet); //把连接加入到网络1中  
						} catch(NullPointerException e) {
							System.out.println("");
						} 
					}
				}
			}
		
	}
	
	public void updataTopology() {                    //更新拓扑图目前只做权值更新
		
		topologyArray = receiveMatrix(dis);
		
	}
	
	public void drawRouter(double[][] r ) {          //根据矩阵画出网络中的路由器
		

		
		for(int i=1;i<r.length+1;i++) {			
			TopoNode node= new TopoNode("identityRouter"+i);
			nodes.put(i, node);		
			node.setXY(i*60, i*60);
			node.setImageIconFromTopoFile("router1.png");  
			source.addTopoData(node, net);

		}
		
	}
	
	public double[][] receiveMatrix(DataInputStream dis) {       //接收一个整数矩阵
		double[][] a;
		
		try {
			int arrayLength = dis.readInt();
			a = new double [arrayLength][arrayLength];
			for(int i = 0;i<arrayLength;i++) {
				for(int j=0;j<arrayLength;j++) {
					a[i][j] = dis.readDouble();
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
	
	
	
	public int[][] receiveSubMatrix(DataInputStream dis) {       //接收一个整数子矩阵,且最多十节点
		int[][] a;
		
		try {
			int arrayLength = dis.readInt();
			a = new int [arrayLength][11];
			for(int i = 0;i<arrayLength;i++)
				for(int j=0;j<11;j++) {
					a[i][j] = dis.readInt();
				} 
			return a;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	
	public void drawLink(double[][] r) {                            //画出拓扑中的链路
		for(int i=1;i<nodes.size()+1;i++)
			for(int j=1;j<nodes.size()+1;j++) {
				if(i<j && r[i-1][j-1]!=0) {
					TopoLink link = new TopoLink("iline"+i+j, nodes.get(i), nodes.get(j)); //通过起点终点，创建链接
					link.setShowArrow(false);	
					try{
			        source.addTopoData(link, net); //把连接加入到网络1中  
					} catch(NullPointerException e) {
						System.out.println("");
					} 
				}
			}
	}
	
	
	public void topoTree() {                                         //画完拓扑之后，创建界面旁边与拓扑相对应的拓扑树
		TopoTreeView tree = new TopoTreeView(ms.di.topoView.getTopoDataSource()); //根据数据源创建树
        tree.setBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)));
        tree.syncTopoview(ms.di.topoView); //将树与拓扑图的选择事件同步起来        
        ms.di.frame.getContentPane().add(tree, BorderLayout.WEST);    
	}



	
	
}

