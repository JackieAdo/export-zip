package com.ado.exportzip.model;

import java.io.InputStream;

/**
 * @author: Jackie
 * @date: 2019/4/22
 */
public class ExportConfig {

    /**
     * 导出文件名
     */
    private String fileName;

    /**
     * 输入流
     */
    private InputStream inputStream;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
