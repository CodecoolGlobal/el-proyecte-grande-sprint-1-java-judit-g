import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ReviewForm from "../component/ReviewForm";
import InstructorCard from "../component/cards/InstructorCard";
import ReviewCard from "../component/cards/ReviewCard";
import '../component/content.css';


export default function InstructorPage() {
  const [instructor, setInstructor] = useState(null);
  const [isSearched, setIsSearched] = useState(true);
  const { publicID } = useParams();
  
  async function fetchInstructor(publicID) {
    const response = await fetch(`/api/instructor/${publicID}`, {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('jwt')}`,
        'Content-type': 'application/json'
      }
    });
    const instructorData = await response.json();
    setInstructor(instructorData);
  }

  useEffect(() => {
    fetchInstructor(publicID);
  }, [])

  async function handleSubmitReview() {
    await fetchInstructor(publicID);
  }

  return instructor && (<>
  <div className="d-flex flex-column min-vh-100">
  <div className="instructor-page">
    <div className="instructor-container mb-10">
      <InstructorCard 
        instructor={instructor}
        isSearched={isSearched}
      />
    </div>
    <div className="reviews-container overflow-auto">
      <ReviewForm instructorPublicId={publicID} onSubmit={handleSubmitReview}/>
      { 
        instructor.reviewDTOs.map(review => (
          <ReviewCard 
          review={review} 
          key={review.publicId}/>
        ))
      }
    </div>
  </div>
</div>

  </>)
}

