import { useState } from "react";
import axios from "axios";
import "./App.css";
import { AgGridReact } from 'ag-grid-react'; 
import 'ag-grid-community/styles/ag-grid.css'; 
import 'ag-grid-community/styles/ag-theme-material.css';
import { ColDef } from 'ag-grid-community';
import { ICellRendererParams } from 'ag-grid-community';

type Repository = {
  id: number;
  full_name: string;
  html_url: string;
  description: string;
};



function App() {
  const [keyword, setKeyword] = useState<string>("");
  const [repoData, setRepoData] = useState<Repository[]>([]);

  const [columnDefs] = useState<ColDef[]>([
    {field: 'id', sortable: true, filter: true}, {
      field: 'full_name', sortable: true, filter: true}, 
      {field: 'html_url', sortable: true, filter: true},
      {
        headerName: 'Actions',
        field:'full_name',
        cellRenderer: (params: ICellRendererParams) => (
          <button
          onClick={()=> alert(params.value)}>Press Me!</button>
        )
      }
  ])
  

  const handleClick = () => {
    axios
      .get<{ items: Repository[] }>(
        `https://api.github.com/search/repositories?q=${keyword}`
      )
      .then((response) => setRepoData(response.data.items))
      .then((logging) =>
        console.log(`The result should be logged here --> ${logging}`)
      )
      .catch((err) => console.log(`Error is throwing from here  --> ${err}`));
  };

  return (
    <>
      <input value={keyword} onChange={(e) => setKeyword(e.target.value)} />
      <button onClick={handleClick}>Fetch Repo</button>
      <div className="ag-theme-material" style={{ height: 500, width: 850 }}>
      <AgGridReact 
        rowData={repoData}
        columnDefs={columnDefs}
        pagination={true} 
        paginationPageSize={5}
        />

        {/* {repoData.length == 0 ? (

        <p>No data available with the given input</p>

      ): (
        <table>
          <tbody>       
         
            {
    
              repoData.map(repo => (
                
                <tr key={repo.id}>
                  <td>{repo.full_name}</td>
                  <a>href={repo.html_url}{repo.html_url}</a>
                  <td>{repo.description}</td>
                </tr>
                
              ))
          
            }  
          </tbody>
        </table>
    
      )}*/}
      </div>
    </>
  );
}

export default App;

/**
 * https://api.github. com/search/repositories?q={KEYWORD}
 */
