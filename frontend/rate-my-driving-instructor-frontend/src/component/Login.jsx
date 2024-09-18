import { useState } from 'react'

function Login() {
  const [username, setUsername] = useState(null);
  const [password, setPassword] = useState(null);

  async function handleSubmit(event) {
    event.preventDefault();
    const user = {
      username,
      password
    }

    const response = await fetch('/api/user/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(user)
    });
    const data = await response.json();
    console.log(data);
    
    if (data.jwt) {
      localStorage.setItem('jwt', data.jwt)
      localStorage.setItem('publicId', data.publicId)
    }
  }



  return (
    <div>Login
      <form onSubmit={event => {
        handleSubmit(event);
        }}>
        <input type="text" placeholder='username' onChange={e => setUsername(e.target.value)}/>
        <input type="password" placeholder='password' onChange={e => setPassword(e.target.value)}/>
        <button type='submit'></button>
      </form>
    </div>
  )
}

export default Login