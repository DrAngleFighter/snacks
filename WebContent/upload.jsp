<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GBK">
<title>Insert title here</title>
</head>
<body>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="text" name="name"><br>
		<select name="brand_id">
			<option value="1">三只松鼠</option>
			<option value="2">百草味</option>
		</select>
		
		<br>
		<input type="submit" value="上传"><br>
	</form>
</body>
</html>