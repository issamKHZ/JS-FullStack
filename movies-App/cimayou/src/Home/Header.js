import React, { useState } from 'react';
import logo1 from '../images/logo.png'
import accountLogo from '../images/account.png'

import "../CSS/Header.css";


function HeaderBanner(props) {

  const [connected, setConnected] = useState(false);

  const handleGoToOrigin = (event) => {
    event.preventDefault();
    props.changeForm("origin");
  }

  const handleRegisterConnect = (event) => {
    event.preventDefault();    
  }

  return (
      <div className="headerBanner">      
      <div className='div-logo'>
        <img className='site-logo' src={logo1} alt='nada' onClick={handleGoToOrigin}></img>
        <h className='site-name' onClick={handleGoToOrigin}>CimaNow</h>      
      </div>  
        <div className='search'>
          <input type="text" placeholder="find you movie..." class="search-bar" />
          <i class="fa-solid fa-magnifying-glass"></i>          
        </div>
        <div class="account-click" >
          {connected ? (
            <span class="profile-text">My Profile</span>            
          ) : (
            <span class="account-text" onClick={handleRegisterConnect}>My account</span>
          )}
          <img className="account-logo" src={accountLogo} alt='account-logo'/>
        </div>  
      </div>      
  );
}

export default HeaderBanner;