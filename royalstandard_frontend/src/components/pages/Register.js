import {Button, Select, Form, Input, Upload, Typography} from "antd";
import {PlusOutlined} from "@ant-design/icons";
import {HTTPRequest, ContentType} from "../../requests/HTTPRequest"
import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
const {Title} = Typography;
const { Option } = Select;

const Register = () => {
  const [registered, setRegistered] = useState(false);
  let navigate = useNavigate();
  let responseOK

  useEffect(() => {
    if (registered) {
      navigate('/home');
    }
  }, [registered, navigate]);

  const onFinish = (values) => {
    console.log('Success:', values);

    const req = new HTTPRequest();
    req.post('/register', ContentType.JSON, JSON.stringify(values))
      .then(res => {
        if (!res.ok) {
          throw new Error("HTTP status: " + res.status);
        }
        return res.json();
      })
      .catch(err => {
        console.log(err);
      })
      .then(data => {
        if (data !== undefined) {
          console.log(data)
          setRegistered(() => true);
        }
      });
  };

  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  return(
    <div className="content-container">
      <Title level={2} style={{textAlign: "center"}}>Register</Title><br/>

      <div className="centered-flex">
        <Form
          name="basic"
          labelCol={{span: 9}} wrapperCol={{span: 15}} initialValues={{remember: true}}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          autoComplete="off"
        >
          <Form.Item label="Username" name="username"
                     rules={[{required: true, message: 'Please input your username!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="Name" name="name"
                     rules={[{required: true, message: 'Please input your name!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="Surname" name="surname"
                     rules={[{required: true, message: 'Please input your surname!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="E-mail" name="email"
                     rules={[{required: true, message: 'Please input your e-mail!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="Phone number" name="phone"
                     rules={[{required: false, message: 'Please input your phone number!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item name="role" label="Role"
                     rules={[{ required: true }]}
          >
            <Select
              placeholder="Select an option"
              allowClear
            >
              <Option value="player">player</Option>
              <Option value="creator">creator</Option>
            </Select>
          </Form.Item>

          <Form.Item label="Password" name="password"
                     rules={[{required: true, message: 'Please input your name!'}]}
          >
            <Input.Password />
          </Form.Item>

          <Form.Item label="Picture" valuePropName="fileList" rules={[{required: false}]}>
            <Upload action="/upload.do" listType="picture-card">
              <div>
                <PlusOutlined />
                <div style={{ marginTop: 8 }}>Upload</div>
              </div>
            </Upload>
          </Form.Item>

          <Form.Item wrapperCol={{offset: 6, span: 15}}>
            <Button type="primary" htmlType="submit">Submit</Button>
            <Button type="primary" htmlType="reset" style={{marginLeft: "20px"}}>Reset</Button>
          </Form.Item>
        </Form>
      </div>
    </div>
  )
};

export default Register;