import { useState } from "react";
import Container from "@mui/material/Container";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import "./App.css";
import AddItem from "./AddItem";
import List from '@mui/material/List'; 
import ListItem from '@mui/material/ListItem'; 
import ListItemText from '@mui/material/ListItemText';

export type Item = {
  product: string;
  amount: string;
}

function App() {
  const [itmes, setItems] = useState<Item[]>([]);

  const addItem = (item: Item) => {
    setItems([item, ...itmes]);
  }

  return (
    <Container>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6">Shooping List</Typography>
        </Toolbar>
      </AppBar>
      <AddItem addItem={addItem}/>
      <List>
      {
        itmes.map((item, index) => 
        <ListItem key={index} divider>
          <ListItemText
          primary={item.product}
          secondary={item.amount}/>
        </ListItem>
        )
      }
      </List>
    </Container>
  );
}

export default App;
