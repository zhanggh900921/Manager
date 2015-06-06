package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibDeviceEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private int hrDeviceIndex;

    private String hrDeviceType;

    private String hrDeviceDescr;

    private String hrDeviceID;

    private int hrDeviceStatus;

    private long hrDeviceErrors;

    public String toString()
    {
        return "hrDeviceIndex=" + hrDeviceIndex + "|" + "hrDeviceType=" + hrDeviceType + "|" + "hrDeviceDescr=" +
            hrDeviceDescr + "|" + "hrDeviceID=" + hrDeviceID + "|" + "hrDeviceStatus=" + hrDeviceStatus + "|" +
            "hrDeviceErrors=" + hrDeviceErrors + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.25.3.2.1";
    }

    public int getHrDeviceIndex()
    {
        return hrDeviceIndex;
    }

    public void setHrDeviceIndex(int value)
    {
        hrDeviceIndex = value;
    }

    public String getHrDeviceType()
    {
        return hrDeviceType;
    }

    public void setHrDeviceType(String value)
    {
        hrDeviceType = value;
    }

    public String getHrDeviceDescr()
    {
        return hrDeviceDescr;
    }

    public void setHrDeviceDescr(String value)
    {
        hrDeviceDescr = value;
    }

    public String getHrDeviceID()
    {
        return hrDeviceID;
    }

    public void setHrDeviceID(String value)
    {
        hrDeviceID = value;
    }

    public int getHrDeviceStatus()
    {
        return hrDeviceStatus;
    }

    public void setHrDeviceStatus(int value)
    {
        hrDeviceStatus = value;
    }

    public long getHrDeviceErrors()
    {
        return hrDeviceErrors;
    }

    public void setHrDeviceErrors(long value)
    {
        hrDeviceErrors = value;
    }
}
