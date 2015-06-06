



package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartTiming3
    implements ActionListener
{

    public ChartTiming3()
    {
    }

    public void run()
    {
        finished = false;
        XYSeries xyseries = new XYSeries("Random Data");
        for(int i = 0; i < 1440; i++)
        {
            double d = Math.random();
            double d1 = Math.random();
            xyseries.add(d, d1);
        }

        XYSeriesCollection xyseriescollection = new XYSeriesCollection(xyseries);
        boolean flag = true;
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Scatter plot timing", "X", "Y", xyseriescollection, PlotOrientation.VERTICAL, flag, false, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setRenderer(new XYDotRenderer());
        BufferedImage bufferedimage = new BufferedImage(400, 300, 1);
        java.awt.Graphics2D graphics2d = bufferedimage.createGraphics();
        java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, 400D, 300D);
        Timer timer = new Timer(10000, this);
        timer.setRepeats(false);
        int j = 0;
        timer.start();
        do
        {
            if(finished)
                break;
            jfreechart.draw(graphics2d, double1, null, null);
            System.out.println("Charts drawn..." + j);
            if(!finished)
                j++;
        } while(true);
        System.out.println("DONE");
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        finished = true;
    }

    public static void main(String args[])
    {
        ChartTiming3 charttiming3 = new ChartTiming3();
        charttiming3.run();
    }

    private boolean finished;
}
