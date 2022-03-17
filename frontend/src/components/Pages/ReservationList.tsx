import {Link, useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";

const ReservationList = (props:any) =>  {
    const location = useLocation();
    const [reservations, setReservation] = useState([{
        id: props.reservation ? props.reservation.id : '',
        car: props.reservation ? props.reservation.car : '',
        startTime: props.reservation ? props.reservation.startTime : '',
        endTime: props.reservation ? props.reservation.endTime : '',
        reservationDate: props.reservation ? props.reservation.reservationDate : '',
        parkingspot: props.reservation ? props.reservation.parkingspot : ''
    },])
    const [error, setError] = useState(null)
    const [fetched, setFetched] = useState(false);

    const fetchReservations = () => {
        fetch("http://localhost:8080/reservation")
            .then(res => res.json())
            .then(reservations => setReservation(reservations))
            .catch(e => setError(e))
            .finally(() => setFetched(true))
    };

    useEffect(() => {
        fetchReservations()
    }, [location])

    if(!fetched){
            return <p>Loading...</p>
        }
    if (error){
        return <div>Error: {error}</div>;
    }else{
        return (
            <Container>
                <Table className="infocard  rounded-3">
                    <thead>
                        <tr>
                            <th scope="col"><h4>Name</h4></th>
                            <th scope="col"><h4>E-mail</h4></th>
                            <th scope="col"><h4>Car</h4></th>
                            <th scope="col"><h4>Number plate</h4></th>
                            <th scope="col"><h4>Parking spot</h4></th>
                            <th scope="col"><h4>From</h4></th>
                            <th scope="col"><h4>Until</h4></th>
                        </tr>
                    </thead>
                    <tbody>
                    {reservations
                        .map(reservation => (
                        <tr key={reservation.id}>
                            <td>{reservation.car.owner.firstname} {reservation.car.owner.lastname}</td>
                            <td>{reservation.car.owner.email}</td>
                            <td>{reservation.car.color}, {reservation.car.brand}</td>
                            <td>{reservation.car.licensePlate}</td>
                            <td>{reservation.parkingspot.spotCode}</td>
                            <td>{reservation.startTime}</td>
                            <td>{reservation.endTime}</td>
                        </tr>
                    ))}
                    </tbody>
                </Table>
            </Container>
        )
    }
}
export default ReservationList;