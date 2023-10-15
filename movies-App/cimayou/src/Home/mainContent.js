import React, {useState} from 'react'
import MovieCard from './MovieCard'
import MyDropdown from './MyDropdown'
import { movies } from '../dataExample';

import '../CSS/main.css'

export default function MainContent(props) {

  const [selectedCategory, setSelectedCategory] = useState('All');
  const [selectedCaract, setSelectedCaract] = useState('By default');


  const handleCategorySelect = (item) => {
    setSelectedCategory(item);    
  };

  const handleCaractSelect = (item) => {
    setSelectedCaract(item);    
  };


  return(
    <div className='main-section'>
        <div className='categorie-bar'>
          <div className='two-dropdown'>
            <MyDropdown nom={"Tried By"} selection={["By default", "Longest", "Most viewed", "Most rated", "Lastest"]} onItemSelect={handleCaractSelect}/>
            <MyDropdown nom={"Categories"} selection={["All", "Action", "Adventure", "Comedy", "Drama", "Fantasy", "Mystery", "Romance"]} onItemSelect={handleCategorySelect}/>
          </div>
            <h className='cat-txt'>Cinema's news</h>
        </div>
        <div className='filtre-and-grid'>            
        <div className='grid-main'> 
          {selectedCaract === 'By default' ? (
              movies
              .filter((element) => element.categorie.includes(selectedCategory))
              .map((element) => (              
                <div className='grid-item'><MovieCard title={element.title} description={element.description} poster={element.poster} /></div>
              ))
            ) : selectedCaract === 'Most viewed' ? (
              movies                
                .slice().sort((a, b) => b.views - a.views)
                .filter((element) => element.categorie.includes(selectedCategory))
                .map((element) => (
                  <div className='grid-item'><MovieCard title={element.title} description={element.description} poster={element.poster} /></div>
                ))
            ) : selectedCaract === 'Most rated' ? (
              movies
              .slice().sort((a, b) => b.rate - a.rate)
              .filter((element) => element.categorie.includes(selectedCategory))
              .map((element) => (
                <div className='grid-item'><MovieCard title={element.title} description={element.description} poster={element.poster} /></div>
              ))
            ) : selectedCaract === 'Lastest' ? (
              movies
              .slice().sort((a, b) => b.date - a.date)
              .filter((element) => element.categorie.includes(selectedCategory))
              .map((element) => (
                <div className='grid-item'><MovieCard title={element.title} description={element.description} poster={element.poster} /></div>
              ))
            ) : selectedCaract === 'Longest' ? (
              movies
              .slice().sort((a, b) => {                
                const durationA = Number(a.duration.replace(/[^\d]/g, ''));
                const durationB = Number(b.duration.replace(/[^\d]/g, ''));              
                return durationB - durationA;
              })
              .filter((element) => element.categorie.includes(selectedCategory))
              .map((element) => (
                <div className='grid-item'><MovieCard title={element.title} description={element.description} poster={element.poster} /></div>
              ))  
            ) : null
          }
        </div>            
        </div>
        <div className='extra'>

        </div>
    </div>
  )

}