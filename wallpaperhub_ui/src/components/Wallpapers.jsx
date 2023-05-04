import React from "react";
import { useEffect, useState } from "react";
import ImageService from "../Services/ImageService";
import Wallpaper from "./Wallpaper";
import Masonry, { ResponsiveMasonry } from "react-responsive-masonry";

const Wallpapers = () => {
  const [images, setImages] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await ImageService.getImages();
        //console.log(response.data)
        setImages(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  return (
    <>
      <div className="bg-black">
        <div className="px-20 py-10 ">
          <ResponsiveMasonry
            columnsCountBreakPoints={{ 350: 1, 750: 2, 900: 3 }}
          >
            <Masonry gutter="20px">
              {images.map((image) => (
                <Wallpaper image={image} key={image.id} />
              ))}
            </Masonry>
          </ResponsiveMasonry>
        </div>
      </div>
    </>
  );
};

export default Wallpapers;
