package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.FenleiDao;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.FenLei;
import com.itdr.pojo.Product;

import java.util.ArrayList;
import java.util.List;

import static com.itdr.common.Const.*;

public class FenLeiService {
    private FenleiDao pd = new FenleiDao();

    //获取节点
    public ResponseCode getAll() {
        ResponseCode rs = null;
        List<FenLei> li = pd.selectAll();
        rs = ResponseCode.successRS(FENKUAI_SUCCESS_CODE,li);
        return rs;
    }


    //新增节点
    public ResponseCode add(Integer id, String parentId, String name, String status, String sortorder) {
        ResponseCode rs = new ResponseCode();
        FenLei b = pd.hedui(id, name);
        if (b == null) {
            int a = pd.add(id, parentId, name, status, sortorder);
            rs.setStatus(FENKUAI_SUCCESS_CODE);
            rs.setData(a);
            return rs;
        } else {
            rs.setStatus(FENKUAI_SAME_CODE);
            rs.setData(FENKUAI_SAME_MSG);
            return rs;
        }
    }


    //修改名字
    public ResponseCode gengxin(Integer id, String name) {
        ResponseCode rs = new ResponseCode();
        FenLei b = pd.hedui(id);
        if (b == null) {
            rs.setStatus(FENKUAI_NO_CODE);
            rs.setData(FENKUAI_NO_MSG);
            return rs;
        }
        int a = pd.gengxin(id, name);
        if (a == 0) {
            rs.setStatus(FENKUAI_NO_CODE);
            rs.setData("更新失败");
            return rs;
        }
        rs.setStatus(FENKUAI_SUCCESS_CODE);
        rs.setData(a);
        return rs;
    }

    public ResponseCode get(Integer id) {
        //非空判断
        List<FenLei> li=pd.getAll(id);

        getAll(id,li);
        ResponseCode rs=ResponseCode.successRS(FENKUAI_SUCCESS_CODE,li);
        return rs;
    }

    private void getAll(Integer id,List<FenLei> list){
        List<FenLei> li=pd.getAll(id);
        if (li!=null&li.size()!=0){
            for (FenLei fl:li
                 ) {
                list.add(fl);
                getAll(fl.getId(),list);
            }
        }
    }

    //获取子节点
    public ResponseCode ssjd(String id) {
            ResponseCode rs = new ResponseCode();
            List<FenLei> a = null;
            a = pd.ssjd(id);
            if (a == null) {
                rs = ResponseCode.defeatedRS(FENKUAI_NO_CODE,FENKUAI_NO_MSG);
                return rs;
            }
            rs = ResponseCode.successRS(FENKUAI_SUCCESS_CODE,a);
            return rs;
    }

//    //获取子类节点
//    public ResponseCode get(Integer id) {
//        ResponseCode rs = new ResponseCode();
//        List<Integer> a=new ArrayList<Integer>();
//        a.add(id);
//        List<FenLei> b=pd.cxzjd(a);
//
//    }

}
