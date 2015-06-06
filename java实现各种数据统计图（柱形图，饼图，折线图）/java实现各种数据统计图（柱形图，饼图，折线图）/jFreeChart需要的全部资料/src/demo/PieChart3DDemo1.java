



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieChart3DDemo1 extends ApplicationFrame
{

    public PieChart3DDemo1(String s)
    {
        super(s);
        PieDataset piedataset = createDataset();
        JFreeChart jfreechart = createChart(piedataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static PieDataset createDataset()
    {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("Java", new Double(43.200000000000003D));
        defaultpiedataset.setValue("Visual Basic", new Double(10D));
        defaultpiedataset.setValue("C/C++", new Double(17.5D));
        defaultpiedataset.setValue("PHP", new Double(32.5D));
        defaultpiedataset.setValue("Perl", null);
        return defaultpiedataset;
    }

    private static JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Pie Chart 3D Demo 1", piedataset, true, true, false);
        PiePlot3D pieplot3d = (PiePlot3D)jfreechart.getPlot();
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);
        pieplot3d.setNoDataMessage("No data to display");
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        PieChart3DDemo1 piechart3ddemo1 = new PieChart3DDemo1("Pie Chart 3D Demo 1");
        piechart3ddemo1.pack();
        RefineryUtilities.centerFrameOnScreen(piechart3ddemo1);
        piechart3ddemo1.setVisible(true);
    }
}
