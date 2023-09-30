import React from 'react';
import MovieCard from './MovieCard'; // Assurez-vous de fournir le bon chemin vers le composant MovieCard
import poster from '../images/poster-mecanic.jpeg';

import '../CSS/LastestMovies.css';


export default function MovieCardGrid() {
  
  return (      
      <div className='container'>
        <h className='title-section'>Lastest movies</h>
        <div className='card-grid'>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>      
        </div>
      </div>
      
  );
}