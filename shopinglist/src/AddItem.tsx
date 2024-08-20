import React, { useState } from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import { Item } from "./App";

type AddItemPros = {
    addItem: (item: Item) => void;
}

function AddItem(props: AddItemPros) {
  const [open, setOpen] = useState(false);
  const [item, setItem] = useState<Item>({
    product: "",
    amount: "",
  });

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };
  
  const addItem = () => {
    props.addItem(item);
    setItem({
        product: '',
        amount: ''
    })
    handleClose();
  }
  return (
    <div>
      <Button variant="outlined" onClick={handleOpen}>Add Item</Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>New Item</DialogTitle>
        <DialogContent>
          <TextField
            value={item.product}
            margin="dense"
            onChange={(e) => setItem({ ...item, product: e.target.value })}
            label="Product"
            fullWidth
          />
          <TextField
            value={item.amount}
            margin="dense"
            onChange={(e) => setItem({ ...item, amount: e.target.value })}
            label="Amount"
            fullWidth
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button onClick={addItem}>Add</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default AddItem;
