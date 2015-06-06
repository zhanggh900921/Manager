package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibSoftwareRunEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private int hrSWRunIndex;

    private String hrSWRunName;

    private String hrSWRunID;

    private String hrSWRunPath;

    private String hrSWRunParameters;

    private int hrSWRunType;

    private int hrSWRunStatus;

    public String toString()
    {
        return "hrSWRunIndex=" + hrSWRunIndex + "|" + "hrSWRunName=" + hrSWRunName + "|" + "hrSWRunID=" + hrSWRunID +
            "|" + "hrSWRunPath=" + hrSWRunPath + "|" + "hrSWRunParameters=" + hrSWRunParameters + "|" + "hrSWRunType=" +
            hrSWRunType + "|" + "hrSWRunStatus=" + hrSWRunStatus + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.25.4.2.1";
    }

    public int getHrSWRunIndex()
    {
        return hrSWRunIndex;
    }

    public void setHrSWRunIndex(int value)
    {
        hrSWRunIndex = value;
    }

    public String getHrSWRunName()
    {
        return hrSWRunName;
    }

    public void setHrSWRunName(String value)
    {
        hrSWRunName = value;
    }

    public String getHrSWRunID()
    {
        return hrSWRunID;
    }

    public void setHrSWRunID(String value)
    {
        hrSWRunID = value;
    }

    public String getHrSWRunPath()
    {
        return hrSWRunPath;
    }

    public void setHrSWRunPath(String value)
    {
        hrSWRunPath = value;
    }

    public String getHrSWRunParameters()
    {
        return hrSWRunParameters;
    }

    public void setHrSWRunParameters(String value)
    {
        hrSWRunParameters = value;
    }

    public int getHrSWRunType()
    {
        return hrSWRunType;
    }

    public void setHrSWRunType(int value)
    {
        hrSWRunType = value;
    }

    public int getHrSWRunStatus()
    {
        return hrSWRunStatus;
    }

    public void setHrSWRunStatus(int value)
    {
        hrSWRunStatus = value;
    }
}
