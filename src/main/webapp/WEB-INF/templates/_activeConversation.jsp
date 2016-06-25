<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script id="_activeConversation" type="text/x-handlebars-template">
<c:forEach var="group" items="${groups}">
	<a class="mdl-navigation__link" href="#" data-group-id="${group.id}">
		${group.name}
	</a>
</c:forEach>
</script>


<script id="_activeConversationAjax" type="text/x-handlebars-template">
  <a class="btn-floating btn-large waves-effect waves-light red" id="create-group-btn" href="javascript:void(0);"><i class="material-icons"></i></a>
{{#each detail}}
	<a class="mdl-navigation__link" href="#" data-group-id="{{id}}">
		{{name}}
	</a>
{{/each}}
</script>

<script id="_userList" type="text/x-handlebars-template">
<form id="add-user">
<div class="input-field col s12">
    <select name="user_id">
      <option value="" disabled selected>Choose your option</option>
    	{{#each detail}}
      		<option value="{{id}}">{{firstName}} {{lastName}}</option>
 		{{/each}}
    </select>
    <label>Add User</label>
  </div>
   <input type="hidden" value="{{groupId}}" id="group-id"/>
	<button class="btn waves-effect waves-light" type="button" name="add-user-group">Submit
   	 <i class="material-icons right">send</i>
  	</button> 
</form>
</script>

<script id="_existingUserList" type="text/x-handlebars-template">
<h3>Existing Users</h3>
{{#each detail}}
<div class="input-field col s12">
   {{firstName}} {{lastName}} <button type="buton" class="delete-member" data-user-id="{{id}}">Delete</button>
  </div>
{{/each}}
</script>

<script id="_gifyResponse" type="text/x-handlebars-template">
{{#each detail}}
<li class="collection-item avatar">
	<img src="{{images.original.url}}" alt="" class="circle"> </li>
{{/each}}
</script>


<script id="_memeResponse" type="text/x-handlebars-template">
{{#each detail}}
<li class="collection-item avatar">
	<img src="{{unescape url}}" alt="" class="circle"> </li>
{{/each}}
</script>