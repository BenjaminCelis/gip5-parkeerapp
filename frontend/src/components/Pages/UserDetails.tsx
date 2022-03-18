import {Link, useLocation} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";

const UserDetails = (props:any) =>  {
     const location = useLocation();
     const [user, setUser] = useState({
         id: props.user ? props.user.id : '',
         firstname: props.user ? props.user.firstname : '',
         lastname: props.user ? props.user.lastname : '',
         email: props.user ? props.user.email : ''
     })
    const [cars, setCars] = useState([{
       id: props.cars ? props.cars.id : '',
       brand: props.cars ? props.cars.brand : '',
       color: props.cars ? props.cars.color : '',
       licensePlate: props.cars ? props.cars.licensePlate : '',
       owner: props.cars ? props.cars.owner : '',
    },])
    const [reservations, setReservations] = useState([{
       id: props.reservation ? props.reservation.id : '',
       car: props.reservation ? props.reservation.car : '',
       startTime: props.reservation ? props.reservation.startTime : '',
       endTime: props.reservation ? props.reservation.endTime : '',
       reservationDate: props.reservation ? props.reservation.reservationDate : '',
       parkingspot: props.reservation ? props.reservation.parkingspot : ''
    },])
     const [error, setError] = useState(null);
     const [fetched, setFetched] = useState(false);
     const userId = location.pathname.substring(location.pathname.lastIndexOf("/") + 1)

     const fetchUser = () => {
         fetch(`http://localhost:8080/user/${userId}`)
             .then(res => res.json())
             .then(user => setUser(user))
             .catch(e => setError(e))
             .finally(() => setFetched(true))
     };
     const fetchReservations = () => {
        fetch(`http://localhost:8080/reservation/user/${userId}`)
            .then(res => res.json())
            .then(reservations => setReservations(reservations))
            .catch(e => setError(e))
            .finally(() => setFetched(true))
     };
     const fetchCars = () => {
         fetch(`http://localhost:8080/car/${userId}`)
             .then(res => res.json())
             .then(cars => setCars(cars))
             .catch(e => setError(e))
             .finally(() => setFetched(true))
     };

         const removeCar = (car:any) => {
             if (window.confirm(`Are you sure you want to remove: ${car.color}, ${car.brand}(${car.licensePlate})?`)) {
                 const requestOptions = {
                     method: 'DELETE'
                 };
                 fetch(`http://localhost:8080/car/${car.id}`, requestOptions)
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
                     })
                     .finally(() => fetchCars())
             }
         }
            const removeReservation = (reservation:any) => {
              if (window.confirm(`Are you sure you want to cancel the reservation?`)) {
                  const requestOptions = {
                      method: 'DELETE'
                  };
                  fetch(`http://localhost:8080/reservation/${reservation.id}`, requestOptions)
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
                      })
                      .finally(() => fetchReservations())
              }
            }


     useEffect(() => {
         fetchUser()
         fetchCars()
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
            <div className="main">
                <Card border="primary" className="infocard rounded-3 leftpanel " style={{ width: '79rem' }}>
                        <Card.Title>
                            <div className="card-header">
                                <h2>{user.firstname} {user.lastname}</h2>
                                <p>Email: {user.email}</p>
                            </div>
                        </Card.Title>
                </Card>
            </div>

                <Card border="primary" className=" rounded-3 card-your-cars car " style={{ width: '30rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Your registered cars:</h2></Card.Title>
                        <Link to={`/car/create/${user.id}`}>
                            <Button className="btn btn-warning">Add new Car</Button>
                        </Link>
                        <Card.Text>
                            <br/>
                            <div className="list-group">
                                <Table className=" rounded-3 ">
                                    <thead>
                                    <tr>
                                        <th scope="col"><h4>Brand</h4></th>
                                        <th scope="col"><h4>Color</h4></th>
                                        <th scope="col"><h4>Plate</h4></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        {cars
                                            .map(car => (
                                            <tr key={car.id}>
                                                <td>{car.brand}</td>
                                                <td>{car.color}</td>
                                                <td>{car.licensePlate}</td>
                                                <td><Button onClick={() => removeCar(car)} className="btn btn-danger">Remove</Button></td>
                                            </tr>
                                        ))}
                                    </tbody>
                                </Table>
                            </div>
                        </Card.Text>
                    </Card.Body>
                </Card>

                <Card border="primary" className=" rounded-3 yourregistrationscard  " style={{ width: '46rem' }}>
                    <Card.Body>
                        <Card.Title><h2>Your reservations:</h2></Card.Title>
                        <Link to={`/reservation/create/${user.id}`}>
                            <Button className="btn btn-warning">Make new Reservation</Button>
                        </Link>
                        <Card.Text>
                            <br/>
                            <Table className=" rounded-3 ">
                                <thead>
                                <tr>
                                    <th scope="col"><h4>Car</h4></th>
                                    <th scope="col"><h4>Plate</h4></th>
                                    <th scope="col"><h4>Spot</h4></th>
                                    <th scope="col"><h4>From</h4></th>
                                    <th scope="col"><h4>Until</h4></th>
                                </tr>
                                </thead>
                                <tbody>
                                    {reservations
                                        .map(reservation => (
                                        <tr key={reservation.id}>
                                            <td>{reservation.car.color}, {reservation.car.brand}</td>
                                            <td>{reservation.car.licensePlate}</td>
                                            <td>{reservation.parkingspot.spotCode}</td>
                                            <td>{reservation.startTime}</td>
                                            <td>{reservation.endTime}</td>
                                            <td><Button onClick={() => removeReservation(reservation)} className="btn btn-danger">Remove</Button></td>
                                        </tr>
                                    ))}
                                </tbody>
                            </Table>
                        </Card.Text>
                        </Card.Body>
                </Card>
        </Container>
        )
    }
}
export default UserDetails;