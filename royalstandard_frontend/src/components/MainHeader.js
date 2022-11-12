import React from "react";
import {Header} from "antd/es/layout/layout";
import HeaderMenuItems from "./partials/HeaderMenuItems";

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
      <HeaderMenuItems headerType="main" />
    </Header>
  );
}

export default MainHeader;