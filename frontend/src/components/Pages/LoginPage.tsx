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
                        <Card.Title><h2>welcome to rent a spot</h2></Card.Title>
                        <Card.Text>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet at cum cumque est magnam molestiae odio officia omnis quam quas quasi, similique veritatis? Aperiam architecto enim placeat quibusdam quo? Enim!</p>
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
                                    <Form.Label><h5>Email address:</h5></Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control type="password" placeholder="Password" />
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
                <Card border="primary" className="registrationcard  " style={{ width: '25rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Register</h2></Card.Title>
                        <Card.Text>
                            <Form>
                                <br/>
                                <Form.Group controlId="formBasicFirstName">
                                    <Form.Label>First Name:</Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicLastName">
                                    <Form.Label>Last Name:</Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicEmail">
                                    <Form.Label>Email address</Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" />
                                </Form.Group>
                                <br/>
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control type="password" placeholder="Password" />
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