import React from 'react';
import logo from './logo.svg';
import {Route, Routes, Navigate, BrowserRouter as Router} from "react-router-dom"
import MainNavigation from "./components/Layout/MainNavigation";
import MainFooter from "./components/Layout/MainFooter";
import LoginPage from "./components/Pages/LoginPage";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {Navbar, Nav, Container, Card} from "react-bootstrap";


function App() {
    return(
    <Router>
        <MainNavigation/>
        <body>
            <LoginPage/>
        </body>
        <MainFooter/>
    </Router>
  );

}

export default App;
