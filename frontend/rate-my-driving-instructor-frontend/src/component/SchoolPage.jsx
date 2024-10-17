import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import Address from './Address';
import InstructorCard from './cards/InstructorCard';

function SchoolPage() {
  const { id } = useParams();
  const [school, setSchool] = useState(null);

  console.log(id);


  useEffect(() => {
    async function fetchData() {
      const response = await fetch(`/api/school/${id}`, {
        method: 'GET',
        headers: {
          'Authorization': `Bearer ${localStorage.getItem('jwt')}`,
          'Content-type': 'application/json'
        }
      });
      const data = await response.json();
      console.log(data);

      setSchool(data);
      console.log(data);
    }
    fetchData();

  }, [id]);


  return (
    <div>
      <div className='page'>SchoolPage</div>
      {school ?
        <div>
          <h3>{school.name}</h3>
          <h4>{school.phoneNumber}</h4>
          <Address address={school.addressDTO} />
          {school.instructors ?
            school.instructors.map(instructor => (
              <div key={instructor.publicId}>
                <InstructorCard instructor={instructor}></InstructorCard>
              </div>
            )) : null}
        </div>
        : <h1>Loading...</h1>
      }
    </div>
  )
}

export default SchoolPage