import React from 'react'
import '../CSS/Categorie.css'

export default function Categorie() {
  return (
    <div className='categorie-container'>        
        <div className='categorie-text'>
            <span className='categorie-items'>Movies</span>
            <span className='categorie-items'>Series</span>
            <span className='categorie-items'>Annimation</span>
            <span className='categorie-items'>Documentary</span>
        </div>
        <div className='border-dashed'></div> 
        <div className='welcomming'>
          <h1>Step into Your Ultimate Online Movie Experience</h1>
        </div>
    </div>
  )
}
