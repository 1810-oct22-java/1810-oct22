import { Component, OnInit } from '@angular/core';
import { Hero } from '../models/hero';
import { HeroService } from '../hero.service';

@Component({
    selector: 'app-heros',
    templateUrl: './heros.component.html',
    styleUrls: ['./heros.component.css']
})
export class HerosComponent implements OnInit {

    heroes: Hero[];
    selectedHero: Hero;

    constructor(private heroService: HeroService) { }

    ngOnInit() {
        this.getHeroes();
    }

    getHeroes(): void {
        this.heroService.getHeroes()
        .subscribe( heros => this.heroes = heros);
    }

    // onSelect(hero) {
    //     if (this.selectedHero === hero) {
    //         this.selectedHero = null;
    //     } else {
    //         this.selectedHero = hero;
    //     }
    // }
}
