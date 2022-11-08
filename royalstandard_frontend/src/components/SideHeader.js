import {Layout, Menu } from "antd";
import React, {useState} from "react";
import {DesktopOutlined, MenuOutlined, PieChartOutlined} from '@ant-design/icons';

const {Sider } = Layout;

function getItem(label, key, icon, children) {
  return {key, icon, children, label};
}

const items = [
  // eslint-disable-next-line react/jsx-no-undef
  getItem('Home', 'side-header-link-home', <PieChartOutlined />),
  getItem('Register', 'side-header-link-register', <DesktopOutlined />),
  getItem('Login', 'side-header-link-login', <DesktopOutlined />),
  getItem('Notifications', 'side-header-link-notifications', <DesktopOutlined />),

  // EXAMPLE OF THE NESTED OPTIONS FROM THE DOCUMENTATION

  // getItem('Login', '3', <UserOutlined />, [
  //   getItem('Option 3-1', '3-1'),
  //   getItem('Option 3-2', '3-2'),
  //   getItem('Option 3-3', '3-3'),
  // ]),
  // getItem('Option 4', '4', <TeamOutlined />, [getItem('Option 4-1', '4-1'), getItem('Option 4-2', '4-2')]),
  // getItem('Option 5', '5', <FileOutlined />),
];

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

            <Menu theme="dark"
                  defaultSelectedKeys={['1']}
                  mode="inline"
                  items={items}
                  onSelect={data => {
                    let newPath = `/${data.key.split("side-header-link-")[1]}`;
                    window.location.assign(newPath);
                  }}/>
          </Sider>
        </div>
      )}
    </>
  );
}

export default SideHeader;