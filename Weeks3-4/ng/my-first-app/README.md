# MyFirstApp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.0.6.

## Some notes on Angular
Angular is a front end/client side framework - runs on browser as opposed to the server
* Created and still maintained by google
* Used to create SPA applications
* Integral part of the MEAN stack (MongoDB , Express (backend web framework) and Angular and NodeJS)  -- one of the most powerful web stacks to build apps

* AngularJS/Angular 1 --> Angular 2(essentially a rewrite. Added components and got rid of controllers and scope) --> Skipped angular3(skipped because of the router. Router package was out of sync with the rest of the angular packages, so they just decided to bring everything to angular 4 so all of the packages are on angular 4) --> Angular 4 (backwards compatible with angular 2; most changes are "under the hood", everything is backwards compatible)
* Angular4: provides:
    * Rapid development and code generation. Angular CLI helps get your app up faster
	* Code organization and productivity
	* Dynamic content
	* Cross platform - windows, mac, doesn’t matter 
	* Testing capabilities 
	* Uses TypeScript -  a superset of JSs
		* Adds static typing
		* Resembles languages like Java and C#
		* Can use class based objects
		* Angular components are essentially classes
		* Has constructors
		* Can use this keyword
	* Components - sections of the UI 
		○ Basic building block of the UI. An angular application is a  tree of components. 
		○ Decorators allow us to mark a class as an Angular component and provide metadata that determines how the component should be processed, instantiated, and used at runtime
		○ Has a selector - custom html tag that we use to insert our component
		○ Template - html along w dynamic info like variables, if statements using directives etc
		○ Component class - define properties 
	* Services - classes that send data and functionality across multiple components
		○ Keeps components lean 
		○ DRY - don’t repeat yourself
		○ Ideal place for AJAX calls 
	* Two main ways to install - angular CLI or quickstart seed. The former is prefered. We need Node.js and NPM as dependencies 
		○ NodeJS is a javascript runtime; runs JS on the server
		○ We need it mostly for NPM, which we use to install angular 
