import { useState, useEffect } from "react";

function LocalUserList() {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("/users.json")
      .then((res) => res.json())
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch(() => {
        setError("Failed to load users");
        setLoading(false);
      });
  }, []);

  if (loading) return <p className="status-text">Loading users...</p>;
  if (error) return <p className="status-text error">{error}</p>;

  return (
    <section className="panel-section">
      <h2 className="panel-title">Local Users</h2>

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

export default LocalUserList;