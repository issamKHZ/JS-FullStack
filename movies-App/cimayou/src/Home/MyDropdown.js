import React from 'react';
import { useState } from 'react';
import '../CSS/dropdown.css'
/*import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';*/

function MyDropdown({nom, selection, onItemSelect,...props}) {

  const [isActive, setIsActive] = useState(false);
  const [selectedItem, setSelectedItem] = useState('');

  const [actualName, setActualName] = useState(nom);

  const handleItemClick = (item) => {
    setSelectedItem(item);
    onItemSelect(item); 
    if (item === 'All') {
      setActualName('Categories');
    } else if ( item === 'By default') {
      setActualName('Tried By');
    } else {
      setActualName(item);
    }
  };

  return (
    <div className='dropdown'>
        <div className='dropdown-btn' onMouseOver={e => setIsActive(true)} onMouseLeave={e => setIsActive(false)} >             
            <span class="align-middle">{actualName}</span>
        </div>
        {isActive && (
            
            <div className='dropdown-content' onMouseEnter={e => setIsActive(true)} onMouseLeave={e => setIsActive(false)}> 
              {selection.map((item) => (
                <div className="dropdown-item" key={item} onClick={() => handleItemClick(item)}>
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
