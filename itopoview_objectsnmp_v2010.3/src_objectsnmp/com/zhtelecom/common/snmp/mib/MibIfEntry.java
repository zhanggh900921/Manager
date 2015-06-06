package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibIfEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private int ifIndex;

    private String ifDescr;

    private int ifType;

    private int ifMtu;

    private long ifSpeed;

    private String ifPhysAddress;

    private int ifAdminStatus;

    private int ifOperStatus;

    private long ifLastChange;

    private long ifInOctets;

    private long ifInUcastPkts;

    private long ifInNUcastPkts;

    private long ifInDiscards;

    private long ifInErrors;

    private long ifInUnknownProtos;

    private long ifOutOctets;

    private long ifOutUcastPkts;

    private long ifOutNUcastPkts;

    private long ifOutDiscards;

    private long ifOutErrors;

    private long ifOutQLen;

    private String ifSpecific;

    public String toString()
    {
        return "ifIndex=" + ifIndex + "|" + "ifDescr=" + ifDescr + "|" + "ifType=" + ifType + "|" + "ifMtu=" + ifMtu +
            "|" + "ifSpeed=" + ifSpeed + "|" + "ifPhysAddress=" + ifPhysAddress + "|" + "ifAdminStatus=" +
            ifAdminStatus + "|" + "ifOperStatus=" + ifOperStatus + "|" + "ifLastChange=" + ifLastChange + "|" +
            "ifInOctets=" + ifInOctets + "|" + "ifInUcastPkts=" + ifInUcastPkts + "|" + "ifInNUcastPkts=" +
            ifInNUcastPkts + "|" + "ifInDiscards=" + ifInDiscards + "|" + "ifInErrors=" + ifInErrors + "|" +
            "ifInUnknownProtos=" + ifInUnknownProtos + "|" + "ifOutOctets=" + ifOutOctets + "|" + "ifOutUcastPkts=" +
            ifOutUcastPkts + "|" + "ifOutNUcastPkts=" + ifOutNUcastPkts + "|" + "ifOutDiscards=" + ifOutDiscards + "|" +
            "ifOutErrors=" + ifOutErrors + "|" + "ifOutQLen=" + ifOutQLen + "|" + "ifSpecific=" + ifSpecific + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.2.2.1";
    }

    public int getIfIndex()
    {
        return ifIndex;
    }

    public void setIfIndex(int value)
    {
        ifIndex = value;
    }

    public String getIfDescr()
    {
        return ifDescr;
    }

    public void setIfDescr(String value)
    {
        ifDescr = value;
    }

    public int getIfType()
    {
        return ifType;
    }

    public void setIfType(int value)
    {
        ifType = value;
    }

    public int getIfMtu()
    {
        return ifMtu;
    }

    public void setIfMtu(int value)
    {
        ifMtu = value;
    }

    public long getIfSpeed()
    {
        return ifSpeed;
    }

    public void setIfSpeed(long value)
    {
        ifSpeed = value;
    }

    public String getIfPhysAddress()
    {
        return ifPhysAddress;
    }

    public void setIfPhysAddress(String value)
    {
        ifPhysAddress = value;
    }

    public int getIfAdminStatus()
    {
        return ifAdminStatus;
    }

    public void setIfAdminStatus(int value)
    {
        ifAdminStatus = value;
    }

    public int getIfOperStatus()
    {
        return ifOperStatus;
    }

    public void setIfOperStatus(int value)
    {
        ifOperStatus = value;
    }

    public long getIfLastChange()
    {
        return ifLastChange;
    }

    public void setIfLastChange(long value)
    {
        ifLastChange = value;
    }

    public long getIfInOctets()
    {
        return ifInOctets;
    }

    public void setIfInOctets(long value)
    {
        ifInOctets = value;
    }

    public long getIfInUcastPkts()
    {
        return ifInUcastPkts;
    }

    public void setIfInUcastPkts(long value)
    {
        ifInUcastPkts = value;
    }

    public long getIfInNUcastPkts()
    {
        return ifInNUcastPkts;
    }

    public void setIfInNUcastPkts(long value)
    {
        ifInNUcastPkts = value;
    }

    public long getIfInDiscards()
    {
        return ifInDiscards;
    }

    public void setIfInDiscards(long value)
    {
        ifInDiscards = value;
    }

    public long getIfInErrors()
    {
        return ifInErrors;
    }

    public void setIfInErrors(long value)
    {
        ifInErrors = value;
    }

    public long getIfInUnknownProtos()
    {
        return ifInUnknownProtos;
    }

    public void setIfInUnknownProtos(long value)
    {
        ifInUnknownProtos = value;
    }

    public long getIfOutOctets()
    {
        return ifOutOctets;
    }

    public void setIfOutOctets(long value)
    {
        ifOutOctets = value;
    }

    public long getIfOutUcastPkts()
    {
        return ifOutUcastPkts;
    }

    public void setIfOutUcastPkts(long value)
    {
        ifOutUcastPkts = value;
    }

    public long getIfOutNUcastPkts()
    {
        return ifOutNUcastPkts;
    }

    public void setIfOutNUcastPkts(long value)
    {
        ifOutNUcastPkts = value;
    }

    public long getIfOutDiscards()
    {
        return ifOutDiscards;
    }

    public void setIfOutDiscards(long value)
    {
        ifOutDiscards = value;
    }

    public long getIfOutErrors()
    {
        return ifOutErrors;
    }

    public void setIfOutErrors(long value)
    {
        ifOutErrors = value;
    }

    public long getIfOutQLen()
    {
        return ifOutQLen;
    }

    public void setIfOutQLen(long value)
    {
        ifOutQLen = value;
    }

    public String getIfSpecific()
    {
        return ifSpecific;
    }

    public void setIfSpecific(String value)
    {
        ifSpecific = value;
    }
}
