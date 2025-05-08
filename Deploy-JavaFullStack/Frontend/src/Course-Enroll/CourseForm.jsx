import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
const CourseForm = () => {

    const [userId,setUserId] = useState('')

    const [courseFormData,setCourseFormData] = useState({userName:'',courseName:'',courseDuration:''})
    const courseNavigate = useState();

    function handleChange(e){
        setCourseFormData({
            ...courseFormData,
            [e.target.name] : e.target.value
        })
    };

    async function handleSubmit (e){
        e.preventDefault();
        try{
            const response = await fetch("http://localhost:8080/courseform" , {
                method : "POST",
                headers: { 'Content-Type': 'application/json' },
                body : JSON.stringify(courseFormData)
            })
            const result = await response.text();
            console.log("Result - text -> ",result)
            setUserId("ID"+ parseInt(result))
        }
        catch(error){
            console.log(error);
            alert("Error occured !!!",error)
        }
    }

    const updateNavigate = useNavigate();
    const updateNavigateFun = () =>{
        updateNavigate('/updateCourseDetails')
    }
    return (
        <div className="Course-Form" >
            <h1>Course-Form</h1>
            <form  onSubmit={handleSubmit}>

                <label htmlFor="" >Enter the Name : </label>
                <input type="text" name="userName" value={courseFormData.userName} onChange={handleChange} />
                <br />

                <label htmlFor=""  >Enter the Course : </label>
                <input type="text" name="courseName" value={courseFormData.courseName} onChange={handleChange} />
                <br />

                <label htmlFor="" >Enter the Course Duration : </label>
                <select type="text" name="courseDuration" value={courseFormData.courseDuration} onChange={handleChange} required>
                    <option value="">-- Select an Option --</option>
                    <option value="2 Months">2 Months</option>
                    <option value="3 Months">3 Months</option>
                    <option value="6 Months">6 Months</option>
                </select>
                <br />

                <div className="Button">
                    <button className='button' type='submit'>Register</button>
                </div>
            </form>
            <div className="Button">
                    <button className='button' onClick={updateNavigateFun}>Update</button>
                </div>
            <div className="avai-courses">
                    <p>You can see the Available-Courses by using the Below link --</p>
                    <Link to="/availableCourse">View-Courses</Link>
                </div>
                <div className="User-Id">
                    <h1>Get your Id : {userId}</h1>
                </div>
        </div>
    )
}

export default CourseForm