import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  itemForm: FormGroup;
  formModel: any = {};
  showError: boolean = false;
  errorMessage: any;
  constructor(public router: Router, private formBuilder: FormBuilder, private httpService: HttpService, private authService: AuthService) {
    this.itemForm = this.formBuilder.group({
      //compelete this
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]

    });
  }

  ngOnInit(): void {
  }
  onLogin() {
    //compelete this
    if (this.itemForm.valid) {
      this.showError = false;
      this.httpService.Login(this.itemForm.value).subscribe((data: any) => {
        if (data.userNo != 0) {

          // localStorage.setItem('role', data.role);
          this.authService.SetRole(data.role);
          this.authService.saveToken(data.token)
          this.router.navigateByUrl('/dashboard');


          setTimeout(() => {
            window.location.reload();
          }, 1000);
        } else {
          this.showError = true;
          this.errorMessage = "Wrong User or Password";
        }
      }, error => {
        // Handle error
        this.showError = false;
        this.errorMessage = "An error occurred while logging in. Please try again later.";
        console.error('Login error:', error);
      });;
    }else{
      this.itemForm.markAllAsTouched();
    }
  }
  registration() {
    //compelete this '
    this.router.navigate(['registration']);
  }
}