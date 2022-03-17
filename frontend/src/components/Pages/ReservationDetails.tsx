import {Link, useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";

const ReservationDetails = () =>  {
    return (
        <Container>
            <div className="main">
                <Card border="primary" className="infocard rounded-3 leftpanel" style={{ width: '80rem' }}>
                        <Card.Title>
                            <div className="card-header">
                                <h2>Benjamin Celis</h2>
                                <p>Email: BenjaminCelis@telenet.be</p>
                            </div>
                        </Card.Title>
                </Card>
            </div>


                <Card border="primary" className=" rounded-3 card-your-cars car " style={{ width: '30rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Your registered cars:</h2></Card.Title>
                        <Card.Text>
                            <br/>
                            <div className="list-group">
                                <Table className=" rounded-3 ">
                                    <thead>
                                    <tr>
                                        <th scope="col"><h4>Car</h4></th>
                                        <th scope="col"><h4>Plate</h4></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr >
                                        <td> Volkswagen Golf grijs</td>
                                        <td> abc-123</td>
                                    </tr>
                                    <tr >
                                        <td> Ford Galaxy rood</td>
                                        <td> def-123</td>
                                    </tr>
                                    <tr >
                                        <td> Audi A1 blauw</td>
                                        <td> erd-123</td>
                                    </tr>
                                    </tbody>
                                </Table>

                            </div>
                        </Card.Text>
                    </Card.Body>
                </Card>

                <Card border="primary" className="infocard rounded-3 yourregistrationscard  " style={{ width: '40rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Your parking reservations:</h2></Card.Title>
                        <Card.Text>
                            <br/>
                            <Table className=" rounded-3 ">
                                <thead>
                                <tr>
                                    <th scope="col"><h4>Car</h4></th>
                                    <th scope="col"><h4>Plate</h4></th>
                                    <th scope="col"><h4>Spot</h4></th>
                                    <th scope="col"><h4>Date</h4></th>
                                    <th scope="col"><h4>From</h4></th>
                                    <th scope="col"><h4>Until</h4></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr >
                                    <td> Volkswagen Golf grijs</td>
                                    <td> abc-123</td>
                                    <td> 1.02</td>
                                    <td> 18.3.2022</td>
                                    <td> 14:00</td>
                                    <td> 16:00</td>
                                </tr>
                                <tr >
                                    <td> Ford Galaxy rood</td>
                                    <td> def-123</td>
                                    <td> 2.02</td>
                                    <td> 18.3.2022</td>
                                    <td> 15:30</td>
                                    <td> 17:00</td>
                                </tr>
                                <tr >
                                    <td> Audi A1 blauw</td>
                                    <td> erd-123</td>
                                    <td> 1.04</td>
                                    <td> 18.3.2022</td>
                                    <td> 14:00</td>
                                    <td> 16:00</td>
                                </tr>
                                </tbody>
                            </Table>
                        </Card.Text>
                        </Card.Body>
                </Card>




        </Container>
    )

}
export default ReservationDetails;