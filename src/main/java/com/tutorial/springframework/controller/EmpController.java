package com.tutorial.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springframework.dto.ResponseDto;
import com.tutorial.springframework.dto.ResponseListDto;
import com.tutorial.springframework.dto.ResponseObjectDto;
import com.tutorial.springframework.entity.EmpEntity;
import com.tutorial.springframework.service.EmpService;

/*
 * Rest API's for Employee CRUD operations.
 * @RequestMapping -> Before all this URL /emp/ will be bind. like -> /emp/add
 * 
 * Diff in GetMapping etc and RequestMapping
 * If you use RequestMapping use have to give method also like @RequestMapping(method = RequestMethod.DELETE)
 * @RequestBody -> Get the data from Payload/body.
 * @PathVariable -> Provide data direct in URL endpoint. : emp/delete/1
 * @RequestParam -> data from params : emp/get?name=sanskar
 */

@RestController
@RequestMapping("/emp/")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@PostMapping("add")
	public ResponseObjectDto<EmpEntity> add(@RequestBody EmpEntity emp) {
		return empService.add(emp);
	}
	
	@PatchMapping("update")
	public ResponseObjectDto<EmpEntity> update(@RequestBody EmpEntity emp) {
		return empService.add(emp);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseDto delete(@PathVariable(name = "id") int id){
		return empService.delete(id);
	}
	
	@GetMapping("get")
	public ResponseObjectDto<EmpEntity> get(@RequestParam(name = "name") String name) {
		return empService.get(name);
	}
	
	@GetMapping("getall")
	public ResponseListDto<EmpEntity> getAll() {
		return empService.getAll();
	}
}
