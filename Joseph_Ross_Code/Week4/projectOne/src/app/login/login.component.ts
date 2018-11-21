import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { THROW_IF_NOT_FOUND } from '@angular/core/src/di/injector';
import { routerNgProbeToken } from '@angular/router/src/router_module';

import {CookieService} from 'ngx-cookie-service'

import { GlobalsService } from '../globals.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username: String;
  public password: String;

  constructor(
                public envVars: GlobalsService,
                public router: Router,
                public cookies: CookieService
              ){}

  ngOnInit() {
    //Redirect session if user is already logged in
    this.checkSession(this.envVars.getApiUrl(), this.router);
  }

  //Used to check if the user has already logged in
  //If so redirect them to the correct page
  checkSession(baseURL: String, router: Router): void {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
      if(xhr.readyState == 4 && xhr.status == 200){
        
        //If session exists navigate them to the correct page
        var sessionStatus =  JSON.parse(xhr.responseText);
        if(sessionStatus['sessionExists'] == true)
          router.navigate([sessionStatus['redirectUrl']]);
      }
    }
    xhr.open("GET", baseURL + "checkSession" , true);
    xhr.send();
  }

  //Will send request to server and verify 
  attemptLogin(): void {

    var router = this.router;

    $.ajax({
        url: this.envVars.getApiUrl() + "login",
        data: {
          "username" : this.username,
          "password" : this.password
        },
        type: 'POST',
        success: function (serverResponce: String) {
          
          console.log(serverResponce);
          //router.navigate([])

        }
    });
    
  }

}
