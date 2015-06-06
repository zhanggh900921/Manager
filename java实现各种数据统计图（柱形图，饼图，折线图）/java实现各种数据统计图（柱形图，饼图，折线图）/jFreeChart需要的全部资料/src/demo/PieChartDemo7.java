



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo7 extends ApplicationFrame
{
    static class Rotator extends Timer
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            plot.setStartAngle(angle);
            angle = angle + 1;
            if(angle == 360)
                angle = 0;
        }

        private PiePlot plot;
        private int angle;

        Rotator(PiePlot pieplot)
        {
            super(100, null);
            angle = 270;
            plot = pieplot;
            addActionListener(this);
        }
    }


    public PieChartDemo7(String s)
    {
        super(s);
        setContentPane(createDemoPanel());
    }

    private static PieDataset createDataset(int i)
    {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        for(int j = 0; j < i; j++)
        {
            double d = 100D * Math.random();
            defaultpiedataset.setValue("Section " + j, d);
        }

        return defaultpiedataset;
    }

    public static JPanel createDemoPanel()
    {
        PieDataset piedataset = createDataset(14);
        JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 7", piedataset, false, true, false);
        jfreechart.setBackgroundPaint(new Color(222, 222, 255));
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setBackgroundPaint(Color.white);
        pieplot.setCircular(true);
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        pieplot.setNoDataMessage("No data available");
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        Rotator rotator = new Rotator(pieplot);
        rotator.start();
        return chartpanel;
    }

    public static void main(String args[])
    {
        PieChartDemo7 piechartdemo7 = new PieChartDemo7("Pie Chart Demo 7");
        piechartdemo7.pack();
        RefineryUtilities.centerFrameOnScreen(piechartdemo7);
        piechartdemo7.setVisible(true);
    }
}
