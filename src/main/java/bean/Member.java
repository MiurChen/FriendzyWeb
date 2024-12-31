package bean;

import java.sql.Timestamp;

public class Member {
	
	   private Integer member_no;
	    private String email;
	    private String mpassword;
	    private String member_name;
	    private String member_nick_name;
	    private String member_pic;
	    private String phone;
	    private String introduction;
	    private Integer companion_comment;
	    private Integer companion_score;
	    private Integer custmer_comment;
	    private Integer custmer_score;
	    private Timestamp registration_time;
	    private Boolean member_status;
	    private String member_token;



public Integer getMember_no() {
	        return member_no;
	    }

	    public void setMember_no(Integer member_no) {
	        this.member_no = member_no;
	    }

public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

public String getMpassword() {
	        return mpassword;
	    }

	    public void setMpassword(String mpassword) {
	        this.mpassword = mpassword;
	    }

public String getMember_name() {
	        return member_name;
	    }

	    public void setMember_name(String member_name) {
	        this.member_name = member_name;
	    }

public String getMember_nick_name() {
	        return member_nick_name;
	    }

	    public void setMember_nick_name(String member_nick_name) {
	        this.member_nick_name = member_nick_name;
	    }

public String getMember_pic() {
	        return member_pic;
	    }

	    public void setMember_pic(String member_pic) {
	        this.member_pic = member_pic;
	    }

public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

public String getIntroduction() {
	        return introduction;
	    }

	    public void setIntroduction(String introduction) {
	        this.introduction = introduction;
	    }

public Integer getCompanion_comment() {
	        return companion_comment;
	    }

	    public void setCompanion_comment(Integer companion_comment) {
	        this.companion_comment = companion_comment;
	    }

public Integer getCompanion_score() {
	        return companion_score;
	    }

	    public void setCompanion_score(Integer companion_score) {
	        this.companion_score = companion_score;
	    }

public Integer getCustmer_comment() {
	        return custmer_comment;
	    }

	    public void setCustmer_comment(Integer custmer_comment) {
	        this.custmer_comment = custmer_comment;
	    }

public Integer getCustmer_score() {
	        return custmer_score;
	    }

	    public void setCustmer_score(Integer custmer_score) {
	        this.custmer_score = custmer_score;
	    }

public Timestamp getRegistration_time() {
	        return registration_time;
	    }

	    public void setRegistration_time(Timestamp registration_time) {
	        this.registration_time = registration_time;
	    }

public Boolean getMember_status() {
	        return member_status;
	    }

	    public void setMember_status(Boolean member_status) {
	        this.member_status = member_status;
	    }

public String getMember_token() {
	        return member_token;
	    }

	    public void setMember_token(String member_token) {
	        this.member_token = member_token;
	    }

}
