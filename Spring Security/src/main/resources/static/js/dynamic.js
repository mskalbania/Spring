$(document).ready(function () {
    var code = $("[name='_csrf']").val();
    $('#usernameField').keyup(function () {
        var username_val = $('#usernameField').val();
        $.getJSON('http://localhost:8080/getByName/' + username_val, function (example) {
            $('#userList').find('tbody').remove();
            var items = [];
            $.each(example, function (key, val) {
                items.push("<tr style='display: none'>");
                items.push("<td>" + val.username + "</td>>");
                items.push("<td>" + val.role + "</td>>");
                items.push("<td>" + val.enabled + "</td>>");
                items.push("<td>" +
                    "<select class='form-control' name='role' form='" + val.username + "'>" +
                    "<option>USER</option>" +
                    "<option>ADMIN</option>" +
                    "</select>" +
                    "</td>");
                items.push("<td id='changeForm'>" +
                    "<form method='post' action='/change' id='" + val.username + "'>" +
                    "<input type='hidden' name='username' value='" + val.username + "'/>" +
                    "<div class='col-lg-1'>" +
                    "<input class='btn btn-primary' type='submit' value='Confirm'/>" +
                    "</div>" +
                    "<input type='hidden' name='_csrf' value='" + code + "'/>" +
                    "</form>" +
                    "</td>");
                if(val.enabled){
                    items.push("<td><a href='/disable/"+val.username +"' class='btn btn-danger btn-sm'>DISABLE</a></td>")
                }else {
                    items.push("<td><a href='/enable/"+val.username +"' class='btn btn-success btn-sm'>ENABLE</a></td>")
                }
                items.push("</tr>");
            });
            $('<tbody>', {html: items.join("")}).appendTo("table");
            $("tr").fadeIn();
        });
    });
});