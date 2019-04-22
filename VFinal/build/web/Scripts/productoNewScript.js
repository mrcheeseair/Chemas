$(document).ready(function(){
    $("#myform").validate({
        errorClass: "claserror",
        errorElement: 'erele',
        rules:{
            categoria_id: {
                required:true
                
            },
            nombre: {
                required:true,
                maxlength:45
            },
            descripcion: {
                required:true,
                maxlength:100
            },
            precio: {
                required: true
                
            }
        }
    });
});


