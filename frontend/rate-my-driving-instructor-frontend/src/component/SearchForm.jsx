function SearchForm({ onSubmit, searchItem, searchType, setSearchItem }) {

  return (
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
  )
}

export default SearchForm