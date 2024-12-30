package dao;

import bean.Member;

public interface MemberDao {

	int insert(Member member);
	
	int deleteByNo(Integer no);
	
	int update(Member member);
	
	Member selectByNo(Integer no);
	
	Member selectByEmail(String email);
	
}
