package com.ado.exportzip.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: Jackie
 * @date: 2019/4/22
 */
public interface ExportZipService {

    /**
     * 导出zip文件
     * @param response
     */
    void export(HttpServletResponse response);
}
