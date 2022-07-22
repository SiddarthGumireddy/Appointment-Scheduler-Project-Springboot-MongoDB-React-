import React, {Component} from "react";

export default class Home extends Component{
    render() {
        return (

            <h1>
            <div className="text-white" style={{ textAlign: "center"}} >Welcome to the Perficient Scheduler</div>

        <h5>
            <div className="text-white" style={{ textAlign: "center"}} >You won't find a Scheduler like this ever again!</div>
            <div className="text-white" style={{ textAlign: "center"}} >Well, Maybe you will in the other demos.</div>
        </h5>
                <br/>
                <h5><div className="text-white" style={{ textAlign: "center"}} >Click on 'Manage Users' to List all Users</div></h5>
                <h5><div className="text-white" style={{ textAlign: "center"}} >Click on 'Manage Appointments' to List all Appointments</div></h5>
                <h5><div className="text-white" style={{ textAlign: "center"}} >Have fun scheduling!</div></h5>

            </h1>


        )
    }
}