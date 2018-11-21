import { Component, OnInit } from '@angular/core';
import { Hero } from '../models/hero';
import { HeroService } from '../hero.service';
import { CoolService } from '../cool.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  heroes: Hero[] = [];
  starWarsHeros = [];
  errorMsg: String = '';

  constructor(private heroService: HeroService, private startWarsService: CoolService) { }

  ngOnInit() {
    this.getHeroes();
    this.getStarWarsHeros();
  }

  getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(heroes => this.heroes = heroes.slice(1, 5));
  }

  getStarWarsHeros() {
    this.startWarsService.getStarWarsPeople(5).subscribe(
      (starHero) => this.starWarsHeros.push(starHero),
      (error) => this.errorMsg = 'Something went wrong on the network... Sorry.'
    );
  }
}
