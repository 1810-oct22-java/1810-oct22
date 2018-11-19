import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; //used for input fields

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { DirectivesComponent } from './components/directives/directives.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { PipesComponent } from './components/pipes/pipes.component';
import { HTTPComponent } from './components/http/http.component';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({

  declarations: [
    /* Declarations array - holds classes that are
related to view. There can be three types of
classes listed here: components, directives, and pipes
*/
    AppComponent,
    HomeComponent,
    LoginComponent,
    DirectivesComponent,
    DataBindingComponent,
    PipesComponent,
    HTTPComponent,
    NavbarComponent
  ],
  /*
  , exports:[]
  classes that need to be accessible to the components
  of other modules. However, we're not making a
  multi-modular app at the moment, so we do not need
  anything in the exports array
  */
  imports: [
    /*
   modules whose classes are needed by classes within
   this current module
   */
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    /*
 Providers - services(@Injectable)
 */
    LoginService],
  bootstrap: [
    /*
Refers to the root component which is the main
view of the angular app
*/
    AppComponent]
})
export class AppModule { }

/*
Angular provides its own system of organization of code and functionality
 and this is accomplished by containers called modules.

A module is a cohesive block of code with a related set of capabilities
which have a specific application domain or a workflow. 

All Angular applications have at least one module, the root module 
 typically defined in the file app-module.ts. Now this module ties 
 together all of our components and defined where to start to bootstap our application. 

Some applications utilize more than one module and most commonly these 
modules define particular features. For example, the HTTPModule defines 
an API to use to send AJAX requests and the BrowserModule defines functionality
 for running your application in a web browser. 
 
Now all modules are TypeScript classes annotated with the @NgModule decorator 
which takes in an object of properties or metadata that specify how to construct the module. 


BOOTSTRAPPING
	- Bootstrapping is an essential process in Angular where the application is loaded
	- The bootstrap process loads main.ts which is the main entry point of the application
  - This process also starts the dependency injection system in Angular 
  
Dependency Injection 
	-  a core concept that pre-dates Angular
    The purpose of DI is to simplify dependency management in software components.
   By reducing the amount of information a component needs to know about its dependencies. 

*/
