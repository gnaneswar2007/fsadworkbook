import React,{useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

function Login(){

const [login,setLogin] = useState({
username:"",
password:""
});

const navigate = useNavigate();

const handleChange = (e)=>{
setLogin({...login,[e.target.name]:e.target.value});
}

const handleSubmit = async(e)=>{
e.preventDefault();

const res = await axios.post("http://localhost:8080/api/login",login);

if(res.data){
localStorage.setItem("username",res.data.username);
navigate("/home");
}
}

return(
<div>
<h2>Login</h2>

<form onSubmit={handleSubmit}>
<input name="username" placeholder="Username" onChange={handleChange}/>
<input name="password" placeholder="Password" onChange={handleChange}/>
<button type="submit">Login</button>
</form>

</div>
);
}

export default Login;