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
            $.ajax({
                type:"POST",
                url:'/Usuarios/verifyUsuario.do',
                data:userName,
                dataType:"json",
                contentType:"application/json",
                success: function (response) {
                if (response == true) {
                    alert(response);
                    $('#nombreInput').css.addClass(".has-success");
                    $('#iconoNombre').css.removeClass(".glyphicon-asterisk");
                    $('#iconoNombre').css.addClass(".glyphicon-ok");

                    $('#errorDisplayNombre').text("funca");


                } else {
                    $('#nombreInput').closest('.form-group').addClass('has-error');
                    $('#iconoNombre').removeClass('glyphicon-asterisk').addClass('glyphicon-remove');
                    $('#errorDisplayNombre').text('Ya existe un usuario con ese username');
                    }
                },
                error:function(e){alert("Error: "+e)}
                }

            )
        }

    }
});