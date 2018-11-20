import { Injectable } from '@angular/core';

@Injectable()
export class SampleServiceService {

  public projectName: String = 'sample';

  constructor() { }

  printHello(): void {
    console.log('hello');
  }

  updateProjectName(newName: String): void {
    this.projectName = newName;
  }
}
