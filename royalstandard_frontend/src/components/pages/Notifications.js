import React from "react";
import {Card, Typography} from "antd";
const {Title} = Typography;

const Notifications = () => {

  return(
    <div className="content-container">
      <Title level={2} style={{textAlign: "center"}}>Notifications</Title><br/>

      <div className="centered-flex">
        <Card title="Notification 1" bordered={true} style={{ width: "400px" }}>
          Notification 1 content
        </Card>
      </div>
    </div>
  )
};

export default Notifications;