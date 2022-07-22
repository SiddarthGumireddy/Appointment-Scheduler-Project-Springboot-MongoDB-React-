import React, {Component} from "react";
import {Card, Form} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import axios from "axios";


export default class User extends Component{
    USERID= (window.location.href.slice(28));
    constructor(props) {
        super(props);

        this.state = {userID:this.USERID, firstName:'', lastName:'',gender:'',emailID:'' ,phoneNumber:''};
        this.UserChange = this.UserChange.bind(this);
        this.submitUser = this.submitUser.bind(this);
    }




    submitUser(event){
        event.preventDefault();

        const user = {
            userID:this.USERID,
            firstName:this.state.UFirstName,
            lastName:this.state.ULastName,
            gender:this.state.UGender,
            age:this.state.UAge,
            emailID:this.state.UEmail,
            phoneNumber:this.state.UPhone,
        };

        axios.put("http://localhost:8082/api/v1/user/UpdateUser/"+user.userID, user)
            .then(response => {
                if(response.data != null){
                    this.setState({userID:'', firstName:'', lastName:'',gender:'',emailID:'' ,phoneNumber:''});
                    alert("User updated successfully!");
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
                <Card.Header>Update User</Card.Header>
                <Card.Body>
                    <Form onSubmit={this.submitUser} id ="UserFormID">
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            {/*<Form.Label>User ID</Form.Label>*/}
                            <Form.Control required type="hidden" name = "UID" value={this.USERID}
                                          onChange={this.UserChange} placeholder="User ID"/>
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
                            <Form.Label>User Email</Form.Label>
                            <Form.Control required type="email" name = "UEmail" value={this.state.UEmail}
                                          onChange={this.UserChange} placeholder="Email" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextId">
                            <Form.Label>Phone</Form.Label>
                            <Form.Control required type="text" name = "UPhone" value={this.state.UPhone}
                                          onChange={this.UserChange} placeholder="Phone Number" />
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