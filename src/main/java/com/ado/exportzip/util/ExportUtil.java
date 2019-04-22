package com.ado.exportzip.util;

import com.ado.exportzip.exception.BusinessException;
import com.ado.exportzip.model.ExportConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: Jackie
 * @date: 2019/4/22
 */
public class ExportUtil {

    /**
     * 导出zip文件
     *
     * @param exportConfigList 打包文件流集合
     * @param outputStream     输出流
     */
    public static void exportZip(List<ExportConfig> exportConfigList, OutputStream outputStream) {

        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(outputStream);
            for (ExportConfig exportConfig : exportConfigList) {
                export(exportConfig, out);
            }
        } catch (Exception e) {
            throw new BusinessException("导出错误");
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void export(ExportConfig exportConfig, ZipOutputStream out) {
        try {
            ZipEntry zipEntry = new ZipEntry(exportConfig.getFileName());
            out.putNextEntry(zipEntry);
            out.write(FileUtil.inputStream2ByteArray(exportConfig.getInputStream()));
            out.flush();
            out.closeEntry();
            exportConfig.getInputStream().close();
        } catch (IOException e) {
            throw new BusinessException("zip文件生成错误");
        }
    }

    /**
     * 设置下载文件输出流格式
     *
     * @param response
     * @param fileName 下载文件名
     * @return
     */
    public static HttpServletResponse getExcelResponse(HttpServletResponse response, String fileName) {
        try {

            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));

            //EXCEL格式  Microsoft excel
            response.setContentType("application/octet-stream;charset=utf-8");

            return response;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
