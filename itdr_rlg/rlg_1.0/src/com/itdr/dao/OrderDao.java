package com.itdr.dao;

import com.itdr.pojo.Order;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    //订单List
    public List<Order> selectAll() {
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());

        String sql="select * from dingdan";
        List<Order> li=null;
        try {
            li=qr.query(sql,new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //订单查询
    public Order SearchProduct(String id) {
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());

        String sql="select * from dingdan where spid=?";
        Order a=null;
        try {
            a=qr.query(sql,new BeanHandler<Order>(Order.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //订单详情
    public Order detail(String id) {
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());

        String sql="select * from dingdan where spid=?";
        Order a=null;
        try {
            a=qr.query(sql,new BeanHandler<Order>(Order.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Order hedui(String id) {
            QueryRunner qr=new QueryRunner(PoolUtil.getCom());
            String sql="select * from dingdan where spid=?";
            Order a=null;
            try {
                a=qr.query(sql,new BeanHandler<Order>(Order.class),id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return a;
    }
    //订单发货

    //这里要有网的时候去看一下字段！！！！！ 8/6
    public int fahuo(String id){
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String zt="1";

        String sql="Update dingdan set ddzt = ? where spid = ?";
        int a=0;
        try {
            a=qr.update(sql,zt,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
