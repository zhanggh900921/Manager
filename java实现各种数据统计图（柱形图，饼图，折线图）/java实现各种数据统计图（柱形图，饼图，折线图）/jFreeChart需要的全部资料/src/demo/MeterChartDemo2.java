



package demo;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MeterChartDemo2 extends ApplicationFrame
{

    public MeterChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(ValueDataset valuedataset)
    {
        MeterPlot meterplot = new MeterPlot(valuedataset);
        meterplot.addInterval(new MeterInterval("High", new Range(80D, 100D)));
        meterplot.setDialOutlinePaint(Color.white);
        JFreeChart jfreechart = new JFreeChart("Meter Chart 2", JFreeChart.DEFAULT_TITLE_FONT, meterplot, false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        dataset = new DefaultValueDataset(50D);
        JFreeChart jfreechart = createChart(dataset);
        JPanel jpanel = new JPanel(new BorderLayout());
        JSlider jslider = new JSlider(-10, 110, 50);
        jslider.setMajorTickSpacing(10);
        jslider.setMinorTickSpacing(5);
        jslider.setPaintLabels(true);
        jslider.setPaintTicks(true);
        jslider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent changeevent)
            {
                JSlider jslider1 = (JSlider)changeevent.getSource();
                MeterChartDemo2.dataset.setValue(new Integer(jslider1.getValue()));
            }

        }
);
        jpanel.add(new ChartPanel(jfreechart));
        jpanel.add("South", jslider);
        return jpanel;
    }

    public static void main(String args[])
    {
        MeterChartDemo2 meterchartdemo2 = new MeterChartDemo2("Meter Chart Demo 2");
        meterchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(meterchartdemo2);
        meterchartdemo2.setVisible(true);
    }

    private static DefaultValueDataset dataset;

}
