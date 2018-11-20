import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  num = 1;

  constructor() { }

  ngOnInit() {
  }

  switchTest() {
    this.num = this.num % 4;
  }

}
