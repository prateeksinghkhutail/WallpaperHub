import React from "react";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import Wallpaper from "./Wallpaper";
import Masonry, { ResponsiveMasonry } from "react-responsive-masonry";
import ImageService from "../Services/ImageService";

const WallpaperByTag = () => {
  const category = useParams();

  const [images, setImages] = useState([]);
  const tag = category.anime;
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);

      try {
        const response = await ImageService.getImagesByTag(tag);
        //console.log(response.data);
        setImages(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, [tag]);

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

export default WallpaperByTag;
