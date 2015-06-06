package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibUDPEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private String udpLocalAddress;

    private int udpLocalPort;

    public String toString()
    {
        return "udpLocalAddress=" + udpLocalAddress + "|" + "udpLocalPort=" + udpLocalPort + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.7.5.1";
    }

    public String getUdpLocalAddress()
    {
        return udpLocalAddress;
    }

    public void setUdpLocalAddress(String value)
    {
        udpLocalAddress = value;
    }

    public int getUdpLocalPort()
    {
        return udpLocalPort;
    }

    public void setUdpLocalPort(int value)
    {
        udpLocalPort = value;
    }
}
