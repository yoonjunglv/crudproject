package com.shinhan.day15;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTest2 {
	public static void main(String[] args) throws SQLException {
		//f1();
		//f2();
		//f3();
		f5();
	}
	
	private static void f5() throws SQLException {
		// 모두 성공하면 commit, 하나라도 실패하면 rollback
		// insert....
		// update....
		Connection conn = null;
		Statement st1 = null;
		Statement st2 = null;
		String sql1 = """
				insert into emp1 (employee_id, first_name, last_name, hire_date, job_id, email) 
				values(5, 'aa', 'bb', sysdate, 'IT', 'yoonjung777')
				""";
		String sql2 = "update emp1 set salary = 3000 where employee_id = 198";
		
		conn = DBUtill.getConnection();
		conn.setAutoCommit(false);
		st1 = conn.createStatement();
		int result1 = st1.executeUpdate(sql1); // 자동 commit 안됨
		st2 = conn.createStatement();
		int result2 = st1.executeUpdate(sql2);
		
		if(result1 >= 1 && result2 >= 1) {
			conn.commit(); // 둘다 성공 했을 때만 성공
		}
		else {
			conn.rollback();
		}
	}

	public static void f3() throws SQLException {
		Connection conn = null;
		Statement st = null;
		int result = 0;
		String sql = """
				delete from emp1
				where employee_id = 999
				""";
		conn = DBUtill.getConnection();
		st = conn.createStatement();
		result = st.executeUpdate(sql); // 자동으로 commit;
		
		System.out.println(result >= 1 ? "delete success":"delete fail");
	}

	public static void f2() throws SQLException {
		Connection conn = null;
		Statement st = null;
		int result = 0;
		String sql = """
				update emp1
				set department_id = (select department_id
				    from employees
				    where employee_id = 100), 
				    salary = (select salary
				    from employees
				    where employee_id = 101)
				where employee_id = 999
				""";
		conn = DBUtill.getConnection();
		st = conn.createStatement();
		result = st.executeUpdate(sql); // 자동으로 commit;
		
		System.out.println(result >= 1 ? "update success":"update fail");
	}
	
	public static void f1() throws SQLException {
		Connection conn = null;
		Statement st = null;
		int result = 0;
		String sql = """
				insert into emp1 values (999, 'fname', 'lname', 'email', '폰', sysdate, 'job', 100, 0.2, 100, '20')
				""";
		conn = DBUtill.getConnection();
		st = conn.createStatement();
		result = st.executeUpdate(sql); // 자동으로 commit;
		
		System.out.println(result >= 1 ? "insert success":"insert fail");
	}

}
