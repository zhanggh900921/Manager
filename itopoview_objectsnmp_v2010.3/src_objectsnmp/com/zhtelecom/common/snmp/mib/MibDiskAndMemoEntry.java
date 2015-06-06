package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibDiskAndMemoEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private int hrStorageIndex;

    private String hrStorageType;

    private String hrStorageDescr;

    private int hrStorageAllocationUnits;

    private int hrStorageSize;

    private int hrStorageUsed;

    private long hrStorageAllocationFailures;

    public String toString()
    {
        return "hrStorageIndex=" + hrStorageIndex + "|" + "hrStorageType=" + hrStorageType + "|" + "hrStorageDescr=" +
            hrStorageDescr + "|" + "hrStorageAllocationUnits=" + hrStorageAllocationUnits + "|" + "hrStorageSize=" +
            hrStorageSize + "|" + "hrStorageUsed=" + hrStorageUsed + "|" + "hrStorageAllocationFailures=" +
            hrStorageAllocationFailures + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.25.2.3.1";
    }

    public int getHrStorageIndex()
    {
        return hrStorageIndex;
    }

    public void setHrStorageIndex(int value)
    {
        hrStorageIndex = value;
    }

    public String getHrStorageType()
    {
        return hrStorageType;
    }

    public void setHrStorageType(String value)
    {
        hrStorageType = value;
    }

    public String getHrStorageDescr()
    {
        return hrStorageDescr;
    }

    public void setHrStorageDescr(String value)
    {
        hrStorageDescr = value;
    }

    public int getHrStorageAllocationUnits()
    {
        return hrStorageAllocationUnits;
    }

    public void setHrStorageAllocationUnits(int value)
    {
        hrStorageAllocationUnits = value;
    }

    public int getHrStorageSize()
    {
        return hrStorageSize;
    }

    public void setHrStorageSize(int value)
    {
        hrStorageSize = value;
    }

    public int getHrStorageUsed()
    {
        return hrStorageUsed;
    }

    public void setHrStorageUsed(int value)
    {
        hrStorageUsed = value;
    }

    public long getHrStorageAllocationFailures()
    {
        return hrStorageAllocationFailures;
    }

    public void setHrStorageAllocationFailures(long value)
    {
        hrStorageAllocationFailures = value;
    }
}
