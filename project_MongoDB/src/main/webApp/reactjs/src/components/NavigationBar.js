import React from "react";
import {Navbar, Nav} from "react-bootstrap";
import {Link} from "react-router-dom";


class NavigationBar extends React.Component {
    render() {
        return (
            <Navbar bg="primary" variant="dark">
                <Link to={"/"} className = "navbar-brand">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/b/ba/Book_icon_1.png" width="25" height="25" alt="brand"/>PRFT Scheduler
                </Link>

                <Nav className="me-auto">
                    <Link to={"/UserList"} className="nav-link">Manage Users</Link>
                    <Link to={"/AppointmentList"} className="nav-link">Manage Appointments</Link>
                </Nav>
            </Navbar>
        );
    }
}
export default NavigationBar;
