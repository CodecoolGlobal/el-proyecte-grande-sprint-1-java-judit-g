import { Link } from "react-router-dom";
import './Card.css';

export default function InstructorCard({ instructor, isSearched }) {
    console.log(instructor);
    
    return <>
        <div className="customCard">
            <Link to={`/instructor/${instructor.publicID}`}>
                <div className="row row-cols-1 row-cols-md-2 mx-auto" style={{marginRight: '900px'}}>
                <div className="col mb-5">  
                    <img className="rounded img-fluid shadow" src="../public/images/no_profile.jpg" style={{width: '200px'}}/>
                </div>
                <div className="col d-flex align-items-center justify-content-center mb-5">
                    <div>
                    <h5 className="fw-bold">{instructor.lastName + ' ' + instructor.firstName}</h5>
                    {instructor.schoolNameDTO ?
                    <p className="text-muted mb-4"><span>School: </span>{instructor.schoolNameDTO.name}</p> : null}
                    <p className="text-muted mb-4"><span>Licences: </span>{instructor.licenseTypeSet && instructor.licenseTypeSet.map((item) =>
                                (<td key={item}>{item}</td>)
                            )}</p>
                    <p className="text-muted mb-4"><span>Rating: </span>{instructor.avgRating}</p>
                </div>
                </div>
                </div>
            </Link>
        </div>
    </>;
}