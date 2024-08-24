package test.com.product.service;

import java.io.IOException;

import test.com.product.model.ProductVO;	// 해당 프로젝트의 VO 경로

public interface FileUploadService {

	public void processFileUpload(ProductVO vo, String saveName) throws IOException;
	public void handleFileUploadOrDefault(ProductVO vo) throws IOException;
	public void handleFileUploadOrRetain(ProductVO vo) throws IOException;
	
}
