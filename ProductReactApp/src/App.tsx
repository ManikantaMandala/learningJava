import { useState } from "react";
import reactLogo from "./assets/react.svg";
import NavBar from "./components/NavBar";
import AddProduct from "./components/AddProduct";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<NavBar />} />
        <Route path="/add/product" element={<AddProduct />} />
      </Routes>
    </div>
  );
}

export default App;
