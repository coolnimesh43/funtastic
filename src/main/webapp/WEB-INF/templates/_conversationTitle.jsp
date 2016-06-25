<script id="_conversationTitle" type="text/x-handlebars-template">
	<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">Conversation Title</span>
			</div>
	<div class="input-field col s12">
    <select class="mood-selector right browser-default ">
	<option value=""  selected>Choose your option</option>
	<c:forEach var="mood" items="${moods}">
      <option value="${mood.id}">${mood.description}</option>
	</c:forEach>
    </select>
  </div>	
		<table style="width:329px;margin-left:auto;margin-right:auto">
    <tr><td><div id="slider" style="margin-top:100px;margin-bottom:100px;"></div></td></tr>
</table>
</script>
