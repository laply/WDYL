<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DB Connection Test</title>
    </head>
<body>
    <%
        String DB_URL = "jdbc:mysql://아이피:3306/데이터베이스";
        String DB_USER = "이름";
        String DB_PASSWORD= "암호";

        Connection conn;
        Statement stmt;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
            conn.close();
            out.println("MySql jdbc test: connect ok!!");
        } catch(Exception e) {
            out.println("error - " + e.getMessage());
        }
    %>
</body>
</html>
