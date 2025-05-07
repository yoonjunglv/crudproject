package com.shinhan.dept;

import java.util.List;

import lombok.extern.java.Log;

@Log
public class DeptService {
	
	DeptDAO deptDAO = new DeptDAO();
	
	public int deptDeleteById(int deptid) {
		int result = deptDAO.deptDeleteById(deptid);
		log.info("DeptService에서 로그 출력: "+ result+"건 delete");
		return result;
	}
	
	public int deptUpdate(DeptDTO dept) {
		int result = deptDAO.deptInsert(dept);
		log.info("DeptService에서 로그 출력: "+ result+"건 update");
		return result;
	}
	
	public int deptInsert(DeptDTO dept) {
		int result = deptDAO.deptInsert(dept);
		log.info("DeptService에서 로그 출력: "+ result+"건 insert");
		return result;
	}
	
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = deptDAO.selectById(deptid);
		log.info("DeptService에서 로그 출력: "+ dept.toString());
		return dept;
	}
	
	public List<DeptDTO> selectALL(){
		List<DeptDTO> deptlist = deptDAO.selectALL();
		log.info("DeptService에서 로그 출력: "+ deptlist.size()+"건 select");
		return deptlist;
	}
}
