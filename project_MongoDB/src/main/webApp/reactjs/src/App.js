import './App.css';
import NavigationBar from "./components/NavigationBar";
import {Col, Container, Row} from "react-bootstrap";
import AppointmentList from "./components/AppointmentList";
import UserList from "./components/UserList";
import Home from "./components/Home";
import Appointment from "./components/Appointment";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

function App() {
    const marginTop = {marginTop:"20px"};
    return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={12} style={marginTop}>
                <Routes>
                    <Route exact path = "/" element={<Home/>}/>
                    <Route exact path = "/UserList" element={<UserList/>}/>
                    <Route exact path = "/AppointmentList" element={<AppointmentList/>}/>
                    <Route exact path = "/Appointment" element={<Appointment/>}/>
                </Routes>
                </Col>
            </Row>
        </Container>
    </Router>
  );
}

export default App;
