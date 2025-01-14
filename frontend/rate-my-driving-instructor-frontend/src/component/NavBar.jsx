import { useEffect, useState } from "react";
import './NavBar.css';
import { useNavigate } from "react-router-dom";

function NavBar() {
  const nav = useNavigate();
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('jwt'));

  function handleLogout() {
    localStorage.clear('jwt');
    localStorage.clear('publicId');
    setIsLoggedIn(false);
    window.dispatchEvent(new Event('storage'));
    nav('/home');
  }

  useEffect(() => {
    const checkAuthStatus = () => setIsLoggedIn(!!localStorage.getItem('jwt'));

    window.addEventListener('storage', checkAuthStatus);

    return () => window.removeEventListener('storage', checkAuthStatus);
  }, []);

  return <div>
    <nav id="mainNav" className="navbar navbar-dark navbar-expand-md sticky-top navbar-shrink py-3">
      <div className="container">
        <a className="navbar-brand d-flex align-items-center" href="/"><span className="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon"><svg className="bi bi-bezier" xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16">
          <path d="M0 10.5A1.5 1.5 0 0 1 1.5 9h1A1.5 1.5 0 0 1 4 10.5v1A1.5 1.5 0 0 1 2.5 13h-1A1.5 1.5 0 0 1 0 11.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zm10.5.5A1.5 1.5 0 0 1 13.5 9h1a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1-1.5 1.5h-1a1.5 1.5 0 0 1-1.5-1.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zM6 4.5A1.5 1.5 0 0 1 7.5 3h1A1.5 1.5 0 0 1 10 4.5v1A1.5 1.5 0 0 1 8.5 7h-1A1.5 1.5 0 0 1 6 5.5v-1zM7.5 4a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1z"></path>
          <path d="M6 4.5H1.866a1 1 0 1 0 0 1h2.668A6.517 6.517 0 0 0 1.814 9H2.5c.123 0 .244.015.358.043a5.517 5.517 0 0 1 3.185-3.185A1.503 1.503 0 0 1 6 5.5v-1zm3.957 1.358A1.5 1.5 0 0 0 10 5.5v-1h4.134a1 1 0 1 1 0 1h-2.668a6.517 6.517 0 0 1 2.72 3.5H13.5c-.123 0-.243.015-.358.043a5.517 5.517 0 0 0-3.185-3.185z"></path>
        </svg></span><span>Ratemydrivinginstructor.com</span></a><button className="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcol-1"><span className="visually-hidden">Toggle navigation</span><span className="navbar-toggler-icon"></span></button>
        <div id="navcol-1" className="collapse navbar-collapse">
          <ul className="navbar-nav mx-auto">
            <li className="nav-item"><a className="nav-link" href="/home">Home</a></li>
            {/* <li className="nav-item"><a className="nav-link" href="/instructors">Instructors</a></li>
            <li className="nav-item"><a className="nav-link" href="/schools">Schools</a></li> */}
            <li className="nav-item"><a className="nav-link" href="/contacts">Contacts</a></li>
            <li className="nav-item"><a className="nav-link" href="/aboutus">About us</a></li>
            {localStorage.getItem('roles')?.includes('ROLE_ADMIN') ?
              <li className="nav-item"><a className="nav-link" href="/admin">Admin section</a></li> : null}
          </ul>
          {localStorage.getItem('jwt') ?
            <a className="btn btn-primary shadow" role="button" onClick={handleLogout}>Log out</a> :
            <><a className="btn btn-primary shadow" role="button" href="/login">Sign in</a>
              <a className="btn btn-primary shadow" role="button" href="/register">Register</a></>}
        </div>
      </div>
    </nav>
  </div>
}

export default NavBar