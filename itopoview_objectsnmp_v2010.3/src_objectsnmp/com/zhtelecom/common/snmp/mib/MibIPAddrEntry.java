package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibIPAddrEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private String ipAdEntAddr;

    private int ipAdEntIfIndex;

    private String ipAdEntNetMask;

    private int ipAdEntBcastAddr;

    private int ipAdEntReasmMaxSize;

    public String toString()
    {
        return "ipAdEntAddr=" + ipAdEntAddr + "|" + "ipAdEntIfIndex=" + ipAdEntIfIndex + "|" + "ipAdEntNetMask=" +
            ipAdEntNetMask + "|" + "ipAdEntBcastAddr=" + ipAdEntBcastAddr + "|" + "ipAdEntReasmMaxSize=" +
            ipAdEntReasmMaxSize + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.4.20.1";
    }

    public String getIpAdEntAddr()
    {
        return ipAdEntAddr;
    }

    public void setIpAdEntAddr(String value)
    {
        ipAdEntAddr = value;
    }

    public int getIpAdEntIfIndex()
    {
        return ipAdEntIfIndex;
    }

    public void setIpAdEntIfIndex(int value)
    {
        ipAdEntIfIndex = value;
    }

    public String getIpAdEntNetMask()
    {
        return ipAdEntNetMask;
    }

    public void setIpAdEntNetMask(String value)
    {
        ipAdEntNetMask = value;
    }

    public int getIpAdEntBcastAddr()
    {
        return ipAdEntBcastAddr;
    }

    public void setIpAdEntBcastAddr(int value)
    {
        ipAdEntBcastAddr = value;
    }

    public int getIpAdEntReasmMaxSize()
    {
        return ipAdEntReasmMaxSize;
    }

    public void setIpAdEntReasmMaxSize(int value)
    {
        ipAdEntReasmMaxSize = value;
    }
}
