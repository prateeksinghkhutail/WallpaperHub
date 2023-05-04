import React from "react";

const wallpaper = ({ image }) => {
  return (
    <div className="">
      <img
        key={image.id}
        src={image.imagePath}
        style={{ width: "100%", display: "block", cursor: "pointer" }}
        alt=""
        onClick={() => window.open(image.imagePath, "_blank")}
      />
    </div>
  );
};

export default wallpaper;
