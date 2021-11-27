import { Roles } from './../login/roles.model';
export class AltaPersona{

    id!: number;
    nombre!: string;
    apellidos!: string;
    edad!: number;
    username!: string;
    password!: string;
    roles!: Roles[];


}
