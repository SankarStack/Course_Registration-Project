import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignInForm from './SignIn/SignInPage'
import LoginPage from './LoginIn/LoginPage';
import CourseForm from './Course-Enroll/CourseForm';
import AvailableCourse from './Available-Courses/AvailableCourse.jsx';
import UpdateCourseRegDetails from './UpdateCourseRegDetails/UpdateCourseRegDetails.jsx'

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<SignInForm />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path='/courseform' element = {<CourseForm />}/>
        <Route path='/availableCourse' element = {<AvailableCourse />} />
        <Route path='/updateCourseDetails' element = {< UpdateCourseRegDetails/>} />
      </Routes>
    </Router>
  )
}

export default App