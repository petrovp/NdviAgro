<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" action="uploadFiles" enctype="multipart/form-data">
		File to upload: <input type="file" name="files" multiple>
<%-- 		 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>

		<input type="submit" value="Upload"> Press here to upload the file!
	</form:form>	
</body>
</html>