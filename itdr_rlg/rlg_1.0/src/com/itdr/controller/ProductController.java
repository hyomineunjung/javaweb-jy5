package com.itdr.controller;
import static com.itdr.common.Const.*;
import com.itdr.common.ResponseCode;
import com.itdr.service.ProductService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage/product/*")
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ResponseCode rs = null;

        //怎么获取请求路径信息
        String pathInfo = request.getPathInfo();
        String path = PathUtils.getPath(pathInfo);

        switch (path) {
            case "list":
                rs = getAll(request);
                break;
            case "search":
                rs = SerachProduct(request);
                break;
            case "detail":
                rs = detail(request);
                break;
            case "shangjia":
                rs = shangjia(request);
                break;
            case "xiajia":
                rs = xiajia(request);
                break;
            case "add":
                rs = add(request);
                break;
            case "update":
                rs = gengxin(request);
                break;

        }
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
    }

    private ProductService ps = new ProductService();


    //模糊查询


    //更新商品
    private ResponseCode gengxin(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("pname");
        Integer status = Integer.parseInt(request.getParameter("status"));
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String price = request.getParameter("price");
        String cuxiao = request.getParameter("cuxiao");
        if (id==0||pname==null){
            ResponseCode qs=new ResponseCode();
            qs.setStatus(PRODUCT_NONE_CODE);
            qs.setMag(PRODUCT_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.gengxin(id, pname, status, categoryId, price, cuxiao);
        return rs;
    }


    //新增商品
    private ResponseCode add(HttpServletRequest request) {
        //获取参数
        Integer id = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("pname");
        Integer status = Integer.parseInt(request.getParameter("status"));
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String price = request.getParameter("price");
        String cuxiao = request.getParameter("cuxiao");
        if (id==0||pname==null||price==null){
            ResponseCode qs=new ResponseCode();
            qs.setStatus(PRODUCT_NONE_CODE);
            qs.setMag(PRODUCT_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.add(id, pname, status, categoryId, price, cuxiao);
        return rs;
    }


    //上架
    private ResponseCode shangjia(HttpServletRequest request) {
        //获取参数
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (id==0){
            ResponseCode qs=new ResponseCode();
            qs.setStatus(PRODUCT_NONE_CODE);
            qs.setMag(PRODUCT_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.shangjia(id);
        return rs;
    }


    //下架

    private ResponseCode xiajia(HttpServletRequest request) {
        //获取参数
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (id==0){
            ResponseCode qs=new ResponseCode();
            qs.setStatus(PRODUCT_NONE_CODE);
            qs.setMag(PRODUCT_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.xiajia(id);
        return rs;
    }
    //商品详情
    private ResponseCode detail(HttpServletRequest request) {
        //获取参数
        Integer id = Integer.parseInt(request.getParameter("id"));
        //调用业务层
        ResponseCode rs = ps.detail(id);
        return rs;
    }


    //       8/6调试 搜索商品 是否可以输入 id或者pname其中一个
    // 成功

    //搜索商品
    private ResponseCode SerachProduct(HttpServletRequest request) {
        //获取参数
        String pname = request.getParameter("pname");
        //调用业务层
        if (request.getParameter("id") == null) {
            ResponseCode rs = ps.SearchProduct(pname);
            return rs;
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResponseCode rs = ps.SearchProduct(id);
        return rs;
    }


    //查询所有商品
    private ResponseCode getAll(HttpServletRequest request) {
        //获取参数
//        String pageSize = request.getParameter("pageSize");
//        String pageNum = request.getParameter("pageNum");

        //调用业务层
        ResponseCode rs = ps.getAll();
        return rs;
    }
}
