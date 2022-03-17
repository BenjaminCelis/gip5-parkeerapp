import React from 'react';
import logo from './logo.svg';
import {Route, Routes, Navigate, BrowserRouter as Router} from "react-router-dom"
import MainNavigation from "./components/Layout/MainNavigation";
import MainFooter from "./components/Layout/MainFooter";
import LoginPage from "./components/Pages/LoginPage";
import CreateReservation from "./components/Pages/CreateReservation";
import ReservationList from "./components/Pages/ReservationList";
import UserDetails from "./components/Pages/UserDetails";
import UserList from "./components/Pages/UserList";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {Navbar, Nav, Container, Card} from "react-bootstrap";


function App() {
    return(
        <Router>
        <MainNavigation/>
            <body>
                <Routes>
                    <Route path="/" element={<LoginPage />} />
                    <Route path="/reservation/create/*" element={<CreateReservation />} />
                    <Route path="/reservation/*" element={<ReservationList />} />
                    <Route path="/user/" element={<UserList />} />
                    <Route path="/user/details/*" element={<UserDetails />} />
                    <Route path="/redirect" element={<Navigate to="/reservation" />} />
                </Routes>
            </body>
        <MainFooter/>
        </Router>
  );

}

export default App;
