package com.zhtelecom.common.snmp.test;

import java.awt.*;
import javax.swing.*;

import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.action.*;
import com.zhtelecom.common.topograph.*;

//运行此示例，需要在Windows XP上启用SNMP Agent服务或从支持SNMP的设备上获取。
//在GUI界面测试获取SNMP数据的例子。如获取网络、IP、UDP、TCP、SNMP系统、IP地址、CPU、内存、磁盘、软件等信息。
//<p>Copyright: www.zhtelecom.com Copyright (c) 2007</p>
public class GetObjectGuiTest extends JApplet
{
    /**
     * WEB Applet小程序初始化接口。也是Application应用程序的初始化接口。
     * 构建拓扑图框架。
     */
    public void init()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            //创建数据源
            TopoDataSource source = new TopoDataSource();

            //通过数据源创建拓扑视图。
            TopoGraphView topoView = new TopoGraphView(source);

            //初始化图形界面。Swing技术。
            JScrollPane sGraph = new JScrollPane(topoView);

            //设置拓扑图视图的事件处理程序。
            HelloMouseAction menuHandle = new HelloMouseAction();
            topoView.setMouseHandle(menuHandle);

            this.getContentPane().setLayout(new BorderLayout());
            this.getContentPane().add(sGraph, BorderLayout.CENTER);
            //this.setVisible(true);
            SNMPBaseAction.setFrame(getAppletFrame());
            this.getParent();
            //最后一步，单独加载拓扑数据。(也可以选择先加载拓扑数据，再构造拓扑视图)
            processData(topoView);
            SNMPFactory.init(SNMPFactory.Mode_Local, null);

        } catch (Exception ex)
        {
            DialogTools.showErroMsgFromEx(this, "初始化系统错误", ex);
            ex.printStackTrace();
        }
    }

    private Frame getAppletFrame()
    {
        Container c = getParent();
        while (c != null)
        {
            if (c instanceof Frame)
            {
                return (Frame) c;
            }
            c = c.getParent();
        }
        return null;
    }

    /**
     * 单独集中处理拓扑数据。
     * 将拓扑图的数据处理与界面显示分开处理。
     *
     */
    private void processData(TopoGraphView topoView)
    {
        //获取数据源
        TopoDataSource source = topoView.getTopoDataSource();
        TopoNode nodePC = new TopoNode(new StringBuffer("127.0.0.1")); //定义PC设备
        nodePC.setX(188);
        nodePC.setY(188);
        source.addTopoData(nodePC);
    }

    public static SNMPTarget getTarget()
    {
        SNMPTarget target = new SNMPTarget();
        TopoGraphView topoview = TopoGraphView.getContextGraphView();
        if (topoview == null)
        {
            return target;
        }
        Object userid = topoview.getSelectedObject();
        if (userid != null)
        {
            String ip = userid.toString();
            target.nodeIP = ip;
        }
        return target;
    }

    //Appliction程序入口，兼容Applet模式。
    public static void main(String[] args)
    {
        //初始化数据和图形
        GetObjectGuiTest helloApplet = new GetObjectGuiTest();
        helloApplet.init();

        //创建Application 窗口
        JFrame frame = new JFrame("ObjectSNMP获取SNMP数据演示");
        SNMPBaseAction.setFrame(frame);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(helloApplet.getContentPane());
        DialogTools.setWindowPCCenter(frame);

    }



//实现事件处理接口
class HelloMouseAction implements TopoMouseHandle
{
    //在拓扑图对象上面点击右键的菜单
    public JPopupMenu createRightClickMenu(TopoGraphView topoView)
    {
        JPopupMenu menu = new JPopupMenu();
        {
            Action action = new UpdateIPAddress();
            menu.add(action);
        }
        menu.addSeparator();

        {
            JMenu menunet = new JMenu("查看网络状态");
            {
                SNMPBaseAction action = new SNMPGetMibSystem();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetMibIfEntry();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetIfNetStatus();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetIP();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetIPAddr();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetTCPConn();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetMibUdpEntry();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetSnmp();
                action.setTarget(getTarget());
                menunet.add(action);
            }
            menu.add(menunet);

        }
        menu.addSeparator();
        {
            JMenu menuhost = new JMenu("查看主机资源状态");
            {
                SNMPBaseAction action = new SNMPGetDiskMemo();
                action.setTarget(getTarget());
                menuhost.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetMibDevice();
                action.setTarget(getTarget());
                menuhost.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetCpu();
                action.setTarget(getTarget());
                menuhost.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetInstallSw();
                action.setTarget(getTarget());
                menuhost.add(action);
            }
            {
                SNMPBaseAction action = new SNMPGetRunSW();
                action.setTarget(getTarget());
                menuhost.add(action);
            }
            menu.add(menuhost);

        }

        menu.addSeparator();
        {
            SNMPBaseAction action = new MibBrowserAction();
            action.setTarget(getTarget());
            menu.add(action);
        }
        return menu;
    }

    //在拓扑图空白区域点击右键的菜单
    public JPopupMenu createRightClickBlankMenu(TopoGraphView topoView)
    {
        return null;
    }

    //双击事件
    public void doubleClickAction(TopoGraphView topoView)
    {

    }
}
}
