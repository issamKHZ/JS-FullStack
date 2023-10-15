import Home from './Home/Home';
import { useState } from 'react';
import './App.css';
import Description from './player/description';
import MoviePage from './MovieFolder/moviePage';
import Player from './player/player';
import LoginHome from './login/login-home';

function App() {

  const [currentPage, setCurrentPage] = useState("origin"); 

  function handleChangeForm(Form) {
    setCurrentPage(Form);
  }
  
  return (
    <div className='original-container'>
      {currentPage === "origin" ? (
        <div className='origin'>
          <button className='home' onClick={() => handleChangeForm("home")}> Home </button>
          <button className='home' onClick={() => handleChangeForm("home2")}> Home2 </button>
          <button className='home' onClick={() => handleChangeForm("description")}> description </button>
          <button className='home' onClick={() => handleChangeForm("player")}> player </button>
          <button className='home' onClick={() => handleChangeForm("login")}> login </button>
        </div>
      ) : currentPage === "home" ? (
        <Home changeForm={handleChangeForm}/>
      ) : currentPage === "home2" ? (
        <MoviePage changeForm={handleChangeForm}/>
      ) : currentPage === "description" ? (
        <Description changeForm={handleChangeForm} />
      ) : currentPage === "player" ? (
        <Player changeForm={handleChangeForm} filmName={"The Mechanic"} />
      ) : currentPage === "login" ? (
        <LoginHome changeForm={handleChangeForm} />
      ) : null}
    </div>
    
  );
}

export default App;
