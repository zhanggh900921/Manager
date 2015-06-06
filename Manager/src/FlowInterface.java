import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class FlowInterface {
	
	TextField tfTxt;
	
	public void bar(int n1,int n2,int n3,int n4) {
  	  JFrame frame=new JFrame("流量统计柱状图");  
  	    frame.setLayout(new GridLayout(1,1,10,10));  
  	    frame.add(new BarChart(n1,n2,n3,n4).getChartPanel());           //添加柱形图  
  	    frame.setBounds(50, 50, 800, 600); 
  	    frame.pack();
  	    frame.setVisible(true);  
  }
	
	
	 public void pie(int n1,int n2,int n3,int n4) {
	  	  JFrame frame=new JFrame("流量统计饼状图");  
	  	    frame.setLayout(new BorderLayout());  
	  	    frame.add(new PieChart(n1,n2,n3,n4).getChartPanel(),BorderLayout.CENTER);         
	  	    tfTxt = new TextField();
	  	    frame.add(tfTxt,BorderLayout.SOUTH);
	  	    TFListener tf = new TFListener();
			tfTxt.addActionListener(tf);
	  	    frame.setBounds(50, 50, 800, 600); 
	  	    frame.pack();
	  	    frame.setVisible(true);  
	  }


	public void subBar(int[][] c, int[][] i) {
		JFrame frame=new JFrame("流量统计柱状图");  
  	    frame.setLayout(new GridLayout(1,1,10,10));  
  	    frame.add(new SubBarChart(c, i).getChartPanel());           //添加柱形图  
  	    frame.setBounds(50, 50, 800, 600); 
  	    frame.pack();
  	    frame.setVisible(true);  
	}
	
	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim();
			tfTxt.setText("");
			
			if(str.equals("内容网络")) {
				JFrame frame=new JFrame("子网统计饼状图");  
		  	    frame.setLayout(new GridLayout(1,1,10,10));  
		  	    frame.add(new SubPieChart(DisplayInterface.contentFlow).getChartPanel());           //添加柱形图  
		  	    frame.setBounds(50, 50, 800, 600); 
		  	    frame.pack();
		  	    frame.setVisible(true);  
			}
			if(str.equals("身份网络")) {
				JFrame frame=new JFrame("子网统计饼状图");  
		  	    frame.setLayout(new GridLayout(1,1,10,10));  
		  	    frame.add(new SubPieChart(DisplayInterface.identityFlow).getChartPanel());           //添加柱形图  
		  	    frame.setBounds(50, 50, 800, 600); 
		  	    frame.pack();
		  	    frame.setVisible(true);  
			}
		}
		
	}
}
