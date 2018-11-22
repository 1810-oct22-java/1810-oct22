import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  dollarAmount: number;
  description: String;
  type: String;


  constructor() { }

  ngOnInit() {
  }

}
