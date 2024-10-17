import { Link } from "react-router-dom"

function AdminReviewCard({ review, onDelete }) {

  async function deleteReview(publicId) {
    await fetch(`/api/review/${publicId}`, {
      method: "DELETE"
    })
  }

  function handleDelete(publicId) {
    deleteReview(publicId);
    onDelete(publicId);
  }

  return (
    <div className="wrapper">
      <div className="col mb-4 d-flex">
        <div className="d-flex">
          <div className="d-flex flex-column align-items-center me-3">
          </div>
          <div className="d-flex flex-column align-items-start">
            <p className="bg-dark border rounded border-dark p-4 mb-2">{review.description}</p>
            <p className="text-muted mb-0">Rating: {review.rating}/5</p>
            <p className="text-muted mb-0">Published: {review.publishingTime.split('T')[0]} {review.publishingTime.split('T')[1].substring(0, 8)}</p>
            <Link to={`/instructor/${review.instructor.publicId}`}>
              <p className="text-muted mb-0">Instructor: {review.instructor.lastName} {review.instructor.firstName}</p>
            </Link>
            <button className="btn btn-primary d-block" style={{ width: '3.5cm' }}
            onClick={() => handleDelete(review.publicId)}>delete</button>
          </div>
        </div>
      </div>
    </div>


  )
}

export default AdminReviewCard

