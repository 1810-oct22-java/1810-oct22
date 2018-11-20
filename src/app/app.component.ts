import { Component, OnInit } from '@angular/core';
import { SampleServiceService } from './sample-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private sampleService: SampleServiceService) {}

  ngOnInit(): void {
    this.printMsg();
    // this.sampleService.printHello();
  }

  printMsg(): void {
    this.sampleService.printHello();
  }
}
