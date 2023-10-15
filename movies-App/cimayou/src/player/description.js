import React, { useState } from 'react'
import Header from '../Home/Header'
import Footer from '../Home/Footer'
import poster from '../images/poster-mecanic.jpg'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlayCircle } from '@fortawesome/free-regular-svg-icons'; 
import { faDownload } from '@fortawesome/free-solid-svg-icons'; 
import { faExclamationTriangle } from '@fortawesome/free-solid-svg-icons';
import { faHeart as regularHeart } from '@fortawesome/free-regular-svg-icons';
import { faHeart as solidHeart } from '@fortawesome/free-solid-svg-icons';
import { Rate } from "antd";


import '../CSS/description.css'



export default function Description(props) {

  const [rating, setRating] = useState(0); 
  const [favBool, setFavBool] = useState(false);

  const handleRatingChange = (newRating) => {
        setRating(newRating*2);
  };

  const handleMoveToFav = () => {
      setFavBool(!favBool)      
  }
 
  return (
    
    <div className='des-main-container'>
      <Header changeForm={props.changeForm}/>      
      <div className='des-path'>
        <div className='des-path-bar'>
          <h className='des-path'><span>CimaNow</span> &gt; <span>  Action  </span> &gt; <span>  ...</span> </h>
        </div>
      </div>
      <div className='global-grid'>
        <div className='box uun'>
          <div className='des-buttons'>
            <div className='display-buttons'>
              <button className='watch-now'>watch now <FontAwesomeIcon className='font' icon={faPlayCircle} /> </button>
              <button className='download-now'>Download now <FontAwesomeIcon className='font' icon={faDownload} /> </button>
            </div>
            <div className='extra-buttons'>
              <button className='add-to' onClick={handleMoveToFav}>Add to {favBool ? <FontAwesomeIcon className='font' icon={solidHeart} /> : <FontAwesomeIcon className='font' icon={regularHeart} />} </button>
              <button className='report'>Report <FontAwesomeIcon className='font' icon={faExclamationTriangle} /> </button>
            </div>
          </div>
        </div>
        <div className='box ddeux' >            
            <div className='des-title'>
              <h className='sentence'>Watch the movie</h> &ensp; <h className='title'> "The Mechanic" </h>
            </div>              
            <div className='story-covert'>
              <div className='des-story'>
                <p className='story-title'>Story</p>
                <h className='story-text'>Spécialiste du meurtre maquillé en accident, Arthur
                  travaille sans relâche et sans autres intermèdes que des rencontres
                  tarifées avec une française de la Nouvelle-Orléans. Sans le moindre 
                  remord non plus, il a même accepté un contrat dont la cible était son mentor. 
                  C'est sans aucun scrupule qu'Arthur accepte de prendre Steve.</h>
              </div>
            </div>
            <div className='tags'>
              <p className='tag un'> <p className='mention'>Date :</p> &ensp; September 2023 </p>
              <p className='tag deux'> <p className='mention'>Quality :</p> &ensp; HD </p>
              <p className='tag trois'> <p className='mention'>Tags :</p> &ensp; Action &ensp; Drama &ensp; Comedy</p>
              <p className='tag quatre'> <p className='mention'>Duration :</p> &ensp; 1h 56min </p>
            </div>
        </div>            
        <div className='box ttrois'>
          <div className='des-movie-container'>
            <div className='des-movie-poster'>
              <div className='des-poster'>
                <img className='des-the-poster' src={poster} alt='poster' />            
                <div className='des-rate'>  
                  <span className='rate'>8.9</span>
                </div>
              </div>
                <div className='des-rating-bar'>  
                    <Rate onChange={handleRatingChange} allowHalf defaultValue={3.5} style={{ color: "black", fontSize:25 }}/>
                </div>
              </div>
            </div>
        </div>
      </div>
      <div className='cast'>
            wait For Cast
      </div> 
      <div className='footer-comp'>
        <Footer />
      </div>  
    </div>
  )
}
