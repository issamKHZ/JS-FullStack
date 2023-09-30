import React from 'react'
import MovieCard from './MovieCard'
import MyDropdown from './MyDropdown'
import poster from '../images/poster-mecanic.jpeg';

import '../CSS/main.css'

export default function MainContent() {
  return(

    <div className='main-section'>
        <div className='categorie-bar'>
          <div className='two-dropdown'>
            <MyDropdown nom={"Tried By"} selection={["Longest", "Most viewed", "Most rated", "Lastest", "oscar"]}/>
            <MyDropdown nom={"Categories"} selection={["action", "adventure", "Comedy", "Drama", "Fantasy", "Mystery", "Romance"]} />
          </div>
            <h className='cat-txt'>Cinema's news </h>
        </div>
        <div className='filtre-and-grid'>            
            <div className='grid-main'> 
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
              <div className='grid-item'><MovieCard title={"the mechanic"} description={"description"} poster={poster}/></div>
            </div>            
        </div>
        <div className='extra'>

        </div>
    </div>
  )
}
