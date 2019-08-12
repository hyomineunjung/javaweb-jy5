package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    //产品列表
    public List<Product> selectAll() {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product";
        List<Product> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }


    //模糊查询
    public List<Product> findByText(String keyWord){
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product where pname like ?";
        List<Product> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class),keyWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //产品搜索
    public Product SearchProduct(Integer id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product where id=?";
        Product a = null;
        try {
            a = qr.query(sql, new BeanHandler<Product>(Product.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //产品搜索
    public Product SearchProduct(String pname) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product where pname=?";
        Product a = null;
        try {
            a = qr.query(sql, new BeanHandler<Product>(Product.class), pname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //产品详情
    public Product detail(Integer id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product where id=?";
        Product a = null;
        try {
            a = qr.query(sql, new BeanHandler<Product>(Product.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //上架
    public int shangjia(Integer id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "Update product set status = 1 where id = ?";
        int a = 0;
        try {
            a = qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Product hedui(Integer id, String pname) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select id,pname from product where id=? and pname=?";
        Product a = null;
        try {
            a = qr.query(sql, new BeanHandler<Product>(Product.class), id, pname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Product hedui(Integer id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select status from product where id=?";
        Product a = null;
        try {
            a = qr.query(sql, new BeanHandler<Product>(Product.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public Product hedui(String pname) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select status from product where pname=?";
        Product a = null;
        try {
            a = qr.query(sql, new BeanHandler<Product>(Product.class), pname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //新增产品
    public int add(Integer id, String pname, Integer status, Integer categoryId, String price, String cuxiao) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "insert into product (id,pname,status,categoryId,price,cuxiao)values(?,?,?,?,?,?)";
        int a = 0;
        id = null;
        try {
            a = qr.update(sql, id, pname, status, categoryId, price, cuxiao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //更新产品
    public int gengxin(Integer id, String pname, Integer status, Integer categoryId, String price, String cuxiao) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "Update product set pname=?,status=?,categoryId=?,price=?,cuxiao=? where id = ?";
        int a = 0;
        try {
            a = qr.update(sql, pname, status, categoryId, price, cuxiao, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //下架
    public int xiajia(Integer id) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "Update product set status = 0 where id = ?";
        int a = 0;
        try {
            a = qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //
}
//更新
//    Update products set categoryId=?,price=?,pname=?,mainImage=?,stats = ?,cuxiao=? where pid = ?