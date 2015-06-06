



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DefaultXYDatasetDemo1 extends ApplicationFrame
{

    public DefaultXYDatasetDemo1(String s)
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
        double ad[] = {
            1.0D, 2D, 3D, 4D, 5D, 6D, 7D, 8D
        };
        double ad1[] = {
            8D, 7D, 6D, 5D, 4D, 3D, 2D, 1.0D
        };
        double ad2[][] = {
            ad, ad1
        };
        defaultxydataset.addSeries("Series 1", ad2);
        double ad3[] = {
            1.0D, 2D, 3D, 4D, 5D, 6D, 7D, 8D
        };
        double ad4[] = {
            1.0D, 2D, 3D, 4D, 5D, 6D, 7D, 8D
        };
        double ad5[][] = {
            ad3, ad4
        };
        defaultxydataset.addSeries("Series 2", ad5);
        return defaultxydataset;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        DefaultXYDatasetDemo1 defaultxydatasetdemo1 = new DefaultXYDatasetDemo1("DefautlXYDataset Demo 1");
        defaultxydatasetdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(defaultxydatasetdemo1);
        defaultxydatasetdemo1.setVisible(true);
    }
}
