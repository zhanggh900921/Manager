package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibProcessorEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private String hrProcessorFrwID;

    private int hrProcessorLoad;

    public String toString()
    {
        return "hrProcessorFrwID=" + hrProcessorFrwID + "|" + "hrProcessorLoad=" + hrProcessorLoad + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.25.3.3.1";
    }

    public String getHrProcessorFrwID()
    {
        return hrProcessorFrwID;
    }

    public void setHrProcessorFrwID(String value)
    {
        hrProcessorFrwID = value;
    }

    public int getHrProcessorLoad()
    {
        return hrProcessorLoad;
    }

    public void setHrProcessorLoad(int value)
    {
        hrProcessorLoad = value;
    }
}
