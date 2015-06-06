package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibOspfStubAreaEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private String ospfStubAreaId;

    private int ospfStubTOS;

    private int ospfStubMetric;

    private int ospfStubStatus;

    private int ospfStubMetricType;

    public String toString()
    {
        return "ospfStubAreaId=" + ospfStubAreaId + "|" + "ospfStubTOS=" + ospfStubTOS + "|" + "ospfStubMetric=" +
            ospfStubMetric + "|" + "ospfStubStatus=" + ospfStubStatus + "|" + "ospfStubMetricType=" +
            ospfStubMetricType + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.14.3.1";
    }

    public String getOspfStubAreaId()
    {
        return ospfStubAreaId;
    }

    public void setOspfStubAreaId(String value)
    {
        ospfStubAreaId = value;
    }

    public int getOspfStubTOS()
    {
        return ospfStubTOS;
    }

    public void setOspfStubTOS(int value)
    {
        ospfStubTOS = value;
    }

    public int getOspfStubMetric()
    {
        return ospfStubMetric;
    }

    public void setOspfStubMetric(int value)
    {
        ospfStubMetric = value;
    }

    public int getOspfStubStatus()
    {
        return ospfStubStatus;
    }

    public void setOspfStubStatus(int value)
    {
        ospfStubStatus = value;
    }

    public int getOspfStubMetricType()
    {
        return ospfStubMetricType;
    }

    public void setOspfStubMetricType(int value)
    {
        ospfStubMetricType = value;
    }
}
