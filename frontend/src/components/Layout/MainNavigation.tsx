import  { Link } from 'react-router-dom';
import { NavLink } from "react-router-dom"
import {Container, Nav, Navbar} from "react-bootstrap";
import React from "react";

function MainNavigation() {
    return <>
        <header className="header">
            <nav>
                <ul>
                    <li>
                        <img
                            src={require('../../images/carparkingimg.png')}
                            width="150"
                            height="150"
                            className ="navimg"
                        />
                    </li>
                    <li>
                        <Link to="/"><h1>Rent-A-Spot</h1></Link>
                    </li>
                    <li>
                        <Link to="/reservation"><h2>Reservations</h2></Link>
                    </li>
                    <li>
                        <Link to="/reservation/create"><h2>New reservation</h2></Link>
                    </li>
                </ul>
            </nav>
        </header>
    </>


}
export default MainNavigation;