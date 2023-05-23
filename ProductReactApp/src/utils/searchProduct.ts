import axios from "axios";
const searchProduct:any = async (selectedOption:string,name:string) => {
    const response = await axios
    .get(`http://localhost:8080/search/is${selectedOption}+${name}`, {
      headers: {
        Accept: "application/json",
      },
    })
    return response.data
    
}

export default searchProduct