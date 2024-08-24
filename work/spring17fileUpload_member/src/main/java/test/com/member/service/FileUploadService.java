package test.com.member.service;

import java.io.IOException;

import test.com.member.model.MemberVO;	// 해당 프로젝트의 VO 경로

public interface FileUploadService {

	public void processFileUpload(MemberVO vo, String saveName) throws IOException;
	public void handleFileUploadOrDefault(MemberVO vo) throws IOException;
	public void handleFileUploadOrRetain(MemberVO vo) throws IOException;
	
}
