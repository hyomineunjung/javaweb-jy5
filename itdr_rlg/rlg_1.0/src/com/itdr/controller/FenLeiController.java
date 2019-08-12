package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.FenLeiService;
import com.itdr.service.ProductService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.itdr.common.Const.*;

@WebServlet("/manage/category/*")
public class FenLeiController extends HttpServlet {
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
            //获取所有节点
            case "get_category":
                rs = getjiedian(request);
                break;
                //查询子节点
            case "get_zjd":
                rs = getzjd(request);
                break;
            //增加节点
            case "add_category":
                rs = addjiedian(request);
                break;
            //修改类名
            case "set_category_name":
                rs = changejiedian(request);
                break;
//            获取当前分类id及递归子节点
//            case "get_deep_category":
//                rs=get(request);
//                break;

        }
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
    }

    private FenLeiService ps = new FenLeiService();

//    获取当前分类id及递归子节点
//    private ResponseCode get(HttpServletRequest request) {
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        ResponseCode rs = ps.get(id);
//        return rs;
//    }

    //修改类名
    private ResponseCode changejiedian(HttpServletRequest request) {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        if (name == null) {
            ResponseCode qs = new ResponseCode();
            qs.setStatus(FENKUAI_NONE_CODE);
            qs.setMag(FENKUAI_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.gengxin(id, name);
        return rs;
    }


    //增加节点
    private ResponseCode addjiedian(HttpServletRequest request) {
        //获取参数
        Integer id = Integer.parseInt(request.getParameter("id"));
        String parentId = request.getParameter("parentId");
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        String sortorder = request.getParameter("sortorder");
        if (parentId == null || name == null || status == null || sortorder == null) {
            ResponseCode qs = new ResponseCode();
            qs.setStatus(FENKUAI_NONE_CODE);
            qs.setMag(FENKUAI_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.add(id, parentId, name, status, sortorder);
        return rs;
    }

    //获取品类子节点
    private ResponseCode getzjd(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id == null) {
            ResponseCode qs = new ResponseCode();
            qs.setStatus(FENKUAI_NO_CODE);
            qs.setMag(FENKUAI_DO_MSG);
            return qs;
        }
        ResponseCode rs = ps.ssjd(id);
        return rs;
    }
    //获取节点
    private ResponseCode getjiedian(HttpServletRequest request) {
        //调用业务层
        ResponseCode rs = ps.getAll();
        return rs;
    }
}
