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
    url = 'http://localhost:8082/api/v1/user/${userID}';
    /**
     * Fetches the appointments from the API.
     */
    async fetchData(url) {
        const fetchOptions = {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
            }
        }

        // Ask the server for the data
        const response = await fetch(url, fetchOptions);

        // Interpret the data
        const code = response.status;
        if (code === 200) {
            console.log("Success");
            const data = await response.json(); // This is our data!
            console.log(data);
            return data;
        }  else {
            // We got an error back from the server
            throw new Error(`Error fetching data: ${code}`);
        }
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

    /**
     * Called when the component is mounted.
     * @returns {*}
     */
    componentDidMount() {
        this.loadUsers();
    }
    loadUsers(){
        let apiUrl = "http://localhost:8082/api/v1/user";
        // Load the users from the database.
        this.fetchData(apiUrl).then(data => {
                // For each appointment, create a new event object.
                const users = [];
                const user = data;
                const id=this.user.userID;
                const firstName = this.user.firstName;
                const lastName = this.user.lastName;
                const age=this.user.age;
                const gender=this.user.gender;
                const email=this.user.emailID;
                const phoneNumber=this.user.phoneNumber;
                const event = new Event(user.id, user.firstName, user.lastName, user.gender, user.age, user.emailID,user.phoneNumber);
                users.push(user);
                this.render();
            }
        ).catch(error => {
                console.log(error);
            }
        );
        console.log(this.state.users);
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
                            <Form.Control required type="text" name = "UFirstName" value={this.state.firstName}
                                          onChange={this.UserChange} placeholder="Firstname" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicText">
                            <Form.Label>User Lastname</Form.Label>
                            <Form.Control required type="text"  name = "ULastName" value={this.state.lastName}
                                          onChange={this.UserChange} placeholder="Lastname" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextId" >
                            <Form.Label>Gender</Form.Label>
                            <Form.Control required type="text" name = "UGender" value={this.state.gender}
                                          onChange={this.UserChange} placeholder="Gender" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextd" >
                            <Form.Label>Age</Form.Label>
                            <Form.Control required type="text" name = "UAge" value={this.state.age}
                                          onChange={this.UserChange} placeholder="Age" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>User Email</Form.Label>
                            <Form.Control required type="email" name = "UEmail" value={this.state.emailID}
                                          onChange={this.UserChange} placeholder="Email" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicTextId">
                            <Form.Label>Phone</Form.Label>
                            <Form.Control required type="text" name = "UPhone" value={this.state.phoneNumber}
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