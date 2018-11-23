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
    this.checkSession();

    //Loads all reimbursments
    this.loadSubmittedReimbursements();
  }

  //Used to check if the user has already logged in
  //If not redirect them to the login page
  checkSession(): void {

    if(!this.envVars.isLoggedIn())
      this.router.navigate(['login']);
  }

  loadSubmittedReimbursements(): void {

    //Used to refrence object scope inside ajax functions
    var self = this;
    
    $.ajax({
        url: this.envVars.getApiUrl() + "getEmployeeReimbursementRecords",
        data: {
          "username" : this.envVars.getUsername(),
          "password" : this.envVars.getPassword()
        },
        type: 'POST',
        success: function (response: String) {

          console.log(response);
        }
    });
  }

}
