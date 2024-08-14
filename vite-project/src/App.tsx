import { useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(1)

 
  if(count < 5){
    const number: number = count * 2;
    setCount(number);
    console.log(number);
  }

// const person = {
//   firstName: "John",
//   lastName: "Doe",
//   email: "jhon.doe@gmail.com"
// }

// const firstName = person.firstName;
// const lastName = person.lastName;
// const email = person.email;

// interface Person {
//   firstName: string;
//   lastName: string;
//   email: string;
// }
//
// class Person {
//   constructor(firstName, lastName, email){
//     this.firstName = firstName;
//     this.lastName = lastName;
//     this.email = email;
//   }
// }

// Person per = new Person("John", "Doe", "john@gmail.com");

  return (
    <>
      <h1 style={{color: 'red', height: 30}}>Hello World</h1>
      <h2>This is my first React Component</h2>
      <div style={{color: 'blue', height: 30}}>
      {count > 5 ? <h3>Count is greater than 5</h3> : <h3>Count is less than 5</h3>} 
      </div>
   <h2>{}</h2>
    </>
  )
}

export default App
