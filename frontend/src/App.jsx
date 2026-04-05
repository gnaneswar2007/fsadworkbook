import React, { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {

  const [reload, setReload] = useState(false);

  const refreshData = () => {
    setReload(!reload);
  };

  return (
    <div>
      <h1>Student Management System</h1>

      <AddStudent onAdded={refreshData} />

      <StudentList refresh={reload} />

    </div>
  );
}

export default App;