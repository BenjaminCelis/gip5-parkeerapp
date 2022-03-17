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
    const [cars, setCars] = useState([{
       id: props.cars ? props.cars.id : '',
       brand: props.cars ? props.cars.brand : '',
       color: props.cars ? props.cars.color : '',
       licensePlate: props.cars ? props.cars.licensePlate : '',
       owner: props.cars ? props.cars.owner : '',
    },])
    const [reservation, setReservation] = useState({
       id: props.reservation ? props.reservation.id : '',
       car: props.reservation ? props.reservation.car : '',
       startTime: props.reservation ? props.reservation.startTime : '',
       endTime: props.reservation ? props.reservation.endTime : '',
       reservationDate: props.reservation ? props.reservation.reservationDate : '',
       parkingspot: props.reservation ? props.reservation.parkingspot : ''
    })

    const [error, setError] = useState(null)
    const [fetched, setFetched] = useState(false);
    const [errorMsg, setErrorMsg] = useState('');
    const {car, startTime, endTime,parkingspot} = reservation;


    const fetchParkingspots = () => {
       fetch("http://localhost:8080/parkingspot")
           .then(res => res.json())
           .then(parkingspots => setParkingspots(parkingspots))
           .catch(e => setError(e))
           .finally(() => setFetched(true))
    };
    const fetchCars = () => {
        fetch("http://localhost:8080/car")
            .then(res => res.json())
            .then(cars => setCars(cars))
            .catch(e => setError(e))
            .finally(() => setFetched(true))
    };

    useEffect(() => {
        fetchParkingspots()
        fetchCars()
    }, [location])

    const handleOnSubmit = (event:any) => {
        event.preventDefault();

        const values = [car, endTime, startTime, parkingspot];
        let errorMsg = '';

        const allFieldsFilled = values.every((field) => {
            const value = `${field}`.trim();
            return value !== '';
        });

            if (allFieldsFilled) {

                    const reservation = {
                        car,
                        endTime,
                        startTime,
                        parkingspot
                    };

                    const requestOptions = {
                                method: 'POST',
                                headers: { 'Content-Type': 'application/json' },
                                body: JSON.stringify(reservation)
                            };
                            fetch('http://localhost:8080/car', requestOptions)
                                .then(async response => {
                                    const isJson = response.headers.get('content-type')?.includes('application/json');
                                    const data = isJson && await response.json();

                                    if (!response.ok) {
                                        const error = (data && data.message) || response.status;
                                        return Promise.reject(error);
                                    }
                                })
                                .catch(error => {
                                    console.error('There was an error!', error);
                                });
            }
            else{
                errorMsg = 'Please fill out all the fields.';
            }
        setErrorMsg(errorMsg);
    };
    const handleInputChange = (event:any) => {
        const { name, value } = event.target;
        setReservation((prevState) => ({
        ...prevState,
        [name]: value
        }));
    };

       if(!fetched){
               return <p>Loading...</p>
           }
       if (error){
           return <div>Error: {error}</div>;
       }else{
           return (
        <Container>
            <div className="main">
                <Form onSubmit={handleOnSubmit}>
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
                                    <br/>
                                    <Form.Group controlId="startTime">
                                        <Form.Label>
                                            <h4>From:</h4>
                                        </Form.Label>
                                        <br/>
                                        <input
                                                name="startTime"
                                                className="input-control"
                                                value={startTime}
                                                onChange={handleInputChange}
                                                type="datetime-local"/>
                                    </Form.Group>
                                    <Form.Group controlId="endTime">
                                        <Form.Label>
                                            <h4>Until:</h4>
                                        </Form.Label>
                                        <br/>
                                        <input
                                                name="endTime"
                                                className="input-control"
                                                value={endTime}
                                                onChange={handleInputChange}
                                                type="datetime-local"/>
                                    </Form.Group>
                                    <br/>
                            </Card.Text>
                        </Card.Body>
                    </Card>

                </div>

                <div className="rightpanel">
                    <Card border="primary" className="createcards selectcarselector" style={{ width: '25rem' }}>
                        <Card.Body>
                            <Form.Group controlId="car">
                                <Form.Label>
                                    <Card.Title>
                                        <h2>Select your car:</h2>
                                    </Card.Title>
                                </Form.Label>
                                <Card.Text>
                                    <Form.Select
                                        name="car"
                                        className="input-control"
                                        value={car}
                                        onChange={handleInputChange}>
                                        <option value='' disabled>Choose a Car</option>
                                        {cars
                                        .map(car => (
                                        <option key={car.id} value={car.id}>{car.licensePlate}</option>
                                        ))}
                                    </Form.Select>
                                </Card.Text>
                            </Form.Group>
                        </Card.Body>
                    </Card>

                    <Card border="primary" className=" createcards parkingspotselector " style={{ width: '25rem' }}>
                        <Card.Body>
                            <Form.Group controlId="parkingspot">
                                <Form.Label>
                                    <Card.Title>
                                        <h2>Select your Parking Spot:</h2>
                                    </Card.Title>
                                </Form.Label>
                                <Card.Text>
                                    <Form.Select
                                        name="parkingspot"
                                        className="input-control"
                                        value={parkingspot}
                                        onChange={handleInputChange}>
                                        <option value='' disabled>Choose a Parking Spot</option>
                                        {parkingspots
                                        .map(parkingspot => (
                                        <option key={parkingspot.id} value={parkingspot.id}>{parkingspot.spotCode}</option>
                                        ))}
                                    </Form.Select>
                                    <br/>
                                    <br/>
                                    <br/>
                                <Button variant="success btn-warning" type="submit">
                                    Confirm your reservation
                                </Button>
                                <br/>
                                </Card.Text>
                            </Form.Group>
                        </Card.Body>
                    </Card>
                    <br />
                </div>
            </Form>
            </div>
        </Container>
    )
    }
}
export default CreateReservation;