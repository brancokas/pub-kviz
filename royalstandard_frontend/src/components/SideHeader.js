import {Layout} from "antd";
import React, {useState} from "react";
import {MenuOutlined} from '@ant-design/icons';
import HeaderMenuItems from "./partials/HeaderMenuItems";

const {Sider} = Layout;

const SideHeader = () => {

  const [collapsed, setCollapsed] = useState(false);
  const [isShown, setIsShown] = useState(false);

  return(
    <>
      <MenuOutlined className="menu-icon" onClick={() => setIsShown(bool => !bool)} />
      <div className="side-header-top" style={{width: "100%", height: "64px", backgroundColor: "#001529"}}></div>

      {/*conditional show*/}
      {isShown && (
        <div className="side-header" style={{position: "relative", zIndex: 10}}>
          <Sider collapsible
                 collapsed={collapsed}
                 onCollapse={(value) => setCollapsed(value)}
                 style={{ minHeight: "100%", position: "absolute", bottom: 0  }}>

              <HeaderMenuItems headerType="side" />
          </Sider>
        </div>
      )}
    </>
  );
}

export default SideHeader;