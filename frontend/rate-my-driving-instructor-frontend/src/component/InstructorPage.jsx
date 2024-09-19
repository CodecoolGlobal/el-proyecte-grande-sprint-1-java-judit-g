import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import InstructorCard from "./InstructorCard";
import ReviewCard from "./ReviewCard";

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
    console.log(instructorData.reviewDTOs);
    setInstructor(instructorData);
  }

  useEffect(() => {
    fetchInstructor(publicID);
  }, [])

  return instructor && (<>
    <div className="details">
      <InstructorCard
        firstname={instructor.firstName}
        lastname={instructor.lastName}
        publicId={instructor.publicID}
        schoolname={instructor.schoolNameDTO.name}
        licenceType={instructor.licenseTypeSet}
        rating={instructor.avgRating}
        isSearched={isSearched}
      />
      { 
        instructor.reviewDTOs.map(review => (
          <ReviewCard review={review} />
        ))
      }
    </div>
  </>)
}