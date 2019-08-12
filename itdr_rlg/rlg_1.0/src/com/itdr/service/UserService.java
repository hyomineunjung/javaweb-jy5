package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

import static com.itdr.common.Const.*;

public class UserService {

    //状态码和信息还没改 记得抄
    //状态码和信息还没改 记得抄
    //状态码和信息还没改 记得抄

    private UserDao ud = new UserDao();

    //返回全部信息
    public ResponseCode selectAll(String pageSize, String pageNum) {
        ResponseCode rs = new ResponseCode();
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }
        UserDao ud = new UserDao();
        List<Users> li = ud.selectAll(pageSize, pageNum);

//        如果集合元素是空
        if (li == null) {
            rs = ResponseCode.defeatedRS(USER_DISPEAR_CODE, USER_DISPEAR_MSG);
            return rs;
        }
        rs = ResponseCode.successRS(USER_SUCCESS_CODE, li);
        return rs;
    }

    //管理员登录
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();
        if (username == null || username.equals("") || password == null || password.equals("")) {
//            rs.setStatus(1);
//            rs.setMag("账号或密码错误");
            rs = ResponseCode.defeatedRS(USER_PARAMETER_CODE, USER_PARAMETER_MSG);
            return rs;
        }
        //查找是否有这样一个用户
        Users u = ud.selectOne(username, password);

        //如果用户不存在
        if (u == null) {
//            rs.setStatus(1);
//            rs.setMag("账号或密码错误");
            rs = ResponseCode.defeatedRS(USER_WRONG_CODE, USER_WRONG_MSG);
            return rs;
        }
        if (u.getType() != 1) {
//            rs.setStatus(2);
//            rs.setMag("没有操作权限！");
            rs = ResponseCode.defeatedRS(USER_CANT_CODE, USER_CANT_MSG);
            return rs;
        }
//        rs.setStatus(0);
//        rs.setData(u);
        rs = ResponseCode.successRS(u);
        return rs;
    }

    //
    public ResponseCode selectOne(String uids) {
        ResponseCode rs = new ResponseCode();
        if (uids == null || uids.equals("")) {
            rs=ResponseCode.defeatedRS(USER_PARAMETER_CODE,USER_PARAMETER_MSG);
            return rs;
        }

        //字符串转数值
        Integer uid = null;
        try {
            uid = Integer.parseInt(uids);
        } catch (Exception e) {
            rs=ResponseCode.defeatedRS(USER_UN_CODE,USER_UN_MSG);
            return rs;
        }


        //查找是否有这样一个用户
        Users u = ud.selectOne(uid);

        //如果用户不存在
        if (u == null) {
//            rs.setStatus(Const.USER_NO_CODE);
//            rs.setMag(Const.USER_NO_MSG);
            rs = ResponseCode.defeatedRS(USER_NO_CODE, USER_NO_MSG);
            return rs;
        }
        //判断用户禁用情况
        if (u.getStats() == 1) {
            rs = ResponseCode.defeatedRS(USER_DISABLE_CODE, USER_DISABLE_MSG);
            return rs;
        }
        //禁用用户
        int row = ud.updateByuid(uid);

        if (row <= 0) {
//            rs.setStatus(106);
//            rs.setMag("用户禁用更新失败");
            rs = ResponseCode.defeatedRS(USER_BAN_CODE, USER_BAN_MSG);
            return rs;
        }
        rs=ResponseCode.successRS(USER_SUCCESS_CODE,row);
        return rs;
    }
}
