import React from 'react'
import Address from './Address'

function SchoolCard({ school }) {
  
  
  return (
    <div className='wrapper'>
      <div className='user-card'>
        <div className='user-card-img'>
          <img src="../public/images/school_logo3.jpg" alt="" />
        </div>
        <div className='user-card-info'>
          <h2>{school.name}</h2>
          <p><span>Phone number:</span>{school.phoneNumber}</p>
          <Address address={school.addressDTO}/>
          <p><span>Number of instructors:</span></p>
          <p><span>Average rating of instructors:</span></p>
        </div>
      </div>
    </div>
  )
}

export default SchoolCard