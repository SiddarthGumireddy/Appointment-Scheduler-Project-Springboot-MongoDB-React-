import React, {Component} from "react";
import {Card} from "react-bootstrap";
import logo from '../Img/PRFT.png';
export default class Home extends Component{
    render() {
        return (

            <Card style={{ width: '80rem', backgroundColor:"darkgray"}}>
                <Card.Body>
                    <Card.Title style={{textAlign:'center'}}>Welcome to Perficient Scheduler</Card.Title>
                    <br/>
                    <Card.Text style={{textAlign:'center'}}>
                        <line>Where scheduling becomes easy.</line>

                    </Card.Text>

                </Card.Body>

            </Card>


        )
    }
}