import React, { useState } from 'react'
import SearchForm from './../component/SearchForm';
import UserPage from './../component/UserPage';

function AdminPage() {

  const [searchedUserName, setSearchedUserName] = useState("");
  const [userSearchResult, setUserSearchResult] = useState(null);

  async function fetchUser() {
    const response = await fetch(`/api/admin/appuser?username=${searchedUserName}`, {
      method: 'GET',
      headers: {
          'Authorization': `Bearer ${localStorage.getItem('jwt')}`,
          'Content-Type': 'application/json',
      }
  });
    const result = await response.json()
    console.log(result)
    setUserSearchResult(result);
  }

  async function handleSubmit(event) {
    event.preventDefault();
    await fetchUser();
  }

  return (
    <div>
      <SearchForm 
      onSubmit={handleSubmit}
      searchItem={searchedUserName}
      setSearchItem={setSearchedUserName}
      searchType={"user"}/>
      {userSearchResult ? (
      <UserPage user={userSearchResult}/> ) : (null)}
    </div>
  )
}

export default AdminPage