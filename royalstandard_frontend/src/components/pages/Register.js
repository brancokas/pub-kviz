import {Button, Select, Form, Input, Upload, Typography, Space, Radio} from "antd";
import {PlusOutlined} from "@ant-design/icons";
import {HTTPRequest, ContentType} from "../../requests/HTTPRequest"
import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import KnowledgeAreas from "../partials/KnowledgeAreas";
const {Title} = Typography;
const { Option } = Select;

const options = [];

for (let key of Object.keys(KnowledgeAreas)) {
  options.push({
    value: KnowledgeAreas[key],
    label: key.toString()
  });
}

const Register = () => {
  const [registered, setRegistered] = useState(false);
  const [error, setError] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    if (registered) {
      navigate('/home');
    }
  }, [registered, navigate]);

  const onFinish = (values) => {
    console.log('Success:', values);

    const req = new HTTPRequest();
    req.post('/users/register', ContentType.JSON, JSON.stringify(values))
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
          setRegistered(() => true);
        }
      });
  };

  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  const getFile = (e) => {
    // console.log('Upload event:', e);
    if (Array.isArray(e)) {
      return e;
    }
    return e && e.fileList;
  };

  const [hasTeam, setHasTeam] = useState(false);
  const onChange = (e) => {
    setHasTeam(e.target.value);
  };

  const [role, setRole] = useState(null);
  const showForNonQuizMasterRole = () => {
    return role !== 'QUIZMASTER';
  }

  const [selectedOptionsCount, setSelectedOptionsCount] = useState(0);

  return(
    <div className="content-container">
      <Title level={2} style={{textAlign: "center"}}>Register</Title><br/>

      <div className="centered-flex">
        <Form
          name="basic"
          labelCol={{span: 8}} wrapperCol={{span: 14}} initialValues={{remember: true}}
          style={{width: "400px"}}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          autoComplete="off"
        >
          <Form.Item label="First name" name="firstName"
                     rules={[{required: true, message: 'Please input your first name!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="Last name" name="lastName"
                     rules={[{required: true, message: 'Please input your last name!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="Nickname" name="nickname"
                     rules={[{required: true, message: 'Please input your nickname!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="E-mail" name="email"
                     rules={[{required: true, message: 'Please input your e-mail!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item label="Phone number" name="phoneNumber"
                     rules={[{required: false, message: 'Please input your phone number!'}]}
          >
            <Input />
          </Form.Item>

          <Form.Item name="role" label="Role"
                     rules={[{ required: true }, {message: 'Please input your role!'}]}
          >
            <Select placeholder="Select an option" allowClear onSelect={item => {
              console.log("selected role ", item)
              setRole(() => item)
            }}>
              <Option value="PLAYER">player</Option>
              <Option value="QUIZMASTER">quiz master</Option>
              <Option value="PLAYER,QUIZMASTER">both</Option>
            </Select>
          </Form.Item>

          {showForNonQuizMasterRole() &&
            <Form.Item label="I have a team"
                       name="hasTeam"
                       rules={[{required: true, message: 'Please choose this option!'}]}>

              <Radio.Group onChange={onChange} value={hasTeam}>
                <Space direction="horizontal">
                  <Radio value={true}>Yes</Radio>
                  <Radio value={false}>No</Radio>
                </Space>
              </Radio.Group>
            </Form.Item>
          }

          {hasTeam && showForNonQuizMasterRole() &&
            <Form.Item label="Team name" name="teamName"
            rules={[{required: showForNonQuizMasterRole(), message: 'Please input your team name!'}]}
            required={hasTeam}>

            <Input />
            </Form.Item>
          }

          {showForNonQuizMasterRole() &&
            <Form.Item label="Knowledge areas" name="knowledgeAreas"
                       validateTrigger="onChange"
                       rules={[{
                         required: showForNonQuizMasterRole(), message: 'Please select three areas!',
                         validator: (_) => {
                           if (selectedOptionsCount === 3) {
                             return Promise.resolve();
                           } else {
                             return Promise.reject('Some message here');
                           }
                         }
                       }]}
            >
              <Select
                mode="tags"
                style={{width: '100%'}}
                onChange={items => setSelectedOptionsCount(() => items.length)}
                tokenSeparators={[',']}
                options={options}
              />
            </Form.Item>
          }

          <Form.Item label="Password" name="password"
                     rules={[{required: true, message: 'Please input your name!'}]}
          >
            <Input.Password />
          </Form.Item>

          <Form.Item label="Image"
                     name='image'
                     valuePropName="fileList"
                     rules={[{required: false}]}
                     getValueFromEvent={getFile}>

            <Upload action="/upload.do"
                    listType="picture-card"
                    beforeUpload={() => {return false;}}>

              <div>
                <PlusOutlined /><div style={{ marginTop: 8 }}>Upload</div>
              </div>
            </Upload>
          </Form.Item>

          <Form.Item wrapperCol={{offset: 6, span: 15}}>
            <Button type="primary" htmlType="submit">Submit</Button>
            <Button type="primary" htmlType="reset" style={{marginLeft: "20px"}}>Reset</Button>
          </Form.Item>
        </Form>

        <div style={{visibility: error === false ? "hidden" : "visible"}}>
          {error}
        </div>
      </div>
    </div>
  )
};

export default Register;