



package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HideSeriesDemo3 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
        implements ActionListener
    {

        private XYZDataset createSampleDataset()
        {
            DefaultXYZDataset defaultxyzdataset = new DefaultXYZDataset();
            double ad[] = {
                2.1000000000000001D, 2.2999999999999998D, 2.2999999999999998D
            };
            double ad1[] = {
                14.1D, 11.1D, 10D
            };
            double ad2[] = {
                2.3999999999999999D, 2.7000000000000002D, 2.7000000000000002D
            };
            double ad3[][] = {
                ad, ad1, ad2
            };
            defaultxyzdataset.addSeries("Series 1", ad3);
            ad = (new double[] {
                2.2000000000000002D, 2.2000000000000002D, 1.8D
            });
            ad1 = (new double[] {
                14.1D, 11.1D, 10D
            });
            ad2 = (new double[] {
                2.2000000000000002D, 2.2000000000000002D, 2.2000000000000002D
            });
            ad3 = (new double[][] {
                ad, ad1, ad2
            });
            defaultxyzdataset.addSeries("Series 2", ad3);
            ad = (new double[] {
                1.8D, 1.8999999999999999D, 2.2999999999999998D, 3.7999999999999998D
            });
            ad1 = (new double[] {
                5.4000000000000004D, 4.0999999999999996D, 4.0999999999999996D, 25D
            });
            ad2 = (new double[] {
                2.1000000000000001D, 2.2000000000000002D, 1.6000000000000001D, 4D
            });
            ad3 = (new double[][] {
                ad, ad1, ad2
            });
            defaultxyzdataset.addSeries("Series 3", ad3);
            return defaultxyzdataset;
        }

        private JFreeChart createChart(XYZDataset xyzdataset)
        {
            JFreeChart jfreechart = ChartFactory.createBubbleChart("Hide Series Demo 3", "X", "Y", xyzdataset, PlotOrientation.VERTICAL, true, true, false);
            XYPlot xyplot = (XYPlot)jfreechart.getPlot();
            renderer = xyplot.getRenderer(0);
            return jfreechart;
        }

        public void actionPerformed(ActionEvent actionevent)
        {
            byte byte0 = -1;
            if(actionevent.getActionCommand().equals("S1"))
                byte0 = 0;
            else
            if(actionevent.getActionCommand().equals("S2"))
                byte0 = 1;
            else
            if(actionevent.getActionCommand().equals("S3"))
                byte0 = 2;
            if(byte0 >= 0)
            {
                boolean flag = renderer.getItemVisible(byte0, 0);
                renderer.setSeriesVisible(byte0, new Boolean(!flag));
            }
        }

        private XYItemRenderer renderer;

        public DemoPanel()
        {
            super(new BorderLayout());
            XYZDataset xyzdataset = createSampleDataset();
            JFreeChart jfreechart = createChart(xyzdataset);
            ChartPanel chartpanel = new ChartPanel(jfreechart);
            JPanel jpanel = new JPanel();
            JCheckBox jcheckbox = new JCheckBox("Series 1");
            jcheckbox.setActionCommand("S1");
            jcheckbox.addActionListener(this);
            jcheckbox.setSelected(true);
            JCheckBox jcheckbox1 = new JCheckBox("Series 2");
            jcheckbox1.setActionCommand("S2");
            jcheckbox1.addActionListener(this);
            jcheckbox1.setSelected(true);
            JCheckBox jcheckbox2 = new JCheckBox("Series 3");
            jcheckbox2.setActionCommand("S3");
            jcheckbox2.addActionListener(this);
            jcheckbox2.setSelected(true);
            jpanel.add(jcheckbox);
            jpanel.add(jcheckbox1);
            jpanel.add(jcheckbox2);
            add(chartpanel);
            add(jpanel, "South");
            chartpanel.setPreferredSize(new Dimension(500, 270));
        }
    }


    public HideSeriesDemo3(String s)
    {
        super(s);
        setContentPane(new DemoPanel());
    }

    public static JPanel createDemoPanel()
    {
        return new DemoPanel();
    }

    public static void main(String args[])
    {
        HideSeriesDemo3 hideseriesdemo3 = new HideSeriesDemo3("JFreeChart: HideSeriesDemo3.java");
        hideseriesdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(hideseriesdemo3);
        hideseriesdemo3.setVisible(true);
    }
}
