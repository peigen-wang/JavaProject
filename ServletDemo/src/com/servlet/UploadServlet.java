package com.servlet;

import org.apache.catalina.core.ApplicationPart;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author peigen
 */
@WebServlet(name = "UploadServlet", urlPatterns = "/upload", asyncSupported = true)
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = getServletContext().getRealPath("/");
        Part p = request.getPart("file1");
        if (p.getContentType().contains("image")) {
            ApplicationPart ap = (ApplicationPart) p;
            String fileName = ap.getSubmittedFileName();
            int path_idx = fileName.lastIndexOf("\\") + 1;
            String filename2 = fileName.substring(path_idx, fileName.length());
            p.write(path + "/upload/" + filename2);
            System.out.print("文件上传成功");
        } else {
            System.out.print("文件上传失败");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
