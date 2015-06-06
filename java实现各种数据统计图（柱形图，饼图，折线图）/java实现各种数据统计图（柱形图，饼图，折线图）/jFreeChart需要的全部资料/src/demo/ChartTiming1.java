



package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ChartTiming1
    implements ActionListener
{

    public ChartTiming1()
    {
    }

    public void run()
    {
        finished = false;
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("One", new Double(10.300000000000001D));
        defaultpiedataset.setValue("Two", new Double(8.5D));
        defaultpiedataset.setValue("Three", new Double(3.8999999999999999D));
        defaultpiedataset.setValue("Four", new Double(3.8999999999999999D));
        defaultpiedataset.setValue("Five", new Double(3.8999999999999999D));
        defaultpiedataset.setValue("Six", new Double(3.8999999999999999D));
        boolean flag = true;
        JFreeChart jfreechart = ChartFactory.createPieChart("Testing", defaultpiedataset, flag, true, false);
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

    public static void main(String args[])
    {
        ChartTiming1 charttiming1 = new ChartTiming1();
        charttiming1.run();
    }

    private boolean finished;
}
