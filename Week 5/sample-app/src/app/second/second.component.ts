import { Component, OnInit } from '@angular/core';
import { SampleServiceService } from '../sample-service.service';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  editedProjectName: String = "";
  starWarsHeros = [];
  errorMsg: String = '';

  constructor(private sampleService: SampleServiceService) { }

  ngOnInit() {
    this.editedProjectName = this.sampleService.projectName;
    console.log(this.sampleService.projectName);
    this.getStarWarsHeros();
  }

  updateProject() {
    if (this.sampleService.projectName !== this.editedProjectName) {
      this.sampleService.updateProjectName(this.editedProjectName);
    }
  }

  resetProjectName(): void {
    this.editedProjectName = this.sampleService.projectName;
  }

  getStarWarsHeros() {
    this.sampleService.getStarWarsPeople(5).subscribe(
      (starWarsHero) => this.starWarsHeros.push(starWarsHero),
      (error) => this.errorMsg = 'Something went wrong on the network... Sorry.'
    );
  }

}
