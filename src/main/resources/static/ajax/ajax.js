
$(document).ready(function() {

    console.log("--------oo");
    $("#tmbtn").click(function(event) {
        event.preventDefault();
        console.log('------');

        var errorDiv = "<p> Abdu</p>";
        $("#content").append(errorDiv);


    })

});