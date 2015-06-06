



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo3 extends ApplicationFrame
{

    public PieChartDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 3", piedataset, true, true, false);
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setNoDataMessage("No data available so we go into this really long spiel about what that means and it runs off the end of the line but what can you do about that!");
        pieplot.setNoDataMessageFont(new Font("Serif", 2, 10));
        pieplot.setNoDataMessagePaint(Color.red);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(new DefaultPieDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        PieChartDemo3 piechartdemo3 = new PieChartDemo3("Pie Chart Demo 3");
        piechartdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(piechartdemo3);
        piechartdemo3.setVisible(true);
    }
}
