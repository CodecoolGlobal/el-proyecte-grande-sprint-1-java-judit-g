import AdminReviewCard from "./AdminReviewCard"

function AdminPageReviews({ user }) {

  return (
    <div>
      {
        user.reviews.map(review => (
          <AdminReviewCard review={review} key={review.publicId} />
        ))
      }
    </div>
  )
}

export default AdminPageReviews

