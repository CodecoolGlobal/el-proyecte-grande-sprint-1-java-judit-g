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
        const schoolResponse = await fetch(`/api/school/${searchType}/${searchItem}`);   
        const instructorNumber = await fetch(`/api/school/${searchType}/${searchItem}`);
        const reviewNumber = await fetch(`/api/school/${searchType}/${searchItem}`);
        const userNumber = await fetch(`/api/school/${searchType}/${searchItem}`);

        const schoolResult = await schoolNumber.json();
        const instructorResult = await instructorNumber.json();
        const reviewResult = await reviewNumber.json();
        const userResult = await userNumber.json();
        
        setStats({
            "school": schoolNumber,
            "instructor": instructorNumber,
            "review": reviewNumber,
            "user": userNumber
        })
    }

    function onSubmit(event) {
        event.preventDefault();
        fetchSearchData(searchType, searchItem);
    }

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
                <button type="button" 
                onClick={() => setSearchType("instructor")}>Instructor</button>
                <button type="button" onClick={() => setSearchType("school")}>School</button> 
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
                {fetchAllStatData[school]}
            </div>
            <div className="intructorBox">
            Number of instructors: 
            {fetchAllStatData[instructor]}
            </div>
            <div className="userBox">
            {fetchAllStatData[user]}
            </div>
            <div className="reviewBox">
            {fetchAllStatData[review]}
            </div>
        </div>
        </>
    )
}