<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("???");
Part part = request.getPart("upload");
String partHeader = part.getHeader("Content-disposition");
System.out.println(partHeader);
String saveDirectory = getServletContext().getRealPath("upload");
//String saveDirectory = "C:\\upload";

String[] phArr = partHeader.split("filename=");
System.out.println("Arrays.toString(phArr)==="+Arrays.toString(phArr));
String originalFileName = phArr[1].trim().replace("\"", "");
System.out.println("originalFileName==="+originalFileName);
if (!originalFileName.isEmpty()) {				
	part.write(saveDirectory+ File.separator +originalFileName);
}
String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
//날짜 및 시간을 통해 파일명 생성
String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
//"날짜_시간.확장자" 형태의 새로운 파일명 생성
String newFileName = now + ext;  

//기존 파일명을 새로운 파일명으로 변경
File oldFile = new File(saveDirectory + File.separator + originalFileName);
File newFile = new File(saveDirectory + File.separator + newFileName);
oldFile.renameTo(newFile);

//변경된 파일명 반환
System.out.println(saveDirectory+ File.separator +originalFileName);
Gson gson = new Gson();
Map<String,Object> map =new HashMap<>();
map.put("url",request.getContextPath()+"/upload/"+ newFileName);
map.put("uploaded",true);

System.out.println("request.getServletContext()==="+request.getContextPath());

String json = gson.toJson(map);
System.out.println(json);
out.println(json);

%>
