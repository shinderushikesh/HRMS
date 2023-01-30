import React from "react";
import '../../css/style.css';
import Header from "../Header";
import Footer from "../Footer";
import Sidebar from "../Sidebar";
import Table from "../Table";
import Navbar from "../Navbar";

function Location_Master() {
    return (
        <>
            <div class="container-scroller mb-2">
                <div class="container-fluid page-body-wrapper">
               <Header/>
              
                <Sidebar />
                
                    <div class="main-panel">
                   
                        <div class="content-wrapper">
                            <div class="row">
                            
                                <div class="col-md-12 grid-margin stretch-card flex-column okkk">
                                    <Navbar/>
                                    <div class="card ">
                                        <div class=" card-body">
                                            <h5 class="mb-2 text-titlecase  mb-4">Audit Type Master</h5>
                                            <div class=" row">
                                                <div class="col-md-3 ">
                                                    <div class=" inputbox-uptable">
                                                        <input type="text" class="field-input" placeholder="Search by Code" />
                                                        <i class="fa fa-search searchicon-uptable"></i>
                                                    </div>      
                                                </div>
                                                <div class="col-md-3 ">
                                                    <div class="inputbox-uptable">
                                                        <select class="field-input">
                                                            <option>Selct by Status</option>
                                                            <option>Active</option>
                                                            <option>Inactive </option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 ">
                                                    <div class=" float-right ">
                                                        <button class="btn btn-all mr-2" data-toggle="modal" data-target="#ExportModal"><i class="fa fa-download"></i> Export</button>
                                                        <button class="btn btn-all mr-2" data-toggle="modal" data-target="#NewModal"><i class="fa fa-plus"></i> New</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="table-responsive inputbox-uptable ">
                                            <Table/>
                                            </div>
                                               
                                            <div class="modal fade" id="ExportModal" tabindex="-1" role="dialog" aria-labelledby="ExportModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <div class="modal-title f16" id="exampleModalLabel">Audit Type Master <button class="btn btn-all mr-2" ><i class="fa fa-download"></i> Export</button></div>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">×</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">  
                                                            <div class="table-responsive inputbox-uptable ">
                                                                <table class="table table-bordered table-hover ">
                                                                    <thead>
                                                                        <tr>

                                                                            <th>
                                                                                Code
                                                                            </th>
                                                                            <th>
                                                                                Name
                                                                            </th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>

                                                                            <td>
                                                                                001
                                                                            </td>
                                                                            <td>
                                                                                Lorem Ipsum
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                002
                                                                            </td>  <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                003
                                                                            </td>
                                                                            <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                004
                                                                            </td>  <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                005
                                                                            </td>   <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                006
                                                                            </td>  <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                007
                                                                            </td> <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                008
                                                                            </td><td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                009
                                                                            </td> <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                010
                                                                            </td> <td>
                                                                                Lorem Ipsum
                                                                            </td>

                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                            <nav aria-label="Page navigation example" class="float-right">
                                                                <ul class="pagination">
                                                                    <li class="page-item"><a class="page-link" href="#"><i class="fa fa-chevron-left"></i>
                                                                    </a></li>
                                                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                                    <li class="page-item"><a class="page-link" href="#"><i class="fa fa-chevron-right"></i></a></li>
                                                                </ul>
                                                            </nav>    
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button class="btn btn-all mr-2 float-right">Update</button>
                                                            <button class="btn btn-all mr-2 float-right">Cancel</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <div class="modal-title f16" id="exampleModalLabel">Audit Type Master</div>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">×</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="row">
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Code</label>
                                                                    <div class="col-md-8  inputbox-left">
                                                                        <input type="text" class="field-input" placeholder="001" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Name</label>
                                                                    <div class="col-md-8 inputbox-left">
                                                                        <input type="text" class="field-input" placeholder="Lorem Ipsum" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Action Plan Code</label>
                                                                    <div class="col-md-8  inputbox-left">
                                                                        <select class="field-input">
                                                                            <option>NoAct</option>
                                                                            <option>Act </option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Active</label>
                                                                    <div class="col-md-8  inputbox-left">
                                                                        <input type="checkbox" class="checkbox-table" />
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button class="btn btn-all mr-2 float-right">Update</button>
                                                            <button class="btn btn-all mr-2 float-right">Cancel</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="modal fade" id="NewModal" tabindex="-1" role="dialog" aria-labelledby="NewModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <div class="modal-title f16" id="exampleModalLabel">Audit Type Master</div>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">×</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="row">
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Code</label>
                                                                    <div class="col-md-8  inputbox-left">
                                                                        <input type="text" class="field-input" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Name</label>
                                                                    <div class="col-md-8 inputbox-left">
                                                                        <input type="text" class="field-input" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Action Plan Code</label>
                                                                    <div class="col-md-8  inputbox-left">
                                                                        <select class="field-input">
                                                                            <option>Select</option>
                                                                            <option>NoAct</option>
                                                                            <option>Act </option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-12 ">
                                                                    <label class="inputlabel col-md-4">Active</label>
                                                                    <div class="col-md-8  inputbox-left">
                                                                        <input type="checkbox" class="checkbox-table" />
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="submit" class="btn btn-all mr-2 float-right">Save</button>
                                                            <button class="btn btn-all mr-2 float-right">Cancel</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="modal fade" id="DeleteModal" tabindex="-1" role="dialog" aria-labelledby="DeleteModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <div class="modal-title f16" id="exampleModalLabel">Audit Type Master</div>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">×</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="row">
                                                                "Are you sure you want to delete this Audit Type Master?"
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="submit" class="btn btn-all mr-2 float-right">Save</button>
                                                            <button class="btn btn-all mr-2 float-right">Cancel</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <nav aria-label="Page navigation example" class="float-right">
                                                <ul class="pagination">
                                                    <li class="page-item"><a class="page-link" href="#"><i class="fa fa-chevron-left"></i>
                                                    </a></li>
                                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                    <li class="page-item"><a class="page-link" href="#"><i class="fa fa-chevron-right"></i></a></li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                    <Footer/>
                                </div>
                            </div>
                        </div> 
                    </div>      
                </div> 
            </div>
            
        </>
    )
}
export default Location_Master;
