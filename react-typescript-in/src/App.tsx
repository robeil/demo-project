import React, { useState, useEffect, useContext } from "react";
import "./App.css";
import Message from "./Message";
import { UserContext } from "./UserContext";

const App: React.FC = () => {

  const [userName, setUserName] = useState<string | null>("Robeil");
  const [userMessage, setUserMessage] = useState<string | null>(
    "This is the message we have received"
  );

  useEffect(() => {
    const timer = setTimeout(() => {
      setUserMessage("This is the new message");
      setUserName("New User");
    }, 5000);
    return () => clearTimeout(timer);
  }, []);

  return (
    <UserContext.Provider value={{name: userName || "", message: userMessage || ""}}>
      <h1>TypeScript is cool!</h1>
      <Message />
    </UserContext.Provider>
  );
};

export default App;
