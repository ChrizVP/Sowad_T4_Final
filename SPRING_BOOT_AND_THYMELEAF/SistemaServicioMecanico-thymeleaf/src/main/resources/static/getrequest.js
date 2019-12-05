$(document).ready(function() {
		setTimeout(function(){
			var url = "/buscar/usuario";
				$.ajax({
					contentType : "application/json",
					url: url,
					type: "GET",
					dataType : 'json',
					success: function(datos){
						$("#datosUsuario").html(" "+ datos.nombre+ " ");
						console.log(result);
					}
				});
				
			});
		
});

