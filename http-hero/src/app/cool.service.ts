import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface StarWarsHero {
  name: String;
  height: number;
}


@Injectable({
  providedIn: 'root'
})
export class CoolService {

  constructor(private http: HttpClient) { }

  getStarWarsPeople(id: number) {
    return this.http.get<StarWarsHero>(`https://swapi.co/api/people/${id}`);
  }

}
