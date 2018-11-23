import { Component, OnInit } from '@angular/core';
import { Router, RouteReuseStrategy } from "@angular/router";
import {CookieService} from 'ngx-cookie-service';
import { GlobalsService } from '../globals.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  dollarAmount: number;
  description: String;
  type: String;

  constructor(
    public envVars: GlobalsService,
    public router: Router,
    public cookies: CookieService
  ){}

  ngOnInit() {
    //Redirect session if user is already logged in

    console.log(this.envVars.username);
    //this.checkSession(this.envVars.getApiUrl(), this.router);
  }

  //Used to check if the user has already logged in
  //If not redirect them to the login page
  checkSession(baseURL: String, router: Router): void {

    var self = this;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
      if(xhr.readyState == 4 && xhr.status == 200){

        console.log("200");

        //If session exists navigate them to the correct page
        var sessionStatus =  JSON.parse(xhr.responseText);
        if(sessionStatus['sessionExists'] != true){
          console.log("renavigating two");
          //self.router.navigate(['login']);
        }

      //If the client has been tampered with (session already deleted on the server side)
      } else if(xhr.readyState == 4 && xhr.status == 401){
        console.log("renavigating");
        //self.router.navigate(['login']);
      }
    }
    xhr.open("GET", baseURL + "checkSessionEmployee" , true);
    xhr.send();
  }

  loadSubmittedReimbursements(): void {

    var self = this;
    var reimbursements = new Array();

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
      if(xhr.readyState == 4 && xhr.status == 200){

        var results = JSON.parse(xhr.responseText);

        console.log(results);

      }
    }
    xhr.open("GET", self.envVars.getApiUrl() + "getUserReimbursements" , true);
    xhr.send();
  }

}
