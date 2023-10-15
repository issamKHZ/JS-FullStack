import React, { useState } from 'react'
import HeaderBanner from '../Home/Header'
import Footer from '../Home/Footer'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleLeft } from '@fortawesome/free-solid-svg-icons';
import { faAngleRight } from '@fortawesome/free-solid-svg-icons';
import { faLightbulb as light } from '@fortawesome/free-regular-svg-icons';
import { faMoon as moon } from '@fortawesome/free-regular-svg-icons';
import { elements, watchs, downloads } from '../dataExample';

import '../CSS/player.css'
import ChoicesList from './choicesList';


export default function Player(props) {

  const [lightBool, setLight] = useState(true);
  const [darkOverlayVisible, setDarkOverlayVisible] = useState(false);
  const [choiceToken, setChoiceToken] = useState('episode');

  const handleSwitchLight = () => {
    setLight(!lightBool);
    setDarkOverlayVisible(!darkOverlayVisible);
  };

  const handleSwitchToEp = () => {
    setChoiceToken('episode');
  };

  const handleSwitchToW = () => {
    setChoiceToken('watch');
  };

  const handleSwitchToDl = () => {
    setChoiceToken('download');
  };

  return (
    <div className='play-container'>      
      <HeaderBanner changeForm={props.changeForm} />
      <div className='des-path-bar'>
        <h className='des-path'><span>CimaNow</span> &gt; <span>  Action  </span> &gt; <span>  {props.filmName}</span></h>      </div>
      <div className={`dark-overlay ${darkOverlayVisible ? 'visible' : ''}`} />
      <div className='play-main'>  
        <div className={`dark-overlay2 ${darkOverlayVisible ? 'visible' : ''}`} /> 
        <div className='play-controller'>
          <div className='three-buttons'>
            <button className='button 1' onClick={handleSwitchToEp}>Episode</button>
            <button className='button 2' onClick={handleSwitchToW}>Watch</button>
            <button className='button 3' onClick={handleSwitchToDl}>Download</button>            
          </div>
          <div className='pre-choice-list'>
            {choiceToken === 'episode' && (
            <ChoicesList EpiQual = {elements} ListAtt = {'episodes'}/>)}
            {choiceToken === 'watch' && (
            <ChoicesList EpiQual = {watchs} ListAtt = {'watchs'}/>)}
            {choiceToken === 'download' && (
            <ChoicesList EpiQual = {downloads} ListAtt = {'downloads'}/>)}          
          </div>
        </div> 
        <div className='play-video'>
          <div className='movie-player'>
            vid
          </div>
          <div className='under-bar'>
            <div className='previous-next'>
              <button className='previous'> <FontAwesomeIcon className='font' icon={faAngleLeft} /> Prev</button>
              <button className='next'>Next <FontAwesomeIcon className='font' icon={faAngleRight} /></button>
            </div>
            <div className='light-off-on'>
              <button className={`light ${lightBool ? '' : 'yellow'}`} onClick={handleSwitchLight}>{lightBool ? <FontAwesomeIcon className='font' icon={light} /> : <FontAwesomeIcon className='font' icon={moon} /> }</button>
            </div>
          </div>
        </div>
        
      </div>
      <div className='footer-comp'>
        <Footer />
      </div>  
    </div>  
  )
}
