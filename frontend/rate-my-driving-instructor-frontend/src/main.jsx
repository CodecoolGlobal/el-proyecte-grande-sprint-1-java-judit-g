import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import './index.css'
import Layout from './component/Layout.jsx'
import SchoolPage from './component/SchoolPage.jsx'
import HomePage from './pages/HomePage.jsx'
import Login from './component/Login.jsx'
import Register from './component/Register.jsx'
import InstructorPage from './component/InstructorPage.jsx'

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    children: [
        {
          path: "/home",
          element:<HomePage/>
        },
        {
          path: "/school/:id",
          element:<SchoolPage/>
        },
        {
          path: "/login",
          element:<Login/>
        },
        {
          path: "/register",
          element:<Register/>
        },
        {
          path: "/instructor/:publicID",
          element:<InstructorPage/>
        },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
      <RouterProvider router={router}/>
  </React.StrictMode>,
)