<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script id="_activeConversation" type="text/x-handlebars-template">
<c:forEach var="group" items="${groups}">
	<a class="mdl-navigation__link" href="#" data-group-id="${group.id}">
		${group.name}
	</a>
</c:forEach>
</script>
