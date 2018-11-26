import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface StarWarsHero {
  name: String;
  height: number;
}

@Injectable({
  providedIn: 'root'
})
export class SampleServiceService {

  public projectName: String = 'sample';

  constructor(private http: HttpClient) { }

  printHello():void {
    console.log('hello');
  }

  updateProjectName(newName: String):void {
    this.projectName = newName;
  }

  getStarWarsPeople(id: number) {
    return this.http.get<StarWarsHero>(`https://swapi.co/api/people/${id}`);
  }
}
