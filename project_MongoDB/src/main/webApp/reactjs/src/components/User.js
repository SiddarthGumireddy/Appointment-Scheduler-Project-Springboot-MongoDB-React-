import React, {Component} from "react";
import {Card, Form} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import axios from "axios";

export default class User extends Component{
    constructor(props) {
        super(props);
        this.state = {userID:'',firstName:'', lastName:'',gender:'', age:'',emailID:'',  phoneNumber:''};
        this.UserChange = this.UserChange.bind(this);
        this.submitUser = this.submitUser.bind(this);
    }


    submitUser(event){
        event.preventDefault();

        const user = {

            firstName:this.state.UFirstName,
            lastName:this.state.ULastName,
            gender:this.state.Ugender,
            age:this.state.Uage,
            emailID:this.state.UEmail,
            phoneNumber:this.state.UPhone,
        };

        axios.post("http://localhost:8082/api/v1/user/addUser", user)
            .then(response => {
                if(response.data != null){
                    this.setState({userID:'',firstName:'', lastName:'',gender:'', age:'', emailID:'', phoneNumber:''});
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

                        <Form.Group className="mb-3" controlId="formBasicTextId" >
                            <Form.Label>Gender</Form.Label>
                            <Form.Control required type="text" name = "UGender" value={this.state.UGender}
                                          onChange={this.UserChange} placeholder="Gender" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextd" >
                            <Form.Label>Age</Form.Label>
                            <Form.Control required type="text" name = "UAge" value={this.state.UAge}
                                          onChange={this.UserChange} placeholder="Age" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>User</Form.Label>
                            <Form.Control required type="email" name = "UEmail" value={this.state.UEmail}
                                          onChange={this.UserChange} placeholder="Email" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextId">
                            <Form.Label>Phone</Form.Label>
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