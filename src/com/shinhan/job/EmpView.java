package com.shinhan.job;

import java.util.List;

import com.shinhan.emp.EmpDTO;

//data를 display하려는 목적, 나중에 웹으로 변경되면 JSP로 만들예정
public class EmpView {

	//여러건출력
	public static void display(List<EmpDTO> emplist) {
		if(emplist.size() == 0) {
			display("해당하는 직원이 존재하지 않습니다.");
			return; // 이 경우 직원 정보는 출력하면 안되기 때문에 return
		}
		System.out.println("=====직원 여러건 조회=====");		
		emplist.stream().forEach(emp->System.out.println(emp));
	}
	public static void display(EmpDTO emp) {
		if (emp == null) {
			display("해당하는 직원이 존재하지 않습니다.");
			return; // 이 경우 직원 정보는 출력하면 안되기 때문에 return
		}
		System.out.println("직원정보:" + emp);
	}
	public static void display(String message) {
		System.out.println("알림:" + message);
	}
	
}
