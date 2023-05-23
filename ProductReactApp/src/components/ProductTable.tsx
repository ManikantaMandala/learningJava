import Table from "react-bootstrap/Table";

type SearchResult = {
  name: string;
  type: string;
  place: string;
  warranty: number;
};

function ProductTable({ searchResponse }: { searchResponse: SearchResult[] }) {
  return (
    <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Type</th>
          <th>Place</th>
          <th>Warranty</th>
        </tr>
      </thead>
      <tbody>
        {searchResponse.length > 0 &&
          searchResponse.map((s: any) => (
            <tr>
              <th scope="row">{s.name}</th>
              <td>{s.type}</td>
              <td>{s.place}</td>
              <td>{s.warranty}</td>
            </tr>
          ))}
      </tbody>
    </Table>
  );
}

export default ProductTable;
