//this is a comment
/* this is a multi
line
comment 
*/

//[access modifier] [non-access modifier] class [ClassName]{} 
public class HelloWorld {
    /*
    To define an object in Java, you must delcare a class
    A class is a blueprint for a discrete entity(object) that 
        contains attributes/state and behavior/methods

    At runtime, your application creates an instance of the object
    */
    //starting point of any java program is the main method
    //[access mod] [non access mods] [return type] [methodName](params/arguments){}
    public static void main(String[] args){
        System.out.println("HELLO WORLD!");
        System.out.println("The first argument in our string array is: " + args[0] );
    }

}


