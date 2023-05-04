package com.example.psk.wallpaperhub_api.controller;

import com.example.psk.wallpaperhub_api.images.Images;
import com.example.psk.wallpaperhub_api.payload.FileResponse;
import com.example.psk.wallpaperhub_api.service.PosServiceImpl;
import com.example.psk.wallpaperhub_api.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/file/")
public class PostController {

    @Autowired
    private PostService postService;
    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadImage
            (@RequestParam("file") MultipartFile file,@RequestParam("tag") String tag) throws IOException {
        String fileName=null;
        try{
            fileName=this.postService.uploadImage(path,file,tag);
        }catch(IOException e){
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null,"Image not uploaded"),INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<>(new FileResponse(fileName,"Image uploaded"),HttpStatus.OK);
    }

    @GetMapping("/images")
    public List<Images> getAllImages()
    {
        return postService.getAllImages();
    }


    @GetMapping(value="/images/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("imageName")String imageName, HttpServletResponse response) throws IOException {
        InputStream resource=this.postService.getImage(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());

    }

    @GetMapping(value="/{tag}")
    public List<Images> getTagImage(@PathVariable("tag")String tag) {

            return postService.getTagImages(tag);


    }


}
