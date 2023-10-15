import React from 'react'
import '../CSS/MovieCard.css'

export default function MovieCard({title, description, poster}) {
  return (
    <div className='card-container'>
      <div className='movie-affiche'>
        <img src={poster} alt='the mechanic poster'/>
        <div className='movie-description'>
          <span className='description'> {description} </span>
        </div>
        <div className='movie-title'>
          <span className='title'>{title}</span>
        </div>
      </div>

    </div>
  )
}
