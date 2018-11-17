import { Injectable } from '@angular/core';
import { User } from '../models/user.models';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userList: User[] = [
    new User('gen', '123'),
    new User('test', 'user'),
    new User('x', 'x')
  ];

  constructor() { }

  public validateUser(username: string, password: string): User {
    for (const u of this.userList) {
      if ((u.username.toLowerCase()) === (username.toLowerCase())) {
        if (u.password.toLowerCase() === password.toLowerCase()) {
          return u;
        }
      }
    }
    return null;
  }
}
