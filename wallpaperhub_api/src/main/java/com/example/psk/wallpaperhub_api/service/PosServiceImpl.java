package com.example.psk.wallpaperhub_api.service;
import com.example.psk.wallpaperhub_api.entity.PostEntity;
import com.example.psk.wallpaperhub_api.images.Images;
import com.example.psk.wallpaperhub_api.repository.PostEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosServiceImpl implements PostService {

//    private PostEntityRepository postRepo;
//
//    private final String PATH="D:\\Docs\\Projects\\react projects\\wallpaperhub\\images";
//
//    public PostEntity uploadImage(MultipartFile file) throws IOException{
//        String fullPath = PATH+file.getOriginalFilename();
//        PostEntity pImage=new PostEntity();
//        pImage.setName(file.getOriginalFilename());
//        pImage.setImagePath(fullPath);
//        file.transferTo(new File(fullPath));
//        return postRepo.save(pImage);
//    }
//
//    public byte[] downloadImage(String fileName) throws IOException{
//        Optional<PostEntity> imageObject = postRepo.findByName(fileName);
//        String fullPath = imageObject.get().getImagePath();
//        return Files.readAllBytes(new File(fullPath).toPath());
//
//    }

    private PostEntityRepository postEntityRepository;

    public PosServiceImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    @Override
    public String uploadImage(String path, MultipartFile file,String tag) throws IOException {

        PostEntity postEntity=new PostEntity();

        postEntity.setTag(tag);
        //File Name
        String name=file.getOriginalFilename();
        postEntity.setName(name);

        //Fullpath
        String filePath=path+name;
        postEntity.setImagePath("http://localhost:8080/file/images/"+name);

        //Crate folder if not created
        File f=new File(path);
        if(!f.exists())
        {
            f.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));
        postEntityRepository.save(postEntity);
        return name;

    }

    @Override
    public InputStream getImage(String path, String fileName) throws FileNotFoundException {

        String fullPath=path+File.separator+fileName;
        InputStream is=new FileInputStream(fullPath);
        return is;
    }

    @Override
    public List<Images> getAllImages() {
        List<PostEntity> postEntities
                =postEntityRepository.findAll();

        List<Images>images=postEntities
                .stream()
                .map(img->new Images(img.getId(),
                        img.getName(),
                        img.getImagePath(),
                        img.getTag()
                        ))
                .collect(Collectors.toList());
        return images;
    }


    @Override
    public List<Images> getTagImages(String tag) {
        List<PostEntity> postEntities
                =postEntityRepository.findAllByTag(tag);

        List<Images>images=postEntities
                .stream()
                .map(img->new Images(img.getId(),
                        img.getName(),
                        img.getImagePath(),
                        img.getTag()
                ))
                .collect(Collectors.toList());
        return images;
    }


}
