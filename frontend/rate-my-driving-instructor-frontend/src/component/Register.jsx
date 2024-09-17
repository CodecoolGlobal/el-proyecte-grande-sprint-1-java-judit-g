import { useState } from 'react'

function Register() {
  const [username, setUsername] = useState(null);
  const [password, setPassword] = useState(null);

  async function handleSubmit(event) {
    event.preventDefault();
    const newUser = {
      username,
      password
    }

    const response = await fetch('/api/user/register', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(newUser)
    });
    const data = await response.json();
    console.log(data);
  }



  return (
    <div>Register
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

export default Register