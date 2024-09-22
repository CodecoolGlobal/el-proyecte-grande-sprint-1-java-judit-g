import Address from '../Address'
import { Link } from "react-router-dom";
import './Card.css';

function SchoolCard({ school }) {
  
  
  return (
    <div className='customCard'>
      <Link to={`/school/${school.publicId}`}>
        <div className="row row-cols-1 row-cols-md-2 mx-auto" style={{marginRight: '900px'}}>
          <div className="col mb-5 imgHolder">
            <img className="rounded img-fluid shadow" src="../public/images/school_logo3.jpg" style={{width: '200px'}}/>
          </div>
          <div className="col d-flex align-items-center justify-content-center mb-5">
            <div>
            <h5 className="fw-bold">{school.name}</h5>
            <p className="text-muted mb-4"><span>Phone number: </span>{school.phoneNumber}</p>
            <Address address={school.addressDTO}/>
            <p className="text-muted mb-4">Number of instructors:</p>
            <p className="text-muted mb-4">Average rating of instructors:</p>
          </div>
          </div>
        </div>
      </Link>
    </div>
  )
}

export default SchoolCard