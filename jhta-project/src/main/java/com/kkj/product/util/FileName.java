package com.kkj.product.util;

import java.util.Collection;

import jakarta.servlet.http.Part;

public class FileName {
	public static String getFileName(Part part) {
		String realFileName = "";
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return realFileName;
    }	
}
