import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  text = 'Radda Radda';
  buttonClass = 'btn btn-primary';
  count = 0;
  color = 'blue';

  constructor() { }

  ngOnInit() {

  }

  clickButton() {
    this.count++;
  }

  changeColor() {
    const classes = ['primary', 'secondary', 'success',
      'danger', 'warning', 'info'];
    this.buttonClass = `btn btn-${classes[this.count % 6]}`;
  }

}
