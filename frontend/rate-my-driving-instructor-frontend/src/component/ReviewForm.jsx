import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"

async function createForm(review) {

  await fetch('/api/review', {
    method: 'POST',
    headers: {
      'Authorization': `Bearer ${localStorage.getItem('jwt')}`,
      "Content-Type": "application/json"
    },
    body: JSON.stringify()
  })
}

function ReviewForm({ publicId }) {

  const navigate = useNavigate();
  const [description, setDescription] = useState(null);
  const [rating, setRating] = useState(null);

  function handleSubmit(event) {
    event.preventDefault();
    if (description) {
      let instructorPublicId = publicId;
      let reviewerPublicId = localStorage.getItem('publicId');
      let review = {description, instructorPublicId, reviewerPublicId, rating}
      createForm(review);
      navigate(`/instructor/${instructorPublicId}`);
    }
  }

  return (
    <form className="review-form" onSubmit={event => handleSubmit(event)}>
      <div>
        <label htmlFor="description" />
        <input type="text" name="description" onChange={event => setDescription(event.target)} />
      </div>
      <div className="buttons">
        <button type="submit">Submit</button>
      </div>
    </form>
    )
}

export default ReviewForm