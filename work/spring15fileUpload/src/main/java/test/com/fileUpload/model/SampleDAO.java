package test.com.fileUpload.model;

import java.util.List;

public interface SampleDAO {
	
	public int insert(SampleVO vo);

	public int update(SampleVO vo);

	public int delete(SampleVO vo);

	public SampleVO selectOne(SampleVO vo);

	public List<SampleVO> selectAll();

	public List<SampleVO> searchList(String searchKey, String searchWord);

}
