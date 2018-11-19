import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username =  '';
  password = '';
  output: string;
  currentUser: User;
  constructor(private loginService: LoginService) {
    console.log('using dependency injection in login component for login service');
  }

  ngOnInit() {
  }

  login() {
    console.log('in login method');
    this.currentUser = this.loginService.validateUser(this.username, this.password);
    if (this.currentUser == null || this.currentUser == undefined) {
      this.output = 'sorry, invalid credentials';
    } else {
      this.output = `welcome ${this.username}. password: ${this.password}`;
    }
  }

}
