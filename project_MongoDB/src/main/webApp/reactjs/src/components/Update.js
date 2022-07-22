import React, {Component} from "react";
import {Card, Form} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import axios from "axios";

export default class Appointment extends Component{
    APPTID= (window.location.href.slice(27));
    constructor(props) {
        super(props);
        this.state = {appointmentID:this.APPTID,userEmail:'', appointmentName:'', appointmentType:'',appointmentDesc:'', appointmentDate:'', startTime:'', endTime:''};
        this.AppointmentChange = this.AppointmentChange.bind(this);
        this.submitAppointment = this.submitAppointment.bind(this);
    }

    submitAppointment(event){
        event.preventDefault();

        const appointment = {
            appointmentID:this.APPTID,
            userEmail:this.state.AEmail,
            appointmentName:this.state.AName,
            appointmentType:this.state.AType,
            appointmentDescription:this.state.ADesc,
            appointmentDate:this.state.ADate,
            startTime:this.state.AStart,
            endTime:this.state.AEnd
        };

        axios.put("http://localhost:8082/api/v1/appointment/UpdateAppointment/"+appointment.appointmentID, appointment)
            .then(response => {
                if(response.data != null){
                    this.setState({appointmentID:this.APPTID,userEmail:'', appointmentName:'', appointmentType:'',appointmentDesc:'', appointmentDate:'', startTime:'', endTime:''});
                    alert("Appointment updated successfully!");
                }
            })
    };

    AppointmentChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }



    render() {
        return (
            <Card className="border border-dark bg-dark text-white">
                <Card.Header>Update an Appointment</Card.Header>
                <Card.Body>
                    <Form onSubmit={this.submitAppointment} id ="AppointmentFormID">
                        <Form.Group className="mb-3" controlId="formBasicText">
                            <Form.Label >Appointment ID : {this.APPTID}</Form.Label>
                            <Form.Control required type="hidden" name = "AID" value={this.APPTID}
                                          onChange={this.AppointmentChange} placeholder="Enter ID" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>User Email</Form.Label>
                            <Form.Control required type="email" name = "AEmail" value={this.state.AEmail}
                                          onChange={this.AppointmentChange} placeholder="Enter email" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword" >
                            <Form.Label>Appointment Name</Form.Label>
                            <Form.Control required type="text" name = "AName" value={this.state.AName}
                                          onChange={this.AppointmentChange} placeholder="Appointment Name" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicText">
                            <Form.Label>Appointment Type</Form.Label>
                            <Form.Control required type="text"  name = "AType" value={this.state.AType}
                                          onChange={this.AppointmentChange} placeholder="Appointment Type" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextd" >
                            <Form.Label>Appointment Description</Form.Label>
                            <Form.Control required type="text" name = "ADesc" value={this.state.ADesc}
                                          onChange={this.AppointmentChange} placeholder="Appointment Description" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicDate" >
                            <Form.Label>Date</Form.Label>
                            <Form.Control required type="text" name = "ADate" value={this.state.ADate}
                                          onChange={this.AppointmentChange} placeholder="Date" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTime">
                            <Form.Label>From</Form.Label>
                            <Form.Control required type="text" name = "AStart" value={this.state.AStart}
                                          onChange={this.AppointmentChange} placeholder="Appointment Name" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTime" >
                            <Form.Label>Till</Form.Label>
                            <Form.Control required type="text" name = "AEnd" value={this.state.AEnd}
                                          onChange={this.AppointmentChange} placeholder="Appointment Name" />
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Update
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        )
    }
}