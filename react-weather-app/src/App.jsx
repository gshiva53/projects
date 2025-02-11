import { useState, useEffect, useRef } from "react";
import "./App.css";

export default function App() {
  const [lat, setLat] = useState(44.34);
  const [lon, setLon] = useState(10.99);
  const [weatherMain, setWeatherMain] = useState("");
  const [weatherDesc, setWeatherDesc] = useState("");

  const apiKey = "<Open Weather API Key>";
  const url = `https://api.openweathermap.org/data/3.0/onecall?lat=${lat}&lon=${lon}&appid=${apiKey}`;

  async function callWeatherApi() {
    fetch(url)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Something wrong with the API call");
        }
        return response.json();
      })
      .then((data) => {
        console.log("received response from weather API");

        setWeatherMain(data.current.weather[0].main);
        setWeatherDesc(data.current.weather[0].description);
      })
      .catch((err) => console.log(err.message));
  }

  async function setLocation(lat, lon) {
    setLat(lat);
    setLon(lon);

    console.log("Location is set now");

    await callWeatherApi();
  }

  return (
    <div className='grid grid-cols-1 justify-items-center'>
      <h1 className='text-3xl font-bold m-2 my-10'>
        Open Weather API Weather App
      </h1>
      <div className='flex'>
        <Search setLocation={setLocation} />
        <div className='m-2 mx-8'>
          <p className='text-xl'>Latitude</p>
          <p className=''>{lat}</p>
        </div>
        <div className='mx-8 m-2'>
          <p className='text-xl'>Longitude</p>
          <p className=''>{lon}</p>
        </div>
      </div>
      <WeatherCondition weatherMain={weatherMain} weatherDesc={weatherDesc} />
    </div>
  );
}

export function Search({ setLocation }) {
  const exampleAddress = `1600+Amphitheatre+Parkway,+Mountain+View,+CA`;
  // const homeAddress = "5/6,+George,+Crescent,+Fannie,+Bay,+NT";
  const [address, setAddress] = useState(exampleAddress);
  const geocodingApiKey = "<Google GeoCoding API key>";

  async function callGeoCodingApi() {
    const geocodingUrl = `https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=${geocodingApiKey}`;

    fetch(geocodingUrl)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Something is wrong with the Geocoding API");
        }

        return response.json();
      })
      .then((data) => {
        const { results } = data;
        const location = results[0].navigation_points[0].location;
        const lat = location.latitude.toFixed(2);
        const lon = location.longitude.toFixed(2);

        setLocation(lat, lon);
      })
      .catch((err) => console.log(err));
  }

  return (
    <div className='mx-8 m-2'>
      <input
        type='text'
        placeholder={exampleAddress}
        className='w-sm size-8'
        onChange={(e) => setAddress(e.target.value)}
      />
      <button type='button'>
        <svg
          xmlns='http://www.w3.org/2000/svg'
          className='size-6 mx-2 focus:ring-2'
          viewBox='0 0 50 50'
          onClick={callGeoCodingApi}
        >
          <path
            fillRule='evenodd'
            d='M 21 3 C 11.621094 3 4 10.621094 4 20 C 4 29.378906 11.621094 37 21 37 C 24.710938 37 28.140625 35.804688 30.9375 33.78125 L 44.09375 46.90625 L 46.90625 44.09375 L 33.90625 31.0625 C 36.460938 28.085938 38 24.222656 38 20 C 38 10.621094 30.378906 3 21 3 Z M 21 5 C 29.296875 5 36 11.703125 36 20 C 36 28.296875 29.296875 35 21 35 C 12.703125 35 6 28.296875 6 20 C 6 11.703125 12.703125 5 21 5 Z'
          ></path>
        </svg>
      </button>
    </div>
  );
}

export function WeatherCondition({ weatherMain, weatherDesc }) {
  return (
    <div className='my-8 flex'>
      <img
        src='https://images.unsplash.com/photo-1491528323818-fdd1faba62cc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80'
        alt='Unsplash image'
        className='inline-block size-18 rounded-full ring-2 ring-white'
      />
      <div>
        <p className='text-xl mx-4 my-1'>{weatherMain}</p>
        <p className='m-2 mx-4 my-1'>{weatherDesc}</p>
      </div>
    </div>
  );
}
