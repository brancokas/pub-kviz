import MenuItem from "antd/es/menu/MenuItem";
import React from "react";
import {useNavigate} from "react-router-dom";
import {DesktopOutlined, HomeOutlined, LogoutOutlined, NotificationOutlined, UserOutlined} from "@ant-design/icons";
import {Menu} from "antd";


const HeaderMenuItems = (props) => {

  const navigate = useNavigate();
  const user = sessionStorage.getItem('user');

  const setDisplayForLoggedIn = () => {
    return user === null ? "block" : "none";
  }

  const setDisplayForLoggedOut = () => {
    return user !== null ? "block" : "none";
  }

  /**
   * icons are shown in a side header and hidden in the main header
   * @returns {string} display CSS property value
   */
  const setIconDisplay = () => {
    return props.headerType === 'main' ? "none" : "inline";
  }

  return(
    <Menu theme="dark" mode={props.headerType === 'main' ? "horizontal" : "inline"}>

      <MenuItem onClick={() => navigate("/")}>
        <HomeOutlined style={{display: setIconDisplay()}} />
        <span>Home</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/register")} style={{display: setDisplayForLoggedIn()}}>
        <DesktopOutlined style={{display: setIconDisplay()}} />
        <span>Register</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/login")} style={{display: setDisplayForLoggedIn()}}>
        <UserOutlined style={{display: setIconDisplay()}} />
        <span>Login</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/notifications")}>
        <NotificationOutlined style={{display: setIconDisplay()}} />
        <span>Notifications</span>
      </MenuItem>

      <MenuItem onClick={() => navigate("/logout")} style={{display: setDisplayForLoggedOut()}}>
        <LogoutOutlined style={{display: setIconDisplay()}} />
        <span>Logout</span>
      </MenuItem>

      {/* use <Submenu> component for a submenu */}
    </Menu>
  )
};

export default HeaderMenuItems;