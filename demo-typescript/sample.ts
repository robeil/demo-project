let message = "Hello world";
let email: string = "robeil@gmail.com";
let age: number;
let isActive : boolean;

console.log(typeof email); 
typeof email == "string";


let externalData: unknown;

console.log(typeof externalData); 

let arrat : number[] = [1,2,3,4];
let tuple: [string, number] = ["hello", 42];
let genericArray: Array<number> = [1, 2, 3, 4];

//type Student
interface Student {
    id: number;
    name: string;
    email?: string;
}

const student: Student = {
    id: 1,
    name: "John Doe",
    email: "robiel@gmail.com"
}

function greet(name: string) : string{
    console.log(`Hello, ${name}`);
    return name;
}

greet("1");

const calSum = (x:number ,  y:number): number => x + y;
