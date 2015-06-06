



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BoxAndWhiskerChartDemo2 extends ApplicationFrame
{

    public BoxAndWhiskerChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static BoxAndWhiskerXYDataset createDataset()
    {
        DefaultBoxAndWhiskerXYDataset defaultboxandwhiskerxydataset = new DefaultBoxAndWhiskerXYDataset("Series Name");
        Object obj = new Day();
        for(int i = 0; i < 10; i++)
        {
            java.util.List list = createValueList(0.0D, 20D, 20);
            defaultboxandwhiskerxydataset.add(((RegularTimePeriod) (obj)).getStart(), BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(list));
            obj = ((RegularTimePeriod) (obj)).next();
        }

        return defaultboxandwhiskerxydataset;
    }

    private static java.util.List createValueList(double d, double d1, int i)
    {
        ArrayList arraylist = new ArrayList();
        for(int j = 0; j < i; j++)
        {
            double d2 = d + Math.random() * (d1 - d);
            arraylist.add(new Double(d2));
        }

        return arraylist;
    }

    private static JFreeChart createChart(BoxAndWhiskerXYDataset boxandwhiskerxydataset)
    {
        DateAxis dateaxis = new DateAxis("Day");
        NumberAxis numberaxis = new NumberAxis("Value");
        XYBoxAndWhiskerRenderer xyboxandwhiskerrenderer = new XYBoxAndWhiskerRenderer();
        XYPlot xyplot = new XYPlot(boxandwhiskerxydataset, dateaxis, numberaxis, xyboxandwhiskerrenderer);
        xyplot.setOrientation(PlotOrientation.HORIZONTAL);
        JFreeChart jfreechart = new JFreeChart("Box-and-Whisker Chart Demo 2", xyplot);
        jfreechart.setBackgroundPaint(Color.white);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setDomainGridlinesVisible(true);
        xyplot.setRangeGridlinePaint(Color.white);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BoxAndWhiskerChartDemo2 boxandwhiskerchartdemo2 = new BoxAndWhiskerChartDemo2("Box-and-Whisker Chart Demo 2");
        boxandwhiskerchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(boxandwhiskerchartdemo2);
        boxandwhiskerchartdemo2.setVisible(true);
    }
}
