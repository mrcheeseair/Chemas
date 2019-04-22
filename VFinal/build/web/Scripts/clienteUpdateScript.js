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
            dui: {
                required:true,
                number:true,
                digits: true,
                minlength:9,
                maxlength:9
            }
        }
    });
});


