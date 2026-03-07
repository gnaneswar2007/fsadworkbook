import { useState, useEffect } from "react";

function UserList() {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((res) => res.json())
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch(() => {
        setError("API Error");
        setLoading(false);
      });
  }, []);

  if (loading) return <p className="status-text">Loading API users...</p>;
  if (error) return <p className="status-text error">{error}</p>;

  return (
    <section className="panel-section">
      <h2 className="panel-title">Users from API</h2>

      <div className="list-grid">
        {users.map((user) => (
          <div key={user.id} className="card">
            <h3 className="card-title">{user.name}</h3>
            <p><strong>Email:</strong> {user.email}</p>
            <p><strong>Phone:</strong> {user.phone}</p>
          </div>
        ))}
      </div>
    </section>
  );
}

export default UserList;