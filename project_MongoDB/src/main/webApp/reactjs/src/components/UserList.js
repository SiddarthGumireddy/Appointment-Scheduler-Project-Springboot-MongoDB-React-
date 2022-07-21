import React from "react";
import {ButtonGroup, Card, Form, Table} from "react-bootstrap";
import Button from 'react-bootstrap/Button';
import axios from "axios";
import {Link} from "react-router-dom";
//import app from "../App";
import UserUpdate from "../components/UserUpdate";
class UserList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {
        this.findAllUsers();
    }

    findAllUsers(){
        axios.get("http://localhost:8082/api/v1/user/ListAllUsers/")
            .then((response)=>response.data)
            .then((data) => {
                this.setState({users:data});
            })
    }

    deleteUser = (userID) =>{
        axios.delete("http://localhost:8082/api/v1/user/delete/"+userID)
            .then(response =>{
                if (response.data != null){
                    alert("user with ID: "+userID + " deleted successfully")
                    this.setState({
                        users: this.state.users
                            .filter(user => user.userID !== userID)
                    });
                }

            });
    };

    render() {
        return (

            <Card className="border border-dark bg-dark text-white">
                <Card.Header>All Users</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant="dark">
                        <thead>
                        <tr>

                            <th className="text-white">Firstname</th>
                            <th className="text-white">Lastname</th>
                            <th className="text-white">Gender</th>
                            <th className="text-white">Age</th>
                            <th className="text-white">Email</th>
                            <th className="text-white">Phone</th>
                            <th className="text-white">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.users.length === 0 ?
                            <tr align="center">
                                <td colSpan="8"> No Users Scheduled</td>
                            </tr> :
                            this.state.users.map((user)=> (
                                <tr key ={user.userID}>
                                    {/*<td type={"hidden"}>{user.userID}</td>*/}
                                    <td>{user.firstName}</td>
                                    <td>{user.lastName}</td>
                                    <td>{user.gender}</td>
                                    <td>{user.age}</td>
                                    <td>{user.emailID}</td>
                                    <td>{user.phoneNumber}</td>
                                    <td>
                                        <ButtonGroup>
                                            {/*<Link to={"/EditU/"+user.userID} className="btn btn -sm btn-outline-primary"*/}
                                            {/*      onClick={UserUpdate.helpID.bind(this, user.userID)}>Update</Link>*/}
                                            <Button href={"/EditU/"+user.userID}
                                                    // onClick={UserUpdate.helpID.bind(this, user.userID)}
                                                    value={user.userID}
                                                    id={"updateButton"}>Update
                                                    </Button>
                                            <Button variant={"danger"} onClick={this.deleteUser.bind(this, user.userID)}>
                                                Delete
                                            </Button>{''}
                                        </ButtonGroup>
                                    </td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </Table>
                    <Form ><Button href="/User">Add User</Button></Form>
                </Card.Body>


            </Card>

        )

    }
}
export default UserList;