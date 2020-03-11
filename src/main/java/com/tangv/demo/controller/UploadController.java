package com.tangv.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/11 2:32 下午
 */

@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/Users/apple/Downloads/";

    @RequestMapping("/")
    public String index(){
    return "upload";
}

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes attributes){
        if (file.isEmpty()){
            attributes.addFlashAttribute("message","please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_PATH + file.getOriginalFilename());
            Files.write(path,bytes);
            attributes.addFlashAttribute("message","you successfully upload '"+file.getOriginalFilename()+"'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "uploadStatus";
    }
}
