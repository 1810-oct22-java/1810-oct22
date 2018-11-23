import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalsService {

  public apiName: String = "http://localhost:8080/bookstore-full-stack/";
  public username;
  public password;

  constructor() {}

  getApiUrl(): String {
    return this.apiName;
  }
}
