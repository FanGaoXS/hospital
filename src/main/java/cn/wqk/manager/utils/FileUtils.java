package cn.wqk.manager.utils;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/10/21:04
 * @Description: SpringMVC（SpringBoot也可以使用）文件工具类（上传文件）
 */
public class FileUtils {
    /*
        @Param:
                file:文件对象
                fileDirPath:想要保存的目录，"src/main/resources/static/"是根目录
                        比如，fileDir="/doctor/"则想要保存的目录是"src/main/resources/static/doctor/"
                fileName:你想要给这个文件保存的名字
        @return:
                文件保存的相对路径（相对src/main/resources/static/）

    */
    public static String uploadFile(@Nullable MultipartFile file,
                                    @Nullable String fileDirPath,
                                    @Nullable String fileName){
        /*
            如果文件大小为空，返回null
            不为空则不返回null
        */
        if (file.isEmpty()){
            return null;
        }else {
            //将想要保存的目录拼接到static目录下
            File fileDir = new File("src/main/resources/static"+fileDirPath);
            if (!fileDir.exists()){//如果该目录的路径不存在
                fileDir.mkdir();   //该目录不存在则创建该目录
            }
            //得到想要保存目录的绝对路径
            String path = fileDir.getAbsolutePath();
            try {
                //将文件以文件名为fileName存储到path下
                file.transferTo(new File(path,fileName));
                //上传成功返回MultipartFile对象
                System.out.println("文件上传到："+fileDirPath+fileName);
                return fileDirPath+fileName;
            } catch (IOException e) {
                e.printStackTrace();
                //上传失败返回null
                return null;
            }
        }
    }
}
