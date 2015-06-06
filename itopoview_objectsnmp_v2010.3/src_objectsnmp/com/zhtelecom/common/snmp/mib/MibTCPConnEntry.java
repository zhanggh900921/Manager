package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibTCPConnEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private int tcpConnState;

    private String tcpConnLocalAddress;

    private int tcpConnLocalPort;

    private String tcpConnRemAddress;

    private int tcpConnRemPort;

    public String toString()
    {
        return "tcpConnState=" + tcpConnState + "|" + "tcpConnLocalAddress=" + tcpConnLocalAddress + "|" +
            "tcpConnLocalPort=" + tcpConnLocalPort + "|" + "tcpConnRemAddress=" + tcpConnRemAddress + "|" +
            "tcpConnRemPort=" + tcpConnRemPort + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.6.13.1";
    }

    public int getTcpConnState()
    {
        return tcpConnState;
    }

    public void setTcpConnState(int value)
    {
        tcpConnState = value;
    }

    public String getTcpConnLocalAddress()
    {
        return tcpConnLocalAddress;
    }

    public void setTcpConnLocalAddress(String value)
    {
        tcpConnLocalAddress = value;
    }

    public int getTcpConnLocalPort()
    {
        return tcpConnLocalPort;
    }

    public void setTcpConnLocalPort(int value)
    {
        tcpConnLocalPort = value;
    }

    public String getTcpConnRemAddress()
    {
        return tcpConnRemAddress;
    }

    public void setTcpConnRemAddress(String value)
    {
        tcpConnRemAddress = value;
    }

    public int getTcpConnRemPort()
    {
        return tcpConnRemPort;
    }

    public void setTcpConnRemPort(int value)
    {
        tcpConnRemPort = value;
    }
}
