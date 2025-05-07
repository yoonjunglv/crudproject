package com.shinhan.emp;

import java.util.List;

// Service: business logic 수행
// 1) 이체업무: (인출하기, 입금하기)
// 2) 비밀번호 암호화
public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();
	
	public EmpDTO execute_sp(int empid) {
		return empDAO.execute_sp(empid);
	}
	
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	
	public int empUpdate2(EmpDTO emp) {
		return empDAO.empUpdate2(emp);
	}
	
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	public int empDeleteById(int empid) {
		return empDAO.empDeleteById(empid);
	}
	
	public List<EmpDTO> selectByJobAndDept(String job, int dept) {
		return empDAO.selectByJobAndDept(job, dept);
	}
	
	public List<EmpDTO> selectByJob(String job) {
		return empDAO.selectByJob(job);
	}
	
	public List<EmpDTO> selectByDept(int deptid) {
		return empDAO.selectByDept(deptid);
	}
	
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}
	
	public List<EmpDTO> selectALL() {
		// .....
		return empDAO.selectALL();
	}

	public List<EmpDTO> selectByCondition(Integer[] deptid, String job, int salary, String hdate) {
		return empDAO.selectByCondition(deptid, job, salary, hdate);
	}
}
