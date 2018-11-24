import { Component, OnInit } from '@angular/core';
import { Router, RouteReuseStrategy } from "@angular/router";
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
    public router: Router
  ){}

  ngOnInit() {
    //Redirect session if user is not logged in
    if(!this.checkSession()){
      this.router.navigate(['login']);
    } else {
      //Loads all reimbursments
      this.loadSubmittedReimbursements();
    }
  }

  //Used to check if the user has already logged in
  //If not redirect them to the login page
  checkSession(): Boolean {

    if(!this.envVars.isLoggedIn())
      return false;

    return true;
  }

  loadSubmittedReimbursements(): void {

    //Used to refrence object scope inside ajax functions
    //var self = this;
    
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

  submitReimbursement(): void {

    $.ajax({
      url: this.envVars.getApiUrl() + "submitReimbursementRequest",
      data: {
        "username" : this.envVars.getUsername(),
        "password" : this.envVars.getPassword(),
        "amount" : this.dollarAmount,
        "descr" : this.description,
        "type" : this.typeToIndex()
      },
      type: 'POST',
      success: function (response: String) {

        console.log(response);
      }
    });

  }

  typeToIndex(): String {
    if(this.type == "lodging") return '1';
    if(this.type == "travel") return '2';
    if(this.type == "food") return '3';
    if(this.type == "other") return '4';
  }

}
