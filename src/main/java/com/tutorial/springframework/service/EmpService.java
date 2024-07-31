package com.tutorial.springframework.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.tutorial.springframework.dto.ResponseDto;
import com.tutorial.springframework.dto.ResponseListDto;
import com.tutorial.springframework.dto.ResponseObjectDto;
import com.tutorial.springframework.entity.EmpEntity;
import com.tutorial.springframework.repository.EmpRepository;
import com.tutorial.springframework.util.AppUtil;

import jakarta.transaction.Transactional;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;
	
	//Insert and update both- If already record exist it will update it by its id.
	public ResponseObjectDto<EmpEntity> add(EmpEntity emp) {
		EmpEntity empResult ;
		try {
			empResult = empRepository.save(emp);
			return AppUtil.getresponseObjectDto(true,"Saved", empResult);
		}catch(Exception e) {
			e.printStackTrace();
			return AppUtil.getresponseObjectDto(false,"Failed",null);
		}
	}
	
	public ResponseDto delete(int id) {
		try {
			EmpEntity emp = empRepository.findById(id).get();
			if(emp != null) {
				empRepository.delete(emp);
				return new ResponseDto(true,"Record deleted");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseDto(false,"Failed to delete");
	}
	
	
	public ResponseObjectDto<EmpEntity> get(String name){
		ResponseObjectDto<EmpEntity> empResult;
		try {
			EmpEntity emp = empRepository.findByName(name).get();
			empResult = AppUtil.getresponseObjectDto(true,"Found", emp);
		} catch(NoSuchElementException e) {
			empResult = AppUtil.getresponseObjectDto(false,"Not found",null);
		}
		return empResult;
	}
	
	@Transactional
	public ResponseListDto<EmpEntity> getAll(){
		ResponseListDto<EmpEntity> empList;
		try {
			List<EmpEntity> list = empRepository.findAll();
			empList = new ResponseListDto<EmpEntity>(true,"Found", list);
		} catch(Exception e) {
			empList = new ResponseListDto<EmpEntity>(true,"Not Found",null);
		}
		return empList;
	}
}

/* @Transactional -> use to maintain transaction.
 * While manipulating with DB if any exception occurs it will be rollback automatically.
 */
