import React from 'react'
import "../css/style.css"

function Navbar() {
    return (
      <>
            <div class="" ><ul class="tabsection">
                <li class="tabsectionlinks active" onclick="openUser(event, 'Plant')"><a href="#">Plant / Agency / Vendor </a></li>
                <li class="tab-spacing">|</li>
                <li class="tabsectionlinks" onclick="openUser(event, 'Department')"><a href="#">Department</a></li>
                <li class="tab-spacing">|</li>
                <li class="tabsectionlinks" onclick="openUser(event, 'Location')"><a href="#">Location</a></li>
                <li class="tab-spacing">|</li>
                <li class="tabsectionlinks" onclick="openUser(event, 'PU')"><a href="#">PU</a></li>
                <li class="tab-spacing">|</li>
                <li class="tabsectionlinks" onclick="openUser(event, 'Cell')"><a href="#">Cell</a></li>
            </ul>           
            {/* <div class="success-msg ">Record successfully updated.</div>
            <div class="error-msg">Record error</div> */}
             </div>
             </>
    )
}
export default Navbar ;