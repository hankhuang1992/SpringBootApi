package com.hank.SpringBootAPI.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/getData")
public class GetDataController {

	@GetMapping
	public HashMap<String, Object> getData() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("results", "a");
		return map;
	}

	// @Autowired
	// private EmployeeDAO employeeDao;
	//
	// @GetMapping(path="/", produces = "application/json")
	// public Employees getEmployees()
	// {
	// return employeeDao.getAllEmployees();
	// }
	//
	// @PostMapping(path= "/", consumes = "application/json", produces =
	// "application/json")
	// public ResponseEntity<Object> addEmployee(
	// @RequestHeader(name = "X-COM-PERSIST", required = true) String
	// headerPersist,
	// @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue =
	// "ASIA") String headerLocation,
	// @RequestBody Employee employee)
	// throws Exception
	// {
	// //Generate resource id
	// Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
	// employee.setId(id);
	//
	// //add resource
	// employeeDao.addEmployee(employee);
	//
	// //Create resource location
	// URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	// .path("/{id}")
	// .buildAndExpand(employee.getId())
	// .toUri();
	//
	// //Send location in response
	// return ResponseEntity.created(location).build();
	// }
}
