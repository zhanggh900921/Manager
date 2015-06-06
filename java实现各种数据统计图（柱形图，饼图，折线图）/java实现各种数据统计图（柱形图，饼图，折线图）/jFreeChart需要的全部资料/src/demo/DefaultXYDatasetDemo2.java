



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DefaultXYDatasetDemo2 extends ApplicationFrame
{

    public DefaultXYDatasetDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        return ChartFactory.createScatterPlot("DefaultXYDatasetDemo1", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, false, false);
    }

    private static XYDataset createDataset()
    {
        DefaultXYDataset defaultxydataset = new DefaultXYDataset();
        double ad[] = new double[1000];
        double ad1[] = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            ad[i] = Math.random() + 1.0D;
            ad1[i] = Math.random() + 1.0D;
        }

        double ad2[][] = {
            ad, ad1
        };
        defaultxydataset.addSeries("Series 1", ad2);
        return defaultxydataset;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        DefaultXYDatasetDemo2 defaultxydatasetdemo2 = new DefaultXYDatasetDemo2("DefautlXYDataset Demo 2");
        defaultxydatasetdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(defaultxydatasetdemo2);
        defaultxydatasetdemo2.setVisible(true);
    }
}
