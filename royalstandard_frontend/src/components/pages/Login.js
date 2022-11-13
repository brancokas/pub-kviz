import React, {useEffect, useState} from "react";
import {Button, Form, Input, Typography} from "antd";
import {ContentType, HTTPRequest} from "../../requests/HTTPRequest";
import {useNavigate} from "react-router-dom";
const {Title} = Typography;

const Login = () => {
  const [loggedIn, setLoggedIn] = useState(false);
  const [error, setError] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    if (loggedIn) {
      navigate('/home');
    }
  }, [loggedIn, navigate]);

  const onFinish = (values) => {
    console.log('Success:', values);

    const req = new HTTPRequest();
    req.post('/users/login', ContentType.JSON, JSON.stringify(values))
      .then(res => {
        if (!res.ok) {
          throw new Error("HTTP status: " + res.status);
        }
        return res.json();
      })
      .catch(err => {
        console.log(err);
        setError(() => err.message);
      })
      .then(data => {
        if (data !== undefined) {
          console.log(data)
          // save user to the session storage
          sessionStorage.setItem('user', JSON.stringify(data));
          setLoggedIn(() => true);
        }
      });
  };

  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  return(
    <div className="content-container">
      <Title level={2} style={{textAlign: "center"}}>Login</Title><br/>

      <div className="centered-flex">
        <Form
          name="basic"
          labelCol={{span: 9}} wrapperCol={{span: 15}} initialValues={{remember: true}}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          autoComplete="off"
        >
          <Form.Item label="Nickname" name="nickname"
                     rules={[{required: true, message: 'Please input your nickname!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="Password" name="password"
                     rules={[{required: true, message: 'Please input your name!'}]}
          >
            <Input.Password />
          </Form.Item>

          <Form.Item wrapperCol={{offset: 9, span: 10}}>
            <Button type="primary" htmlType="submit">Submit</Button>
          </Form.Item>
        </Form>

        <div style={{visibility: error === false ? "hidden" : "visible"}}>
          {error}
        </div>
      </div>
    </div>
  )
};

export default Login;