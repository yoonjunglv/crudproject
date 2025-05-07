package com.shinhan.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.day15.DBUtill;

public class DeptDAO {
	// DB연결, 해제시 사용
	Connection conn;
	// SQL문을 DB에 전송
	Statement st;
	PreparedStatement pst;
	// Select 결과
	ResultSet rs;
	// insert, delete, update 결과는 영향 받은 건수
	int resultCount;
	
	static final String SELECT_ALL = "select * from departments";
	static final String SELECT_DETAIL = "select * from departments where department_id = ?";
	static final String INSERT = "insert into departments values(?,?,?,?)";
	static final String UPDATE = "update departments set "
								+ " department_name=?,manager_id=?,location_id=? "
								+ " where department_id=?";
	static final String DELETE = "delete from departments where department_id=?";
	
	// 부서 번호로 data 삭제하기
	public int deptDeleteById(int deptid) {
		int result = 0;
		conn = DBUtill.getConnection();
		pst = null;
		
		try {
			pst = conn.prepareStatement(DELETE);
			pst.setInt(1, deptid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 부서 테이블에 data 수정하기
	public int deptUpdate(DeptDTO dept) {
		int result = 0;
		conn = DBUtill.getConnection();
		pst = null;
		
		try {
			pst = conn.prepareStatement(UPDATE);
			pst.setInt(1, dept.getDepartment_id());
			pst.setString(2, dept.getDepartment_name());
			pst.setInt(3, dept.getManager_id());
			pst.setInt(4, dept.getLocation_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 부서 테이블에 data 삽입하기
	public int deptInsert(DeptDTO dept) {
		int result = 0;
		conn = DBUtill.getConnection();
		pst = null;
		
		try {
			pst = conn.prepareStatement(INSERT);
			pst.setInt(1, dept.getDepartment_id());
			pst.setString(2, dept.getDepartment_name());
			pst.setInt(3, dept.getManager_id());
			pst.setInt(4, dept.getLocation_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 부서 번호로 부서 정보를 상세보기 (1건 조회)
	public DeptDTO selectById(int deptid) {
		conn = DBUtill.getConnection();
		pst = null;
		rs = null;
		DeptDTO dept = null;
		
		try {
			pst = conn.prepareStatement(SELECT_DETAIL);
			pst.setInt(1, deptid);
			rs = pst.executeQuery();
			if(rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, rs);
		}
		return dept;
	}
	
	// 모든 부서 조회
	public List<DeptDTO> selectALL(){
		List<DeptDTO> deptlist = new ArrayList<>();
		conn = DBUtill.getConnection();
		st = null;
		rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtill.dbDisconnect(conn, st, rs);
		}
		return deptlist;
	}

	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = DeptDTO.builder()
				.department_id(rs.getInt("department_id"))
				.department_name(rs.getString("department_name"))
				.manager_id(rs.getInt("manager_id"))
				.location_id(rs.getInt("location_id"))
				.build();
		return dept;
	}
}
