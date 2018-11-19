import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

<<<<<<< HEAD
=======
  text = 'hello world';
  buttonClass = 'btn btn-secondary';
  count = 0;
  color = 'blue';

>>>>>>> 05c8627c0abaad60ec41906d1d0288ce6de998aa
  constructor() { }

  ngOnInit() {
  }

<<<<<<< HEAD
=======
  changeColor() {
    const classes = ['primary', 'secondary', 'success',
  'danger', 'warning', 'info', 'light', 'dark'];
  this.buttonClass = `btn btn-${classes[this.count % 8]}`;
  }

  clickButton() {
    this.count++;
  }

>>>>>>> 05c8627c0abaad60ec41906d1d0288ce6de998aa
}
