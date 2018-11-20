import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf: boolean = true;
  numArr = [1,2,3,4,5,9];

  constructor() { }

  ngOnInit() {
  }

  toggleIf() {
    this.showIf = !this.showIf;
  }

}
