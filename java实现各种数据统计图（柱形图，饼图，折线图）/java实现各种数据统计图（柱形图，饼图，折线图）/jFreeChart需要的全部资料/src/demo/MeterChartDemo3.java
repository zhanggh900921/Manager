



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

public class MeterChartDemo3 extends ApplicationFrame
{

    public MeterChartDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(String s, ValueDataset valuedataset, DialShape dialshape)
    {
        MeterPlot meterplot = new MeterPlot(valuedataset);
        meterplot.setDialShape(dialshape);
        meterplot.setRange(new Range(0.0D, 60D));
        meterplot.addInterval(new MeterInterval("Normal", new Range(0.0D, 35D), Color.lightGray, new BasicStroke(2.0F), new Color(0, 255, 0, 64)));
        meterplot.addInterval(new MeterInterval("Warning", new Range(35D, 50D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 255, 0, 64)));
        meterplot.addInterval(new MeterInterval("Critical", new Range(50D, 60D), Color.lightGray, new BasicStroke(2.0F), new Color(255, 0, 0, 128)));
        meterplot.setNeedlePaint(Color.darkGray);
        meterplot.setDialBackgroundPaint(Color.white);
        meterplot.setDialOutlinePaint(Color.gray);
        meterplot.setMeterAngle(260);
        meterplot.setTickLabelsVisible(true);
        meterplot.setTickLabelFont(new Font("Dialog", 1, 10));
        meterplot.setTickLabelPaint(Color.darkGray);
        meterplot.setTickSize(5D);
        meterplot.setTickPaint(Color.lightGray);
        meterplot.setValuePaint(Color.black);
        meterplot.setValueFont(new Font("Dialog", 1, 14));
        JFreeChart jfreechart = new JFreeChart(s, JFreeChart.DEFAULT_TITLE_FONT, meterplot, true);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JPanel jpanel = new JPanel(new GridLayout(1, 3));
        DefaultValueDataset defaultvaluedataset = new DefaultValueDataset(23D);
        ChartPanel chartpanel = new ChartPanel(createChart("DialShape.PIE", defaultvaluedataset, DialShape.PIE));
        ChartPanel chartpanel1 = new ChartPanel(createChart("DialShape.CHORD", defaultvaluedataset, DialShape.CHORD));
        ChartPanel chartpanel2 = new ChartPanel(createChart("DialShape.CIRCLE", defaultvaluedataset, DialShape.CIRCLE));
        jpanel.add(chartpanel);
        jpanel.add(chartpanel1);
        jpanel.add(chartpanel2);
        return jpanel;
    }

    public static void main(String args[])
    {
        MeterChartDemo3 meterchartdemo3 = new MeterChartDemo3("Meter Chart Demo 4");
        meterchartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(meterchartdemo3);
        meterchartdemo3.setVisible(true);
    }
}
