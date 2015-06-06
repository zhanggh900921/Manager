



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class NormalDistributionDemo1 extends ApplicationFrame
{

    public NormalDistributionDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static XYDataset createDataset()
    {
        NormalDistributionFunction2D normaldistributionfunction2d = new NormalDistributionFunction2D(0.0D, 1.0D);
        XYDataset xydataset = DatasetUtilities.sampleFunction2D(normaldistributionfunction2d, -5D, 5D, 100, "Normal");
        return xydataset;
    }

    public static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Normal Distribution", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        return jfreechart;
    }

    public static void main(String args[])
    {
        NormalDistributionDemo1 normaldistributiondemo1 = new NormalDistributionDemo1("Normal Distribution Demo 1");
        normaldistributiondemo1.pack();
        RefineryUtilities.centerFrameOnScreen(normaldistributiondemo1);
        normaldistributiondemo1.setVisible(true);
    }
}
