package bean;

import java.sql.Timestamp;

public class Member {
	private Integer member_No;
	private String email;
	private String mpassword;
	private String member_name;
	private String member_nickname;
	private String member_pic;
	private String phone;
	private String introduction;
	private Integer companion_review_count;
	private Integer companion_avg_rating;
	private Integer customor_review_count;
	private Integer custmer_score;
	private Timestamp registration_time;
	private Boolean member_status;

public Integer getMember_No() {
		return member_No;
	}

	public void setMember_No(Integer member_No) {
		this.member_No = member_No;
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

public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
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

public Integer getCompanion_review_count() {
		return companion_review_count;
	}

	public void setCompanion_review_count(Integer companion_review_count) {
		this.companion_review_count = companion_review_count;
	}

public Integer getCompanion_avg_rating() {
		return companion_avg_rating;
	}

	public void setCompanion_avg_rating(Integer companion_avg_rating) {
		this.companion_avg_rating = companion_avg_rating;
	}

public Integer getCustomor_review_count() {
		return customor_review_count;
	}

	public void setCustomor_review_count(Integer customor_review_count) {
		this.customor_review_count = customor_review_count;
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
}
