import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PipesComponent } from './components/pipes/pipes.component';

@NgModule({
  declarations: [
    AppComponent,
    HeroesComponent,
    HomeComponent,
    LoginComponent,
    DirectivesComponent,
    NavbarComponent,
    DataBindingComponent,
    PipesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
