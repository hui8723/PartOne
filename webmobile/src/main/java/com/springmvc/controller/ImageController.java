package com.springmvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springmvc.utils.FileManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangminghui on 2017/10/16.
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    private final String FILE_NAME = "pic.jpg";
    private final String UPDATE_FORUMIMG_SUCESS = "上传图片成功";
    private final String UPDATE_FORUMIMG_FAILED = "上传图片失败";
    private final int WIDTH = 250;
    private final int HEIGHT = 250;

    @RequestMapping(value = "upload",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody String uploadImage(@RequestParam("formImg")MultipartFile uploadFiles[]) throws FileNotFoundException{
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = null;
        try {
            if (uploadFiles != null && uploadFiles.length > 0) {
                List<String> fileAbsolutePaths = new ArrayList<String>();
                List<String> thumbnailPaths = new ArrayList<String>();
                for (int i = 0; i < uploadFiles.length; i++) {
                    if (!uploadFiles[i].isEmpty()) {
                        InputStream fis = uploadFiles[i].getInputStream(); // 创建读取用户上传的图片
                        long time = System.currentTimeMillis();
                        String originalFile = "/" + time + FILE_NAME;
                        String thumbnailFile = "/" + time + FILE_NAME;
//                        String original_path = request.getSession().getServletContext()
//                                .getRealPath("/")
//                                + "images/original";
//                        String thumbnail_path = request.getSession().getServletContext()
//                                .getRealPath("/")
//                                + "images/thumbnail";
//                        FileOutputStream fos = new FileOutputStream(original_path
//                                + originalFile);
//                        byte[] original = convert2ByteArray(fis, fos);
//
//                        FastDFSFile file2 = new FastDFSFile("520", original, "jpg");
//                        String fileAbsolutePath = FileManager.upload(file2);
//                        fileAbsolutePaths.add(fileAbsolutePath);
//                        fos.close();
                        /**
                         // 生成缩略图
                        Im4JavaUtil.thumbnail(thumbnailFile, original_path,
                                thumbnail_path, WIDTH, HEIGHT);
                        FileInputStream fis2 = null;
                        fis2 = new FileInputStream(thumbnail_path + thumbnailFile);
                        byte[] thumbnailByte = convert2ByteArray(fis2, null);
                        //System.out.println("*********thumbnailByte*******"+thumbnailByte.length);
                        FastDFSFile file1 = new FastDFSFile("520", thumbnailByte, "jpg");
                        String thumbnailPath = FileManager.upload(file1);
                        thumbnailPaths.add(thumbnailPath);
                        fis2.close();
                        File temporary1 = new File(original_path + originalFile);
                        temporary1.delete();
                        File temporary2 = new File(thumbnail_path + thumbnailFile);
                        temporary2.delete();
                     **/
                        if (fileAbsolutePaths == null
                                || fileAbsolutePaths.isEmpty()) {
//                            msg.setCode("1");
//                            msg.setInfo(UPDATE_FORUMIMG_FAILED);
//                            msg.setData("");
                            json = gson.toJson("upload fail");
                            return json;

                        }
                        fis.close();
                    }
                }
                Map<String,List<String>> map = new HashMap<String, List<String>>();
                map.put("thumbnailPaths", thumbnailPaths);
                map.put("fileAbsolutePaths", fileAbsolutePaths);
                json = gson.toJson(map);
            }
        }catch (Exception e) {

        }
        return json;
    }

    private byte[] convert2ByteArray(InputStream is, FileOutputStream fos)
            throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 8];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
            if (fos != null) {
                fos.write(buffer, 0, len);
            }
        }
        return baos.toByteArray();
    }

}
