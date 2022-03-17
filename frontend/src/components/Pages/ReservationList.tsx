import {Link, useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";

const CreateReservation = () =>  {
    return (
        <Container >
            <Table className="infocard rounded-3 allreservationstable">
                <thead>
                <tr>
                    <th scope="col"><h4>Name</h4></th>
                    <th scope="col"><h4>E-mail</h4></th>
                    <th scope="col"><h4>Car</h4></th>
                    <th scope="col"><h4>Number plate</h4></th>
                    <th scope="col"><h4>Parking spot</h4></th>
                    <th scope="col"><h4>Date</h4></th>
                    <th scope="col"><h4>From</h4></th>
                    <th scope="col"><h4>Until</h4></th>
                </tr>
                </thead>
                <tbody>
                <tr >
                    <td> Benjamin Celis</td>
                    <td> benjamin.celis@telenet.be</td>
                    <td> Volkswagen Golf grijs</td>
                    <td> abc-123</td>
                    <td> 1.02</td>
                    <td> 18.3.2022</td>
                    <td> 14:00</td>
                    <td> 16:00</td>
                </tr>
                <tr >
                    <td> John Smith</td>
                    <td> JohnSmith@telenet.be</td>
                    <td> Ford Galaxy rood</td>
                    <td> def-123</td>
                    <td> 2.02</td>
                    <td> 18.3.2022</td>
                    <td> 15:30</td>
                    <td> 17:00</td>
                </tr>
                <tr >
                    <td> Jan Jansens</td>
                    <td> JanJansens@telenet.be</td>
                    <td> Audi A1 blauw</td>
                    <td> erd-123</td>
                    <td> 1.04</td>
                    <td> 18.3.2022</td>
                    <td> 14:00</td>
                    <td> 16:00</td>
                </tr>
                <tr >
                    <td> Benjamin Celis</td>
                    <td> benjamin.celis@telenet.be</td>
                    <td> Volkswagen Golf grijs</td>
                    <td> abc-123</td>
                    <td> 1.05</td>
                    <td> 18.3.2022</td>
                    <td> 14:00</td>
                    <td> 16:00</td>
                </tr>
                <tr >
                    <td> Benjamin Celis</td>
                    <td> benjamin.celis@telenet.be</td>
                    <td> Volkswagen Golf grijs</td>
                    <td> abc-123</td>
                    <td> 1.06</td>
                    <td> 18.3.2022</td>
                    <td> 14:00</td>
                    <td> 16:00</td>
                </tr>
                </tbody>
            </Table>
        </Container>
    )

}
export default CreateReservation;