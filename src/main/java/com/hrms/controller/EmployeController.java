package com.hrms.controller;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.Employee;
import com.hrms.exception.CustomException;
import com.hrms.services.EmployeeService;
import com.hrms.utils.ExcelFileWriter;

/**
 * @author Rushikesh shinde
 *
 */

@RestController
@RequestMapping("/hrms/api")
public class EmployeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<Object> getAllEmployee(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		System.out.println("Get All Employee");
		Map<String, Object> emp = employeeService.getAllEmployees(pageNo, pageSize);
		if (emp == null) {
			String message = "no Employees Found";
			String details = "Please check that data exists";
			System.out.println(message + "," + details);
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(emp, HttpStatus.OK);
	}

	// Add Employee
	@PostMapping("/add")
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> addEmployee(@Validated @RequestBody Employee employee) {
		Employee Employe = null;
		try {
			Employe = employeeService.addEmployee(employee);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(new CustomException(e.getLocalizedMessage(), e.getMessage()),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Employe, HttpStatus.OK);

	}

	// get Employee by employee code
	@GetMapping("/employee-by-code/{emp_cd}")
	public ResponseEntity<Object> getByEmployeeCode(@PathVariable String emp_cd) {
		Employee Employe = employeeService.getByEmployeeCode(emp_cd);

		if (Employe == null) {
			String message = "Employee with Employee code " + emp_cd + " not found";
			String details = "Please check Employee code";
			return new ResponseEntity<Object>(new CustomException(message, details), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Employe, HttpStatus.OK);
	}

	// soft delete Employee
	@Transactional
	@DeleteMapping("/employee/{emp_cd}")
	public ResponseEntity<Object> deleteEmployeeByCode(@PathVariable String emp_cd) {
		try {
			employeeService.deleteEmployee(emp_cd);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	}

	@PutMapping("/employee/{emp_cd}")
	public ResponseEntity<Object> updateEmployeeByCode(@RequestBody Employee emp, @PathVariable String emp_cd) {
		try {
			return new ResponseEntity<>(employeeService.updateEmp(emp, emp_cd), 
			HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.NOT_FOUND);
		}

	}
	
	//Export Employee
	@GetMapping("employee/export")
	public ResponseEntity<ByteArrayResource> downloadTemplate() throws Exception {
		
		try {
			String columnNames[] = { "Employee Id", "Employee Name", "Employee Code", "Gender", "Date of Birth",
					"Employee Nationality", "Employee Citizenship", "Marital Status", "Employee Spouse Name", "Employee Father Name", " Passport", "Employee passport No", "passport issue Place",
					"Passport issue Date", "Passport expiry Date", "mobile number", "Alternate Mobile", "Email", "Current Address", "Permanent Address", "StayDuration", "Pin Code", "Adhar Number", "Pan Number",
					"Old Employee Id", "designation", "From To", "Company Address", "leaving Reason", "School Name", "Period From", "Period To", "Percentage", "Hsc Or Diploma", "Collage Name", "Join From", "Period To",
					"Specialization", "Percent", "university Name" , "Degree Period From", "Degree Period To", "Degree Specialization", "Degree Percentage" };
			
				List<Employee> entities = employeeService.getAllEmployeeNoPaged();
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
				String currentDateTime = dateFormatter.format(new Date());
				String fileName = "employeeExport_" + currentDateTime + ".xlsx";
				
				XSSFWorkbook workbook  = ExcelFileWriter.writeToExcel(entities, columnNames); // creates the workbook
				HttpHeaders header = new HttpHeaders();
				header.setContentType(new MediaType("application", "force-download"));
				header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
				workbook.write(stream);
				workbook.close();
				return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
//			logger.error(e.getMessage());'
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

   }
	
}
