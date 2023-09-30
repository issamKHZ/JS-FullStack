import React from 'react';
import { useState } from 'react';
import '../CSS/dropdown.css'
/*import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';*/

function MyDropdown({nom, selection}) {

  const [isActive, setIsActive] = useState(false);

  return (
    <div className='dropdown'>
        <div className='dropdown-btn' onMouseOver={e => setIsActive(true)} onMouseLeave={e => setIsActive(false)} >             
            <span class="align-middle">{nom}</span>
        </div>
        {isActive && (
            
            <div className='dropdown-content' onMouseEnter={e => setIsActive(true)} onMouseLeave={e => setIsActive(false)}> 
              {selection.map((item) => (
                <div className="dropdown-item">
                  {item}
                </div>
              )
              )}
            </div>
        )}
    </div>
  );
}

export default MyDropdown;
