package com.zhtelecom.common.snmp.test;

import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;

/**
 * 此测试需要路由器的SNMP Agent支持或支持OSPF-MIB的设备。
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class SetGetTest
{
    SNMPAPI snmpapi;

    SNMPTarget nodeParam;

    public SetGetTest()
    {
        try
        {
            /**
             * 初始化系统日志文件。
             */
            MyLog.initLogParam("SNMPTest");
            //使用客户端模式。需要先启用ObjectSNMP的RMI服务（例如：运行RMISNMPServer.java）。
            //SNMPFactory.init(SNMPFactory.Mode_Client, "127.0.0.1");

            //使用本地模式。
            SNMPFactory.init(SNMPFactory.Mode_Local, null);

            // 获取SNMP API
            snmpapi = SNMPFactory.getSNMPAPI();

            SNMPFactory.loadMib("OSPF-MIB");

            //设置SNMP Agent连接参数
            nodeParam = new SNMPTarget();
            nodeParam.nodeIP = "127.0.0.1";
            nodeParam.port = 166;
            nodeParam.writeCommunity = "private";

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public void testGetOID()
    {
        try
        {
            String v = snmpapi.getOIDValue("1.3.6.1.2.1.2.2.1.2.1", nodeParam);
            System.out.println(v);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void testGetNextOID()
    {
        try
        {
            String v = snmpapi.getNextOIDValue("1.3.6.1.2.1.1.2.0", nodeParam);
            System.out.println(v);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void testUpdateSystem()
    {
        try
        {
            MibSystem mib = new MibSystem();
            mib.setSysName("objectsnmp");
            mib.setSysUpTime(111);
            snmpapi.update(mib, nodeParam);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void testIf()
    {
        try
        {

            MibIfEntry entry = new MibIfEntry();
            entry.setIfIndex(1);
            Object obj = snmpapi.getMibObject(entry, nodeParam);
            System.out.println(obj);
            entry = (MibIfEntry) obj;
            entry.setIfAdminStatus(1);
            snmpapi.update(entry, nodeParam);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void testAddTableOspf()
    {
        try
        {
            MibOspfStubAreaEntry ospf = new MibOspfStubAreaEntry();
            ospf.setOspfStubAreaId("192.168.9.0");
            ospf.setOspfStubTOS(3);
            ospf.setOspfStubStatus(SNMPAPI.RowStatusEntryAdd); //设置snmp rowstatus的值为添加语义。
            ospf.setOspfStubMetric(1);
            ospf.setOspfStubMetricType(2);

            snmpapi.addTableRow(ospf, nodeParam);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void testUpdateTableOspf()
    {
        try
        {
            MibOspfStubAreaEntry ospf = new MibOspfStubAreaEntry();
            ospf.setOspfStubAreaId("192.168.9.0");
            ospf.setOspfStubTOS(3);
            ospf.setOspfStubStatus(SNMPAPI.RowStatusEntryActive); //设置snmp rowstatus的值为激活语义。
            ospf.setOspfStubMetric(3);
            ospf.setOspfStubMetricType(3);

            snmpapi.update(ospf, nodeParam);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void testdelTableOspf()
    {
        try
        {
            MibOspfStubAreaEntry ospf = new MibOspfStubAreaEntry();
            ospf.setOspfStubAreaId("192.168.9.0");
            ospf.setOspfStubTOS(3);
            ospf.setOspfStubStatus(SNMPAPI.RowStatusEntryDel); //设置snmp rowstatus的值为删除语义。
            ospf.setOspfStubMetric(3);
            ospf.setOspfStubMetricType(3);

            snmpapi.delTableRow(ospf, nodeParam);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * 在本机测试从windows xp的SNMP Agent查询数据。（参见如何启动xp的SNMP Agent服务）
     * @param args String[]
     */
    public static void main(String args[])
    {
        try
        {

            SetGetTest test = new SetGetTest();
            test.testGetOID();
            test.testGetNextOID();
            test.testUpdateSystem();
            test.testIf();
            test.testAddTableOspf();
            test.testUpdateTableOspf();
            test.testdelTableOspf();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
