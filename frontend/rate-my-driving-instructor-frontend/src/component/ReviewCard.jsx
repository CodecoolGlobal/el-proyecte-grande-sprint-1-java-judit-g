function ReviewCard({ review }) {
  
  return (
    <div className="wrapper">
      <div className="review-card">
        <h4>{review.rating}</h4>
        <h3>{review.reviewer.username}</h3>
        <h1>{review.description}</h1>
      </div>
    </div>
  )
}

export default ReviewCard