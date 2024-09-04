import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

function SchoolPage() {
  const { id } = useParams();
  const [school, setSchool] = useState(null);

  useEffect(() => {
    async function fetchData() {
      const response = await fetch(`/api/school/${id}`);
      const data = await response.json();
      console.log(data);
      
      setSchool(data);
    }
    fetchData();
  }, [id]);


  return (
    <div>
      <div>SchoolPage</div>
      {school ? 
        <div>
          <h3>{school.name}</h3>
          <h4>{school.phoneNumber}</h4>
        </div>
        : <h1>Loading...</h1>
      }
    </div>
  )
}

export default SchoolPage