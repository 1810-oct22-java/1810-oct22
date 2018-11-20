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

  // must use DI for router
  constructor(private router: Router) { }

  ngOnInit() {
  }

  goToLogin() {
    this.router.navigate(['login']); // navigate to denoted path
  }
}
