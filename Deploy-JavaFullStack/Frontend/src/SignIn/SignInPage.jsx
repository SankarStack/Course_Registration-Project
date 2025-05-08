import React, { useState } from 'react'
import '../ButtonIcon/ButtonStyle.css'
import { useNavigate } from 'react-router-dom';

const SignInPage = () => {

    const navigate= useNavigate()
    const courseForm = useNavigate();

    const [formData, setFormData] = useState({ userName: '', userPwd: '', userGender: '' });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        var n =1;
        try {
            const response = await fetch('http://localhost:8080/addUser', {
    
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            });
        } catch (error) {
            console.error('Error:', error);
            alert('Server error.');
            n=0;
        }
        if(n==1){
            alert("You successfully Signed-In")
            courseForm('/courseform')
        }
    };

    const setNavigateFun = () =>{
        navigate('/login')
    }



    return (
        <div className="signIn">
            <form onSubmit={handleSubmit} >

                <label htmlFor="" >Username : </label>
                <input type="text" name="userName" value={formData.userName} onChange={handleChange} />
                <br />

                <label htmlFor=""  >Password : </label>
                <input type="password" name="userPwd" value={formData.userPwd} onChange={handleChange}/>
                <br />

                <label htmlFor="" >Select Gender : </label>
                <select type="text" name="userGender" value={formData.userGender} onChange={handleChange} required>
                    <option value="">-- Select an Option --</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
                <br />

                <div className="Button">
                    <button className='button' type='submit'>Signin</button>
                </div>

                <div className="login-mess">
                    <p>
                        if you already have an account, go to Login page
                    </p>
                    <div className="Button" >
                        <button type='submit' className='button' onClick={setNavigateFun}>Login</button>
                    </div>
                </div>

            </form>
        </div>
    )
}

export default SignInPage