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
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        int[] set = new int[] { 1, 2 ,3};
        Set<Set<Integer>> result = getSubSet(set); // 调用方法
        // 输出结果
        for (Set<Integer> subSet : result) {
            for (Integer num : subSet)
                System.out.print(num);

            System.out.println("");
        }
    }

    public static Set<Set<Integer>> getSubSet(int[] set) {
        Set<Set<Integer>> result = new HashSet<Set<Integer>>(); // 用来存放子集的集合，如{{},{1},{2},{1,2}}
        int length = set.length;
        int num = length == 0 ? 0 : 1 << (length); // 2的n次方，若集合set为空，num为0；若集合set有4个元素，那么num为16.

        // 从0到2^n-1（[00...00]到[11...11]）
        for (int i = 0; i < num; i++) {
            Set<Integer> subSet = new HashSet<Integer>();
            int index = i;
            for (int j = 0; j < length; j++) {
                if ((index & 1) == 1) { // 每次判断index最低位是否为1，为1则把集合set的第j个元素放到子集中
                    subSet.add(set[j]);
                }
                index >>= 1; // 右移一位
            }

            result.add(subSet); // 把子集存储起来
        }
        return result;
    }
}
