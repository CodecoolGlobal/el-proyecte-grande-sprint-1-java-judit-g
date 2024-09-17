export default function InstructorCard({ firstname, lastname, publicId, schoolname, licenceType, rating }) {
    return <>
        <div className="intructor-card" id={publicId}>
            <div className="picture">place of picture</div>
            <div className="details">
                <table>
                    <thead>
                        <tr>
                            <td>Intstructor</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Name: {lastname} {" "} {firstname}</td>
                        </tr>
                        <tr>
                            <td>Schholname: {schoolname}</td>
                        </tr>
                        <tr>
                            <td>Licence type: </td>
                            {licenceType && licenceType.map((item) =>
                                (<td>{item}</td>)
                            )}
                        </tr>
                        <tr>
                            <td>Rating: {rating}</td>
                        </tr>
                    </tbody>

                </table>
            </div>
        </div>
    </>;
}