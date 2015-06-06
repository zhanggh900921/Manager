package com.zhtelecom.common.snmp.mib;

//GenJavaCodeTool自动生成的OM对象代码！
public class MibSoftwareInstallEntry implements com.zhtelecom.common.snmp.OMMappingInfo
{
    private int hrSWInstalledIndex;

    private String hrSWInstalledName;

    private String hrSWInstalledID;

    private int hrSWInstalledType;

    private String hrSWInstalledDate;

    public String toString()
    {
        return "hrSWInstalledIndex=" + hrSWInstalledIndex + "|" + "hrSWInstalledName=" + hrSWInstalledName + "|" +
            "hrSWInstalledID=" + hrSWInstalledID + "|" + "hrSWInstalledType=" + hrSWInstalledType + "|" +
            "hrSWInstalledDate=" + hrSWInstalledDate + "|";
    }

    public String getMappingOID()
    {
        return "1.3.6.1.2.1.25.6.3.1";
    }

    public int getHrSWInstalledIndex()
    {
        return hrSWInstalledIndex;
    }

    public void setHrSWInstalledIndex(int value)
    {
        hrSWInstalledIndex = value;
    }

    public String getHrSWInstalledName()
    {
        return hrSWInstalledName;
    }

    public void setHrSWInstalledName(String value)
    {
        hrSWInstalledName = value;
    }

    public String getHrSWInstalledID()
    {
        return hrSWInstalledID;
    }

    public void setHrSWInstalledID(String value)
    {
        hrSWInstalledID = value;
    }

    public int getHrSWInstalledType()
    {
        return hrSWInstalledType;
    }

    public void setHrSWInstalledType(int value)
    {
        hrSWInstalledType = value;
    }

    public String getHrSWInstalledDate()
    {
        return hrSWInstalledDate;
    }

    public void setHrSWInstalledDate(String value)
    {
        hrSWInstalledDate = value;
    }
}
