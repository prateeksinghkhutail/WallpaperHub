package com.example.psk.wallpaperhub_api.images;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Images {

    private long id;
    private String name;
    private String imagePath;
    private String tag;
}
