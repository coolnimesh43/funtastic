<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script id="_userInfo" type="text/x-handlebars-template">
<c:choose>
	<c:when test="${not empty user.profiePic and not empty user.profiePic.url}">
		<img src="${user.profiePic.url}" class="demo-avatar">
	</c:when>
	<c:otherwise>
		<img src="assets/images/user.jpg" class="demo-avatar">
	</c:otherwise>
</c:choose>
<div class="demo-avatar-dropdown">
	<span>${user.firstName} ${user.lastName}</span>
	<div class="mdl-layout-spacer"></div>
</div>

</script>