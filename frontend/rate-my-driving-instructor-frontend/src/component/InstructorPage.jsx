import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import InstructorCard from "./InstructorCard";

export default function InstructorPage() {
    const [instructor, setInstructor] = useState(null);
    const [isSearched, setIsSearched] = useState(true);
    const { publicID } = useParams();

    async function fetchInstructor(publicID) {
        console.log("ffff", publicID);
        const response = await fetch(`/api/instructor/${publicID}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('jwt')}`,
                'Content-type': 'application/json'
            }
        });
        const instructorJson = await response.json();
        setInstructor(instructorJson);
        console.log(instructorJson);
        
    }

    useEffect(() => {
        fetchInstructor(publicID);
        console.log("hhh", publicID);
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
        </div>
    </>)
}