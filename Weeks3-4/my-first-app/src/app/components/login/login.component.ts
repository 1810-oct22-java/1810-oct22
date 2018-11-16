import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  output: string;
  constructor() { }

  ngOnInit() {
  }

  login() {
    this.output = `welcome ${this.username}. password: ${this.password}`;
  }

}
