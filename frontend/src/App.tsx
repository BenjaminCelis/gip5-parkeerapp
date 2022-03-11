import React from 'react';
import logo from './logo.svg';
import './App.css';
import {Route, BrowserRouter as Router} from "react-router-dom"
import MainNavigation from "./components/Layout/MainNavigation";
import MainFooter from "./components/Layout/MainFooter";

function App() {
    return(
    <Router>
        <MainNavigation/>

        <MainFooter/>
    </Router>
  );

}

export default App;
