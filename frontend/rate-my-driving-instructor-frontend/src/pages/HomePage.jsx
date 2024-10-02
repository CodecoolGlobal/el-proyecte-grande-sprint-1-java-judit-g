import { useEffect, useState } from "react"
import './HomePage.css'
import SchoolCard from "../component/cards/SchoolCard";
import InstructorCard from "../component/cards/InstructorCard";

export default function HomePage() {
    const [searchItem, setSearchItem] = useState("");
    const [searchType, setSearchType] = useState("School");
    const [fetchedList, setFetchedList] = useState([]);
    const [isSearched, setIsSearched] = useState(false);
    const [stats, setStats] = useState({});

    async function fetchSearchData(searchType, searchItem) {
        console.log(`/api/${searchType.toLowerCase()}/search?name=${searchItem}`);
        
        const response = await fetch(`/api/user/${searchType.toLowerCase()}/search?name=${searchItem}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });
        const listedSearchResult = await response.json();
        console.log(listedSearchResult);
        
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

    useEffect(() => {
        fetchAllStatData()
    }, [])

    return (
        <>
        <div className="homePage">
            <div className="searchBar card-body d-flex flex-column align-items-center">
                <div className="searchButtons">
                    <button 
                    className="btn btn-primary d-block w-100"
                    type="button" 
                    onClick={() => {
                        setSearchType("Instructor");
                        searchType === "Instructor" ? null : setFetchedList([]);
                        }}>Instructor</button>
                    <button 
                    className="btn btn-primary d-block w-100"
                    type="button" 
                    onClick={() => {
                        setSearchType("School");
                        searchType === "School" ? null : setFetchedList([]);
                        }}>School</button> 
                </div>  
                <form className="searchForm text-center" onSubmit={onSubmit}>
                    <input 
                    className="form-control"
                    type="text"
                    value={searchItem}
                    placeholder={`${searchType}...`}
                    onChange={(e) => setSearchItem(e.target.value)} 
                    name="search" 
                    id="search" 
                    />
                    <button type="submit" className="btn btn-primary d-block w-100">Search</button>
                </form>
            </div>
            {fetchedList[0] ? 
                <div className="searchResultBox">
                    <div className="searchResults" key='1' style={{ height: '10vh' }}>    
                        {fetchedList ? fetchedList.map((item) => (
                            <div key={item.id}>
                                {searchType === "School" ? 
                                <SchoolCard school={item}/> :
                                <InstructorCard instructor={item}
                                isSearched={isSearched}
                                />
                            }
                            </div>
                        )) : (<div>no results yet</div>)}
                    </div>
                </div> : null}
        </div>

        
        {/* <div className="statDiv">
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
        </div> */}
        </>
    )
}