import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [weather, setWeather] = useState({
    temp:'',
    desc: '',
    icon: ''
  });
  
  //fetch('https://api.openweathermap.org/data/2.5/ weather?q=London&APIKey=bce66945228222445cfa64cbe86952fa&units=metric')
  useEffect(() => {
    fetch('https://api.openweathermap.org/data/2.5/weather?q=London&APIKey=bce66945228222445cfa64cbe86952fa&units=metric')
    .then(response => response.json())
.then(data => {
  setWeather({
    temp: data.main.temp,
    desc: data.weather[0].main,
    icon: data.weather[0].icon
  });
}
  )
  .catch(error => console.error('Error fetching weather data'));
  }, []);

  
   if(weather.icon){
    return (
      <>
    <p>Temperature: {weather.temp} °C</p> <p>Description: {weather.desc}</p> <img src={`http://openweathermap.org/img/wn/${weather. icon}@2x.png`}
    alt="Weather icon" /> 
    </>  )
   }else {
    return <div>Loading...</div>
   }

   

}

export default App
