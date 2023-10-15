import React, {useState} from 'react'
import MovieCard from '../Home/MovieCard'
import Header from '../Home/Header'
import Categorie from '../Home/Categorie'
import Footer from '../Home/Footer'
import { movies } from '../dataExample'

import '../CSS/moviePage.css'



export default function MoviePage(props) {

    const [itemsToShow, setItemsToShow] = useState(8);
    

    const handleViewMore = () => {
        setItemsToShow(itemsToShow + 8);
    }

  return (
    <div className='movie-page-cont'>
        <Header changeForm={props.changeForm}/>
        <Categorie />        
        <div className='extra-top'>
            <div className='path-bar'>
                <h className='path'><span>CimaNow</span>  &gt; <span>  Movies  </span> &gt; <span>  Action  </span> &gt; <span>  ...</span> </h>
            </div>
        </div>
        <div className='grid'>
            {movies.slice(0, itemsToShow).map((element) => (
                <div className='grid-item'><MovieCard title={element.title} description={element.description} poster={element.poster}/></div>
            ))}               
        </div>
        <div className='extra-bottom'>
            <button className='load-more' onClick={handleViewMore}>view more</button>
        </div>
        <Footer />
    </div>
  )
}
