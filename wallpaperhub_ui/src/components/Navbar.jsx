import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div className="text-white">
      <div className="px-10 py-10 flex justify-between">
        <div className="text-2xl font-bold">
          <Link>WALLPAPERHUB</Link>
        </div>
        <div className="flex gap-10">
          <Link
            className="text-inherit text-base font-light"
            to="http://localhost:3000/anime"
          >
            <h6>ANIME</h6>
          </Link>
          <Link className="text-inherit" to="http://localhost:3000/movies">
            <h6>MOVIES</h6>
          </Link>
          <Link className="text-inherit" to="http://localhost:3000/nature">
            <h6>NATURE</h6>
          </Link>
          <Link className="text-inherit" to="http://localhost:3000/cyberpunk">
            <h6>CYBERPUNK</h6>
          </Link>
          <Link className="text-inherit" to="http://localhost:3000/cars">
            <h6>CARS</h6>
          </Link>
          <Link className="text-inherit" to="http://localhost:3000/others">
            <h6>OTHERS</h6>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
