import  { Link } from 'react-router-dom';
import { NavLink } from "react-router-dom"
import {Container, Nav, Navbar} from "react-bootstrap";
import React from "react";

function MainNavigation() {
    return <>
        <Navbar bg="#153965" variant="dark">
            <Container>
                <img
                    src={require('../../images/carparkingimg.png')}
                    width="150"
                    height="150"
                    className ="navimg"
                    alt="React Bootstrap logo"
                />
                <Navbar.Brand href="#home"><h1>Rent-A-Spot</h1></Navbar.Brand>
                <Nav className="me-auto">

                </Nav>

            </Container>
        </Navbar>
    </>


}
export default MainNavigation;