import {Link, useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col, Dropdown, ListGroup} from "react-bootstrap";

const CreateReservation = (props:any) =>  {
                           const location = useLocation();
                           const [parkingspots, setParkingspots] = useState([{
                               id: props.parkingspot ? props.parkingspot.id : '',
                               floor: props.parkingspot ? props.parkingspot.floor : '',
                               spot: props.parkingspot ? props.parkingspot.spot : '',
                               spotCode: props.parkingspot ? props.parkingspot.spotCode : '',
                               taken: props.parkingspot ? props.parkingspot.taken : '',

                           },])
                           const [error, setError] = useState(null)
                           const [fetched, setFetched] = useState(false);

                           const fetchParkingspots = () => {
                               fetch("http://localhost:8080/parkingspot")
                                   .then(res => res.json())
                                   .then(parkingspots => setParkingspots(parkingspots))
                                   .catch(e => setError(e))
                                   .finally(() => setFetched(true))
                           };

                           useEffect(() => {
                               fetchParkingspots()
                           }, [location])

                           if(!fetched){
                                   return <p>Loading...</p>
                               }
                           if (error){
                               return <div>Error: {error}</div>;
                           }else{
           return (
        <Container>
            <div className="main">
                <div className="leftpanel">
                    <Card border="primary" className="createcards infocardcreate" style={{ width: '25rem' }}>
                        <Card.Body>
                            <Card.Text>
                                <p>
                                    On this page of the website you can rent your parking spot. Make sure every field is filled in. Afterwards you
                                    can press on the 'confirm your reservation' button to register your reservation.
                                </p>
                            </Card.Text>
                        </Card.Body>
                    </Card>

                    <Card border="primary" className="createcards" style={{ width: '25rem' }}>
                        <Card.Body>
                            <Card.Title><h2>Select your timeslot: </h2></Card.Title>
                            <Card.Text>
                                <Form>
                                    <br/>
                                    <div>
                                        <h4>from:</h4>
                                        <input type="datetime-local"/>

                                    </div>
                                    <div>
                                        <br/>
                                        <h4>until:</h4>
                                        <input type="datetime-local"/>

                                    </div>
                                    <br/>

                                </Form>
                            </Card.Text>
                        </Card.Body>
                    </Card>

                </div>

                <div className="rightpanel">
                    <Card border="primary" className="createcards selectcarselector" style={{ width: '25rem' }}>
                        <Card.Body>
                            <Card.Title><h2>Select your car:</h2></Card.Title>
                            <Card.Text>
                                <br/>
                                <select>
                                    <option>Select your car:</option>
                                    <option>car 1 - abc-123</option>
                                    <option>car 2 - def-123</option>
                                    <option>car 3 - efg-123</option>
                                    <option>car 4 - hij-123</option>
                                    <option>car 5 - klm-123</option>
                                </select>
                                <br/>
                                <br/>
                            </Card.Text>
                        </Card.Body>
                    </Card>

                    <Card border="primary" className=" createcards parkingspotselector " style={{ width: '25rem' }}>
                        <Card.Body>
                            <Card.Title><h2>Select your parking spot:</h2></Card.Title>
                            <Card.Text>
                                <br/>
                                <br/>
                                <br/>
                                <select>
                                    <option>Select your parking spot:</option>
                                    {parkingspots
                                    .filter(parkingspot => parkingspot.taken == false)
                                    .map(parkingspot => (
                                    <option key={parkingspot.id}>{parkingspot.spotCode}</option>
                                    ))}
                                </select>

                                <br/>
                                <br/>
                                <br/>

                                <Button variant="success btn-warning" type="submit">
                                    Confirm your reservation
                                </Button>
                                <br/>

                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <br />
                </div>


            </div>
        </Container>
    )
    }
}
export default CreateReservation;