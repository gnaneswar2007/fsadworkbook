import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ refresh }) {

const [students,setStudents]=useState([]);

useEffect(()=>{
fetchStudents();
},[refresh]);

const fetchStudents=async()=>{
const res=await axios.get("http://localhost:8080/students");
setStudents(res.data);
}

return(

<div>

<h2>Student List</h2>

<table border="1">

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
</tr>
</thead>

<tbody>

{students.map((s)=>(
<tr key={s.id}>
<td>{s.id}</td>
<td>{s.name}</td>
<td>{s.email}</td>
<td>{s.course}</td>
</tr>
))}

</tbody>

</table>

</div>

)
}

export default StudentList;