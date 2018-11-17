import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from '../../models/user.models';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  output: string;
  color = 'white';
  currentUser: User;

  constructor(private loginService: LoginService) {
    console.log('using dependency injection');
  }

  ngOnInit() {
  }

  usrPass() {
    // this.output = `${this.username} ${this.password}`;
    this.currentUser = this.loginService.validateUser(this.username, this.password);
    if (this.currentUser == null) {
      this.output = `sorry, invalid credentials`;
    } else {
      this.output = `Welcome, ${this.username}. Password: ${this.password}`;
    }
  }

}
