import { CarResponse, Car } from "../components/types";
import axios from "axios";

export const getCars = async (): Promise<CarResponse[]> => {
    const token = sessionStorage.getItem("jwt");

  const response = await axios.get(`${import.meta.env.VITE_API_URL}/api/cars`
    , {
    headers: {
      'Authorization': token,
    }

  });
  return response.data._embedded.cars;
};

export const deleteCar = async (link: string): Promise<CarResponse> => {
  const response = await axios.delete(link);
  return response.data;
};

export const addCar = async (car: Car): Promise<CarResponse> => {
  const token = sessionStorage.getItem("jwt");
  const response = await axios.post(
    `${import.meta.env.VITE_API_URL}/api/cars`,
    car,
    {
      headers: {
        'Authorization': token,
        "Content-Type": "application/json",
      },
    }
  );
  return response.data;
};
