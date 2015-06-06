



package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HideSeriesDemo2 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
        implements ActionListener
    {

        private CategoryDataset createSampleDataset()
        {
            DefaultStatisticalCategoryDataset defaultstatisticalcategorydataset = new DefaultStatisticalCategoryDataset();
            defaultstatisticalcategorydataset.add(10D, 2.3999999999999999D, "Row 1", "Column 1");
            defaultstatisticalcategorydataset.add(15D, 4.4000000000000004D, "Row 1", "Column 2");
            defaultstatisticalcategorydataset.add(13D, 2.1000000000000001D, "Row 1", "Column 3");
            defaultstatisticalcategorydataset.add(7D, 1.3D, "Row 1", "Column 4");
            defaultstatisticalcategorydataset.add(22D, 2.3999999999999999D, "Row 2", "Column 1");
            defaultstatisticalcategorydataset.add(18D, 4.4000000000000004D, "Row 2", "Column 2");
            defaultstatisticalcategorydataset.add(28D, 2.1000000000000001D, "Row 2", "Column 3");
            defaultstatisticalcategorydataset.add(7D, 1.3D, "Row 2", "Column 4");
            defaultstatisticalcategorydataset.add(2D, 2.3999999999999999D, "Row 3", "Column 1");
            defaultstatisticalcategorydataset.add(8D, 4.4000000000000004D, "Row 3", "Column 2");
            defaultstatisticalcategorydataset.add(8D, 2.1000000000000001D, "Row 3", "Column 3");
            defaultstatisticalcategorydataset.add(7D, 1.3D, "Row 3", "Column 4");
            return defaultstatisticalcategorydataset;
        }

        private JFreeChart createChart(CategoryDataset categorydataset)
        {
            JFreeChart jfreechart = ChartFactory.createAreaChart("Hide Series Demo 2", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
            categoryplot.setRenderer(new StatisticalLineAndShapeRenderer());
            renderer = categoryplot.getRenderer(0);
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

        private CategoryItemRenderer renderer;

        public DemoPanel()
        {
            super(new BorderLayout());
            CategoryDataset categorydataset = createSampleDataset();
            JFreeChart jfreechart = createChart(categorydataset);
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


    public HideSeriesDemo2(String s)
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
        HideSeriesDemo2 hideseriesdemo2 = new HideSeriesDemo2("JFreeChart: HideSeriesDemo2.java");
        hideseriesdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(hideseriesdemo2);
        hideseriesdemo2.setVisible(true);
    }
}
