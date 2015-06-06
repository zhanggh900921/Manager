



package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RingChartDemo1 extends ApplicationFrame
{

    public RingChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static PieDataset createDataset()
    {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("One", new Double(43.200000000000003D));
        defaultpiedataset.setValue("Two", new Double(10D));
        defaultpiedataset.setValue("Three", new Double(27.5D));
        defaultpiedataset.setValue("Four", new Double(17.5D));
        defaultpiedataset.setValue("Five", new Double(11D));
        defaultpiedataset.setValue("Six", new Double(19.399999999999999D));
        return defaultpiedataset;
    }

    private static JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart jfreechart = ChartFactory.createRingChart("Ring Chart Demo 1", piedataset, false, true, false);
        RingPlot ringplot = (RingPlot)jfreechart.getPlot();
        ringplot.setLabelFont(new Font("SansSerif", 0, 12));
        ringplot.setNoDataMessage("No data available");
        ringplot.setSectionDepth(0.34999999999999998D);
        ringplot.setCircular(false);
        ringplot.setLabelGap(0.02D);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        RingChartDemo1 ringchartdemo1 = new RingChartDemo1("Ring Chart Demo 1");
        ringchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(ringchartdemo1);
        ringchartdemo1.setVisible(true);
    }
}
