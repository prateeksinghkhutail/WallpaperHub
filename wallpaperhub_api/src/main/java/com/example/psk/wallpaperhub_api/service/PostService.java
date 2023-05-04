package com.example.psk.wallpaperhub_api.service;

import com.example.psk.wallpaperhub_api.images.Images;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public interface PostService {
    String uploadImage(String path, MultipartFile file,String tag) throws IOException;
    InputStream getImage(String path,String fileName) throws FileNotFoundException;


    List<Images> getAllImages();
    List<Images> getTagImages(String tag);
}
