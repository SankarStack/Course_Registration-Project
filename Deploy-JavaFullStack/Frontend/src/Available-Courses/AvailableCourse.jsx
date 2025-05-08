import React, { useEffect, useState } from 'react'
import './AvailableCourseCss.css'
import { useNavigate } from 'react-router-dom';
const AvailableCourse = () => {
    const [course, getCourse] = useState([])
    useEffect(() => {
        const getCourseData = async () => {
            try {
                const response = await fetch("http://localhost:8080/getCourses");
                const result = await response.json();
                getCourse(result);
            }
            catch (err) {
                console.log(err)
            }
        }
        (async () => await getCourseData())()
    }, []);

    const enrollCourseNavigate = useNavigate();
    const enrollCourse = () => {
        enrollCourseNavigate('/courseform');
    }
    return (

        <div className="view-course">
            <h1>Availabe-Courses</h1>
            <table>
                <tr>
                    <th>CourseId</th>
                    <th>CourseName</th>
                    <th>MentorName</th>
                    <th>Enroll-Course</th>
                </tr>
                {
                    course.map((courses) => (
                        <tr key={courses.courseId}> 
                            <th>ID{courses.courseId}</th>
                            <th>{courses.courseName}</th>
                            <th>{courses.mentorName}</th>
                            <th><button onClick={enrollCourse}>Enroll</button></th>
                        </tr>
                    ))
                }
            </table>
        </div>
    )
}

export default AvailableCourse