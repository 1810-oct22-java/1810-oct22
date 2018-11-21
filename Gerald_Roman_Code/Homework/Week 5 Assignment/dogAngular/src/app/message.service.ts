import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface dogBreeds{
  name: String;
  image: String;
}
@Injectable({
  providedIn: 'root'
})

export class MessageService {

  constructor(private http: HttpClient) { }

  getDogByBreed(breed: String){
    console.log(`https://dog.ceo/api/chihuahua/images/random`);
      
   //   `https://dog.ceo/api/chihuahua/images/random`);
  //  return this.http.get<dogBreeds>(`https://dog.ceo/api/${breed}/images/random`);
  }
}