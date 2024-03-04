import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './auth.interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { RegistrationComponent } from './registration/registration.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpService } from '../services/http.service';
import { DashbaordComponent } from './dashbaord/dashbaord.component';
import { AddcargoComponent } from './addcargo/addcargo.component';
import { AssginCargoComponent } from './assgin-cargo/assgin-cargo.component';
import { ViewcargostatusComponent } from './viewcargostatus/viewcargostatus.component';
import { WelcomepageComponent } from './welcomepage/welcomepage.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
      RegistrationComponent,
      DashbaordComponent,
      AddcargoComponent,
      AssginCargoComponent,
      ViewcargostatusComponent,
      WelcomepageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  
  ],
  providers: [HttpService,HttpClientModule,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    }, ],
  bootstrap: [AppComponent]
})
export class AppModule { }