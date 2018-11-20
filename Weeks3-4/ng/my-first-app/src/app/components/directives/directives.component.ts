import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {
<<<<<<< HEAD
  showIf= true;
=======

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
>>>>>>> 38122283bd9c4207be1c2d26ed0570dbf262e562

  constructor() { }

  ngOnInit() {
  }
  toggleIf(){
    this.showIf = !this.showIf;
  }

}
