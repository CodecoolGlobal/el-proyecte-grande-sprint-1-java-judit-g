import React, { useState } from 'react'
import SearchForm from './../component/SearchForm';
import UserCard from './../component/cards/UserCard';
import { Link } from 'react-router-dom';
import ReviewCard from '../component/cards/ReviewCard';
import AdminPageReviews from '../component/cards/AdminPageReviewCard';
import AdminReviewCard from '../component/cards/AdminReviewCard';

function AdminPage() {

  const [searchedUserName, setSearchedUserName] = useState("");
  const [userSearchResult, setUserSearchResult] = useState(null);
  const [toggle, setToggle] = useState(true);

  function removeDeletedReview(publicId) {
    let userClone = structuredClone(userSearchResult);
    userClone.reviews = userClone.reviews.filter(review => review.publicId !== publicId)
    setUserSearchResult(userClone)
  }

  async function fetchUser() {
    const response = await fetch(`/api/admin/appuser?username=${searchedUserName}`, {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${localStorage.getItem('jwt')}`,
        'Content-Type': 'application/json',
      }
    });
    const result = await response.json()
    setUserSearchResult(result);
  }

  async function handleSubmit(event) {
    event.preventDefault();
    await fetchUser();
  }

  function handleReturn() {
    setSearchedUserName(null)
    setUserSearchResult(null)
  }

  function handleClick() {
    setToggle(!toggle)
  }

  return (
    <>
      <div>
        {userSearchResult ? (
          <div className="d-flex flex-column">
            <div className="">
              <div className="user-container">
                <UserCard user={userSearchResult} />
                {
                  toggle ? (
                    <div>
                      <div className="reviews-container overflow-auto">
                        {
                          userSearchResult.reviews.map(review => (
                            <AdminReviewCard review={review} key={review.publicId} onDelete={removeDeletedReview}/>
                          ))
                        }
                      </div>
                      <button className="btn btn-primary d-block w-100"
                        onClick={handleClick}>Hide Reviews</button>
                    </div>
                  ) : (
                    <button className="btn btn-primary d-block w-100"
                      onClick={handleClick}>See Reviews</button>)
                }
                <button className="btn btn-primary d-block w-100"
                  onClick={handleReturn}>Return</button>
              </div>
            </div>
          </div>) : (
          <SearchForm
            onSubmit={handleSubmit}
            searchItem={searchedUserName}
            setSearchItem={setSearchedUserName}
            searchType={"user"} />
        )}
      </div>

    </>
  )
}

export default AdminPage