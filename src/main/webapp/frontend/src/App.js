import React from "react";
import "./App.css";
import '../src/css/style.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from "./components/Login";
import Location_Master from "./components/masters/Location_Master";
import Navbar from "../src/components/Navbar";


const App = () => {
  window.onbeforeunload = (event) => {
    const e = event || window.event;
    e.preventDefault();
    if (e) {
      e.returnValue = "";
    }
    return "";
  };

  return (
    <div className="">
      <Router>
            <Switch>
              <Route path="/" exact component={Login} />
              <Route path="/locationMaster" component={Location_Master} />
              <Route
                path="/logout"
                exact
                component={() => (
                  <Login message="User Logged Out Successfully." />
                )}
              />
            </Switch>
    </Router>
    </div>
  );
};

export default App;
