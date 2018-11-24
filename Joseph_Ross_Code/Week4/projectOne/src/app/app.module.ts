import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import {CookieService} from 'ngx-cookie-service'

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRouterModule } from './app-router.module';
import { EmployeeComponent } from './employee/employee.component';
import { ManagerComponent } from './manager/manager.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    ManagerComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    FormsModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
