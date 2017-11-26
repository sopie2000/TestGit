package kr.co.www.web.service.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.www.vo.CommonMap;
import kr.co.www.web.dao.sample.SampleDao;

@Service("sampleService")
public class SampleService {
	
	@Autowired
	private SampleDao sampleDao;
	
	/**
	 * Sample board 목록
	 * @param commonMap CommonMap
	 * @return List<CommonMap>
	 */
	public List<CommonMap> selectSampleList(CommonMap commonMap) {
		return sampleDao.selectSampleList(commonMap);
	}

	/**
	 * Sample board 카운트
	 * @param commonMap CommonMap
	 * @return int
	 */
	public int selectSampleCount(CommonMap commonMap) {
		return sampleDao.selectSampleCount(commonMap);
	}
	
	/**
	 *  Sample board 상세
	 * @param commonMap CommonMap
	 * @return CommonMap
	 */
	public CommonMap selectSampleDetail(CommonMap commonMap) {
		return sampleDao.selectSampleDetail(commonMap);
	}	
	
	/**
	 * Sample board 등록
	 * @param commonMap CommonMap
	 * @return int
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public int insertSample(CommonMap commonMap) throws Exception {
		return sampleDao.insertSample(commonMap);
	}
}
