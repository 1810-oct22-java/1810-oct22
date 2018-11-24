import { Component, OnInit } from '@angular/core';
import { Router, RouteReuseStrategy } from "@angular/router";
import { GlobalsService } from '../globals.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  constructor(
    public envVars: GlobalsService,
    public router: Router
  ) {}

  ngOnInit() {
     //Redirect session if user is not logged in
     if(!this.checkSession()){
      this.router.navigate(['login']);
    } else {
      //Loads all reimbursments
      this.loadAllReimbursements();
    }
  }

  //Used to check if the user has already logged in
  //If not redirect them to the login page
  checkSession(): Boolean {

    if(!this.envVars.isLoggedIn())
      return false;

    return true;
  }

}
