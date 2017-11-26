package kr.co.www.batch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Class Name : ProductBatchService.java
 * @Description : scheduler 관련 클래스
 * @Modification Information
 * @
 * @  수정일         		수정자                   수정내용
 * @ -------------------------------------------------
 * @ 2016. 10. 28.    sopie         
 *
 * @author sopie    
 * @since 2016. 10. 28.
 * @version 1.0
 * @see
 */
@Component
public class ProductBatchService {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(ProductBatchService.class);

	/**
	 *	초 분 시 일 월 년
	 *	매일 0시 0분 0초에 구동
	 *	테스트 시 0 * * * * *  로 변경 하면 1분 마다 구동됨.
	 *	common.properties 에 시간을 빼서 작업 하셔도됨.
	 * @throws Exception 
	 */	
	//@Scheduled(cron="*/10 * * * * *")	
	//@Scheduled(fixedRate=1000) // 1초마다 한번씩 실행 
	//@Scheduled(fixedDelay=1000) // 메서드 종료 시점에서 1초후 실행
	@Scheduled(cron="0 0 0 * * *")
	public void sampleBatch() throws Exception {
		logger.info("scheduler 동작!!!");
	}
}
