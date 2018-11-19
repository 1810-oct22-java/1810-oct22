/*
Into to TS:

In order to understand Angular, we must first understand TypeScript.

- strict typing, arrow notation, interfaces, classes, constructors,
access modifiers, properties, modules*

TS is a superset of JS, meaning that any valid JS code is also valid
TS code. TS code, however, must be TRANSPILED into JS code.

TS Data Types - one of the main features of TS that sets it apart from
JS is its (optional) use of strong typing. The types are as follows:
 - number, boolean, string, void, null, undefined, never, any
- a variable initialized with undefined means that the car has no value
or object assigned to it
whereas null means that it has been set to an object whose value is undefined


Helpful resources:
https://blog.mariusschulz.com/2016/11/18/typescript-2-0-the-never-type

*/
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
//STRICT TYPING
var greeting;
greeting = 'hello';
var x = 6;
//x = 'hi';
var a;
var b;
var c;
var d;
var e; //strictly typed arrays
var tup; //a TUPLE is a heterogeneous array
var f;
//f = 5; //reassignment does not compile due to strict typing
var g;
var h;
//h = false;
//return type of functions that never return. type guards that are never true;
//RETURN TYPES
function add(a, b) {
    return a + b;
}
var test = add(5, 6);
//let test2 = add('this is', 'a string');
function neverReturns(a) {
    while (true) {
    }
}
function anyReturn(a) {
    return undefined;
}
//TS supports Enum data type 
var DaysOfWeek;
(function (DaysOfWeek) {
    DaysOfWeek[DaysOfWeek["MONDAY"] = 10] = "MONDAY";
    DaysOfWeek[DaysOfWeek["TUESDAY"] = 11] = "TUESDAY";
    DaysOfWeek[DaysOfWeek["WEDNESDAY"] = 12] = "WEDNESDAY";
    DaysOfWeek[DaysOfWeek["THURSDAY"] = 13] = "THURSDAY";
    DaysOfWeek[DaysOfWeek["FRIDAY"] = 14] = "FRIDAY";
    DaysOfWeek[DaysOfWeek["SATURDAY"] = 15] = "SATURDAY";
    DaysOfWeek[DaysOfWeek["SUNDAY"] = 16] = "SUNDAY";
})(DaysOfWeek || (DaysOfWeek = {}));
;
var today = DaysOfWeek.FRIDAY;
var tomorrow = DaysOfWeek[15];
//ARROW NOTATION
var sayHi = function (welcome) {
    console.log(welcome + "!!!! " + (9 + 10));
};
var sayHelloo = function (welcome) { return console.log(welcome + "!!!!"); };
sayHelloo("hi");
var gen = {
    name: 'my name',
    age: 100,
    speak: function () {
        console.log('arrow notation functionality uses ' +
            'brackets and semicolons when there is more than one line of code');
        console.log('TS is fun');
    },
    hairColor: 'brownish w overly bleached ends'
};
/*CLASSES
Classes in TS are similar to classes in most OOP languages.
Properties are made public by default but can be made private
    - when a member is private, it cannot be accessed from
      outside of its containing class
    - the protected modifier acts similarly to private, except
      members declared protected can also be accessed within
      deriving classes
      
Constructors are used to simplify creating new objects
*/
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    // in classes, functions are called methods
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
var pointA = new Point(10, 10);
console.log(pointA.getDistance());
//inheritance
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    //overriding getDistance() method
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
var pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance());
//understanding private 
var Animal = /** @class */ (function () {
    function Animal(name) {
        this.name = name;
    }
    Animal.prototype.getName = function () {
        return this.name;
    };
    Animal.prototype.setName = function (name) {
        this.name = name;
    };
    return Animal;
}());
var animal = new Animal('Puppy');
//console.log(animal.name); //will not work; name is private
console.log(animal.getName()); //works. using Encapsulation***
//animal.name = 'Tomcat'; //same; still does not work
animal.setName('Tomcat');
//understanding protected 
var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    return Person;
}());
var Employee = /** @class */ (function (_super) {
    __extends(Employee, _super);
    function Employee(name, department) {
        var _this = _super.call(this, name) || this;
        _this.department = department;
        return _this;
    }
    Employee.prototype.getElevatorPitch = function () {
        return "Hello, my name is " + this.name + " and I work\n        in " + this.department + ".";
    };
    return Employee;
}(Person));
var emp1 = new Employee("John", "Sales");
//console.log(emp1.name); //cannot access name directly outside of subclass
console.log(emp1.getElevatorPitch()); //works fine
/* READONLY modifier
    You can make properties read only.
    These properties must be initialized at their declaration or in the constructor
    Allows you to work in a functional way(unexpected mutation is bad)
    Can use modifier in interfaces as well. Can be initialized but not reassigned
*/
var Car = /** @class */ (function () {
    function Car() {
        this.numWheels = 4;
    }
    return Car;
}());
var c1 = new Car();
//c1.brand = 'Honda'; //does not work as car is created without brand
console.log(c1.numWheels); //can access
console.log(c1.brand);
// c1.numWheels = 10; // reassignment will not work
var Car2 = /** @class */ (function () {
    function Car2(brand) {
        this.numWheels = 4;
        this.brand = brand;
    }
    return Car2;
}());
var c2 = new Car2('Honda'); //can be set via constructor
var c3 = new Car2('Toyota');
//c2.brand = 'Hyundai'; //still not able to be reassigned
/*  STATIC
Thus far, we've only discussed instance members of a class. But it's important
to note that we have static members, which are visible on the class itself
and not instances
*/
var Calculator = /** @class */ (function () {
    function Calculator() {
    }
    Calculator.add = function (a, b) {
        return a + b;
    };
    Calculator.subtract = function (a, b) {
        return a - b;
    };
    return Calculator;
}());
var num = Calculator.add(10, 3);
/* ABSTRACT CLASS
Abstract classes are base classes from which other classes may be derived. They
may not be instantiated directly. Unlike an interface, an abstract class may
contain implementation details for its members. The abstract keyword is used
to define abstract classes as well as abstract methods within an abstract class

Methods within an abstract class that are marked abstract have no implementation
and must be implemented in derived classes; they must use the abstract keyword;
*/
var Account = /** @class */ (function () {
    function Account() {
    }
    return Account;
}());
var CheckingAccount = /** @class */ (function (_super) {
    __extends(CheckingAccount, _super);
    function CheckingAccount() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    CheckingAccount.prototype.generateReports = function () {
        console.log('concrete');
    };
    return CheckingAccount;
}(Account));
//Typescript also supports 
//https://www.typescriptlang.org/docs/handbook/generics.html
