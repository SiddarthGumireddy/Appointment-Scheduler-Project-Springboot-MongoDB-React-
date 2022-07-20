import React, {Component} from "react";
import {Card, Form} from "react-bootstrap";
import Button from "react-bootstrap/Button";

export default class Appointment extends Component{
    constructor(props) {
        super(props);
        this.state = {AEmail:'', AName:'', AType:'',ADesc:'', ADate:'', AStart:'', AEnd:''};
        this.AppointmentChange = this.AppointmentChange.bind(this);
        this.submitAppointment = this.submitAppointment.bind(this);
    }

    submitAppointment(event){
        alert('UserEmail: '+this.state.AEmail+',ApptName: '+this.state.AName+
            ',ApptType: '+this.state.AType+',ApptDesc: '+this.state.ADesc+
            ',ApptDate: '+this.state.ADate+',Start: '+this.state.AStart+',End: '+this.state.AEnd);
        event.preventDefault();
    }

    AppointmentChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    render() {
        return (
            <Card className="border border-dark bg-dark text-white">
                <Card.Header>Add an Appointment</Card.Header>
                <Card.Body>
                    <Form onSubmit={this.submitAppointment} id ="AppointmentFormID">
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
                            <Form.Control required type="date" name = "ADate" value={this.state.ADate}
                                          onChange={this.AppointmentChange} placeholder="Date" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTime">
                            <Form.Label>From</Form.Label>
                            <Form.Control required type="time" name = "AStart" value={this.state.AStart}
                                          onChange={this.AppointmentChange} placeholder="Appointment Name" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTime" >
                            <Form.Label>Till</Form.Label>
                            <Form.Control required type="time" name = "AEnd" value={this.state.AEnd}
                                          onChange={this.AppointmentChange} placeholder="Appointment Name" />
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Add
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        )
    }
}