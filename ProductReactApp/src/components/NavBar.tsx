import React, { useState } from "react";
import { Link } from "react-router-dom";
import searchProduct from "../utils/searchProduct";
import ProductTable from "./ProductTable";
import Table from "react-bootstrap/Table";

const NavBar = () => {
  const [name, setName] = useState("");
  const [selectedOption, setSelectedOption] = useState("");
  const [searchResponse, setSearchResponse] = useState([]);

  async function handleSubmit(e: any) {
    e.preventDefault();
    try {
      const data = await searchProduct(selectedOption, name);
      setSearchResponse(data);
    } catch (error) {
      console.log(error);
    }
  }
  return (
    <>
      <Link to="/add/product">
        <button>Add product</button>
      </Link>
      <div className="wrap" search-control="false">
        <div className="searchDiv">
          <form onSubmit={handleSubmit} className="search" method="get">
            <select
              name="dropdown"
              id="dropdown"
              value={selectedOption}
              onChange={(e) => setSelectedOption(e.target.value)}
            >
              <option>Select</option>
              <option value="Name">Name</option>
              <option value="Text">Text</option>
              <option value="Place">Place</option>
            </select>
            <input
              type="text"
              className="searchTerm"
              placeholder="Search"
              name="key"
              onChange={(e) => setName(e.target.value)}
            />
            <input type="submit" className="searchButton" />
          </form>
        </div>
      </div>
      <ProductTable searchResponse={searchResponse} />
    </>
  );
};

export default NavBar;
