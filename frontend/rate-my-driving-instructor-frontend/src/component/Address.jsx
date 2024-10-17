import React from 'react'

function Address({ address }) {
  return (
    <p className="text-muted mb-4"><span>Address: </span>{address.city + ', ' + address.postCode + ', ' + address.streetName + ' ' + address.streetNumber + '.'}</p>
  )
}

export default Address