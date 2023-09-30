import React, {useState} from 'react';
import { Rate } from "antd";
import '../App.css'

function RatingDemo () {

    const [rating, setRating] = useState(0); // Initial rating value

    const handleRatingChange = (newRating) => {
        setRating(newRating*2);
    };
 
    return (
        <div className="App">
            <h1>Product Rating</h1>
            <Rate onChange={handleRatingChange} allowHalf/>
            <h1> the actual rate is : {rating} </h1>
        </div>
    );
  
}

export default RatingDemo;