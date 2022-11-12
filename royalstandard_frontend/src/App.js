import 'antd/dist/antd.min.css';
import './App.css';
import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";

import MainHeader from './components/MainHeader';
import SideHeader from './components/SideHeader';
import Logo from "./components/Logo";

import Register from "./components/pages/Register";
import Login from "./components/pages/Login";
import Home from "./components/pages/Home";
import Notifications from "./components/pages/Notifications";
import Logout from "./components/pages/Logout";

const App = () => {

  return(
    <>
      <MainHeader />
      <SideHeader />
      <Logo />

      <BrowserRouter>
        <Routes>
          <Route path="/register" element={<Register />}/>
          <Route path="/login" element={<Login />}/>
          <Route path="/notifications" element={<Notifications />}/>
          <Route path="/logout" element={<Logout />}/>

          {/*matches any route*/}
          <Route path="/*" element={<Home />}/>
        </Routes>
      </BrowserRouter>
    </>
)};
export default App;