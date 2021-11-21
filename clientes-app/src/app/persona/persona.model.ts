export class Persona{

    id: number;
    nombre: string = '';
    apellido: string = '';

    constructor(nombre: string, apellido: string, id:number){
        this.nombre = nombre;
        this.apellido = apellido;
        this.id=id;
    }


}
