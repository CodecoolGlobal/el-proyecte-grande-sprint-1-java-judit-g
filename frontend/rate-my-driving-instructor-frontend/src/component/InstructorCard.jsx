import { Link } from "react-router-dom";

export default function InstructorCard({ instructor, isSearched }) {

    return <>
        <div className="intructor-card" id={instructor.publicID}>
            <div className="picture">place of picture</div>
            <div className="details">
                <table>
                    <thead>
                        <tr>
                            <td>Insructor</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Name: {instructor.lastName} {" "} {instructor.firstName}</td>
                        </tr>
                        <tr>
                            <td>Schoolname: {instructor.schoolNameDTO.name}</td>
                        </tr>
                        <tr>
                            <td>License type: </td>
                            {instructor.licenseTypeSet && instructor.licenseTypeSet.map((item) =>
                                (<td key={item}>{item}</td>)
                            )}
                        </tr>
                        <tr>
                            <td>Rating: {instructor.avgRating}</td>
                        </tr>
                    </tbody>
                </table>
                {!isSearched && 
                (<Link to={`/instructor/${instructor.publicID}`}>See reviews</Link>)}
            </div>
        </div>
    </>;
}