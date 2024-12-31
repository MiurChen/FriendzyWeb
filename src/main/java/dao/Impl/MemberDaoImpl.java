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
//		Member member = dao.selectByEmail("john.doe@example.com");
////		Member member = dao.selectByNo(1);
//		System.out.println(member.getMpassword());
		
		//測試新增
		MemberDao dao = new MemberDaoImpl();
		Member newMember = new Member();
		newMember.setEmail("1234@gmail.com");
		newMember.setMpassword("12345678");
		newMember.setMember_name("Miu");
		newMember.setMember_nick_name(null); // 如果沒有暱稱，可以設置為 null
		newMember.setMember_pic(null); // 如果沒有會員圖片，可以設置為 null
		newMember.setPhone(null); // 如果沒有電話號碼，可以設置為 null
		newMember.setIntroduction(null); // 如果沒有簡介，可以設置為 null
		newMember.setCompanion_comment(0); // 初始評論數為 0
		newMember.setCompanion_score(0); // 初始分數為 0
		newMember.setCustmer_comment(0); // 初始顧客評論數為 0
		newMember.setCustmer_score(0); // 初始顧客分數為 0
		newMember.setRegistration_time(new java.sql.Timestamp(System.currentTimeMillis())); // 當前時間戳
		newMember.setMember_status(true); // 預設為啟用狀態
		newMember.setMember_token(null); // 如果沒有 token，可以設置為 null
		int insertResult = dao.insert(newMember);
		System.out.println(insertResult);
	}
	
	@Override
	public Member selectByNo(Integer no) {
		String sql = "SELECT * FROM member_info where member_no = ?";
		try (
			Connection conn = ds.getConnection(); //連線
			PreparedStatement pstmt = conn.prepareStatement(sql); //SQL敘述
		){
			pstmt.setInt(1,no);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					Member member = new Member();
					member.setMember_no(rs.getInt("member_no"));
					member.setEmail(rs.getString("email"));
					member.setMpassword(rs.getString("mpassword"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_nick_name(rs.getString("member_nick_name"));
					member.setPhone(rs.getString("phone"));
					member.setIntroduction(rs.getString("introduction"));
					member.setCompanion_comment(rs.getInt("companion_comment"));
					member.setCompanion_score(rs.getInt("companion_score"));
					member.setCustmer_comment(rs.getInt("custmer_comment"));
					member.setCustmer_score(rs.getInt("custmer_score"));
					member.setRegistration_time(rs.getTimestamp("registration_time"));
					member.setMember_status(rs.getBoolean("member_status"));
					member.setMember_token(rs.getString("member_token"));
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
		String sql = "INSERT INTO member_info (email, mpassword, member_name, member_nick_name, member_pic, phone, " +
                "introduction, companion_comment, companion_score, custmer_comment, custmer_score, " +
                "registration_time, member_status, member_token) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getMpassword());
				pstmt.setString(3, member.getMember_name());
				pstmt.setString(4, member.getMember_nick_name());
				pstmt.setString(5, member.getMember_pic());
	        	pstmt.setString(6, member.getPhone());
	        	pstmt.setString(7, member.getIntroduction());
	        	pstmt.setInt(8, member.getCompanion_comment());
	        	pstmt.setInt(9, member.getCompanion_score());
	        	pstmt.setInt(10, member.getCustmer_comment());
	        	pstmt.setInt(11, member.getCustmer_score());
	        	pstmt.setTimestamp(12, member.getRegistration_time());
	        	pstmt.setBoolean(13, member.getMember_status());
	        	pstmt.setString(14, member.getMember_token());
	        	
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
		String sql = "SELECT * FROM member_info where email= ?";
		try (
			Connection conn = ds.getConnection(); //連線
			PreparedStatement pstmt = conn.prepareStatement(sql); //SQL敘述
		){
			pstmt.setString(1,email);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					Member member = new Member();
					member.setMember_no(rs.getInt("member_no"));
					member.setEmail(rs.getString("email"));
					member.setMpassword(rs.getString("mpassword"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_nick_name(rs.getString("member_nick_name"));
					member.setPhone(rs.getString("phone"));
					member.setIntroduction(rs.getString("introduction"));
					member.setCompanion_comment(rs.getInt("companion_comment"));
					member.setCompanion_score(rs.getInt("companion_score"));
					member.setCustmer_comment(rs.getInt("custmer_comment"));
					member.setCustmer_score(rs.getInt("custmer_score"));
					member.setRegistration_time(rs.getTimestamp("registration_time"));
					member.setMember_status(rs.getBoolean("member_status"));
					member.setMember_token(rs.getString("member_token"));
					return member;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
