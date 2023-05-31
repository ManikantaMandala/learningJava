import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

const AddProduct = () => {
  const [name, setName] = useState("");
  const [type, setType] = useState("");
  const [place, setPlace] = useState("");
  const [warranty, setWarranty] = useState("");

  async function handleRequest(e: any) {
    e.preventDefault();
    try {
      const intW: number = parseInt(warranty);
      const addProdRes = await axios.post("http://localhost:8080/products", {
        name,
        type,
        place,
        warranty: intW,
      });
      console.log(addProdRes);
      alert(`Added product ${addProdRes.data.name}`);
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      <form className="search" method="post" onSubmit={handleRequest}>
        <input
          type="text"
          className="Name"
          placeholder="Enter the name"
          name="key"
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="text"
          className="Type"
          placeholder="Enter the type"
          name="key"
          onChange={(e) => setType(e.target.value)}
        />
        <input
          type="text"
          className="Place"
          placeholder="Enter the place"
          name="key"
          onChange={(e) => setPlace(e.target.value)}
        />
        <input
          type="text"
          className="Warranty"
          placeholder="Enter the warranty"
          name="key"
          onChange={(e) => setWarranty(e.target.value)}
        />
        <input type="submit" className="searchButton" />
      </form>
      <Link to="/">
        <button>Back</button>
      </Link>
    </>
  );
};

export default AddProduct;
