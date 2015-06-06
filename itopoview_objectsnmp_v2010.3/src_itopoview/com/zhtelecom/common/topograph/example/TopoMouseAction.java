package com.zhtelecom.common.topograph.example;

import javax.swing.JPopupMenu;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoLink;
import com.zhtelecom.common.topograph.TopoMouseHandle;
import com.zhtelecom.common.topograph.TopoNetwork;
import com.zhtelecom.common.topograph.TopoNode;
import com.zhtelecom.common.topograph.TopoObject;
import com.zhtelecom.common.topograph.TopoTreeView;
import com.zhtelecom.common.topograph.example.menuaction.ActionAddAlarm;
import com.zhtelecom.common.topograph.impl.ActionAlarmThreadTest;
import com.zhtelecom.common.topograph.example.menuaction.ActionAlarmDel;
import com.zhtelecom.common.topograph.example.menuaction.ActionAlarmView;
import com.zhtelecom.common.topograph.example.menuaction.ActionBatchAddNodeTest;
import com.zhtelecom.common.topograph.example.menuaction.ActionLinkUpdate;
import com.zhtelecom.common.topograph.example.menuaction.ActionNetworkAdd;
import com.zhtelecom.common.topograph.example.menuaction.ActionNetworkNodeLinkDel;
import com.zhtelecom.common.topograph.example.menuaction.ActionNodeAdd;
import com.zhtelecom.common.topograph.example.menuaction.ActionNodeImageUpdate;
import com.zhtelecom.common.topograph.example.menuaction.ActionPrintXY;
import com.zhtelecom.common.topograph.example.menuaction.ActionSetLinkEnd;
import com.zhtelecom.common.topograph.example.menuaction.ActionSetLinkStart;
import com.zhtelecom.common.topograph.example.menuaction.ActionUpdateUserID;
import com.zhtelecom.common.topograph.example.menuaction.ActionClearAll;
import com.zhtelecom.common.topograph.example.menuaction.ActionDelAllAlarm;
import com.zhtelecom.common.topograph.example.menuaction.ActionAlarmAddAll;

/**
 * 各种菜单、事件的处理入口。具体的事件操作在每一个Action里面。

 * @version 1.0
 */
public class TopoMouseAction implements TopoMouseHandle
{
    /**
     * 在node上面点击右键的菜单
     * @param topoView TopoGraphView
     * @return JPopupMenu
     */
    public JPopupMenu createRightClickMenu(TopoGraphView topoView)
    {
        JPopupMenu menu = new JPopupMenu();

        menu.add("右键对象:" + topoView.getSelectedObject());
        menu.addSeparator();

        //设置删除菜单
        ActionNetworkNodeLinkDel actionNetworkNodeLinkDel = new
            ActionNetworkNodeLinkDel();
        //传递topoView对象。
        actionNetworkNodeLinkDel.putValue("topoGraphView", topoView);
        menu.add(actionNetworkNodeLinkDel);

        //节点或网络才有下列菜单
        if (topoView.getSelectedObject() instanceof TopoNode)
        {
            menu.addSeparator();
            //设置连接起点菜单
            ActionSetLinkStart actionSetLinkStart = new ActionSetLinkStart();
            actionSetLinkStart.putValue("topoGraphView", topoView);
            menu.add(actionSetLinkStart);

            //设置连接终点菜单
            ActionSetLinkEnd actionSetLinkEnd = new ActionSetLinkEnd();
            actionSetLinkEnd.putValue("topoGraphView", topoView);
            menu.add(actionSetLinkEnd);

            menu.addSeparator();
            //设置修改图片菜单
            ActionNodeImageUpdate actionNodeImageUpdate = new
                ActionNodeImageUpdate();
            actionNodeImageUpdate.putValue("topoGraphView", topoView);
            menu.add(actionNodeImageUpdate);

        }

        //Link有下列菜单
        if (topoView.getSelectedObject() instanceof TopoLink)
        {
            menu.addSeparator();
            ActionLinkUpdate actionLinkUpdate = new ActionLinkUpdate();
            actionLinkUpdate.putValue("topoGraphView", topoView);
            menu.add(actionLinkUpdate);

        }

        menu.addSeparator();
        //设置告警添加菜单
        ActionAddAlarm actionAddAlarm = new ActionAddAlarm();
        actionAddAlarm.putValue("topoGraphView", topoView);
        menu.add(actionAddAlarm);

        //设置告警清除菜单
        ActionAlarmDel actionAlarmDel = new ActionAlarmDel();
        actionAlarmDel.putValue("topoGraphView", topoView);
        menu.add(actionAlarmDel);

        //设置告警显示菜单
        ActionAlarmView actionAlarmView = new ActionAlarmView();
        actionAlarmView.putValue("topoGraphView", topoView);
        menu.add(actionAlarmView);

        //设置修改用户ID菜单
        menu.addSeparator();
        ActionUpdateUserID actionUpdateUserID = new ActionUpdateUserID();
        actionUpdateUserID.putValue("topoGraphView", topoView);
        menu.add(actionUpdateUserID);

        return menu;

    }

