import { Link } from "react-router-dom";

export default function InstructorCard({ firstname, lastname, publicId, schoolname, licenceType, rating, isSearched }) {

    return <>
        <div>
            <Link to={`/instructor/${publicId}`}>
                <div className="row row-cols-1 row-cols-md-2 mx-auto" style={{marginRight: '900px'}}>
                <div className="col mb-5">
                    <img className="rounded img-fluid shadow" src="../public/images/no_profile.jpg" />
                </div>
                <div className="col d-flex align-items-center justify-content-center mb-5">
                    <div>
                    <h5 className="fw-bold">{firstname + ' ' + lastname}</h5>
                    <p className="text-muted mb-4"><span>School: </span>{schoolname}</p>
                    <p className="text-muted mb-4"><span>Licences: </span>{licenceType}</p>
                    <p className="text-muted mb-4"><span>Rating: </span>{rating}</p>
                </div>
                </div>
                </div>
            </Link>
        </div>
    </>;
}