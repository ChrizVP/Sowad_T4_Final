export class ServicioMecanicoCab{
    servicioCab_id:number;
	total:Float32Array;
	cliente:{
        cliente_id:number;
        apellidos:String;
        nombre:String;
    };
	personal:{
        personal_id:number;
        nombre:String;
        apellidos:String;
    };

	fecha:Date;
}