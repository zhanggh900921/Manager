



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

// Referenced classes of package demo:
//            SimpleIntervalXYDataset

public class XYBarChartDemo3 extends ApplicationFrame
{

    public XYBarChartDemo3(String s)
    {
        super(s);
        SimpleIntervalXYDataset simpleintervalxydataset = new SimpleIntervalXYDataset();
        JFreeChart jfreechart = createChart(simpleintervalxydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("Sample", "X", false, "Y", intervalxydataset, PlotOrientation.VERTICAL, true, true, false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(new SimpleIntervalXYDataset()));
    }

    public static void main(String args[])
    {
        XYBarChartDemo3 xybarchartdemo3 = new XYBarChartDemo3("XY Bar Chart Demo 3");
        xybarchartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(xybarchartdemo3);
        xybarchartdemo3.setVisible(true);
    }
}
