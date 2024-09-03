import { useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import { Car } from "./types";
import { useMutation } from "@tanstack/react-query";


function AddCar() {
  //const queryClient = useQueryClient();

  const { mutate } = useMutation({ //supposed to pass the addCar function as a parameter
    onSuccess: () => {
     //queryClient.invalidateQueries(["cars"]);
    },
    onError: (err) => {
      console.error(err);
    },
  });

  const handleSave = () => { mutate(); setCar({ brand: '', model: '', color: '', registrationNumber:'', modelYear: 0, price: 0 });
handleClose(); }

  const [open, setOpen] = useState(false);
  const [car, setCar] = useState<Car>({
    brand: "",
    model: "",
    color: "",
    registrationNumber: "",
    modelYear: 0,
    price: 0,
  });

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };
  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setCar({ ...car, [event.target.name]: event.target.value });
  };

  return (
    <div>
      <button onClick={handleClickOpen}>New Car</button>{" "}
      <Dialog open={open} onClose={handleClose}>
        {" "}
        <DialogTitle>New car</DialogTitle>{" "}
        <DialogActions> <button onClick={handleClose}>Cancel</button> <button onClick={handleSave}>Save</button> </DialogActions>
        <DialogContent>
          {" "}
          <input
            placeholder="Brand"
            name="brand"
            value={car.brand}
            onChange={handleChange}
          />
          <br />
          <input
            placeholder="Model"
            name="model"
            value={car.model}
            onChange={handleChange}
          />
          <br />
          <input
            placeholder="Color"
            name="color"
            value={car.color}
            onChange={handleChange}
          />
          <br />
          <input
            placeholder="Year"
            name="modelYear"
            value={car.modelYear}
            onChange={handleChange}
          />
          <br />
          <input
            placeholder="Reg.nr"
            name="registrationNumber"
            value={car.registrationNumber}
            onChange={handleChange}
          />
          <br />
          <input
            placeholder="Price"
            name="price"
            value={car.price}
            onChange={handleChange}
          />
          <br />
        </DialogContent>{" "}
        <DialogActions>
          {" "}
          <button onClick={handleClose}>Cancel</button>{" "}
          <button onClick={handleClose}>Save</button>
        </DialogActions>{" "}
      </Dialog>
    </div>
  );
}

export default AddCar;
