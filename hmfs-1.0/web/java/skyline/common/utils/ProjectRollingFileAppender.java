package skyline.common.utils;

import org.apache.log4j.DailyRollingFileAppender;
import pub.platform.advance.utils.PropertyManager;

import java.io.IOException;

/**
 * log4j��չ��������־���·��.
 * User: zhanrui
 * Date: 12-8-10
 * Time: ����4:15
 */
public class ProjectRollingFileAppender extends DailyRollingFileAppender {
    @Override
    public synchronized void setFile(String fileName, boolean append,
                                     boolean bufferedIO, int bufferSize) throws IOException {
        String prj_root_dir = "prj_root_dir";
        String prjRoot = PropertyManager.getProperty(prj_root_dir);
        if (prjRoot == null || "".equals(prjRoot)) {
            throw new RuntimeException("��Ŀ���ò�������δ���ã�" + prj_root_dir);
        }
        if (!fileName.startsWith(prjRoot)) {
            fileName = prjRoot + fileName;
        }
        super.setFile(fileName, append, bufferedIO, bufferSize);
    }
}