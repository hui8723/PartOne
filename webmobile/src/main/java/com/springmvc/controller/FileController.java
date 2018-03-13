package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by tangminghui on 2017/10/13.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ServletContext servletContext;

//    已将html文件设置为静态资源，访问地址为：http://localhost:8080/webmobile/html/upload-file.html
    @RequestMapping(value = "/upload-file",method = RequestMethod.GET)
    public ModelAndView uploadFilePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/html/upload-file.html");
        return mv;
    }

    @RequestMapping(value = "/upload-file",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        saveFile(file);
        return "Success";
    }

    private boolean saveFile(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
//                getRealPath()取得WEB-INF所在文件夹下路径
                String path = servletContext.getRealPath("") + File.separator + file.getOriginalFilename();
                FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(path));
                return true;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
