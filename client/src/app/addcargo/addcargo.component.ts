import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';



@Component({
  selector: 'app-addcargo',
  templateUrl: './addcargo.component.html'
 
})
export class AddcargoComponent implements OnInit {
  itemForm: FormGroup;
  formModel:any={status:null};
  showError:boolean=false;
  errorMessage:any;
  cargList:any=[];
  assignModel: any={};
  driverList:any=[]
  showMessage: any;
  responseMessage: any;
  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
    {
      this.itemForm = this.formBuilder.group({
        content: [this.formModel.username,[ Validators.required]],
        size: [this.formModel.password,[ Validators.required]],
        status: [this.formModel.password,[ Validators.required]]
       
    });
  }
  ngOnInit(): void {
   this.getCargo();
   this.getDrivers();
   this.assignModel.driverId=null;
  }
  getCargo() {
    this.cargList=[];
    this.httpService.getCargo().subscribe((data: any) => { 
      this.cargList=data;
      console.log(this.cargList);
    }, 
      error => {
      // Following code handles errors
      this.showError = true;
      this.errorMessage = "Error. Please try again.";
      console.error('Login error:', error);
    });;
  }
  getDrivers() {
    this.driverList=[];
    this.httpService.getDrivers().subscribe((data: any) => {this.driverList=data;
      console.log(this.driverList);
    }, 
      error => {
      // Following code handles errors
      this.showError = true;
      this.errorMessage = "Error. Please try again.";
      console.error('Login error:', error);
    });;
  }
 
  onSubmit()
  {
    if(this.itemForm.valid)
    {
        this.showError = false;
         const formData = this.itemForm.value;
        this.httpService.addCargo(formData).subscribe((data: any) => {this.itemForm.reset();
          this.getCargo();}, 
          error => {
          // Following code handles errors
          this.showError = true;
          this.errorMessage = "Error. Please try again.";
          console.error('Login error:', error);
        });;
    }
    else{
      this.itemForm.markAllAsTouched();
    }
  }
  addDriver(value:any)
  {
    this.assignModel.cargoId=value.id
  }
  assignDriver()
  {
    if(this.assignModel.driverId!=null)
    {
      this.showMessage = false;
      this.httpService.assignDriver(this.assignModel.driverId,this.assignModel.cargoId).subscribe((data: any) => {
        debugger;
        this.showMessage = true;
        this.responseMessage=data.message;;
      }, error => {
        // Handle error
        this.showError = true;
        this.errorMessage = "Error. Please try again.";
        console.error('Login error:', error);
      });;
    }
  }
  
}