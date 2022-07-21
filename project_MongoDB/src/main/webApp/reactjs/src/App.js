import './App.css';
import NavigationBar from "./components/NavigationBar";
import {Col, Container, Row} from "react-bootstrap";
import AppointmentList from "./components/AppointmentList";
import UserList from "./components/UserList";
import Home from "./components/Home";
import Appointment from "./components/Appointment";
import Update from "./components/Update";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import User from "./components/User";
import UserUpdate from "./components/UserUpdate";

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
                    <Route exact path = "/Edit/:appointmentID" element={<Update/>}/>
                    <Route exact path = "/UserList" element={<UserList/>}/>
                    <Route exact path = "/AppointmentList" element={<AppointmentList/>}/>
                    <Route exact path = "/Appointment" element={<Appointment/>}/>
                    <Route exact path = "/User" element={<User/>}/>
                    <Route exact path = "/EditU/:userID" element={<UserUpdate/>}/>
                </Routes>
                </Col>
            </Row>
        </Container>
    </Router>
  );
}

export default App;
