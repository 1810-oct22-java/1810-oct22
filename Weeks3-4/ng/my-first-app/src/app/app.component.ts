import { Component } from '@angular/core';

@Component({
  // selector - custom HTML element used to include this component in the app
  selector: 'app-root',

  /* link to Template(HTML FILE) for this component
  can be replaced with in-line HTML using the template attribute 
  */
 templateUrl: './app.component.html',
// template: `<h1>This is my {{ title }} app</h1>`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Genesis App';
}
