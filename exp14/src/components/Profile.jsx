import React,{useEffect,useState} from "react";
import axios from "axios";

function Profile(){

const [user,setUser] = useState({});

const username = localStorage.getItem("username");

useEffect(()=>{

axios.get(`http://localhost:8080/api/user/${username}`)
.then(res=>{
setUser(res.data);
});

},[]);

return(
<div>
<h2>Profile</h2>

<p>Username : {user.username}</p>
<p>Email : {user.email}</p>

</div>
);
}

export default Profile;