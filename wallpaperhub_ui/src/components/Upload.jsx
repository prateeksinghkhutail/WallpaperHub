import React from "react";
import axios from "axios";
const Upload = () => {
  const [selectedFile, setSelectedFile] = React.useState(null);
  const [isFilePicked, setIsFilePicked] = React.useState(false);

  const changeHandler = (event) => {
    setSelectedFile(event.target.files[0]);
    setIsFilePicked(true);
  };

  const handleSubmission = () => {
    const formData = new FormData();
    formData.append("file", selectedFile);
    axios.post("http://localhost:8080/file/upload", formData).then((res) => {
      console.log(res);
      alert("file uploaded successfully");
    });
  };

  return (
    <div className="py-10 text-black bg-white">
      <div className="text-center py-20">
        Upload File to database
        <form className="text-center py-10">
          <input type="file" name="file" onChange={changeHandler} />
          <div>
            <button
              onClick={handleSubmission}
              className="bg-gray-200 rounded-md "
            >
              Sumbit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Upload;
