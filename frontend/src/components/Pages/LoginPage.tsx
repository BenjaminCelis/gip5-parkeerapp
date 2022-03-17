import {Link, useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";


const LoginPage = () =>  {
    return (
        <Container>
            <div className="main">
                <div className="leftpanel">
                <Card border="primary" className="infocard rounded-3 " style={{ width: '25rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Welcome to Rent-A-Spot</h2></Card.Title>
                        <Card.Text>
                            <p>
                                Hello and welcome to Rent-A-Spot.
                                This web application is made for everyone who wants to reserve a parking spot at our parking in advance.
                                <br/> <br/>
                                After creating an account, you are able to rent a parking spot at a specific time for a certain time.
                            </p>
                        </Card.Text>
                    </Card.Body>
                </Card>

                <Card border="primary" className="logincard" style={{ width: '25rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Login</h2></Card.Title>
                        <Card.Text>
                            <Form>
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label><h5>Email:</h5></Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label><h5>Password:</h5></Form.Label>
                                    <Form.Control type="password" placeholder="Enter password" />
                                </Form.Group>
                                <br/>
                                <Button variant="success btn-warning" type="submit">
                                    Login
                                </Button>
                            </Form>
                        </Card.Text>
                    </Card.Body>
                </Card>
                </div>
                <Card border="primary" className="registrationcard" style={{ width: '25rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Register</h2></Card.Title>
                        <Card.Text>
                            <Form>
                                <br/>
                                <Form.Group controlId="formBasicFirstName">
                                    <Form.Label><h5>First name:</h5></Form.Label>
                                    <Form.Control type="email" placeholder="Enter first name" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicLastName">
                                    <Form.Label><h5>Last name:</h5></Form.Label>
                                    <Form.Control type="email" placeholder="Enter last name" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label><h5>Email:</h5></Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label><h5>Password:</h5></Form.Label>
                                    <Form.Control type="password" placeholder="Enter password" />
                                </Form.Group>
                                <br/>
                                <Button variant="success btn-warning" type="submit">
                                    Register
                                </Button>
                            </Form>
                        </Card.Text>
                    </Card.Body>
                </Card>
                <br />

            </div>
        </Container>
    )

}
export default LoginPage;