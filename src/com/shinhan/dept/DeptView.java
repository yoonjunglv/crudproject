package com.shinhan.dept;

import java.util.List;

public class DeptView {
	
	public static void display(List<DeptDTO> deptlist) {
		if(deptlist.size() == 0) {
			display("해당하는 부서가 존재하지 않습니다.");
			return;
		}
		System.out.println("========== 부서 여러건 조회 ==========");
		deptlist.stream().forEach(dept->System.out.println(dept));
	}
	
	public static void display(DeptDTO dept) {
		if (dept == null) {
			display("해당하는 부서가 존재하지 않습니다.");
			return;
		}
		System.out.println("부서정보: "+dept);
	}

	public static void display(String message) {
		System.out.println("알림: " + message);
	}
}
