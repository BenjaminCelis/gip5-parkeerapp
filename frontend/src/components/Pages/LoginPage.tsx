import {Link, useLocation, useNavigate} from "react-router-dom";
import React, {useEffect, useState} from "react";
import {Card, Table, Container, Button, Form, Row, Col} from "react-bootstrap";


const LoginPage = (props:any) =>  {
	const location = useLocation();
	let navigate = useNavigate();

	const [user, setUser] = useState({
		email: props.cars ? props.user.email : '',
		firstName: props.cars ? props.user.firstName : '',
		lastName: props.cars ? props.user.lastName : '',
		password: props.cars ? props.user.password : '',
	})
	const [error, setError] = useState(null)
	const [fetched, setFetched] = useState(false);
	const [errorMsg, setErrorMsg] = useState('');
	const {email, firstName, lastName, password} = user;

	const handleOnSubmit = (event:any) => {
		event.preventDefault();

		const values = [email, firstName, lastName, password];
		let errorMsg = '';

		const allFieldsFilled = values.every((field) => {
			const value = `${field}`.trim();
			return value !== '';
		});
		if (allFieldsFilled) {
			const user = {
			email,
			firstName,
			lastName,
			password
		};

		const requestOptions = {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify(user)
		};
		fetch('http://localhost:8080/members', requestOptions)
			.then(async response => {
			const isJson = response.headers.get('content-type')?.includes('application/json');
			const data = isJson && await response.json();
			navigate(`./user/details/${data.userDTO.id}`);

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
		setUser((prevState) => ({
			...prevState,
			[name]: value
		}));
	};

		return (
			<Container>
				<div className="main">
				<div className="leftpanel">
					<Card border="primary" className="infocard rounded-3 card-welcome-message" style={{ width: '25rem' }}>
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

					<Card border="primary" className="" style={{ width: '25rem' }}>
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
				<Card border="primary" className="card-acc-registration" style={{ width: '25rem' }}>
					<Card.Body>
					<Card.Title><h2>Register</h2></Card.Title>
						<Card.Text>
							<Form onSubmit={handleOnSubmit}>
							<br/>
							<Form.Group controlId="firstName">
								<Form.Label><h5>First name:</h5></Form.Label>
                                <Form.Control
                                    className="input-control"
                                    type="text"
                                    name="firstName"
                                    value={firstName}
                                    placeholder="Enter your first name"
                                    onChange={handleInputChange}
                                />
							</Form.Group>
							<br/>
							<Form.Group controlId="lastName">
								<Form.Label><h5>Last name:</h5></Form.Label>
                                <Form.Control
                                    className="input-control"
                                    type="text"
                                    name="lastName"
                                    value={lastName}
                                    placeholder="Enter your last name"
                                    onChange={handleInputChange}
                                />
							</Form.Group>
								<br/>
                            <Form.Group controlId="email">
								<Form.Label><h5>Email:</h5></Form.Label>
                                <Form.Control
                                    className="input-control"
                                    type="email"
                                    name="email"
                                    value={email}
                                    placeholder="Enter your e-mail"
                                    onChange={handleInputChange}
                                />
							</Form.Group>
							<br/>
							<Form.Group controlId="password">
								<Form.Label><h5>Password:</h5></Form.Label>
                                <Form.Control
                                    className="input-control"
                                    type="password"
                                    name="password"
                                    value={password}
                                    placeholder="Enter your password"
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