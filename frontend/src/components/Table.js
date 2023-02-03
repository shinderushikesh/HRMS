import React from "react";
import '../css/style.css';

function Table(){
    return(
        <table class="table table-bordered table-hover ">
        <thead>
            <tr>

                <th>
                    Code
                </th>
                <th>
                    Name
                </th>

                <th>
                    Action Plan Code
                </th> <th class="action-table">
                    Active
                </th>
                <th class="action-table">
                    Action
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

                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>

                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i>
                    <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i></td>
            </tr>
            <tr>
                <td>
                    002
                </td>  <td>
                    Lorem Ipsum
                </td>
                <td class="green-text">
                    Act
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i></td>

            </tr>
            <tr>
                <td>
                    003
                </td>
                <td>
                    Lorem Ipsum
                </td>
                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i></td>

            </tr>
            <tr>
                <td>
                    004
                </td>  <td>
                    Lorem Ipsum
                </td>
                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i></td>

            </tr>
            <tr>
                <td>
                    005
                </td>   <td>
                    Lorem Ipsum
                </td>
                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>

                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i></td>

            </tr>
            <tr>
                <td>
                    006
                </td>  <td>
                    Lorem Ipsum
                </td>
                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td>
                    <i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i>
                </td>

            </tr>
            <tr>
                <td>
                    007
                </td> <td>
                    Lorem Ipsum
                </td>
                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td>
                    <i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i>
                </td>
            </tr>
            <tr>
                <td>
                    008
                </td><td>
                    Lorem Ipsum
                </td>
                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i></td>

            </tr>
            <tr>
                <td>
                    009
                </td> <td>
                    Lorem Ipsum
                </td>
                <td class="red-text">
                    NoAct
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i> <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i></td>

            </tr>
            <tr>
                <td>
                    010
                </td> <td>
                    Lorem Ipsum
                </td>
                <td class="green-text">
                    Act
                </td>
                <td class="green-text">
                    <input type="checkbox" class="checkbox-table" />
                </td>
                <td><i class="fa fa-pencil-square-o table-icon" title="Edit" data-toggle="modal" data-target="#exampleModal"></i>
                    <i class="fa fa-trash-o table-icondelete red-text" title="Delete" data-toggle="modal" data-target="#DeleteModal"></i>
                </td>
            </tr>
        </tbody>
    </table> 
    )
}
export default Table;