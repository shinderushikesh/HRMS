import React from "react";
import '../css/style.css';

function Sidebar() {
    return (
        <>
            <div class="container-scroller">
                <div class="container-fluid page-body-wrapper">
                    <nav class="sidebar okkz sidebar-offcanvas scroll-nav " id="sidebar">
                        <ul class="nav ">
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="collapse" href="#ui-Transaction" aria-expanded="false" aria-controls="ui-Transaction">
                                    <i class="fa fa-exchange menu-icon"></i>
                                    <span class="menu-title">Transaction Master</span>
                                    <i class="fa fa-caret-down menu-arrow"></i>
                                </a>
                                <div class="collapse" id="ui-Transaction">
                                    <ul class="nav flex-column sub-menu">
                                        <li class="nav-item"> <a class="nav-link" href="#"><i class="fa fa-newspaper-o menu-icon"></i> Audit Template</a></li>
                                        <li class="nav-item"> <a class="nav-link" href="#"><i class="fa fa-calendar menu-icon"></i> Schedule Audit</a></li>
                                        <li class="nav-item"> <a class="nav-link" href="#"><i class="fa fa-file-text menu-icon"></i>Conduct Audit</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="collapse" href="#ui-Main" aria-expanded="false" aria-controls="ui-Main">
                                    <i class="fa fa-home menu-icon"></i>
                                    <span class="menu-title">Main Masters</span>
                                    <i class="fa fa-caret-down menu-arrow"></i>
                                </a>
                                <div class="collapse" id="ui-Main">
                                    <ul class="nav flex-column sub-menu">
                                        <li class="nav-item"> <a class="nav-link" href="user-master.html"><i class="fa fa-user menu-icon"></i>User Master</a></li>
                                        <li class="nav-item"> <a class="nav-link" href="team-master.html"><i class="fa fa-users menu-icon"></i>Team Master</a></li>
                                        <li class="nav-item"> <a class="nav-link" href="category-master.html"><i class="fa fa-list menu-icon"></i>Category Master</a></li>
                                        <li class="nav-item"> <a class="nav-link" href="question-master.html"><i class="fa fa-question-circle menu-icon"></i>Question Master</a></li>
                                        <li class="nav-item" >
                                            <a class="nav-link organization" href="#ui-Main" aria-controls="ui-Main" >
                                                <i class="fa fa-calendar menu-icon"></i>Organization master <i class="fa fa-caret-down menu-arrow"></i> </a>
                                            <div class="sub-organization" id="ui-Main" >
                                                <ul class="nav flex-column sub-menu">
                                                    <li class="nav-item"> <a class="nav-link" href="Plant-Agency-Vendor-master.html"><i class="fa fa-industry menu-icon"></i>Plant/Agency/ Vendor</a></li>
                                                    <li class="nav-item"> <a class="nav-link" href="Plant-Agency-Vendor-master.html"><i class="fa fa-building-o menu-icon"></i>Department Master</a></li>
                                                    <li class="nav-item"> <a class="nav-link" href="Plant-Agency-Vendor-master.html"><i class="fa fa-map-marker menu-icon"></i>Location Master</a></li>
                                                    <li class="nav-item"> <a class="nav-link" href="Plant-Agency-Vendor-master.html"><i class="fa fa-puzzle-piece menu-icon"></i>PU Master</a></li>
                                                    <li class="nav-item"> <a class="nav-link" href="Plant-Agency-Vendor-master.html"><i class="fa fa-ellipsis-h menu-icon"></i>Cell Master</a></li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="nav-item"> <a class="nav-link" href="audittype-master.html"><i class="fa fa-columns menu-icon"></i>Audit Type Master</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">
                                    <i class="fa fa-file-text-o menu-icon"></i>
                                    <span class="menu-title">Reports</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </>
    )
}
export default Sidebar;