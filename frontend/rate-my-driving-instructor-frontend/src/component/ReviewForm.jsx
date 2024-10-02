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

  async function handleSubmit(event) {
    event.preventDefault();
    if (description) {
      let reviewerPublicId = localStorage.getItem('publicId');
      let userName = localStorage.getItem('username');
      let appUserDTO = {
        publicId: reviewerPublicId,
        username: userName
      }
      let reviewToPost = { description, instructorPublicId, reviewerPublicId, rating };
      let reviewToRender = { description, instructorPublicId, appUserDTO, rating };
      createReview(reviewToPost);
      onSubmit(reviewToRender);
    }
  }

  return (
    <div>
      <div className="review-form">
        <form className="p-3 p-xl-4" method="post" onSubmit={event => handleSubmit(event)}>
          <StarRating onRating={setRating} rating={rating} />
          <div className="mb-3">
            <label htmlFor="description" />
            <textarea id="message-1" className="form-control" name="description" rows="6" placeholder="Write down your experiences! :)" onChange={event => setDescription(event.target.value)}></textarea>
          </div>
          <div>
            <button className="btn btn-primary shadow d-block w-100" type="submit">Submit</button>
          </div>
        </form>
      </div>
    </div>
  )
}


export default ReviewForm