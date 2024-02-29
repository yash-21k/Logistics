import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';


@Component({
  selector: 'app-assgin-cargo',
  templateUrl: './assgin-cargo.component.html',
  styleUrls: ['./assgin-cargo.component.scss']
})
export class AssginCargoComponent {
  

  showError:boolean=false;
  errorMessage:any;
  cargList:any=[];
  statusModel: any={};
  showMessage: any;
  responseMessage: any;
  id: any;

  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
  {
    //this.id = this.authService.getId;
  }
  ngOnInit(): void {
   this.getAssignedCargo();
   this.statusModel.newStatus=null;
  }
  getAssignedCargo() {
    // console.log("Driver ID is displayed")
    // console.log(this.id)
    this.cargList=[];
    this.httpService.getAssignOrders(1).subscribe((data: any) => {this.cargList=data;
      console.log(this.cargList);
    }, error => {
      // Handle error
      this.showError = true;
      this.errorMessage = "Error. Please try again.";
      console.error('Login error:', error);
    });;
  }
  addStatus(value:any)
  {
    this.statusModel.cargoId=value.id
  }
  assignDriver()
  {
    console.log("Update")
    console.log(this.statusModel.newStatus)
    if(this.statusModel.newStatus!=null)
    {
      this.showMessage = false;
      this.httpService.updateCargoStatus(this.statusModel.newStatus,this.statusModel.cargoId).subscribe((data: any) => {
        this.showMessage = true;
        this.responseMessage=data.message;;
        this.getAssignedCargo();
      }, error => {
        // Following code handles errors
        this.showError = true;
        this.errorMessage = "Error. Please try again.";
        console.error('Login error:', error);
      });;
    }
  }  
}