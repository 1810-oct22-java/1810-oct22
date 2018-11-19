import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [1, 5, 6, 7, 8, 9];

  constructor() { }

  ngOnInit() {
  }

  toggleIf() {
    this.showIf = !this.showIf;
  }

}
