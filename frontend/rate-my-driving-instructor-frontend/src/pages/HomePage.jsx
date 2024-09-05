import { useEffect, useState } from "react"
import './HomePage.css'

export default function HomePage() {
    const [searchItem, setSearchItem] = useState("");
    const [searchType, setSearchType] = useState("instructor");
    const [fetchedList, setFetchedList] = useState([]);
    const [stats, setStats] = useState({});

    async function fetchSearchData(searchType, searchItem) {
        const response = await fetch(`/api/school/${searchType}/${searchItem}`);
        const listedSearchResult = await response.json();
        setFetchedList(listedSearchResult);
    }

    async function fetchAllStatData() {
        const schoolRes = await fetch(`/api/school/count`);   
        const instructorRes = await fetch(`/api/instructor/count`);
        const reviewRes = await fetch(`/api/review/count`);
        const userRes = await fetch(`/api/reviwer/count`);

        const schoolNumber = await schoolRes.json();
        const instructorNumber = await instructorRes.json();
        const reviewNumber = await reviewRes.json();
        const userNumber = await userRes.json();

        // if (schoolNumber || instructorNumber || reviewNumber || userNumber) {
        //     setStats({
        //         "school": schoolNumber,
        //         "instructor": instructorNumber,
        //         "review": reviewNumber,
        //         "user": userNumber
        //     })
        // } 

    }

    function onSubmit(event) {
        event.preventDefault();
        fetchSearchData(searchType, searchItem);
    }
function onClickToggle()

    useEffect(() => {
        fetchAllStatData()
    }, [])

    return (
        <>
        <div className="homePage">
            <form className="searchForm" onSubmit={onSubmit}>
                <input 
                type="text"
                value={searchItem}
                onChange={(e) => setSearchItem(e.target.value)} 
                name="search" 
                id="search" 
                />
            </form>
            <div className="searchButtons">
                <button 
                type="button" 
                onClick={() => setSearchType("instructor")}>Instructor</button>
                <button 
                type="button" 
                onClick={() => setSearchType("school")}>School</button> 
            </div>
        
            <div className="searchResults">    
                {fetchedList ? fetchedList.map((item) => (

                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                            </tr>
                        </thead>
                    </table>
                    
                )) : (<div>no results yet</div>)}
            </div>
        </div>

        <div className="statDiv">STATS
            <div className="schoolBox">
                Number of schools: 
                {stats["school"]}
            </div>
            <div className="intructorBox">
            Number of instructors: 
            {stats["instructor"]}
            </div>
            <div className="userBox">
            {stats["user"]}
            </div>
            <div className="reviewBox">
            {stats["review"]}
            </div>
        </div>
        </>
    )
}