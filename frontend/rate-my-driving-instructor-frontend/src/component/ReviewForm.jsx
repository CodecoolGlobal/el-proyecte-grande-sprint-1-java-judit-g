import { useState } from "react"
import StarRating from './StarRating';

async function createReview(review) {
  const response = await fetch('/api/review', {
    method: 'POST',
    headers: {
      'Authorization': `Bearer ${localStorage.getItem('jwt')}`,
      "Content-Type": "application/json"
    },
    body: JSON.stringify(review)
  })

  //exception handling on frontend!
  if (response.status === 400) {
    const error = await response.json();
    console.log(error);
  } 
}

function ReviewForm({ instructorPublicId, onSubmit }) {

  const [description, setDescription] = useState(null);
  const [rating, setRating] = useState(null);

  function handleSubmit(event) {
    event.preventDefault();
    if (description) {
      let reviewerPublicId = localStorage.getItem('publicId');
      console.log(reviewerPublicId);
      let review = {description, instructorPublicId, reviewerPublicId, rating}
      console.log(review);
      createReview(review);
      onSubmit(review);
    }
  }

  return (
    <form className="review-form" onSubmit={event => handleSubmit(event)}>
      <div>
        <label htmlFor="description" />
        <input type="text" name="description" onChange={event => setDescription(event.target.value)} />
      </div>
      <div className="buttons">
        <button type="submit">Submit</button>
      </div>
      <StarRating onRating={setRating} rating={rating}/>
    </form>
    )
}

export default ReviewForm