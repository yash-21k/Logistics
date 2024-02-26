import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-viewcargostatus',
  templateUrl: './viewcargostatus.component.html',
  styleUrls: ['./viewcargostatus.component.scss']
})
export class ViewcargostatusComponent {
  cargo:any={}
  showError:any;
  errorMessage: any;
  cargoIdMd:any;
  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
  {

  }

  search()
  {
   //complete this function 
   debugger;
   this.cargo={};
   this.httpService.getCargo().subscribe((data:any)=>{
    this.cargo=data;
    console.log(data);
   }, error =>{
    this.showError = true;
    this.errorMessage = "An error occured while searching the cargo. Please try again with valid cargo data"
   })
  }
  }


