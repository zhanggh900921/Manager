



package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

public class PieChartDemo4 extends ApplicationFrame
{
    private static class DemoPanel extends JPanel
        implements ActionListener
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            String s = actionevent.getActionCommand();
            if("BY_KEY".equals(s))
            {
                if(!ascendingByKey)
                {
                    dataset.sortByKeys(SortOrder.ASCENDING);
                    ascendingByKey = true;
                } else
                {
                    dataset.sortByKeys(SortOrder.DESCENDING);
                    ascendingByKey = false;
                }
            } else
            if("BY_VALUE".equals(s))
            {
                if(!ascendingByValue)
                {
                    dataset.sortByValues(SortOrder.ASCENDING);
                    ascendingByValue = true;
                } else
                {
                    dataset.sortByValues(SortOrder.DESCENDING);
                    ascendingByValue = false;
                }
            } else
            if("RANDOM".equals(s))
            {
                ArrayList arraylist = new ArrayList(dataset.getKeys());
                Collections.shuffle(arraylist);
                DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
                Comparable comparable;
                for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); defaultpiedataset.setValue(comparable, dataset.getValue(comparable)))
                    comparable = (Comparable)iterator.next();

                PiePlot pieplot = (PiePlot)chart.getPlot();
                pieplot.setDataset(defaultpiedataset);
                dataset = defaultpiedataset;
            }
        }

        JFreeChart chart;
        DefaultPieDataset dataset;
        boolean ascendingByKey;
        boolean ascendingByValue;

        public DemoPanel(DefaultPieDataset defaultpiedataset)
        {
            super(new BorderLayout());
            ascendingByKey = false;
            ascendingByValue = false;
            dataset = defaultpiedataset;
            chart = PieChartDemo4.createChart(defaultpiedataset);
            ChartPanel chartpanel = new ChartPanel(chart);
            add(chartpanel);
            JPanel jpanel = new JPanel(new FlowLayout());
            JButton jbutton = new JButton("By Key");
            jbutton.setActionCommand("BY_KEY");
            jbutton.addActionListener(this);
            JButton jbutton1 = new JButton("By Value");
            jbutton1.setActionCommand("BY_VALUE");
            jbutton1.addActionListener(this);
            JButton jbutton2 = new JButton("Random");
            jbutton2.setActionCommand("RANDOM");
            jbutton2.addActionListener(this);
            jpanel.add(jbutton);
            jpanel.add(jbutton1);
            jpanel.add(jbutton2);
            add(jpanel, "South");
        }
    }


    public PieChartDemo4(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static DefaultPieDataset createDataset()
    {
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("Section A", new Double(43.200000000000003D));
        defaultpiedataset.setValue("Section B", new Double(10D));
        defaultpiedataset.setValue("Section C", new Double(27.5D));
        defaultpiedataset.setValue("Section D", new Double(17.5D));
        defaultpiedataset.setValue("Section E", new Double(11D));
        defaultpiedataset.setValue("Section F", new Double(19.399999999999999D));
        return defaultpiedataset;
    }

    private static JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 4", piedataset, true, true, false);
        PiePlot pieplot = (PiePlot)jfreechart.getPlot();
        pieplot.setLabelFont(new Font("SansSerif", 0, 12));
        pieplot.setNoDataMessage("No data available");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);
        pieplot.setExplodePercent("Section D", 0.5D);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new DemoPanel(createDataset());
    }

    public static void main(String args[])
    {
        PieChartDemo4 piechartdemo4 = new PieChartDemo4("Pie Chart Demo 4");
        piechartdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(piechartdemo4);
        piechartdemo4.setVisible(true);
    }

}
