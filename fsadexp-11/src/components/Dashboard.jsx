import { useState } from "react";
import LocalUserList from "./LocalUserList";
import UserList from "./UserList";
import FakePostList from "./FakePostList";

function Dashboard() {

  const [page, setPage] = useState("local");

  return (
    <div className="dashboard-shell">

      <h1 className="dashboard-title">React API Integration Dashboard</h1>

      <div className="tab-row">
        <button
          className={page === "local" ? "tab-btn active" : "tab-btn"}
          onClick={() => setPage("local")}
        >
          Local Users
        </button>
        <button
          className={page === "api" ? "tab-btn active" : "tab-btn"}
          onClick={() => setPage("api")}
        >
          Users API
        </button>
        <button
          className={page === "posts" ? "tab-btn active" : "tab-btn"}
          onClick={() => setPage("posts")}
        >
          Fake API Posts
        </button>
      </div>

      <div className="content-panel">
        {page === "local" && <LocalUserList />}
        {page === "api" && <UserList />}
        {page === "posts" && <FakePostList />}
      </div>

    </div>
  );
}

export default Dashboard;