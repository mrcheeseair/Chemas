$(document).ready(function(){
    $("#myform").validate({
        errorClass: "claserror",
        errorElement: 'erele',
        rules:{
            pago_id: {
                required:true
                
            },
            fecha: {
                required:true
                
            },
            empleado_id: {
                required:true
                
            },
            mesa_id: {
                required:true
            }
            
        }
    });
});

