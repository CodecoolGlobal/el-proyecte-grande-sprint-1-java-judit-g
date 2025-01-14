import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import './index.css'
import Layout from './component/Layout.jsx'
import SchoolPage from './component/SchoolPage.jsx'
import HomePage from './pages/HomePage.jsx'
import Register from './component/Register.jsx'
import App from './App.jsx'
import InstructorPage from './pages/InstructorPage.jsx'
import LoginPage from './pages/LoginPage.jsx'
import AboutUsPage from './pages/AboutUsPage.jsx'
import ContactPage from './pages/ContactPage.jsx'
import AdminPage from './pages/AdminPage.jsx'

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <App />
      },
      {
        path: "/home",
        element: <HomePage />
      },
      {
        path: "/school/:id",
        element: <SchoolPage />
      },
      {
        path: "/login",
        element: <LoginPage />
      },
      {
        path: "/register",
        element: <Register />
      },
      {
        path: "/instructor/:publicID",
        element: <InstructorPage />
      },
      {
        path: "/aboutus",
        element: <AboutUsPage />
      },
      {
        path: "/contacts",
        element: <ContactPage />
      },
      {
        path: "/admin",
        element: <AdminPage />
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)