import React from 'react'
import { useState } from 'react';

const UpdateSignedUser = () => {

    const [courseFormData, setCourseFormData] = useState({ userId: '', userName: '', courseName: '', courseDuration: '' })

    function handleChange(e) {
        setCourseFormData({
            ...courseFormData,
            [e.target.name]: e.target.value
        })
    };

    async function handleSubmit(e) {
        e.preventDefault();
        try {
            const response = await fetch("http://localhost:8080/updateCourseDetails", {
                method: "POST",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(courseFormData)
            })
            const result = await response.text();
            console.log("Result - text -> ", result)
        }
        catch (error) {
            console.log(error);
            alert("Error occured !!!", error)
        }
    }
    return (
        <>
            <div className="update-signed-user">

                <h1>Update-Course-Registered-Deatils</h1>

                <form onSubmit={handleSubmit}>

                    <label htmlFor="" >Enter your Id : </label>
                    <input type="text" name="userId" value={courseFormData.userId} onChange={handleChange} />
                    <br />

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
                        <button className='button' type='submit'>Update</button>
                    </div>
                </form>

            </div>

        </>
    )
}

export default UpdateSignedUser