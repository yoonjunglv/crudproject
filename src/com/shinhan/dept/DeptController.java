package com.shinhan.dept;

import java.util.List;
import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;
import com.shinhan.job.EmpView;

public class DeptController implements CommonControllerInterface{
	
	static Scanner sc = new Scanner(System.in);
	static DeptService deptService = new DeptService();
	
	@Override
	public void execute() {
		boolean isStop = false;
		while(!isStop) {
			menuDisplay();
			int job = sc.nextInt();
			
			switch(job) {
			case 1->{f_selectAll();}
			case 2->{f_selectById();}
			case 3->{f_insertDept();}
			case 4->{f_updateDept();}
			case 5->{f_deleteDept();}
			case 9->{isStop=true;}
			}
		}
		System.out.println("========== 끝!!!!! ==========");
	}

	private static void f_deleteDept() {
		System.out.print("삭제할 직원 ID>> ");
		int empid = sc.nextInt();
		int result = deptService.deptDeleteById(empid);
		EmpView.display(result+"건 삭제");
	}

	private static void f_updateDept() {
		System.out.print("수정할 부서 ID>> ");
		int dept_id = sc.nextInt();
		DeptDTO exist_dept = deptService.selectById(dept_id);
		if (exist_dept == null) {
			DeptView.display("존재하지 않는 부서입니다.");
			return;
		}
		DeptView.display("========== 존재하는 부서 정보입니다. ==========");
		DeptView.display(exist_dept);
		int result = deptService.deptUpdate(makeDept(dept_id));
		DeptView.display(result+"건 수정");
	}

	private static void f_insertDept() {
		System.out.print("신규 부서 ID>> ");
		int dept_id = sc.nextInt();
		
		int result = deptService.deptInsert(makeDept(dept_id));
		EmpView.display(result+"건 입력");
	}
	
	private static DeptDTO makeDept(int dept_id) {
		System.out.print("department_name>> ");
		String department_name = sc.next();
		System.out.print("manager_id>> ");
		int manager_id = sc.nextInt();
		System.out.print("location_id>> ");
		int location_id = sc.nextInt();
		DeptDTO dept = DeptDTO.builder()
				.department_id(dept_id)
				.department_name(department_name)
				.manager_id(manager_id)
				.location_id(location_id)
				.build();
		return dept;
	}

	private static void f_selectById() {
		System.out.print("조회할 ID>> ");
		int deptid = sc.nextInt();
		DeptDTO dept = deptService.selectById(deptid);
		DeptView.display(dept);
	}

	private static void f_selectAll() {
		List<DeptDTO>deptlist = deptService.selectALL();
		DeptView.display(deptlist);
	}

	private static void menuDisplay() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("1.모두조회 2.조회(부서번호) 3.데이터삽입 4.데이터수정 5.데이터삭제 9.프로그램종료");
		System.out.println("--------------------------------------------------------------");
		System.out.print("작업선택> ");
	}
}
