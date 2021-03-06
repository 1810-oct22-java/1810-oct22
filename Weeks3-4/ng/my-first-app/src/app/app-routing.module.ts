import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from 'src/app/components/login/login.component';
import { HomeComponent } from 'src/app/components/home/home.component';
import { DataBindingComponent } from 'src/app/components/data-binding/data-binding.component';
import { DirectivesComponent } from 'src/app/components/directives/directives.component';
import { PipesComponent } from 'src/app/components/pipes/pipes.component';
import { HttpComponent } from 'src/app/components/http/http.component';

const routes: Routes = [
  // where your routes are listed
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent},
  { path: 'binding', component: DataBindingComponent },
  { path: 'directives', component: DirectivesComponent },
  { path: 'pipes', component: PipesComponent },
  { path: 'http', component: HttpComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
