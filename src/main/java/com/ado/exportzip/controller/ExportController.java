package com.ado.exportzip.controller;

import com.ado.exportzip.service.ExportZipService;
import com.ado.exportzip.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Jackie
 * @date: 2019/4/22
 */

@RestController
public class ExportController {

    private static Logger logger = LoggerFactory.getLogger(ExportController.class);

    @Resource
    private ExportZipService exportZipService;

    @GetMapping("exportZip")
    public void exportZip(HttpServletRequest request, HttpServletResponse response) {

        exportZipService.export(response);
    }
}
