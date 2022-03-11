import React from 'react';
import logo from './logo.svg';
import './App.css';
import {Route, Routes, Navigate, BrowserRouter as Router} from "react-router-dom"
import MainNavigation from "./components/Layout/MainNavigation";
import MainFooter from "./components/Layout/MainFooter";
import LoginPage from "./components/Pages/LoginPage";

function App() {
    return(
    <Router>
        <MainNavigation/>
        <LoginPage/>
        <MainFooter/>
    </Router>
  );

}

export default App;
