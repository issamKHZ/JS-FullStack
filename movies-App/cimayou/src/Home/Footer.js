import React from 'react'
import '../CSS/footer.css'
import 'font-awesome/css/font-awesome.min.css'


export default function Footer() {
  return (
    <footer className='footer'>
        <div className='footer'>
          <div className='row'>
            <a href="https://google.com"><i className="fa fa-facebook"></i></a>
            <a href="https://google.com"><i className="fa fa-instagram"></i></a>
            <a href="https://google.com"><i className="fa fa-youtube"></i></a>
            <a href="https://google.com"><i className="fa fa-twitter"></i></a>
          </div>

          <div className='row'>
            <ul>
              <li><a href="https://google.com">Contact us</a></li>
              <li><a href="https://google.com">Our Services</a></li>
              <li><a href="https://google.com">Privacy Policy</a></li>
              <li><a href="https://google.com">Terms & Conditions</a></li>
              <li><a href="https://google.com">Career</a></li>
            </ul>
          </div>

          <div className='row'>
            INFERNO Copyright © 2023 Inferno - All rights reserved || Designed By: Issam
          </div>
        </div>
      </footer>
  
  )
}
