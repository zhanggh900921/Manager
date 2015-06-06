



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.*;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MeterChartDemo1 extends ApplicationFrame
{

    public MeterChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(ValueDataset valuedataset)
    {
        MeterPlot meterplot = new MeterPlot(valuedataset);
        meterplot.setRange(new Range(0.0D, 60D));
        meterplot.addInterval(new MeterInterval("Normal", new Range(0.0D, 35D), Color.lightGray, new BasicStroke(2.0F), new Color(0, 255, 0, 64)));
        meterplot.addInterval(new MeterInterval("Warning", new Range(35D, 50D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 255, 0, 64)));
        meterplot.addInterval(new MeterInterval("Critical", new Range(50D, 60D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 0, 0, 128)));
        meterplot.setNeedlePaint(Color.darkGray);
        meterplot.setDialBackgroundPaint(Color.white);
        meterplot.setDialOutlinePaint(Color.gray);
        meterplot.setDialShape(DialShape.CHORD);
        meterplot.setMeterAngle(260);
        meterplot.setTickLabelsVisible(true);
        meterplot.setTickLabelFont(new Font("Dialog", 1, 10));
        meterplot.setTickLabelPaint(Color.darkGray);
        meterplot.setTickSize(5D);
        meterplot.setTickPaint(Color.lightGray);
        meterplot.setValuePaint(Color.black);
        meterplot.setValueFont(new Font("Dialog", 1, 14));
        JFreeChart jfreechart = new JFreeChart("Meter Chart 1", JFreeChart.DEFAULT_TITLE_FONT, meterplot, true);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        dataset = new DefaultValueDataset(23D);
        JFreeChart jfreechart = createChart(dataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        return chartpanel;
    }

    public static void main(String args[])
    {
        MeterChartDemo1 meterchartdemo1 = new MeterChartDemo1("Meter Chart Demo 1");
        meterchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(meterchartdemo1);
        meterchartdemo1.setVisible(true);
    }

    private static DefaultValueDataset dataset;
}
