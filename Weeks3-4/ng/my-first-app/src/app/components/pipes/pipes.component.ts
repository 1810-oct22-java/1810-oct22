import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  text = 'sample text';
<<<<<<< HEAD
  currentTime: Date;
  constructor() { 
    setInterval( ()=> {
      this.currentTime = new Date();
    },1000);

=======
  currentTime;

  constructor() {
    setInterval( () => {
      this.currentTime = new Date();
    }, 1000);
>>>>>>> 38122283bd9c4207be1c2d26ed0570dbf262e562
  }

  ngOnInit() {
  }

}
