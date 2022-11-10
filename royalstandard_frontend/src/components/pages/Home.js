import React from "react";
import { Typography } from "antd";
const { Title } = Typography;

const Home = () => {
  return (
    <div className="content-container">
      <Title level={2} style={{ textAlign: "center" }}>
        Home
      </Title>
      <br />
      <div>
        Aplikacija nudi mogućnost lakšeg oglašavanja kvizova kvizaškoj
        zajednici, ali isto tako i lakše pronalaženje istih. Igrači koji bi se
        htjeli okušati u igranju kvizova, ali nemaju ekipu, također će pronaći
        prednosti aplikacije jer će ih ona sama međusobno povezati ovisno o
        njihovim područjima znanja. Aplikacija će upravo tim međusobnim
        povezivanjem igrača, ali i sastavljača kvizova pridonijeti stvaranju
        veće i jače kvizaške zajednice te samim time jačanju i širenju kvizaške
        scene.
      </div>
    </div>
  );
};

export default Home;
