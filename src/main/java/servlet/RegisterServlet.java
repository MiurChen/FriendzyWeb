package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import bean.Member;
import dao.MemberDao;
import dao.Impl.MemberDaoImpl;

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json; charset=UTF-8");
		
		//取得前端的資料
		String account = req.getParameter("email");
		String password = req.getParameter("password");
		String memberName = req.getParameter("memberName");
		
		JsonObject responseJson = new JsonObject();
		
		Member existMember = memberDao.selectByEmail(account);
		
		if(existMember != null) {
			responseJson.addProperty("status", "error");
			responseJson.addProperty("message", "該帳號已註冊，請確認後再執行");
		}else {
		
		//新增會員 (號碼應為流水號，DB需更改，後端無需給預設)
		Member newMember = new Member();
		newMember.setEmail(account);
		newMember.setMpassword(password);
		newMember.setMember_name(memberName);
		
		//新增會員會帶入的預設值
		newMember.setMember_status(true);
		newMember.setCompanion_review_count(0);
        newMember.setCompanion_avg_rating(0);
        newMember.setCustomer_review_count(0);
        newMember.setCustmer_score(0);
        newMember.setRegistration_time(new java.sql.Timestamp(System.currentTimeMillis()));
		
		int result = memberDao.insert(newMember);
		
		if(result >0) {
			responseJson.addProperty("status", "success");
			responseJson.addProperty("message", "註冊成功");
		}else {
			responseJson.addProperty("status", "error");
			responseJson.addProperty("message","註冊失敗，請稍後再試");
			}
		}
		PrintWriter out = resp.getWriter();
		out.print(responseJson.toString());
		out.flush();
	}

}
