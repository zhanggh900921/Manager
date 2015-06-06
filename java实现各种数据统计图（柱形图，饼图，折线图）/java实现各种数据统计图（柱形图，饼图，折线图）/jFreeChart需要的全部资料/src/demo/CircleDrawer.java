



package demo;

import java.awt.*;
import java.awt.geom.*;
import org.jfree.ui.Drawable;

public class CircleDrawer
    implements Drawable
{

    public CircleDrawer(Paint paint, Stroke stroke, Paint paint1)
    {
        outlinePaint = paint;
        outlineStroke = stroke;
        fillPaint = paint1;
    }

    public void draw(Graphics2D graphics2d, Rectangle2D rectangle2d)
    {
        java.awt.geom.Ellipse2D.Double double1 = new java.awt.geom.Ellipse2D.Double(rectangle2d.getX(), rectangle2d.getY(), rectangle2d.getWidth(), rectangle2d.getHeight());
        if(fillPaint != null)
        {
            graphics2d.setPaint(fillPaint);
            graphics2d.fill(double1);
        }
        if(outlinePaint != null && outlineStroke != null)
        {
            graphics2d.setPaint(outlinePaint);
            graphics2d.setStroke(outlineStroke);
            graphics2d.draw(double1);
        }
        graphics2d.setPaint(Color.black);
        graphics2d.setStroke(new BasicStroke(1.0F));
        java.awt.geom.Line2D.Double double2 = new java.awt.geom.Line2D.Double(rectangle2d.getCenterX(), rectangle2d.getMinY(), rectangle2d.getCenterX(), rectangle2d.getMaxY());
        java.awt.geom.Line2D.Double double3 = new java.awt.geom.Line2D.Double(rectangle2d.getMinX(), rectangle2d.getCenterY(), rectangle2d.getMaxX(), rectangle2d.getCenterY());
        graphics2d.draw(double2);
        graphics2d.draw(double3);
    }

    private Paint outlinePaint;
    private Stroke outlineStroke;
    private Paint fillPaint;
}
