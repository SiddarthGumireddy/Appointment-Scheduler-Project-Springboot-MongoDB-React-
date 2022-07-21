import React, {Component} from "react";
import {Card, Form} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import axios from "axios";

export default class User extends Component{
    constructor(props) {
        super(props);
        this.state = {userID:'',emailID:'', firstName:'', lastName:'',gender:'', age:'', phoneNumber:''};
        this.UserChange = this.UserChange.bind(this);
        this.submitUser = this.submitUser.bind(this);
    }


    submitUser(event){
        event.preventDefault();

        const user = {
            emailID:this.state.UEmail,
            firstName:this.state.UFirstName,
            lastName:this.state.ULastName,
            age:this.state.Uage,
            gender:this.state.Ugender,
            phoneNumber:this.state.UPhone,
        };

        axios.post("http://localhost:8082/api/v1/user/Add/", user)
            .then(response => {
                if(response.data != null){
                    this.setState({userID:'',emailID:'', firstName:'', lastName:'',gender:'', age:'', phoneNumber:''});
                    alert("User saved successfully!");
                }
            })
    };

    UserChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    render() {
        return (
            <Card className="border border-dark bg-dark text-white">
                <Card.Header>Add a User</Card.Header>
                <Card.Body>
                    <Form onSubmit={this.submitUser} id ="UserFormID">
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>User</Form.Label>
                            <Form.Control required type="email" name = "UEmail" value={this.state.UEmail}
                                          onChange={this.UserChange} placeholder="Email" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword" >
                            <Form.Label>User Firstname</Form.Label>
                            <Form.Control required type="text" name = "UFirstName" value={this.state.UFirstName}
                                          onChange={this.UserChange} placeholder="Firstname" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicText">
                            <Form.Label>User Lastname</Form.Label>
                            <Form.Control required type="text"  name = "ULastName" value={this.state.ULastName}
                                          onChange={this.UserChange} placeholder="Lastname" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextd" >
                            <Form.Label>Age</Form.Label>
                            <Form.Control required type="number" name = "UAge" value={this.state.UAge}
                                          onChange={this.UserChange} placeholder="Age" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextId" >
                            <Form.Label>Date</Form.Label>
                            <Form.Control required type="text" name = "UGender" value={this.state.UGender}
                                          onChange={this.UserChange} placeholder="Gender" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextId">
                            <Form.Label>From</Form.Label>
                            <Form.Control required type="text" name = "UPhone" value={this.state.UPhone}
                                          onChange={this.UserChange} placeholder="Phone Number" />
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