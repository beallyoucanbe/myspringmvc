package spittr.fileupload;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhaosy-c on 2017/7/31.
 */
@Controller
public class UploadControl {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(new File("e:/upload/" + file.getOriginalFilename()), file.getBytes());
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
