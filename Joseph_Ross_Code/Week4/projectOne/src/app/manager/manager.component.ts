import { Component, OnInit } from '@angular/core';
import { Router, RouteReuseStrategy } from "@angular/router";
import { GlobalsService } from '../globals.service';
import { DataTableDirective } from 'angular-datatables';

import { AfterViewInit, OnDestroy, ViewChild } from '@angular/core';
import { Subject } from 'rxjs';


@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements AfterViewInit, OnDestroy, OnInit {

  @ViewChild(DataTableDirective)
  dtElement: DataTableDirective;

  dtOptions: DataTables.Settings = {};

  dtTrigger: any = new Subject();

  public selectedReimbId: String;
  public selectedReimbDescision: String;

  constructor(
    public envVars: GlobalsService,
    public router: Router
  ) {}

  ngAfterViewInit(): void {
    this.dtTrigger.next();
  }

  ngOnDestroy(): void {
    // Do not forget to unsubscribe the event
    this.dtTrigger.unsubscribe();
  }

  rerender(): void {

    var self = this;

    this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      // Destroy the table first
      dtInstance.destroy();
      // Call the dtTrigger to rerender again
      this.dtTrigger.next();
    });
  }

  ngOnInit() {
     //Redirect session if user is not logged in
     if(!this.checkSession()){
      this.router.navigate(['login']);
      
    } else {

      var self = this;

      //Loads all reimbursments
      this.loadAllReimbursements();

      $(document).ready(function() {
        var table = $('#reimb-table').DataTable();
     
        $('#reimb-table tbody').on( 'click', 'tr', function () {

            $('#approve-btn').prop( "disabled", true );
            $('#deny-btn').prop( "disabled", true );
            $('#reimb-id-display').text("-");

            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');

            if($(this).children().eq(5).text() == "1"){
              self.selectedReimbId = $(this).children().eq(0).text();

              $('#approve-btn').prop( "disabled", false );
              $('#deny-btn').prop( "disabled", false );

              $('#reimb-id-display').text(self.selectedReimbId + "");
            }

        } );
     
    } );
    }
  }
  

  //Used to check if the user has already logged in
  //If not redirect them to the login page
  checkSession(): Boolean {

    if(!this.envVars.isLoggedIn())
      return false;

    return true;
  }

  loadAllReimbursements(): void {

    this.dtOptions = {
      ajax: {
        url: this.envVars.getApiUrl() + "getAllReimbursementsServlet",
        data: {
          "username" : this.envVars.getUsername(),
          "password" : this.envVars.getPassword()
        },
        type: 'POST',
      },
      columns: [
        {
          title: 'Id',
          data: 'reimbId'
        },
        {
          title: 'Amount',
          data: 'amount'
        }, 
        {
          title: 'Submitted',
          data: 'timeSubmitted'
        }, 
        {
          title: 'Description',
          data: 'desc'
        },
        {
          title: 'User Id',
          data: 'userId'
        },
        {
          title: 'Status',
          data: 'statusId'
        },
        {
          title: 'Type',
          data: 'reimbTypeId'
        },
      ]
    };

    
  }

  approve(): void {
    this.submitReimbursmentDescision(2);
  }

  deny(): void {
    this.submitReimbursmentDescision(3);
  }

  submitReimbursmentDescision(decision: number): void {
    var self = this;
    $.ajax({
      url: this.envVars.getApiUrl() + "managerReimbursementDecision",
      data: {
        "username" : this.envVars.getUsername(),
        "password" : this.envVars.getPassword(),
        "reimbId" : this.selectedReimbId,
        "decision" : decision
      },
      type: 'POST',
      success: function (response: String) {
        self.rerender();

        $('#approve-btn').prop( "disabled", true );
        $('#deny-btn').prop( "disabled", true );
        $('#reimb-id-display').text("-");
      }
    });
  }
}
