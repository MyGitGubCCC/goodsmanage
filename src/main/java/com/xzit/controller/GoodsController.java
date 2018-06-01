package com.xzit.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Goods;
import com.xzit.entity.Student;
import com.xzit.service.GoodsService;
import com.xzit.service.StudentService;
import com.xzit.until.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by caochengcheng on 2018/4/10.
 */
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "selectGoodsBySno.action")
    @ResponseBody
    public DataGrid<Goods> selectGoodsBySno(String sno, Integer page, Integer rows, HttpSession session)throws Exception{
        if (session.getAttribute("role")=="学生"){
            sno = (String) session.getAttribute("number");
        }
        PageInfo<Goods> pageInfo = goodsService.selectBySno(sno,page,rows);
        DataGrid<Goods> dataGrid = new DataGrid<Goods>();
        dataGrid.setRows(pageInfo.getList());
        dataGrid.setTotal(pageInfo.getTotal());
        return dataGrid;
    }
    //返回list型
    @RequestMapping(value = "selectGoodsListBySno.action")
    @ResponseBody
    public List<Goods> selectGoodsBySid(String sno)throws Exception{
        //如果sno没有数据，则给他赋予一个-1，让它查不到任何goods
        if (sno==null || sno=="") sno = "-1";
        List<Goods> goods = goodsService.selectGoodsListBySid(sno);
        return goods;
    }

    @RequestMapping(value = "insertOrUpdateGoods.action")
    @ResponseBody
    public void insertOrUpdateGoods(@RequestParam(value="file_upload2", required=false) MultipartFile file, String sno, Goods goods,
                                     HttpServletRequest request,HttpServletResponse response)throws Exception{
        String msg="异常";
        Student student = studentService.selectBySno(sno);
        int state=0;
        if (goods.getGoodsid()!=null){
            //保存图片
            if(file.getOriginalFilename()!=null&&file.getOriginalFilename()!="") {
                String imageUrl = savePicture(file, request);
                goods.setPictureurl(imageUrl);
            }
            try {
                state = goodsService.updateByPrimaryKeySelective(goods);
            }catch (Exception e){
                e.printStackTrace();
            }
            if (state==0) msg = "更新失败！请查看编号是否重复";
            else msg="更新成功";
        }else {
            if (student!=null){
                goods.setSid(student.getSid());
                //保存图片
                if(file.getOriginalFilename()!=null&&file.getOriginalFilename()!="") {
                    String imageUrl = savePicture(file, request);
                    goods.setPictureurl(imageUrl);
                }
                try {
                    state = goodsService.insertSelective(goods);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if (state==0) msg = "添加失败";
                else msg="添加成功";
            }else msg="添加失败！学号不正确";
        }

        JSONObject obj = new JSONObject();
        obj.put("success",true);
        obj.put("msg",msg);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(obj.toString());
    }
    //文件保存到服务器上
    protected String savePicture(MultipartFile file, HttpServletRequest request)
            throws IOException, FileNotFoundException {
        String imageUrl = "";
        //String ImagePath = request.getSession().getServletContext().getRealPath("/static/img");
        String ImagePath = ("C:/CCCC/upload/img");
        File targetfile = new File(ImagePath, file.getOriginalFilename());
        Date date = new Date(System.currentTimeMillis());
        if(targetfile.exists()){
            String[] s = file.getOriginalFilename().split("\\.");
            s[0] = date.getTime()+"";
            targetfile = new File(ImagePath, s[0] + "." + s[1]);
            imageUrl = s[0]+"."+s[1];
        }else {
            File file1 = new File(ImagePath);
            file1.mkdirs();
            String[] s = file.getOriginalFilename().split("\\.");
            s[0] = date.getTime()+"";
            targetfile = new File(ImagePath, s[0] + "." + s[1]);
            imageUrl = s[0]+"."+s[1];

        }

        InputStream ins = file.getInputStream();
        FileOutputStream fos = new FileOutputStream(targetfile);

        byte b[] = new byte[1024];
        int temp = 0;

        while((temp = ins.read(b)) != -1){
            fos.write(b, 0, temp);
        }

        fos.close();
        ins.close();

        return "/upload/img/"+imageUrl;
    }

    @RequestMapping(value = "deleteGoods.action")
    @ResponseBody
    public String  deleteGoods(int goodsid)throws Exception{
        String msg="删除失败！";

        if (goodsService.selectByPrimaryKey(goodsid)!=null){
            //删除图片
            Goods goods = new Goods();
            goods = goodsService.selectByPrimaryKey(goodsid);
            String s=goods.getPictureurl();
            if (s!=null && s!=""){
                String s1 = "C:/CCCC"+s;
                File file = new File(s1);
                file.delete();
            }
            if (goodsService.deleteByPrimaryKey(goodsid)==1){
                msg="删除成功";
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            msg = mapper.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping(value = "lookGoodsPicture.action")
    @ResponseBody
    public String  lookGoodsPicture(int goodsid)throws Exception{
        String pictureUrl=null;
        Goods goods = new Goods();
        try {
            goods = goodsService.selectByPrimaryKey(goodsid);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (goods.getPictureurl()!=null && goods.getPictureurl()!=""){
            pictureUrl=goods.getPictureurl();
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            pictureUrl = mapper.writeValueAsString(pictureUrl);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pictureUrl;
    }
}
