import { Component, OnInit } from '@angular/core';
import { FirstService } from '../first.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  editedProjectName: String = '';
  //heroes: Hero[] = [];
  //starWarsHeros = [];

  constructor(private FirstService: FirstService) { }

  ngOnInit() {
    this.editedProjectName = this.FirstService.projectName;
    
  }
  updateProject2() {
  }
/**
 * 
 *   getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(heroes => this.heroes = heroes.slice(1, 5));
  }


  getStarWarsHeros() {
    this.startWarsService.getStarWarsPeople(7).subscribe(
      (starHero) => this.starWarsHeros.push(starHero),
      (error) => this.errorMsg = 'Something went wrong on the network... Sorry.'
    );
  }
 */

  updateProject() {
    if (this.FirstService.projectName !== this.editedProjectName) {
      this.FirstService.updateProjectName(this.editedProjectName);
    }
  }

  resetProjectName(): void {
    this.editedProjectName = this.FirstService.projectName;
  }

}
