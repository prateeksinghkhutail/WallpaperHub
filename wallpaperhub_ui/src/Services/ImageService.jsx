import React from "react";
import axios from "axios";

const url1 = "http://localhost:8080/file/images";
const url2 = "http://localhost:8080/file/";
class ImageService {
  getImages() {
    return axios.get(url1);
  }

  getImagesByTag(tag) {
    return axios.get(url2 + tag);
  }
}

export default new ImageService();
