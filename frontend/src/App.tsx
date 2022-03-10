import React from 'react';
import logo from './logo.svg';
import './App.css';
import {Route, BrowserRouter as Router} from "react-router-dom"
import MainNavigation from "./components/Layout/MainNavigation";

function App() {
    return(
    <Router>
        <MainNavigation/>
    </Router>
  );

}

export default App;
