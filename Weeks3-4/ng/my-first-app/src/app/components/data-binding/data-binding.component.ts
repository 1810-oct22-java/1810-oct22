import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

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
