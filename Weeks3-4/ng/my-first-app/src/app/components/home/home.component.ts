import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
<<<<<<< HEAD
=======

>>>>>>> 05c8627c0abaad60ec41906d1d0288ce6de998aa
/*
@Component indicates that the following TS class is a component
*/
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

<<<<<<< HEAD
  text = 'hello world';
  buttonClass = 'btn btn-secondary';
  count = 0;
  color = 'blue';

=======
  // must use DI for router
>>>>>>> 05c8627c0abaad60ec41906d1d0288ce6de998aa
  constructor(private router: Router) { }

  ngOnInit() {
  }

  goToLogin() {
    this.router.navigate(['login']); // navigate to denoted path
  }
<<<<<<< HEAD
  goToLogin(){
    this.router.navigate(['login']);
  }

=======
>>>>>>> 05c8627c0abaad60ec41906d1d0288ce6de998aa
}
