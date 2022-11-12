import {Menu} from "antd";
import React from "react";
import {Header} from "antd/es/layout/layout";
import MenuItem from "antd/es/menu/MenuItem";

const MainHeader = () => {

  return(
    <Header
      className="main-header"
      style={{
        position: 'fixed',
        zIndex: 1,
        width: '100%',
      }}
    >
      <div className="logo" />

      <Menu theme="dark" mode="horizontal">
        {/*<Link> tags are not supported in this context*/}
        <MenuItem><a href="/">Home</a></MenuItem>
        <MenuItem><a href="/register">Register</a></MenuItem>
        <MenuItem><a href="/login">Login</a></MenuItem>
        <MenuItem><a href="/notifications">Notifications</a></MenuItem>
        <MenuItem><a href="/logout">Logout</a></MenuItem>
      </Menu>
    </Header>
  );
}

export default MainHeader;