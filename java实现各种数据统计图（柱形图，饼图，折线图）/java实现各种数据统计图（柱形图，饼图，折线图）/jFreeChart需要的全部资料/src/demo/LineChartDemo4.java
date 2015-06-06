



package demo;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

// Referenced classes of package demo:
//            SampleXYDataset

public class LineChartDemo4 extends ApplicationFrame
{

    public LineChartDemo4(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Line Chart Demo 4", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.getDomainAxis().setLowerMargin(0.0D);
        xyplot.getDomainAxis().setUpperMargin(0.0D);
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        xylineandshaperenderer.setLegendLine(new java.awt.geom.Rectangle2D.Double(-4D, -3D, 8D, 6D));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(new SampleXYDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        LineChartDemo4 linechartdemo4 = new LineChartDemo4("Line Chart Demo 4");
        linechartdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(linechartdemo4);
        linechartdemo4.setVisible(true);
    }
}
