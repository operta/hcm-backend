package ba.infostudio.hcm.fileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


@RestController
public class FileUploadController {

    @PostMapping(value = "/uploadFile")
    public @ResponseBody String uploadFileHandler(@RequestParam("uploadFile") MultipartFile file) {


        String path = System.getProperty("user.dir") +
                "-client" + File.separator +
                "src" + File.separator +
                "assets" + File.separator +
                "images" + File.separator +
                "clientFiles";


        String extension = "";
        int i = file.getContentType().lastIndexOf('/');
        if (i > 0) {
            extension = file.getContentType().substring(i+1);
        }

        String fileName = file.getName() + Math.random() + "." + extension;

        if (!file.isEmpty()) {
            try {

                byte[] bytes = file.getBytes();


                File dir = new File(path);
                if (!dir.exists())
                    dir.mkdirs();


                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();


                return fileName;
            } catch (Exception e) {
                return "You failed to upload file => " + e.getMessage();
            }
        } else {
            return "You failed to upload file because it was empty.";
        }

    }


}
