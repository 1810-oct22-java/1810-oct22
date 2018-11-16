import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { CookieService } from 'ngx-cookie-service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EmployeeViewComponent } from './employee-view/employee-view.component';
import { ManagerViewComponent } from './manager-view/manager-view.component';
import { AddRequestComponent } from './add-request/add-request.component';
import { SeeRequestsComponent } from './see-requests/see-requests.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeViewComponent,
    ManagerViewComponent,
    AddRequestComponent,
    SeeRequestsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [ CookieService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
