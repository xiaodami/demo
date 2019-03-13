package com.baizhi.controller;

import com.baizhi.entity.Tu;
import com.baizhi.service.TuService;
import com.baizhi.util.Load;
import com.sun.deploy.net.URLEncoder;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class TuController {
    @Autowired
    private TuService ts;
    @RequestMapping("selectAll")
    @ResponseBody
    public List<Tu> selectAll(){
        return ts.selectAll();
    }
    @RequestMapping("insert.do")
    public void insert(String id, MultipartFile up,HttpSession session) throws IOException {
        System.out.println(123);
        System.out.println(up.getOriginalFilename());
        String path="G:\\ideaweb\\demo\\src\\main\\webapp\\img\\";
        System.out.println(path);
        String uploading = Load.uploading(up, path);
        System.out.println(uploading);
        String s = UUID.randomUUID().toString();
        Tu tu = new Tu(s, uploading);
        ts.insert(tu);
        List<Tu> tus = ts.selectAll();
        session.setAttribute("tus",tus);

    }

    @RequestMapping("/download.do")
    public void downLoad(HttpSession session, HttpServletResponse res, HttpServletRequest req) throws Exception{
        /*path = URLDecoder.decode(path, "UTF-8");
        String RealPathDir = session.getServletContext().getRealPath("img/"+path);
        *///下载资源的路径
        InputStream in = new FileInputStream("G:\\ideaweb\\demo\\src\\main\\webapp\\img\\预习资料使用方法 + 预习期规范要求.doc");
        //获得输出流
        OutputStream out = res.getOutputStream();
        //设置响应头，指定文件下载到客户端的文件名和打开方式
        //设置响应类型
       // path.lastIndexOf(".");
        //String ext = path.substring(path.lastIndexOf("."));
        res.setContentType(req.getSession().getServletContext().getMimeType("doc"));
        res.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("预习资料使用方法 + 预习期规范要求.doc","UTF-8"));
        IOUtils.copy(in, out);
    }
}
