import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
