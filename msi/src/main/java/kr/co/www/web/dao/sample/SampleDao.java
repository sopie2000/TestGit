package kr.co.www.web.dao.sample;

import java.util.List;

import kr.co.www.vo.CommonMap;

public interface SampleDao {
	
	List<CommonMap> selectSampleList(CommonMap commonMap);
	
	int selectSampleCount(CommonMap commonMap); 
	
	CommonMap selectSampleDetail(CommonMap commonMap);
	
	int insertSample(CommonMap commonMap);
}
