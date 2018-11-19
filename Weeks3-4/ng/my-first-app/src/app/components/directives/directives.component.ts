import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [1, 5, 6, 7, 8, 9];
  employees = [
    {
      name: 'Gen',
      role: 'Trainer'
    },
    {
      name: 'Peter',
      role: 'Trainer'
    },
    {
      name: 'Carolyn',
      role: 'Trainer'
    },
    {
      name: 'Quinn',
      role: 'Trainer'
    },
    {
      name: 'Nick',
      role: 'Trainer'
    },
    {
      name: 'Richard',
      role: 'Trainer'
    },
    {
      name: 'Phil',
      role: 'Associate'
    },
    {
      name: 'Margy',
      role: 'Associate'
    },
    {
      name: 'James',
      role: 'Associate'
    },
    {
      name: 'Michael',
      role: 'Associate'
    },
    {
      name: 'Bill',
      role: 'Associate'
    }
  ];

  constructor() { }

  ngOnInit() {
  }

  toggleIf() {
    this.showIf = !this.showIf;
  }

}
