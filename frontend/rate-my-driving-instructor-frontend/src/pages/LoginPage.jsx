import { useState } from 'react'
import { useNavigate } from 'react-router-dom';

function LoginPage() {
  const [username, setUsername] = useState(null);
  const [password, setPassword] = useState(null);
  const navigate = useNavigate();

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
      window.dispatchEvent(new Event('storage'));
      navigate('/home');
    }
  }

  return (
    <div>
      <section className="position-relative py-4 py-xl-5">
        <div className='container'>
          <div className='row mb-5'>
            <div className='row d-flex justify-content-center'>
              <div>
                <div className='card mb-5'>
                  <div className='card-body d-flex flex-column align-items-center'>
                    <div className='bs-icon-xl bs-icon-circle bs-icon-primary bs-icon my-4'>
                      <svg className="bi bi-person" xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16">
                        <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
                      </svg>
                    </div>
                    <form className="text-center" method="post" onSubmit={event => handleSubmit(event)}>
                      <div className="mb-3">
                        <input className="form-control" type="username" name="username" placeholder="Username" onChange={e => setUsername(e.target.value)}/>
                        </div>
                      <div className="mb-3">
                        <input className="form-control" type="password" name="password" placeholder="Password" style={{ marginRight: '82px' }} onChange={e => setPassword(e.target.value)}/>
                        </div>
                      <div className="mb-3">
                        <button className="btn btn-primary d-block w-100" type="submit">Login</button>
                        </div>
                      <p className="text-muted">Forgot your password?</p>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  )
}

export default LoginPage