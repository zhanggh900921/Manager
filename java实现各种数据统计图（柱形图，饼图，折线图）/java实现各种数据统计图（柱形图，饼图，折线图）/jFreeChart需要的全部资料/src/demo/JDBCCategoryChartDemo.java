



package demo;

import java.awt.Color;
import java.io.PrintStream;
import java.sql.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JDBCCategoryChartDemo extends ApplicationFrame
{

    public JDBCCategoryChartDemo(String s)
    {
        super(s);
        CategoryDataset categorydataset = readData();
        JFreeChart jfreechart = ChartFactory.createBarChart3D("JDBC Category Chart Demo", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.yellow);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        setContentPane(chartpanel);
    }

    private CategoryDataset readData()
    {
        JDBCCategoryDataset jdbccategorydataset = null;
        String s = "jdbc:postgresql://localhost/jfreechartdb";
        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            System.err.print("ClassNotFoundException: ");
            System.err.println(classnotfoundexception.getMessage());
        }
        try
        {
            Connection connection = DriverManager.getConnection(s, "jfreechart", "password");
            jdbccategorydataset = new JDBCCategoryDataset(connection);
            String s1 = "SELECT * FROM CATEGORYDATA1;";
            System.out.println("Once...");
            jdbccategorydataset.executeQuery(s1);
            System.out.println("Again...");
            jdbccategorydataset.executeQuery(s1);
            System.out.println("Done.");
            connection.close();
        }
        catch(SQLException sqlexception)
        {
            System.err.print("SQLException: ");
            System.err.println(sqlexception.getMessage());
        }
        catch(Exception exception)
        {
            System.err.print("Exception: ");
            System.err.println(exception.getMessage());
        }
        return jdbccategorydataset;
    }

    public static void main(String args[])
    {
        JDBCCategoryChartDemo jdbccategorychartdemo = new JDBCCategoryChartDemo("JDBC Category Chart Demo");
        jdbccategorychartdemo.pack();
        RefineryUtilities.centerFrameOnScreen(jdbccategorychartdemo);
        jdbccategorychartdemo.setVisible(true);
    }
}
