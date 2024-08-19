// import React, { useState } from "react";
// import "./App.css";

// function App() {
//   const [name, setName] = useState("");
//   const [myData, setMyData] = useState<string | undefined>(undefined);

//   const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
//     setName(event.target.value);
//   }

//   const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
//     event.preventDefault();
//     alert(`Hello, ${name} myData: ${myData}`);
//     console.log(myData);
//     doAsync();
//   }

//   const doAsync = async () => {
//     try{

//     const response = await fetch("https://jsonplaceholder.typicode.com/todos/1");
//     const data = await response.json();
//     setMyData(data.title);
//     console.log(data.title);

//     } catch (error) {
//       console.error("Error fetching data:", error);
//     }
//   }
//   fetch("https://jsonplaceholder.typicode.com/todos/1", {
//     method: "GET",
//     headers: {
//       "Content-Type": "application/json",
//     },
//   }).then((response) => {
//     return response.json();
//   }).then((data) => {
//     console.log(data.title);
//   })
//   return (
//     <>
//     <h1>Async</h1>
//     <h2>{myData}</h2>
//       <form onSubmit={handleSubmit}>
//         <input type="text" value={name} onChange={handleChange} />
//         <input type="submit" value="Submit" />
//       </form>
//     </>
//   );
// }

// export default App;
