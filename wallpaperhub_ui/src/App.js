import Upload from './components/Upload';
import Navbar from './components/Navbar';
import Wallpapers from './components/Wallpapers';
import Footer from './components/Footer';
import Banner from './components/Banner';
import WallpaperByTag from './components/WallpaperByTag';

import {
  createBrowserRouter,
  Outlet,
  RouterProvider,
} from "react-router-dom";



const Layout=()=>{
  return(
    <>
    <Navbar/>
    <Banner/>
    <Outlet/>
    <Footer/>
    
    </>
  )
}

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    children:[
      {
        path: "/",
        element:<Wallpapers/>

      },
      {
        path: "/upload",
        element:<Upload/>
      },
      {
        path: "/:anime",
        element:<WallpaperByTag/>
      },
      {
        path: "/:movies",
        element:<WallpaperByTag/>
      },
      {
        path: "/:nature",
        element:<WallpaperByTag/>
      },
      {
        path: "/:cyberpunk",
        element:<WallpaperByTag/>
      },
      {
        path: "/:cars",
        element:<WallpaperByTag/>
      },
      {
        path: "/:others",
        element:<WallpaperByTag/>
      }
    ]
  },
]);



function App() {
  return (
    <div className='flex bg-black justify-center' >
      <div className='w-9/12 '>

      <RouterProvider router={router} />
 
      </div>
    
    
    </div>
  );
}

export default App;
