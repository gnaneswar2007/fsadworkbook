import React from "react";
import {useNavigate} from "react-router-dom";

function Home(){

const navigate = useNavigate();

const username = localStorage.getItem("username");

if(!username){
navigate("/login");
}

return(
<div>
<h2>Welcome {username}</h2>
</div>
);
}

export default Home;