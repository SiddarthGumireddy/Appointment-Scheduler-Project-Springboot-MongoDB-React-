import React from "react";
import {Navbar, Nav} from "react-bootstrap";
import {Link} from "react-router-dom";
import logo from '../Img/PRFT2.png';


class NavigationBar extends React.Component {

    render() {

        return (
            <Navbar variant="dark" style={{ height: 60, backgroundColor:"#931919"}}>
                <Link to={"/"} className = "navbar-brand">
                    <img src={logo} width="100" height="75" alt="brand" padding-top="inherit"/>Scheduler
                </Link>

                <Nav className="me-auto" style={{ height: 43 }}>
                    <Link to={"/UserList"} className="nav-link" >Manage Users</Link>
                    <Link to={"/AppointmentList"} className="nav-link">Manage Appointments</Link>
                </Nav>
            </Navbar>
        );
    }

}
export default NavigationBar;
