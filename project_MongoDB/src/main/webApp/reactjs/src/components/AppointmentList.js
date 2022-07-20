import React from "react";
import {Card, Form, Table} from "react-bootstrap";
import Button from 'react-bootstrap/Button';
import axios from "axios";
class AppointmentList extends React.Component{
    render() {
        return (

            <Card className="border border-dark bg-dark text-white">
                <Card.Header>All Appointments</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant="dark">
                        <thead>
                        <tr>
                            <th className="text-white">ID</th>
                            <th className="text-white">User Email</th>
                            <th className="text-white">Appointment Name</th>
                            <th className="text-white">Appointment Type</th>
                            <th className="text-white">Appointment Description</th>
                            <th className="text-white">Date</th>
                            <th className="text-white">Start Time</th>
                            <th className="text-white">End Time</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr align="center">
                            <td colSpan="8">No Appointments Scheduled</td>
                        </tr>
                        </tbody>
                    </Table>
                    <Form ><Button href="/Appointment">Add an Appointment</Button></Form>
                </Card.Body>


            </Card>

        )

    }
}
export default AppointmentList;