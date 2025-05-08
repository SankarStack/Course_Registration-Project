import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {

    const [loginform,setloginForm] = useState({userName:'',userPwd:''})
    const courseNavigate = useNavigate();
  
    const loginData = (e) => {
        setloginForm({
            ...loginform,
            [e.target.name] : e.target.value
        });
    };

    const handleSubmit = async (e) =>{
        e.preventDefault();
        try{
            const response = await fetch('http://localhost:8080/login',{
                method : 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(loginform)
            })
        const result = await response.json();
        console.log("Result -> ",result)
        if(result == true){
            alert("Loged-In !!!!")
            courseNavigate('/courseform');
        }
        else{
            alert("UserName or userPwd might be Wrong !!")
            console.log(result)
        }
        }
        catch(error){
            console.log("Error : ",error);
        }

    }
   
  return (
<div className="Login-Page">
            <form onSubmit={handleSubmit} >

                <label htmlFor="" >Username : </label>
                <input type="text" name="userName" value={loginform.userName} onChange={loginData} />
                <br />

                <label htmlFor=""  >Password : </label>
                <input type="password" name="userPwd" value={loginform.userPwd} onChange={loginData}/>
                <br />



                <div className="Button">
                    <button className='button' type='submit'>Login</button>
                </div>

            </form>
        </div>
  )
}

export default LoginPage