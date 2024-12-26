package dao.lmpl;

import static util.JdbcConstant.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zaxxer.hikari.HikariDataSource;

import bean.Member;
import dao.MemberDao;


public class MemberDaolmpl implements MemberDao{
	
	private HikariDataSource ds;
	public MemberDaolmpl() {
		ds = new HikariDataSource();
		ds.setJdbcUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
		ds.setMinimumIdle(5);
		ds.setMaximumPoolSize(10);
		ds.addDataSourceProperty("cachePrepStmts", true); //欲處理語句緩存功能
		ds.addDataSourceProperty("prepStmtCacheSize", 250); //緩存最大保存語句數
		ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048); //每語句長度上限
	}
	
	public static void main(String[] args) {
		//測試查詢
		MemberDao dao = new MemberDaolmpl();
		Member member = dao.selectByNo(1);
		System.out.println(member.getEmail());
		System.out.println(member.getMpassword());
	}
	
	@Override
	public Member selectByNo(Integer member_no) {
		String sql = "SELECT email, mpassword FROM members where member_no= ?";
		try (
			Connection conn = ds.getConnection(); //連線
			PreparedStatement pstmt = conn.prepareStatement(sql); //SQL敘述
		){
			pstmt.setInt(1,member_no);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					Member member = new Member();
					member.setEmail(rs.getString("email"));
					member.setMpassword(rs.getString("mpassword"));
					return member;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteByNo(Integer no) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
