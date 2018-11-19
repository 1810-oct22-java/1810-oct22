export class User {
    // model classes are used somewhat like pojos in Java. used to model objects
    username: string;
    password: string;

    constructor(name, pw) {
        this.username = name;
        this.password = pw;
    }
}
