package com.example.psk.wallpaperhub_api.repository;

import com.example.psk.wallpaperhub_api.entity.PostEntity;
import com.example.psk.wallpaperhub_api.images.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostEntityRepository extends JpaRepository<PostEntity,Long> {

    Optional<PostEntity> findByName(String fileName);
    public List<PostEntity> findAllByTag(String tag);

}
