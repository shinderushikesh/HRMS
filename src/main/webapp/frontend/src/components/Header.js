import React from "react";
import '../css/style.css';
import logo from '../images/logo.png';
import logos from '../images/logo-mini.png';

function Header ()
{
    return (

        <>
                 <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                    <div class="navbar-brand-wrapper d-flex justify-content-center">
                        <div class="navbar-brand-inner-wrapper d-flex justify-content-between align-items-center w-100">
                            <a class="navbar-brand brand-logo" ><img src={logo} alt="logo" /></a>
                            <a class="navbar-brand brand-logo-mini" ><img src={logos} alt="logo" /></a>
                            <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                                <span class="fa fa-bars"></span>
                            </button>
                        </div>
                    </div>
                    <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
                        <ul class="navbar-nav mr-lg-2">
                            <li class="nav-item nav-user-status dropdown">
                                <div class="d-flex align-items-baseline">
                                    <p class="mb-0"><a href="index.html">Dashboard</a></p>
                                    <i class="fa fa-chevron-right margin-breadcrum"></i>
                                    <p class="mb-0">Audit Type Master</p>
                                </div>
                            </li>
                        </ul>
                        <ul class="navbar-nav navbar-nav-right">
                            <li class="nav-item nav-date dropdown">
                                <a class="nav-link d-flex justify-content-center align-items-center" href="javascript:;">
                                    <h6 class="date mb-0">26 April 2022</h6>
                                </a>
                            </li>
                            <li class="nav-item dropdown mr-0">
                                <a class="nav-link count-indicator dropdown-toggle d-flex align-items-center justify-content-center" id="notificationDropdown" href="#" data-toggle="dropdown">
                                    Admin
                                </a>
                                <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
                                    <div class="margin-auto"><img src="images/faces/user.png" alt="" class="admin-pic" /></div>
                                    <div class="admin-name-top">Admin Panal</div>
                                    <div class="top-right-logout-submit">
                                        <a type="submit" class="btn btn-all top-rightadmin-leftbtn" href="login.html">Logout</a>
                                        <a type="submit" class="btn btn-all top-rightadmin-rightbtn" href="index.html">Cancel</a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                            <span class="fa fa-bars"></span>
                        </button>
                    </div>
                </nav>
        </>
    )
}
export default Header ;