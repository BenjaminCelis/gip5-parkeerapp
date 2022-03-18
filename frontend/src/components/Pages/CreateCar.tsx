import {Link, useLocation, useNavigate} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";


const LoginPage = (props:any) =>  {
	const location = useLocation();
	let navigate = useNavigate();
    const ownerId = location.pathname.substring(location.pathname.lastIndexOf("/") + 1);
	const [car, setCar] = useState({
		brand: props.cars ? props.car.brand : '',
		color: props.cars ? props.car.color : '',
		licensePlate: props.cars ? props.car.licensePlate : '',
		ownerId: props.cars ? props.car.ownerId : ''
	})
	const [error, setError] = useState(null)
	const [fetched, setFetched] = useState(false);
	const [errorMsg, setErrorMsg] = useState('');
	const {brand, color, licensePlate} = car;

	const handleOnSubmit = (event:any) => {
		event.preventDefault();

		const values = [brand, color, licensePlate];
		let errorMsg = '';

		const allFieldsFilled = values.every((field) => {
			const value = `${field}`.trim();
			return value !== '';
		});
		if (allFieldsFilled) {
			const user = {
			brand,
			color,
			licensePlate,
			ownerId
		};

		const requestOptions = {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify(user)
		};
		fetch('http://localhost:8080/car', requestOptions)
			.then(async response => {
			const isJson = response.headers.get('content-type')?.includes('application/json');
			const data = isJson && await response.json();
			navigate(`../user/details/${ownerId}`);

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
		setCar((prevState) => ({
			...prevState,
			[name]: value
		}));
	};

		return (
			<Container>
				<div className="main">
                <Card border="primary" className="card" style={{ width: '25rem' }}>
					<Card.Body>
					<Card.Title><h2>Create a car</h2></Card.Title>
						<Card.Text>
							<Form onSubmit={handleOnSubmit}>
							<br/>
							<Form.Group controlId="brand">
								<Form.Label><h5>Car brand:</h5></Form.Label>
                                <Form.Control
                                    className="input-control"
                                    type="text"
                                    name="brand"
                                    value={brand}
                                    placeholder="Enter the brand of the car"
                                    onChange={handleInputChange}
                                />
							</Form.Group>
							<br/>
							<Form.Group controlId="color">
								<Form.Label><h5>Color:</h5></Form.Label>
                                <Form.Control
                                    className="input-control"
                                    type="text"
                                    name="color"
                                    value={color}
                                    placeholder="Enter the color of the car"
                                    onChange={handleInputChange}
                                />
							</Form.Group>
								<br/>
                            <Form.Group controlId="licensePlate">
								<Form.Label><h5>License Plate:</h5></Form.Label>
                                <Form.Control
                                    className="input-control"
                                    type="text"
                                    name="licensePlate"
                                    value={licensePlate}
                                    placeholder="Enter the license plate"
                                    onChange={handleInputChange}
                                />
							</Form.Group>
							<br/>
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
};
 export default LoginPage;