import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import InstructorCard from "./InstructorCard";
import ReviewCard from "./ReviewCard";
import ReviewForm from "./ReviewForm";

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

  function handleSubmitReview(review) {
    let newInstructor = structuredClone(instructor);
    console.log(newInstructor);
    newInstructor.reviewDTOs.push(review);
    setInstructor(newInstructor);
  }

  return instructor && (<>
    <div className="details">
      <InstructorCard 
        instructor={instructor}
        isSearched={isSearched}
      />
      <ReviewForm instructorPublicId={publicID} onSubmit={handleSubmitReview}/>
      { 
        instructor.reviewDTOs.map(review => (
          <ReviewCard 
          review={review} 
          key={review.publicId}/>
        ))
      }
    </div>
  </>)
}