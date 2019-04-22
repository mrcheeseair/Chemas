$(document).ready(function(){
    $("#myform").validate({
        errorClass: "claserror",
        errorElement: 'erele',
        rules:{
            ordenId: {
                required:true
            },
            productoId: {
                required:true
            },
            cantidad: {
                required:true
            }
            
        }
    });
});


