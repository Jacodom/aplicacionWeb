/**
 * Created by Jacobo on 30/10/14.
 */
$(document).ready(function(){

    $('#nombreInput').focusout(verificarUsername
    );

    function verificarUsername() {
        var userName = $(this).val();

        $('.error-ingreso').css("color", "red");

        if (userName.length < 6) {
            $('#errorDisplayNombre').text("El username debe contener al menos 6 caracteres");
        } else {

            var jsonName = {"username":userName};

            $.ajax({
                type:"GET",
                url:'/Usuario/verifyUsuario',
                data:JSON.stringify(jsonName),
                dataType:"json",
                contentType:"application/json",
                success: function (response) {
                if (response == true) {
                    $('#nombreInput').css.addClass(".has-success");
                    $('#iconoNombre').css.removeClass(".glyphicon-asterisk");
                    $('#iconoNombre').css.addClass(".glyphicon-ok");

                    $('#errorDisplayNombre').text("funca");


                } else {
                    $('#nombreInput').css.addClass(".has-error");
                    $('#iconoNombre').css.removeClass(".glyphicon-asterisk");
                    $('#icono').css.addClass(".glyphicon-remove");


                    $('#errorDisplayNombre').text("funca2");
                    }
                },
                error:function(e){alert("Error: "+e)}
                }

            )
        }

    }
});