    /**
     * 在空白区域点击右键的菜单。
     * @param topoView TopoGraphView
     * @return JPopupMenu
     */
    public JPopupMenu createRightClickBlankMenu(TopoGraphView topoView)
    {
        JPopupMenu menu = new JPopupMenu();

        TopoNetwork net = topoView.getCurrentNetwork();
        String netName = "";
        if (net == null)
        {
            netName = TopoTreeView.topoTreeRootObject;
        } else
        {
            netName = net.toString();
        }

        menu.add("右键空白区域，当前网络：" + netName);

        menu.addSeparator();

        //  设置网络添加菜单
        ActionNetworkAdd actionNetworkAdd = new ActionNetworkAdd();
        actionNetworkAdd.putValue("topoGraphView", topoView);
        menu.add(actionNetworkAdd);

        //设置节点添加菜单
        ActionNodeAdd actionNodeAdd = new ActionNodeAdd();
        actionNodeAdd.putValue("topoGraphView", topoView);
        menu.add(actionNodeAdd);

        menu.addSeparator();

        //设置拓扑图批量添加菜单
        ActionBatchAddNodeTest actionBatchAddTest = new ActionBatchAddNodeTest();
        actionBatchAddTest.putValue("topoGraphView", topoView);
        menu.add(actionBatchAddTest);


        ActionClearAll actionclearall = new ActionClearAll();
        actionclearall.putValue("topoGraphView", topoView);
        menu.add(actionclearall);


        ActionAlarmAddAll actionAlarmAddAll = new ActionAlarmAddAll();
        actionAlarmAddAll.putValue("topoGraphView", topoView);
        menu.add(actionAlarmAddAll);


        ActionDelAllAlarm actionDelAllAlarm = new ActionDelAllAlarm();
        actionDelAllAlarm.putValue("topoGraphView", topoView);
        menu.add(actionDelAllAlarm);

        menu.addSeparator();
        //设置打印坐标菜单
        ActionPrintXY actionPrintXY = new ActionPrintXY();
        actionPrintXY.putValue("topoGraphView", topoView);
        menu.add(actionPrintXY);
        return menu;


    }

    //双击事件
    public void doubleClickAction(TopoGraphView topoView)
    {
        TopoObject obj = topoView.getSelectedObject();

        if (null == obj)
        {
            String name = (topoView.getCurrentNetwork() != null) ? topoView.getCurrentNetwork().toString() :
                TopoTreeView.topoTreeRootObject;
            javax.swing.JOptionPane.showMessageDialog(topoView, "当前显示网络:" + name, "双击空白区域", javax.swing.JOptionPane.
                INFORMATION_MESSAGE);
            return;
        }

        String parentName = (obj.getParent() != null) ? obj.getParent().toString() : TopoTreeView.topoTreeRootObject;

        if (obj instanceof TopoNetwork)
        {
            TopoNetwork net = (TopoNetwork) obj;
            javax.swing.JOptionPane.showMessageDialog(topoView,
                "网络名：" +
                net.toString() +
                "   ；下级对象" + net.getChildren().size() +
                "个  ；上级网络:" + parentName +
                "    ;网络所有告警个数:" + net.getAllAlarms().size() + "个" +
                "(其中，本身告警" + net.getThisNetworkAlarms().size() +
                "，下级告警" + net.getAllChildAlarms().size() + "个)",
                "双击操作",
                javax.swing.JOptionPane.
                INFORMATION_MESSAGE);

        } else
        {
            javax.swing.JOptionPane.showMessageDialog(topoView,
                "对象：" +
                obj.toString() +
                "  ；上级网络:" + parentName +
                "    本对象告警个数：" + obj.getAllAlarms().size(),
                "双击操作",
                javax.swing.JOptionPane.
                INFORMATION_MESSAGE);

        }

    }

}
