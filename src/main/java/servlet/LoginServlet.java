package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import bean.Member;
import dao.MemberDao;
import dao.Impl.MemberDaoImpl;
import util.JdbcConstant.*;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json; charset=UTF-8");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Member member = memberDao.selectByEmail(email);
		
		JsonObject responseJson = new JsonObject();
		
		if(member == null) {
			responseJson.addProperty("status", "error");
			responseJson.addProperty("message", "尚未註冊，請先註冊後再登入");	
		}else {
			if(member.getMpassword().equals(password)) {
				responseJson.addProperty("status", "success");
                responseJson.addProperty("message", "登入成功");
                // 可以返回一些額外的會員資料
//                responseJson.addProperty("memberNo", member.getMember_No());
//                responseJson.addProperty("memberName", member.getMember_name());
            } else {          
                responseJson.addProperty("status", "error");
                responseJson.addProperty("message", "帳號或密碼錯誤，請重新輸入");
            }
		}
		
		PrintWriter out = resp.getWriter();
		out.print(responseJson.toString());
		out.flush();
		}
}
