function ReviewCard( { review } ) {
  
  return (
    <div className="wrapper">
  <div className="col mb-4 d-flex">
    <div className="d-flex">
      <div className="d-flex flex-column align-items-center me-3">
        <img className="rounded-circle flex-shrink-0 fit-cover" width="50" height="50" src="../public/images/no_profile.jpg" />
        <p className="fw-bold text-primary mb-0 mt-2">{review.appUserDTO.username}</p>
      </div>
      <div className="d-flex flex-column align-items-start">
        <p className="bg-dark border rounded border-dark p-4 mb-2">{review.description}</p>
        <p className="text-muted mb-0">Rating: {review.rating}/5</p>
      </div>
    </div>
  </div>
</div>


  )
}

export default ReviewCard

