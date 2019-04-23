
$(document).ready(function(){
    $("#myform").validate({
        errorClass: "claserror",
        errorElement: 'erele',
        rules:{
            nombre: {
                required:true,
                maxlength:45
                
            },
            apellido: {
                required:true,
                maxlength:45
            },
            sexo: {
                required:true,
                minlength:1,
                maxlength:1
            },
            email: {
                required:true,
                maxlength:45
            },
            
            dui: {
                required:true,
                number:true,
                digits: true,
                minlength:9,
                maxlength:9
            },
            contrasenia: {
                required:true,
                maxlength:45
            },
            fechaNac: {
                required:true,
                
            },
            usuario: {
                required:true,
                maxlength:10
            }

            
        }
    });
});
