import { useState } from 'react'
import axios from 'axios'
import './App.css'

type Repository = {
  id: number;
  full_name: string;
  html_url: string;
  description: string;
}

function App() {

  const [keyword, setKeyword] = useState<string>('');
  const [repoData, setRepoData] = useState<Repository[]>([]);

 const handleClick = () => {
  axios.get<{ items: Repository[] }> (`https://api.github.com/search/repositories?q=${keyword}`)
    .then(response => setRepoData(response.data.items))
    .then(logging => console.log(`The result should be logged here --> ${logging}`))
    .catch(err => console.log(`Error is throwing from here  --> ${err}`))
 }

  return (
    <>
      <input 
      value={keyword}
      onChange={e => setKeyword(e.target.value)} />
      <button onClick={handleClick}>Fetch Repo</button>
      
      {repoData.length == 0 ? (
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
      )}
    </>
   
  )
}

export default App

/**
 * https://api.github. com/search/repositories?q={KEYWORD}
 */