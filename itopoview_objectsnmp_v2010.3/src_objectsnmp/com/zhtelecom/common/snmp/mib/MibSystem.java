package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibSystem implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private String sysDescr;

    private String sysObjectID;

    private long sysUpTime;

    private String sysContact;

    private String sysName;

    private String sysLocation;

    private int sysServices;

    public String toString()
    {
        return "sysDescr=" + sysDescr + "|" + "sysObjectID=" + sysObjectID + "|" + "sysUpTime=" + sysUpTime + "|" +
            "sysContact=" + sysContact + "|" + "sysName=" + sysName + "|" + "sysLocation=" + sysLocation + "|" +
            "sysServices=" + sysServices + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.1";
    }

    public String getSysDescr()
    {
        return sysDescr;
    }

    public void setSysDescr(String value)
    {
        sysDescr = value;
    }

    public String getSysObjectID()
    {
        return sysObjectID;
    }

    public void setSysObjectID(String value)
    {
        sysObjectID = value;
    }

    public long getSysUpTime()
    {
        return sysUpTime;
    }

    public void setSysUpTime(long value)
    {
        sysUpTime = value;
    }

    public String getSysContact()
    {
        return sysContact;
    }

    public void setSysContact(String value)
    {
        sysContact = value;
    }

    public String getSysName()
    {
        return sysName;
    }

    public void setSysName(String value)
    {
        sysName = value;
    }

    public String getSysLocation()
    {
        return sysLocation;
    }

    public void setSysLocation(String value)
    {
        sysLocation = value;
    }

    public int getSysServices()
    {
        return sysServices;
    }

    public void setSysServices(int value)
    {
        sysServices = value;
    }
}
