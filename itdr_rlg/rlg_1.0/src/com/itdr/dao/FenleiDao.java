package com.itdr.dao;

import com.itdr.pojo.FenLei;
import com.itdr.pojo.Product;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FenleiDao {


    //全部节点
    public List<FenLei> selectAll() {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from fenlei";
        List<FenLei> a = null;
        try {
            a = qr.query(sql, new BeanListHandler<FenLei>(FenLei.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //新增节点
    public int add(Integer id, String parentId, String name, String status, String sortorder) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "insert into fenlei (id,parentId,name,status,sortorder)values(?,?,?,?,?)";
        int a = 0;
        id = null;
        try {
            a = qr.update(sql, id, parentId, name, status, sortorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //核对节点
    public FenLei hedui(Integer id, String name) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select id,pname from fenlei where id=? and pname=?";
        FenLei a = null;
        try {
            a = qr.query(sql, new BeanHandler<FenLei>(FenLei.class), id, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public FenLei hedui(Integer id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select id,name from fenlei where id=?";
        FenLei a = null;
        try {
            a = qr.query(sql, new BeanHandler<FenLei>(FenLei.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //修改节点名
    public int gengxin(Integer id, String name) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "Update fenlei set name=? where id = ?";
        int a = 0;
        try {
            a = qr.update(sql, name, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //递归
//    @Override
//    public ServerResponse<FenLei> getAllChilds(Integer parentId) {
//        //非空校验
//        if(parentId == null){
//            ServerResponse.createServerResponseByError("参数不能为空！");
//        }
//        List<FenLei> list = getFirstLevalChilds(parentId);
//        return ServerResponse.createServerResponseBySuccess(list);
//    }
//
//    @Override
//    public ServerResponse getDeepCategory(Integer parentId) {
//        //非空校验
//        if(parentId == null){
//            ServerResponse.createServerResponseByError("参数不能为空！");
//        }
//        List<Integer> list = new ArrayList<>();
//        list.add(parentId);
//        getDeepChilds(parentId,list);
//        return ServerResponse.createServerResponseBySuccess(list);
//    }
//
//    private void getDeepChilds(Integer parentId,List<Integer> ids){
//        List<Integer> list = categoryMapper.getChildIds(parentId);
//        if(list != null && list.size() != 0){
//            for (Integer c : list){
//                ids.add(c);
//                getDeepChilds(c,ids);
//            }
//        }
//    }
//
//    private List<FenLei> getFirstLevalChilds(Integer parentId){
//        List<FenLei> list = categoryMapper.getChilds(parentId);
//        if(list != null && list.size() != 0){
//            for (FenLei c : list){
//                c.setChilds(getFirstLevalChilds(c.getId()));
//            }
//        }
//        return list;
//    }

    public List<FenLei> getAll(Integer id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from fenlei where id=?";
        List<FenLei> a = null;
        try {
            a = qr.query(sql, new BeanListHandler<FenLei>(FenLei.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //获取子节点
    public List<FenLei> ssjd(String id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from fenlei where parentId=?";
        List<FenLei> a = null;
        try {
            a = qr.query(sql,new BeanListHandler<FenLei>(FenLei.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


//    //查询子节点
//    public static List<FenLei> cxzjd(List<Integer> a) {
//        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
//        String sql = "select id from fenlei where parentId=?";
//        List<FenLei> c = null;
//        List<Integer> e = null;
//        try {
//            for (Integer b : a
//                    ) {
//                c.add(qr.query(sql, new BeanHandler<FenLei>(FenLei.class), b));
//            }
//            for (FenLei d : c
//                    ) {
//                e.add(d.getId());
//            }
//        } catch (SQLException m) {
//            m.printStackTrace();
//        }
//        return c;
//    }
}
