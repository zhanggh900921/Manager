
import java.awt.Font;  
import java.awt.GridLayout;
import java.text.DecimalFormat;  
import java.text.NumberFormat;  
  

import javax.swing.JFrame;
import javax.swing.JPanel;  
  

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;  
  
public class PieChart { 
	int n1,n2,n3,n4;
    ChartPanel frame1;  
    public PieChart(int n1,int n2,int n3,int n4){  
    	this.n1 = n1;
    	this.n2 = n2;
    	this.n3 = n3;
    	this.n4 = n4;
          DefaultPieDataset data = getDataSet();  
          JFreeChart chart = ChartFactory.createPieChart3D("各多态流量所占比例",data,true,false,false);  
        //设置百分比  
          PiePlot pieplot = (PiePlot) chart.getPlot();  
          DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
          NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
          pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
        
      //没有数据的时候显示的内容  
          pieplot.setNoDataMessage("无数据显示");  
          pieplot.setCircular(false);  
          pieplot.setLabelGap(0.02D);  
        
          pieplot.setIgnoreNullValues(true);//设置不显示空值  
          pieplot.setIgnoreZeroValues(true);//设置不显示负值  
         frame1=new ChartPanel (chart,true);  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
          PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象  
          piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码  
          chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));  
    }  
    private  DefaultPieDataset getDataSet() {  
        DefaultPieDataset dataset = new DefaultPieDataset();  
        dataset.setValue("内容网络",n1);  
        dataset.setValue("身份网络",n2);  
        dataset.setValue("地址网络",n3);  
        dataset.setValue("服务网络",n4);    
        return dataset;  
    }  
    public ChartPanel getChartPanel(){  
        return frame1;  
          
    }
    
   
}  