import { useState, useEffect } from "react";
import axios from "axios";

function FakePostList() {

  const [posts, setPosts] = useState([]);
  const [filterUser, setFilterUser] = useState("");

  const loadPosts = () => {
    axios.get("https://dummyjson.com/posts")
      .then((res) => {
        setPosts(res.data.posts);
      });
  };

  useEffect(() => {
    loadPosts();
  }, []);

  const filteredPosts = filterUser
    ? posts.filter(p => p.userId === Number(filterUser))
    : posts;

  return (
    <section className="panel-section">
      <h2 className="panel-title">Fake API Posts</h2>

      <div className="toolbar">
        <button className="action-btn" onClick={loadPosts}>Refresh</button>

        <label className="filter-label" htmlFor="user-filter">Filter by user:</label>
        <select
          id="user-filter"
          className="filter-select"
          onChange={(e) => setFilterUser(e.target.value)}
          value={filterUser}
        >
          <option value="">All Users</option>
          <option value="1">User 1</option>
          <option value="2">User 2</option>
          <option value="3">User 3</option>
        </select>
      </div>

      <div className="list-grid">
        {filteredPosts.map((post) => (
          <div key={post.id} className="card">
            <h3 className="card-title">{post.title}</h3>
            <p>{post.body}</p>
            <small><strong>User ID:</strong> {post.userId}</small>
          </div>
        ))}
      </div>
    </section>
  );
}

export default FakePostList;