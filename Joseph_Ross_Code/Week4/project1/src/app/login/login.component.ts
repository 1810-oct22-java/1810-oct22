import { Component, OnInit } from '@angular/core';

import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  sessionId: string;

  constructor(private cookieTool:CookieService) { }

  ngOnInit() {

    //Check if the client has a session-id
    if(this.cookieTool.get('session-id')){
      //TODO: 

    }
  }

}
