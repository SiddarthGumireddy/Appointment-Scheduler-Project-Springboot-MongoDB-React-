import React from "react";
import {ButtonGroup, Card, Form, Table} from "react-bootstrap";
import Button from 'react-bootstrap/Button';
import axios from "axios";
import {Link} from "react-router-dom";
//import app from "../App";
class AppointmentList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            appointments: []
        };
    }

    componentDidMount() {
        this.findAllAppointments();
    }

    findAllAppointments(){
        axios.get("http://localhost:8082/api/v1/appointment/List/")
            .then((response)=>response.data)
            .then((data) => {
                this.setState({appointments:data});
            })
    }

    deleteAppointment = (appointmentID) =>{
        axios.delete("http://localhost:8082/api/v1/appointment/DeleteOne/"+appointmentID)
            .then(response =>{
                if (response.data != null){
                    alert("appointment with ID: "+appointmentID + " deleted successfully")
                    this.setState({
                        appointments: this.state.appointments
                            .filter(appointment => appointment.appointmentID !== appointmentID)
                    });
                }

            });
    };

    render() {
        return (

            <Card className="border border-dark bg-dark text-white">
                <Card.Header>All Appointments</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant="dark">
                        <thead>
                        <tr>

                            <th className="text-white">User Email</th>
                            <th className="text-white">Appointment Name</th>
                            <th className="text-white">Appointment Type</th>
                            <th className="text-white">Appointment Description</th>
                            <th className="text-white">Date</th>
                            <th className="text-white">Start Time</th>
                            <th className="text-white">End Time</th>
                            <th className="text-white">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.appointments.length === 0 ?
                                <tr align="center">
                                    <td colSpan="8"> No Appointments Scheduled</td>
                                </tr> :
                                this.state.appointments.map((appointment)=> (
                                    <tr key ={appointment.appointmentID}>

                                        <td>{appointment.userEmail}</td>
                                        <td>{appointment.appointmentName}</td>
                                        <td>{appointment.appointmentType}</td>
                                        <td>{appointment.appointmentDescription}</td>
                                        <td>{appointment.appointmentDate}</td>
                                        <td>{appointment.startTime}</td>
                                        <td>{appointment.endTime}</td>
                                        <td>
                                            <ButtonGroup>
                                                <Link to={"/Edit/"+appointment.appointmentID} className="btn btn -sm btn-outline-primary">Update</Link>
                                                <Button variant={"danger"} onClick={this.deleteAppointment.bind(this, appointment.appointmentID)}>
                                                    Delete
                                                </Button>{''}
                                            </ButtonGroup>
                                        </td>
                                    </tr>
                                    ))
                        }
                        </tbody>
                    </Table>
                    <Form ><Button href="/Appointment">Add an Appointment</Button></Form>
                </Card.Body>


            </Card>

        )

    }
}
export default AppointmentList;