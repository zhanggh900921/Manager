



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo5 extends ApplicationFrame
{

    public PieChartDemo5(String s)
    {
        super(s);
        setContentPane(createDemoPanel());
    }

    public static JPanel createDemoPanel()
    {
        JPanel jpanel = new JPanel(new GridLayout(2, 2));
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("Section 1", 23.300000000000001D);
        defaultpiedataset.setValue("Section 2", 56.5D);
        defaultpiedataset.setValue("Section 3", 43.299999999999997D);
        defaultpiedataset.setValue("Section 4", 11.1D);
        JFreeChart jfreechart = ChartFactory.createPieChart("Chart 1", defaultpiedataset, false, false, false);
        jfreechart.addSubtitle(new TextTitle("setCircular(true);", new Font("Dialog", 0, 12)));
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setCircular(true);
        JFreeChart jfreechart1 = ChartFactory.createPieChart("Chart 2", defaultpiedataset, false, false, false);
        jfreechart1.addSubtitle(new TextTitle("setCircular(false);", new Font("Dialog", 0, 12)));
        PiePlot pieplot1 = (PiePlot)jfreechart1.getPlot();
        pieplot1.setCircular(false);
        JFreeChart jfreechart2 = ChartFactory.createPieChart3D("Chart 3", defaultpiedataset, false, false, false);
        jfreechart2.addSubtitle(new TextTitle("setCircular(true);", new Font("Dialog", 0, 12)));
        PiePlot3D pieplot3d = (PiePlot3D)jfreechart2.getPlot();
        pieplot3d.setForegroundAlpha(0.6F);
        pieplot3d.setCircular(true);
        JFreeChart jfreechart3 = ChartFactory.createPieChart3D("Chart 4", defaultpiedataset, false, false, false);
        jfreechart3.addSubtitle(new TextTitle("setCircular(false);", new Font("Dialog", 0, 12)));
        PiePlot3D pieplot3d1 = (PiePlot3D)jfreechart3.getPlot();
        pieplot3d1.setForegroundAlpha(0.6F);
        pieplot3d1.setCircular(false);
        jpanel.add(new ChartPanel(jfreechart));
        jpanel.add(new ChartPanel(jfreechart1));
        jpanel.add(new ChartPanel(jfreechart2));
        jpanel.add(new ChartPanel(jfreechart3));
        jpanel.setPreferredSize(new Dimension(800, 600));
        return jpanel;
    }

    public static void main(String args[])
    {
        PieChartDemo5 piechartdemo5 = new PieChartDemo5("Pie Chart Demo 5");
        piechartdemo5.pack();
        RefineryUtilities.centerFrameOnScreen(piechartdemo5);
        piechartdemo5.setVisible(true);
    }
}
