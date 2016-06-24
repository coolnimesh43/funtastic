var $handlebarHelpers;
var funtastic = funtastic || {};
funtastic.admin = funtastic.admin || {};
funtastic.admin.common = funtastic.admin.common || {};
(function ( common ) {
    $handlebarHelpers = {
        renderTemplate : function ( templateId, templateData, containerRendered ) {
            var source = $(templateId).html();
            var template = Handlebars.compile(source);
            var output = template(templateData);
            $(containerRendered).html(output);
        }
    }

    $handlebarHelpers.registerCustomHandlebarHelpers = function () {
        
    }

    $(document).ready(function () {
        $handlebarHelpers.registerCustomHandlebarHelpers();
    });
    
})(funtastic.admin.common);
