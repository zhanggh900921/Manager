package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibIPRouterEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private String ipRouteDest;

    private int ipRouteIfIndex;

    private int ipRouteMetric1;

    private int ipRouteMetric2;

    private int ipRouteMetric3;

    private int ipRouteMetric4;

    private String ipRouteNextHop;

    private int ipRouteType;

    private int ipRouteProto;

    private int ipRouteAge;

    private String ipRouteMask;

    private int ipRouteMetric5;

    private String ipRouteInfo;

    public String toString()
    {
        return "ipRouteDest=" + ipRouteDest + "|" + "ipRouteIfIndex=" + ipRouteIfIndex + "|" + "ipRouteMetric1=" +
            ipRouteMetric1 + "|" + "ipRouteMetric2=" + ipRouteMetric2 + "|" + "ipRouteMetric3=" + ipRouteMetric3 + "|" +
            "ipRouteMetric4=" + ipRouteMetric4 + "|" + "ipRouteNextHop=" + ipRouteNextHop + "|" + "ipRouteType=" +
            ipRouteType + "|" + "ipRouteProto=" + ipRouteProto + "|" + "ipRouteAge=" + ipRouteAge + "|" +
            "ipRouteMask=" + ipRouteMask + "|" + "ipRouteMetric5=" + ipRouteMetric5 + "|" + "ipRouteInfo=" +
            ipRouteInfo + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.4.21.1";
    }

    public String getIpRouteDest()
    {
        return ipRouteDest;
    }

    public void setIpRouteDest(String value)
    {
        ipRouteDest = value;
    }

    public int getIpRouteIfIndex()
    {
        return ipRouteIfIndex;
    }

    public void setIpRouteIfIndex(int value)
    {
        ipRouteIfIndex = value;
    }

    public int getIpRouteMetric1()
    {
        return ipRouteMetric1;
    }

    public void setIpRouteMetric1(int value)
    {
        ipRouteMetric1 = value;
    }

    public int getIpRouteMetric2()
    {
        return ipRouteMetric2;
    }

    public void setIpRouteMetric2(int value)
    {
        ipRouteMetric2 = value;
    }

    public int getIpRouteMetric3()
    {
        return ipRouteMetric3;
    }

    public void setIpRouteMetric3(int value)
    {
        ipRouteMetric3 = value;
    }

    public int getIpRouteMetric4()
    {
        return ipRouteMetric4;
    }

    public void setIpRouteMetric4(int value)
    {
        ipRouteMetric4 = value;
    }

    public String getIpRouteNextHop()
    {
        return ipRouteNextHop;
    }

    public void setIpRouteNextHop(String value)
    {
        ipRouteNextHop = value;
    }

    public int getIpRouteType()
    {
        return ipRouteType;
    }

    public void setIpRouteType(int value)
    {
        ipRouteType = value;
    }

    public int getIpRouteProto()
    {
        return ipRouteProto;
    }

    public void setIpRouteProto(int value)
    {
        ipRouteProto = value;
    }

    public int getIpRouteAge()
    {
        return ipRouteAge;
    }

    public void setIpRouteAge(int value)
    {
        ipRouteAge = value;
    }

    public String getIpRouteMask()
    {
        return ipRouteMask;
    }

    public void setIpRouteMask(String value)
    {
        ipRouteMask = value;
    }

    public int getIpRouteMetric5()
    {
        return ipRouteMetric5;
    }

    public void setIpRouteMetric5(int value)
    {
        ipRouteMetric5 = value;
    }

    public String getIpRouteInfo()
    {
        return ipRouteInfo;
    }

    public void setIpRouteInfo(String value)
    {
        ipRouteInfo = value;
    }
}
