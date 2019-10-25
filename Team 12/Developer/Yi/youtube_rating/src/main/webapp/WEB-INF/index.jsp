<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>

<h1>Welcome to our youtube rating system</h1>
<%-- Just a example of how to connect to backend database --%>
<c:out value = "${repoList.get(0).GetTopicName()}"/>
<c:out value = "${repoList.get(0).GetTotalViews()}"/>
<c:out value = "${repoList.get(0).GetCommentNum()}"/>
<c:out value = "${repoList.get(0).GetVideoNum()}"/>
</body>
</html>