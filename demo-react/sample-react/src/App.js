import { useState } from 'react';
import './App.css';
import MyComponent from './MyComponent';
import AuthContext from './ContextApi';
import MyForm from './MyForm';

function App() {
  const [count, setCount] = useState(10);
  const [name, setName] = useState({
    firstName: "Robeil",
    lastName: "Aregawi"
  })
const userName = 'Jonh';

if(count < 5) {
  setName({
    firstName: "Robeil",
    lastName: "Aregawi1"
  })
}

  return (
  <AuthContext.Provider value={userName}>
      <MyComponent />
    <MyForm />
</AuthContext.Provider>
  );
}

export default App;
