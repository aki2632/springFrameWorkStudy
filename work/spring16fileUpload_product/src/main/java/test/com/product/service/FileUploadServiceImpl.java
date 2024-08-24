package test.com.product.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import test.com.product.model.ProductDAO;	// 해당 프로젝트의 DAO 경로
import test.com.product.model.ProductVO;	// 해당 프로젝트의 VO 경로

@Slf4j
@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	@Autowired
    ProductDAO dao;	// 해당 프로젝트의 DAO를 DI
    
    @Autowired
    ServletContext context;
    
    public FileUploadServiceImpl() {
        log.info("FileUploadServiceImpl()...");
    }

	 @Override
	 public void processFileUpload(ProductVO vo, String saveName) throws IOException {
	     String realPath = context.getRealPath("resources/upload_img");
	     log.info("realPath:{}", realPath);

	     File file = new File(realPath, saveName);
	     vo.getFile().transferTo(file);

	     BufferedImage originalImg = ImageIO.read(file);
	     BufferedImage thumbImg = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
	     Graphics2D graphic = thumbImg.createGraphics();
	     graphic.drawImage(originalImg, 0, 0, 50, 50, null);

	     File thumbFile = new File(realPath, "thumb_" + saveName);
	     ImageIO.write(thumbImg, saveName.substring(saveName.lastIndexOf(".") + 1), thumbFile);
	 }
	
	 @Override
	 public void handleFileUploadOrDefault(ProductVO vo) throws IOException {
	     String originName = vo.getFile() != null ? vo.getFile().getOriginalFilename() : null;
	     log.info("originName:{}", originName);

	     if (originName != null && !originName.isEmpty()) {
	         String saveName = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
	         log.info("save_name:{}", saveName);
	         vo.setImg_name(saveName);
	         processFileUpload(vo, saveName);
	     } else {
	         vo.setImg_name("default.png");
	     }
	 }
	    
	 @Override
	 public void handleFileUploadOrRetain(ProductVO vo) throws IOException {
	     String originName = vo.getFile() != null ? vo.getFile().getOriginalFilename() : null;
	     log.info("originName:{}", originName);

	     if (originName != null && !originName.isEmpty()) {
	         handleFileUploadOrDefault(vo);
	     } else {
	         ProductVO existingVO = dao.selectOne(vo);
	         vo.setImg_name(existingVO.getImg_name());
	     }
	 }

}
