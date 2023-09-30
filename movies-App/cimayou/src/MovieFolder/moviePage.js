import React from 'react'
import MovieCard from '../Home/MovieCard'
import poster from '../images/poster-mecanic.jpeg';
import Header from '../Home/Header'
import Categorie from '../Home/Categorie'
import Footer from '../Home/Footer'
import '../CSS/moviePage.css'

export default function MoviePage(props) {
  return (
    <div className='movie-page-cont'>
        <Header changeForm={props.changeForm}/>
        <Categorie />        
        <div className='extra-top'>
            <div className='path-bar'>
                <h className='path'><span>CimaNow</span> &gt; <span>  Action  </span> &gt; <span>  ...</span> </h>
            </div>
        </div>
        <div className='grid'>
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
        <div className='extra-bottom'>
            <button className='load-more'>view more</button>
        </div>
        <Footer />
    </div>
  )
}
