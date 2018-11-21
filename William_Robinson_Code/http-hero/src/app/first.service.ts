import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface StarWarsStarShip {
  name: String;
 
}

@Injectable({
  providedIn: 'root'
})
export class FirstService {
 // static starships =  [];
  public projectName: String = "sample";

  constructor(private http: HttpClient) { }

  getStarWarsStarShips(id: number) {
    //var num:number = 29;
   // var i: number = 0;
    try{
     
     // FirstService fs = new FirstService();
   // for(i=0; i<num; i++){
    this.http.get<StarWarsStarShip>(`https://swapi.co/api/starships/${id}`);
    //}
 }catch(e){
    console.log("Sorry there was an error");
  } 

  } 
  updateProjectName(newName: String): void {
    this.projectName = newName;
  }
 // return starships;
  
  }

 

