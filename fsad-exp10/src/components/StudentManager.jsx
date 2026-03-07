import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

  // Initial students array with 5 objects
  const [students, setStudents] = useState([
    { id: 1, name: "Rahul", course: "Computer Science" },
    { id: 2, name: "Anita", course: "Electronics" },
    { id: 3, name: "Vikram", course: "Mechanical" },
    { id: 4, name: "Sneha", course: "Civil" },
    { id: 5, name: "Arjun", course: "Information Technology" }
  ]);

  // Object to store new student data
  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  // Handle input change
  const handleChange = (e) => {
    const { name, value } = e.target;

    setNewStudent({
      ...newStudent,
      [name]: value
    });
  };

  // Add student
  const addStudent = () => {

    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      alert("Please fill all fields");
      return;
    }

    setStudents([...students, newStudent]);

    // Clear input fields
    setNewStudent({
      id: "",
      name: "",
      course: ""
    });
  };

  // Delete student
  const deleteStudent = (id) => {
    const updatedStudents = students.filter(
      (student) => student.id !== id
    );

    setStudents(updatedStudents);
  };

  return (
    <div className="container">

      <h2>Student Manager</h2>

      <div className="form">
        <input
          type="number"
          name="id"
          placeholder="Student ID"
          value={newStudent.id}
          onChange={handleChange}
        />

        <input
          type="text"
          name="name"
          placeholder="Student Name"
          value={newStudent.name}
          onChange={handleChange}
        />

        <input
          type="text"
          name="course"
          placeholder="Course"
          value={newStudent.course}
          onChange={handleChange}
        />

        <button onClick={addStudent}>Add Student</button>
      </div>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>

          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button
                    className="delete"
                    onClick={() => deleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>

        </table>
      )}

    </div>
  );
}

export default StudentManager;