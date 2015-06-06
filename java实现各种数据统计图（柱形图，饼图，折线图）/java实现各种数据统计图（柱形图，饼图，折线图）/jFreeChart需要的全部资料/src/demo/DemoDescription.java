



package demo;


public class DemoDescription
{

    public DemoDescription(String s, String s1)
    {
        className = s;
        description = s1;
    }

    public String getClassName()
    {
        return className;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return description;
    }

    private String className;
    private String description;
}
