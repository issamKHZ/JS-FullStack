import React from 'react'
import HeaderBanner from './Header'
import Categorie from './Categorie'
import '../CSS/Home.css'
import LastestMovies from './LastestMovies'
import MainContent from './mainContent'
import Footer from './Footer'



export default function Home(props) {
  return (
    <div className='Container'>
        <header className="App-header"></header>
        <body className='App-body'>                
            <div className='header'>
                <HeaderBanner changeForm={props.changeForm}/>        
            </div>        
            <div className='categorie-banner'>
              <Categorie />
            </div>     
            <div className='latest-movie'> 
              <LastestMovies />
            </div>   
            <div className='main'>
              <MainContent />
            </div>  
            <div className='footer-comp'>
              <Footer />
            </div>             
        </body>          
    </div>
  )
}
