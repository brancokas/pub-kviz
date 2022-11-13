import MenuItem from "antd/es/menu/MenuItem";
import React from "react";
import {useNavigate} from "react-router-dom";
import {DesktopOutlined, HomeOutlined, LogoutOutlined, NotificationOutlined, UserOutlined} from "@ant-design/icons";
import {Menu} from "antd";

const HeaderMenuItems = (props) => {

  const navigate = useNavigate();
  const user = sessionStorage.getItem('user');

  const setDisplayForLoggedOut = () => {
    return user === null ? "block" : "none";
  }

  const setDisplayForLoggedIn = () => {
    return user !== null ? "block" : "none";
  }

  return(
    <Menu theme="dark" mode={props.headerType === 'main' ? "horizontal" : "inline"}>

      <MenuItem onClick={() => navigate("/")}>
        {props.headerType === 'side' && <HomeOutlined />}
        <span>Home</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/register")} style={{display: setDisplayForLoggedOut()}}>
        {props.headerType === 'side' && <DesktopOutlined />}
        <span>Register</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/login")} style={{display: setDisplayForLoggedOut()}}>
        {props.headerType === 'side' && <UserOutlined />}
        <span>Login</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/notifications")} style={{display: setDisplayForLoggedIn()}}>
        {props.headerType === 'side' && <NotificationOutlined/>}
        <span>Notifications</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/logout")} style={{display: setDisplayForLoggedIn()}}>
        {props.headerType === 'side' && <LogoutOutlined/>}
        <span>Logout</span>
      </MenuItem>

      {/* use <Submenu> component for a submenu */}
    </Menu>
  )
};

export default HeaderMenuItems;