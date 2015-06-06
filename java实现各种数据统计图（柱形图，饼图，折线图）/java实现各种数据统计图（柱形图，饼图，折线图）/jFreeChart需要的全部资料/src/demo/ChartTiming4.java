



package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import javax.swing.Timer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;

public class ChartTiming4
    implements ActionListener
{

    public ChartTiming4()
    {
        data = new float[2][1440];
    }

    public void run()
    {
        finished = false;
        populateData();
        FastScatterPlot fastscatterplot = new FastScatterPlot(data, new NumberAxis("X"), new NumberAxis("Y"));
        JFreeChart jfreechart = new JFreeChart("Fast Scatter Plot Timing", JFreeChart.DEFAULT_TITLE_FONT, fastscatterplot, true);
        BufferedImage bufferedimage = new BufferedImage(400, 300, 1);
        java.awt.Graphics2D graphics2d = bufferedimage.createGraphics();
        java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, 400D, 300D);
        Timer timer = new Timer(10000, this);
        timer.setRepeats(false);
        int i = 0;
        timer.start();
        do
        {
            if(finished)
                break;
            jfreechart.draw(graphics2d, double1, null, null);
            System.out.println("Charts drawn..." + i);
            if(!finished)
                i++;
        } while(true);
        System.out.println("DONE");
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        finished = true;
    }

    private void populateData()
    {
        for(int i = 0; i < data[0].length; i++)
        {
            float f = i;
            data[0][i] = f;
            data[1][i] = 100F + 2.0F * f + (float)Math.random() * 1440F;
        }

    }

    public static void main(String args[])
    {
        ChartTiming4 charttiming4 = new ChartTiming4();
        charttiming4.run();
    }

    private boolean finished;
    private float data[][];
}
