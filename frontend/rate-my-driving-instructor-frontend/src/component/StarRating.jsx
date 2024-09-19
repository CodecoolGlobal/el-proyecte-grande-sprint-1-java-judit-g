import { useState } from 'react';
import { FaStar } from 'react-icons/fa'

function StarRating({ onRating, rating }) {
  const [hover, setHover] = useState(null);

  return (
    <div className='star-rating'>
      {[...Array(5)].map((star, index) => {
        const currentRating = index + 1;
        return(
          <label>
            <input
              type="radio"
              name="rating"
              value={currentRating}
              onClick={() => onRating(currentRating)} 
            />
            <FaStar
              className='star' 
              size={50}
              color={currentRating <= (hover || rating) ? "#ffc107": "#e4e5e9"}
              onMouseEnter={() => setHover(currentRating)}
              onMouseLeave={() => setHover(null)}
            />
          </label>
        );
      })}
    </div>
  )
}

export default StarRating