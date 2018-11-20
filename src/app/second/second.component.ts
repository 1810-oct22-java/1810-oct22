import { Component, OnInit } from '@angular/core';
import { SampleServiceService } from '../sample-service.service';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  editedProjectName: String = '';

  constructor(private sampleService: SampleServiceService) { }

  ngOnInit() {
    this.editedProjectName = this.sampleService.projectName;
  }

  updateProject() {
    if (this.sampleService.projectName !== this.editedProjectName) {
      this.sampleService.updateProjectName(this.editedProjectName);
    }
  }

  resetProjectName(): void {
    this.editedProjectName = this.sampleService.projectName;
  }

}
