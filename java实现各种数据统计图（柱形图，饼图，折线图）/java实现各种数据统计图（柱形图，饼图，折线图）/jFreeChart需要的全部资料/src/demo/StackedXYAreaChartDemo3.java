



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo3 extends ApplicationFrame
{

    public StackedXYAreaChartDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static TableXYDataset createDataset()
    {
        TimeTableXYDataset timetablexydataset = new TimeTableXYDataset();
        timetablexydataset.add(new Day(14, 2, 2007), 87D, "Series 1");
        timetablexydataset.add(new Day(15, 2, 2007), 67D, "Series 1");
        timetablexydataset.add(new Day(16, 2, 2007), 78D, "Series 1");
        timetablexydataset.add(new Day(17, 2, 2007), 55D, "Series 1");
        timetablexydataset.add(new Day(18, 2, 2007), 58D, "Series 1");
        timetablexydataset.add(new Day(19, 2, 2007), 60D, "Series 1");
        timetablexydataset.add(new Day(14, 2, 2007), 45D, "Series 2");
        timetablexydataset.add(new Day(15, 2, 2007), 67D, "Series 2");
        timetablexydataset.add(new Day(16, 2, 2007), 61D, "Series 2");
        timetablexydataset.add(new Day(17, 2, 2007), 58D, "Series 2");
        timetablexydataset.add(new Day(18, 2, 2007), 73D, "Series 2");
        timetablexydataset.add(new Day(19, 2, 2007), 64D, "Series 2");
        timetablexydataset.add(new Day(14, 2, 2007), 32D, "Series 3");
        timetablexydataset.add(new Day(15, 2, 2007), 38D, "Series 3");
        timetablexydataset.add(new Day(16, 2, 2007), 43D, "Series 3");
        timetablexydataset.add(new Day(17, 2, 2007), 12D, "Series 3");
        timetablexydataset.add(new Day(18, 2, 2007), 19D, "Series 3");
        timetablexydataset.add(new Day(19, 2, 2007), 26D, "Series 3");
        return timetablexydataset;
    }

    private static JFreeChart createChart(TableXYDataset tablexydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedXYAreaChart("Stacked XY Area Chart Demo 3", "X Value", "Y Value", tablexydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        DateAxis dateaxis = new DateAxis("Date");
        xyplot.setDomainAxis(dateaxis);
        dateaxis.setLowerMargin(0.0D);
        dateaxis.setUpperMargin(0.0D);
        StackedXYAreaRenderer2 stackedxyarearenderer2 = (StackedXYAreaRenderer2)xyplot.getRenderer();
        stackedxyarearenderer2.setRoundXCoordinates(true);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedXYAreaChartDemo3 stackedxyareachartdemo3 = new StackedXYAreaChartDemo3("Stacked XY Area Chart Demo 3");
        stackedxyareachartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(stackedxyareachartdemo3);
        stackedxyareachartdemo3.setVisible(true);
    }
}
