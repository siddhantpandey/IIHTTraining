
/*function show(name){
	//return "Hello "+name;
	return 12.5;
}*/
function show(name: string): string{
	return "Hello "+name;
	//return 12.5;
}
let a: any;
let name: string="First";
let age:number=25;
let basic: number=20345.56;
let isAdmin:boolean=true;
let names:string[]=['First','Second','Third'];
let name: Array<string>=['First','Second','Third'];

enum Role {
	EMPLYEE, //0
	MANAGER, //1
	ADMIN //2
};
enum Roles {
	EMPLYEE=3,//3
	MANAGER,//4
	ADMIN //5
};
let userrole:Role=Role.EMPLOYEE;
//enumerated datatype : used to provide name to number
console.log('Role: ',Role[0]);

let x:any="Hello";
x=50;
x=[23,24,25];

function func(name:string):void{
	
}
class Employee{
	//public
	name:string;
	age:number;
	basic:number;

	show_details(): void{
	console.log(this.name,"|",this.age,"|",this.basic);
	}//if return type not specified for function then it is any
}
let emp:Employee;//does not create an object, just a reference
emp=new Employee(); //creates an object

let emp_pro:EMployee = new Employee;
