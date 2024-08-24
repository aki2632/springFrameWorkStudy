package test.com.fileUpload.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import test.com.fileUpload.model.SampleDAO;
import test.com.fileUpload.model.SampleVO;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    SampleDAO dao;
    
    @Autowired
    ServletContext context;
    
    @Override
    public void processFileUpload(SampleVO vo, String saveName) throws IOException {
        String realPath = context.getRealPath("resources/upload_img");
        log.info("realPath:{}", realPath);

        File file = new File(realPath, saveName);
        vo.getFile().transferTo(file);

        // Create thumbnail
        BufferedImage originalImg = ImageIO.read(file);
        BufferedImage thumbImg = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphic = thumbImg.createGraphics();
        graphic.drawImage(originalImg, 0, 0, 50, 50, null);

        File thumbFile = new File(realPath, "thumb_" + saveName);
        ImageIO.write(thumbImg, saveName.substring(saveName.lastIndexOf(".") + 1), thumbFile);
    }

    
    @Override
    public void handleFileUpload(SampleVO vo) throws IllegalStateException, IOException {
        String originName = vo.getFile().getOriginalFilename();
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
    public void handleFileUploadOrRetain(SampleVO vo) throws IllegalStateException, IOException {
        String originName = vo.getFile().getOriginalFilename();
        log.info("originName:{}", originName);

        if (originName != null && !originName.isEmpty()) {
            // New file uploaded, handle as usual
            handleFileUpload(vo);
        } else {
            // No new file, retain existing image name
            SampleVO existingVO = dao.selectOne(vo);
            vo.setImg_name(existingVO.getImg_name());
        }
    }

    public SampleServiceImpl() {
        log.info("SampleServiceImpl()...");
    }

    @Override
    public int insert(SampleVO vo) throws IllegalStateException, IOException {
        log.info("insert()...");
        handleFileUpload(vo);
        return dao.insert(vo);
    }

    @Override
    public int update(SampleVO vo) throws IllegalStateException, IOException {
        log.info("update()...");
        handleFileUploadOrRetain(vo);
        return dao.update(vo);
    }

    @Override
    public int delete(SampleVO vo) {
        log.info("delete()...");
        return dao.delete(vo);
    }

    @Override
    public SampleVO selectOne(SampleVO vo) {
        log.info("selectOne()...");
        return dao.selectOne(vo);
    }

    @Override
    public List<SampleVO> selectAll() {
        log.info("selectAll()...");
        return dao.selectAll();
    }

    @Override
    public List<SampleVO> searchList(String searchKey, String searchWord) {
        log.info("searchList()...");
        return dao.searchList(searchKey, searchWord);
    }

}
