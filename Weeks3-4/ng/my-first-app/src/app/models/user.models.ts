export class User {
    // models are used somewhat like pojos
    username: string;
    password: string;

    constructor(name: string, pw: string) {
        this.username = name;
        this.password = pw;
    }
}
