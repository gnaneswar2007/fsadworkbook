import React from "react";
import {Link,useNavigate} from "react-router-dom";

function Navbar(){

const navigate = useNavigate();

const logout = ()=>{
localStorage.removeItem("username");
navigate("/login");
}

return(

<div>

<Link to="/home">Home</Link> |
<Link to="/profile">Profile</Link> |
<button onClick={logout}>Logout</button>

</div>

);
}

export default Navbar;