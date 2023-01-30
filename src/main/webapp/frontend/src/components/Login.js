import React, { useState } from "react";
import { useDispatch } from "react-redux";
import logo from '../images/logo.png';
import '../css/style.css';
import { authenticateUser } from "../services/index";

const Login = (props) => {
  const [error, setError] = useState();
  const [show, setShow] = useState(true);

var accessTokenObj = JSON.parse(localStorage.getItem("jwtToken:"));
console.log(accessTokenObj);
  const initialState = {
    username: "",
    password: "",
  };

  const [user, setUser] = useState(initialState);

  const credentialChange = (event) => {
    const { name, value } = event.target;
    setUser({ ...user, [name]: value });
  };

  const dispatch = useDispatch();

  const validateUser = () => {
    dispatch(authenticateUser(user.username, user.password))
      .then((response) => {
		localStorage.setItem('login',JSON.stringify)
        console.log(response.data);
        return props.history.push("/home");
      })
      .catch((error) => {
        console.log(error.message);
        setShow(true);
        resetLoginForm();
        setError("Invalid username and password");
      });
  };

  const resetLoginForm = () => {
    setUser(initialState);
  };

  return (
<div class="container-scroller">
            <div class="container-fluid page-body-wrapper full-page-wrapper">
                <div class="content-wrapper d-flex align-items-center auth px-0">
                    <div class="row w-100 mx-0">
                        <div class="col-lg-4 mx-auto">
                            <div class="auth-form-light text-left py-5 px-4 px-sm-5">
                                <div class="brand-logo">
                                    <img src={logo} alt="logo"/>
                                </div>
                            <h4>Hello! let's get started</h4>
                            <h6 class="font-weight-light">Sign in to continue.</h6>
                            <form class="pt-3">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-lg" name="username" value={user.username}
                                    onChange={credentialChange}  placeholder="Username"/>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control form-control-lg" value={user.password}
                                    onChange={credentialChange}  name="password"  placeholder="Password"/>
                                </div>
                                <div class="mt-3">
                                    <a class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" onClick={validateUser}>Login</a>
                                </div>
                                <div class="my-2 d-flex justify-content-between align-items-center">
                                    <a  class="auth-link text-black" onClick={resetLoginForm}>Forgot password?</a>
                                </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  );
};

export default Login;
