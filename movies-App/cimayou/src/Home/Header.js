import React from 'react';
import "../CSS/Header.css";
import logo1 from '../images/logo.png'
import accountLogo from '../images/account.png'


function HeaderBanner(props) {

  /*const handleGoToCart = (event) => {
    event.preventDefault();
    props.changeForm("cart");
  }

  const handleGoToHome = (event) => {
    event.preventDefault();
    props.changeForm("home");
  }*/

  const handleGoToOrigin = (event) => {
    event.preventDefault();
    props.changeForm("origin");
  }

  return (
      <div className="headerBanner">        
      <img className='site-logo' src={logo1} alt='nada'></img>
      <h1 className='site-name'>CimaNow</h1>
      <button className='revert' onClick={handleGoToOrigin}>revert</button>
        <div className='search'>
          <input type="text" placeholder="find you movie..." class="search-bar" />
          <i class="fa-solid fa-magnifying-glass"></i>          
        </div>
        <div class="account-click">
        <span class="account-text">My account</span>
        <img className="account-logo" src={accountLogo} alt='account-logo'/>
        </div>  
      </div>      
  );
}

export default HeaderBanner;