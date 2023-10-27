import React from 'react'
/*import HeaderBanner from '../Home/Header'*/
import Login from './login'
import '../CSS/login-home.css'
import '../CSS/styles.css'

export default function LoginHome(props) {
  return (
    <div className='Container'>
        <header className="App-header"></header>
        <body className='App-body'>                                         
            <div className='login-pad'>
                <Login />
            </div>                       
        </body>          
    </div>
  )
}
