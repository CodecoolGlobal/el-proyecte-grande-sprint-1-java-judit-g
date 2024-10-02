import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ReviewForm from "./ReviewForm";
import InstructorCard from "./cards/InstructorCard";
import ReviewCard from "./cards/ReviewCard";
import './Content.css';


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
    console.log(instructorData);
    setInstructor(instructorData);
    console.log(instructor)
  }

  useEffect(() => {
    fetchInstructor(publicID);
  }, [])

  async function handleSubmitReview() {
    await fetchInstructor(publicID);
  }

  return instructor && (<>
    <div className="content">
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