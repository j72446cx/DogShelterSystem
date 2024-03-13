package com.dog.shelter.rescue.system.dogrescuesheltersystem.Controller;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.Result;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("Image upload: {} ", image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("Image upload successfully, with url: {}", url);
        return Result.success(url);
    }

    @PostMapping("/uploadPdf")
    public Result uploadPdf(MultipartFile file) throws IOException{


        log.info("Pdf uploading: {}", file.getOriginalFilename());

        // 从MultipartFile获取字节内容和原始文件名
        byte[] content = file.getBytes();
        String originalFileName = file.getOriginalFilename();

        // 调用AliOSSUtils的upload方法上传PDF
        String url = aliOSSUtils.upload(content, originalFileName);

        log.info("Pdf upload successfully, with url: {}", url);

        return Result.success(url);
    }


}
