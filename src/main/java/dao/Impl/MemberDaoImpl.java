package dao.Impl;

import util.JdbcConstant;
import util.JdbcConstant.*;

import java.nio.channels.NonWritableChannelException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import com.zaxxer.hikari.HikariDataSource;

import bean.Member;
import dao.MemberDao;


public class MemberDaoImpl implements MemberDao{
	
	private HikariDataSource ds = JdbcConstant.getDataSource();
	
//	private HikariDataSource ds;
//	public MemberDaoImpl() {
//		ds = new HikariDataSource();
//		ds.setJdbcUrl(URL);
//		ds.setUsername(USER);
//		ds.setPassword(PASSWORD);
//		ds.setMinimumIdle(5);
//		ds.setMaximumPoolSize(10);
//		ds.addDataSourceProperty("cachePrepStmts", true); //欲處理語句緩存功能
//		ds.addDataSourceProperty("prepStmtCacheSize", 250); //緩存最大保存語句數
//		ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048); //每語句長度上限
//		
//		
//	}
	
	public static void main(String[] args) {
//		//測試查詢
//		MemberDao dao = new MemberDaoImpl();
//		Member member = dao.selectByEmail("alexander.smith@example.com");
////		Member member = dao.selectByNo(1);
//		System.out.println(member.getMpassword());
		
		//測試新增
		MemberDao dao = new MemberDaoImpl();
		Member newMember = new Member();
		newMember.setMember_No(18);
		newMember.setEmail("1234@gmail.com");
		newMember.setMpassword("123456789");
		newMember.setMember_name("Miue");
		newMember.setMember_nickname(null);
		newMember.setMember_pic(null);
		newMember.setPhone(null);
		newMember.setIntroduction(null);
		newMember.setCompanion_available_time(null);
		newMember.setLocation(null);
		newMember.setCompanion_review_count(0);
		newMember.setCompanion_avg_rating(0);
		newMember.setCustomer_review_count(0);
		newMember.setCustmer_score(0);
		newMember.setRegistration_time(new java.sql.Timestamp(System.currentTimeMillis()));
		newMember.setMember_status(true);
		int insertResult = dao.insert(newMember);
		System.out.println(insertResult);
	}
	
	@Override
	public Member selectByNo(Integer no) {
		String sql = "SELECT * FROM members where member_no = ?";
		try (
			Connection conn = ds.getConnection(); //連線
			PreparedStatement pstmt = conn.prepareStatement(sql); //SQL敘述
		){
			pstmt.setInt(1,no);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					Member member = new Member();
					member.setMember_No(rs.getInt("member_No"));
					member.setEmail(rs.getString("email"));
					member.setMpassword(rs.getString("mpassword"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_nickname(rs.getString("member_nickname"));
					member.setPhone(rs.getString("phone"));
					member.setIntroduction(rs.getString("introduction"));
					member.setCompanion_review_count(rs.getInt("companion_review_count"));
					member.setCompanion_avg_rating(rs.getInt("companion_avg_rating"));
					member.setCustomer_review_count(rs.getInt("customer_review_count"));
					member.setCustmer_score(rs.getInt("custmer_score"));
					member.setRegistration_time(rs.getTimestamp("registration_time"));
					member.setMember_status(rs.getBoolean("member_status"));
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
		String sql = "INSERT INTO members VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)";
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				pstmt.setInt(1, member.getMember_No());
				pstmt.setString(2, member.getEmail());
				pstmt.setString(3, member.getMpassword());
				pstmt.setString(4, member.getMember_name());
				pstmt.setString(5, member.getMember_nickname());
				pstmt.setString(6, member.getMember_pic());
				pstmt.setString(7, member.getPhone());
				pstmt.setString(8, member.getIntroduction());
				pstmt.setString(9, member.getLocation());
				pstmt.setTimestamp(10, member.getCompanion_available_time());
				pstmt.setInt(11, member.getCompanion_review_count());
				pstmt.setInt(12, member.getCompanion_avg_rating());
				pstmt.setInt(13, member.getCustomer_review_count());
				pstmt.setInt(14, member.getCustmer_score());
				pstmt.setTimestamp(15, member.getRegistration_time());
				pstmt.setBoolean(16, member.getMember_status());
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
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
	
	@Override
	public Member selectByEmail(String email) {
		String sql = "SELECT * FROM members where email= ?";
		try (
			Connection conn = ds.getConnection(); //連線
			PreparedStatement pstmt = conn.prepareStatement(sql); //SQL敘述
		){
			pstmt.setString(1,email);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					Member member = new Member();
					member.setMember_No(rs.getInt("member_No"));
					member.setEmail(rs.getString("email"));
					member.setMpassword(rs.getString("mpassword"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_nickname(rs.getString("member_nickname"));
					member.setPhone(rs.getString("phone"));
					member.setIntroduction(rs.getString("introduction"));
					member.setCompanion_review_count(rs.getInt("companion_review_count"));
					member.setCompanion_avg_rating(rs.getInt("companion_avg_rating"));
					member.setCustomer_review_count(rs.getInt("customer_review_count"));
					member.setCustmer_score(rs.getInt("custmer_score"));
					member.setRegistration_time(rs.getTimestamp("registration_time"));
					member.setMember_status(rs.getBoolean("member_status"));
					return member;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
