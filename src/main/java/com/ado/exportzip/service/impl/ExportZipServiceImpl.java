package com.ado.exportzip.service.impl;

import com.ado.exportzip.model.ExportConfig;
import com.ado.exportzip.service.ExportZipService;
import com.ado.exportzip.util.ExportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jackie
 * @date: 2019/4/22
 */
@Service
public class ExportZipServiceImpl implements ExportZipService {

    private static Logger logger = LoggerFactory.getLogger(ExportZipServiceImpl.class);


    @Override
    public void export(HttpServletResponse response) {
        ExportUtil.getExcelResponse(response, "testZip.zip");
        try {
            List<ExportConfig> exportConfigList = new ArrayList<>();
            for (int i = 0; i < 5; i ++) {
                ExportConfig exportConfig = new ExportConfig();
                exportConfig.setFileName("test" + i + ".txt");
                exportConfig.setInputStream(new FileInputStream("D:\\software\\gitWork\\export-zip\\src\\main\\resources\\test.txt"));
                exportConfigList.add(exportConfig);
            }
            ExportUtil.exportZip(exportConfigList, response.getOutputStream());
        } catch (FileNotFoundException e) {
            logger.warn("文件未找到");
        } catch (IOException e) {
            logger.warn("输出流获取异常");
        }
    }
}
