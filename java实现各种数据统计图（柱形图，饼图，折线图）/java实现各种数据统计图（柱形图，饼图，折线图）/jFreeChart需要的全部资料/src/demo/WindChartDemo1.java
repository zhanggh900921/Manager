



package demo;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.data.xy.DefaultWindDataset;
import org.jfree.data.xy.WindDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class WindChartDemo1 extends ApplicationFrame
{

    public WindChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static long millisForDate(int i, int j, int k)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(k, j - 1, i, 12, 0);
        return calendar.getTimeInMillis();
    }

    private static Object[] createItem(long l, int i, int j)
    {
        return (new Object[] {
            new Date(l), new Integer(i), new Integer(j)
        });
    }

    public static WindDataset createDataset()
    {
        Object aobj[] = createItem(millisForDate(3, 1, 1999), 0, 10);
        Object aobj1[] = createItem(millisForDate(4, 1, 1999), 1, 8);
        Object aobj2[] = createItem(millisForDate(5, 1, 1999), 2, 10);
        Object aobj3[] = createItem(millisForDate(6, 1, 1999), 3, 10);
        Object aobj4[] = createItem(millisForDate(7, 1, 1999), 4, 7);
        Object aobj5[] = createItem(millisForDate(8, 1, 1999), 5, 10);
        Object aobj6[] = createItem(millisForDate(9, 1, 1999), 6, 8);
        Object aobj7[] = createItem(millisForDate(10, 1, 1999), 7, 11);
        Object aobj8[] = createItem(millisForDate(11, 1, 1999), 8, 10);
        Object aobj9[] = createItem(millisForDate(12, 1, 1999), 9, 11);
        Object aobj10[] = createItem(millisForDate(13, 1, 1999), 10, 3);
        Object aobj11[] = createItem(millisForDate(14, 1, 1999), 11, 9);
        Object aobj12[] = createItem(millisForDate(15, 1, 1999), 12, 11);
        Object aobj13[] = createItem(millisForDate(16, 1, 1999), 0, 0);
        Object aobj14[][] = {
            aobj, aobj1, aobj2, aobj3, aobj4, aobj5, aobj6, aobj7, aobj8, aobj9, 
            aobj10, aobj11, aobj12, aobj13
        };
        Object aobj15[][][] = {
            aobj14
        };
        return new DefaultWindDataset(aobj15);
    }

    private static JFreeChart createChart(WindDataset winddataset)
    {
        JFreeChart jfreechart = ChartFactory.createWindPlot("Wind Chart Demo", "Date", "Direction / Force", winddataset, true, false, false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        WindChartDemo1 windchartdemo1 = new WindChartDemo1("Wind Chart Demo 1");
        windchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(windchartdemo1);
        windchartdemo1.setVisible(true);
    }
}
