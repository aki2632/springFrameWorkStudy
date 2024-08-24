package test.com.fileUpload.service;

import java.io.IOException;
import java.util.List;

import test.com.fileUpload.model.SampleVO;

public interface SampleService {
    
	public void processFileUpload(SampleVO vo, String saveName) throws IOException;
    public void handleFileUpload(SampleVO vo) throws IllegalStateException, IOException; // 파일 업로드와 관련된 메서드 추가
    public void handleFileUploadOrRetain(SampleVO vo) throws IllegalStateException, IOException; // 파일 업로드가 있을 경우 처리하거나 기존 이미지 유지
	
    public int insert(SampleVO vo) throws IllegalStateException, IOException;
    public int update(SampleVO vo) throws IllegalStateException, IOException;
    public int delete(SampleVO vo);
    
    public SampleVO selectOne(SampleVO vo);
    public List<SampleVO> selectAll();
    public List<SampleVO> searchList(String searchKey, String searchWord);
}
