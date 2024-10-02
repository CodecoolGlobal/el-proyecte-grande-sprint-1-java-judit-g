function UserPage({ user }) {



  return (

    <div className='customCard'>
      <div className="row row-cols-1 row-cols-md-2 mx-auto" style={{ marginRight: '900px' }}>
        <div className="col mb-5 imgHolder">
          <img className="rounded img-fluid shadow" src="../public/images/user_photo.jpg" style={{ width: '200px' }} />
        </div>
        <div className="col d-flex align-items-center justify-content-center mb-5">
          <div>
            <h5 className="fw-bold">{user.username}</h5>
            <p className="text-muted mb-4"><span>user id: </span>{user.publicId}</p>
          </div>
        </div>
      </div>
    </div>
  )

}

export default UserPage