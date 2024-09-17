function NavBar() {
   return <div>NAVBAR
      <button onClick={() => {
         localStorage.setItem('jwt', 0);
      }}>Logout</button>
   </div>
}

export default NavBar