import React, {useState} from 'react';
import './App.css';
import { Route, Routes, BrowserRouter as Router } from "react-router-dom"; //dulezite pro navigovani mezi strankama
import ExpensesDashboard from './pages/dashboard/ExpensesDashboard';
import FriendsDashboard from "./pages/dashboard/FriendsDashboard";
import ProfileDashboard from './pages/dashboard/ProfileDashboard';
import FeedDashboard from './pages/dashboard/FeedDashboard';
import LandingPage from './pages/LandingPage';
import AdminPage from './pages/AdminPage';
import UnauthorizedPage from './pages/dashboard/UnauthorizedPage';
import Chat from './components/Chat';

function App() {

  const links = [
    {
      id: 1,
      path: "/",
      component: <LandingPage />
    },
    {
      id: 2,
      path: "/expenses",
      component: <ExpensesDashboard />
    },
    {
      id: 3,
      path: "/feed",
      component: <FeedDashboard />
    },
    {
      id: 4,
      path: "/friends",
      component: <FriendsDashboard />
    },
    {
      id: 5,
      path: "/profile",
      component: <ProfileDashboard />
    },
    {
      id: 6,
      path: "/chat",
      component: <Chat />
    },
    {
      id: 7,
      path: "/admin",
      component: <AdminPage />
    },
    {
      id: 8,
      path: "/unauthorized",
      component: <UnauthorizedPage />
    }
  ]
  const [theme, setTheme] = useState(true);

  const changeTheme = () => {
    setTheme(current => !current);
    const haha = document.getElementById("root");
    if (theme) {
      haha.style.backgroundColor = "#C3CFD9";
    } else {
      haha.style.backgroundColor = "black";
    }
  }

  return (
    <div>
      <button id='changer' className='navbar-button' onClick={changeTheme}>{theme ? "Light theme" : "Dark theme"}</button>
      <Router>
        <Routes>{
          }
          {links && links.map(link => {
            return (
              <Route key={link.id} path={link.path} element={link.component} />
            )
          })}
        </Routes>
      </Router>
    </div>
  );
}

export default App;
