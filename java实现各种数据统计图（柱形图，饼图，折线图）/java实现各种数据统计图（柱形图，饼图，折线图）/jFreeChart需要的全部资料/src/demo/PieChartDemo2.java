



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo2 extends ApplicationFrame
{

    public PieChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static PieDataset createDataset()
    {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("One", 43.200000000000003D);
        defaultpiedataset.setValue("Two", 10D);
        defaultpiedataset.setValue("Three", 27.5D);
        defaultpiedataset.setValue("Four", 17.5D);
        defaultpiedataset.setValue("Five", 11D);
        defaultpiedataset.setValue("Six", 19.399999999999999D);
        return defaultpiedataset;
    }

    private static JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 2", piedataset, true, true, false);
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setSectionPaint("One", new Color(160, 160, 255));
        pieplot.setSectionPaint("Two", new Color(128, 128, 223));
        pieplot.setSectionPaint("Three", new Color(96, 96, 191));
        pieplot.setSectionPaint("Four", new Color(64, 64, 159));
        pieplot.setSectionPaint("Five", new Color(32, 32, 127));
        pieplot.setSectionPaint("Six", new Color(0, 0, 111));
        pieplot.setNoDataMessage("No data available");
        pieplot.setExplodePercent("Two", 0.5D);
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
        pieplot.setLabelBackgroundPaint(new Color(220, 220, 220));
        pieplot.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator("Tooltip for legend item {0}"));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        PieChartDemo2 piechartdemo2 = new PieChartDemo2("Pie Chart Demo 2");
        piechartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(piechartdemo2);
        piechartdemo2.setVisible(true);
    }
}
