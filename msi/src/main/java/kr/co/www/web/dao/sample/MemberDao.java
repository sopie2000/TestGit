package kr.co.www.web.dao.sample;

import kr.co.www.vo.CommonMap;

public interface MemberDao {

	CommonMap selectMemberDetail(String user_id);
}
