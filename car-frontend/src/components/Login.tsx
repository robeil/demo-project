import { useState } from "react";
import axios from "axios";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Stack from "@mui/material/Stack";
import Carlist from './Carlist';

type User = {
  username: string;
  password: string;
};

function Login() {
  const [user, setUser] = useState<User>({
    username: "",
    password: "",
  });
  const [isAuthenticated, setIsAuthenticated] = useState<boolean>(false);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setUser({ ...user, [event.target.name]: event.target.value });
  }

    const handleLogin = async () => {
        axios.post(import.meta.env.VITE_API_URL + "/login", user,)
        .then(res => { 
            const jwtToken = res.headers.authorization;
            if (jwtToken !== null) { 
                sessionStorage.setItem("jwt", jwtToken); 
                setIsAuthenticated(true);
            }
            }) .catch(err => console.error(err));
    }

    if(isAuthenticated) {
        return <Carlist />
    }
  return (
    <div>
      <Stack spacing={2} alignItems="center" mt={2}>
        {" "}
        <TextField name="username" label="Username" onChange={handleChange} />
        <TextField
          type="password"
          name="password"
          label="Password"
          onChange={handleChange}
        />
        <Button variant="outlined" color="primary" onClick={handleLogin}>
          {" "}
          Login
        </Button>{" "}
      </Stack>
    </div>
  );
}

export default Login;
