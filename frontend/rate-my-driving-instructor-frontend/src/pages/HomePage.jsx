import { useEffect, useState } from "react"
import './HomePage.css'

export default function HomePage() {
    const [searchItem, setSearchItem] = useState("");
    const [searchType, setSearchType] = useState("Instructor");
    const [fetchedList, setFetchedList] = useState([]);
    const [stats, setStats] = useState({});

    async function fetchSearchData(searchType, searchItem) {
        const response = await fetch(`/api/school/${searchType.toLowerCase()}/${searchItem}`);
        const listedSearchResult = await response.json();
        setFetchedList(listedSearchResult);
    }

    async function fetchAllStatData() {
        const schoolRes = await fetch(`/api/school/count`);   
        const instructorRes = await fetch(`/api/instructor/count`);
        const reviewRes = await fetch(`/api/review/count`);
        const userRes = await fetch(`/api/user/count`);

        const schoolNumber = await schoolRes.json();
        const instructorNumber = await instructorRes.json();
        const reviewNumber = await reviewRes.json();
        const userNumber = await userRes.json();
        
        console.log(schoolNumber + "s", instructorNumber + "i", reviewNumber + "r", userNumber + "u");
        

        if (schoolNumber && instructorNumber && reviewNumber && userNumber) {
            setStats({
                "school": schoolNumber,
                "instructor": instructorNumber,
                "review": reviewNumber,
                "user": userNumber
            })
        }
    }

    function onSubmit(event) {
        event.preventDefault();
        fetchSearchData(searchType, searchItem);
        
    }
//function onClickToggle()

    useEffect(() => {
        fetchAllStatData()
    }, [])

    return (
        <>
        <div className="homePage">
            <div className="searchBar">
                <form className="searchForm" onSubmit={onSubmit}>
                    <input 
                    type="text"
                    value={searchItem}
                    placeholder={`${searchType}...`}
                    onChange={(e) => setSearchItem(e.target.value)} 
                    name="search" 
                    id="search" 
                    />
                </form>
                <div className="searchButtons">
                    <button 
                    type="button" 
                    onClick={() => setSearchType("Instructor")}>Instructor</button>
                    <button 
                    type="button" 
                    onClick={() => setSearchType("School")}>School</button> 
                </div>
            </div>
            <div className="searchResults">    
                {fetchedList ? fetchedList.map((item) => (
                    <div key={item.id}>
                        <table>
                            <thead>
                                <tr>
                                    <th>Name</th>
                                </tr>
                            </thead>
                        </table>
                    </div>

                    
                )) : (<div>no results yet</div>)}
            </div>
        </div>

        
        <div className="statDiv">
            <h1>
                STATISTICS
            </h1>
            <div className="schoolBox">
            <h3>Number of schools:</h3>
                {stats["school"]}
                </div>
                <div className="intructorBox">
            <h3> Number of instructors: </h3>  
                {stats["instructor"]}
                </div>
            <div className="userBox">
            <h3>Number of registered users:</h3>
                {stats["user"]}
            </div>
                <div className="reviewBox">
                <h3> Number of reviews: </h3>
                {stats["review"]}
            </div>
        </div>
        </>
    )
}