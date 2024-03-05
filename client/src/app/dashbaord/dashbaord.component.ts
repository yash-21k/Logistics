import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { HttpService } from '../../services/http.service';

@Component({
  selector: 'app-dashbaord',
  templateUrl: './dashbaord.component.html',
  styleUrls: ['./dashbaord.component.scss']
})
export class DashbaordComponent {
  IsLoggin: any = false;
  roleName: string | null;
  username: string | null;
  constructor(private authService: AuthService, private router: Router) {
    this.IsLoggin = authService.getLoginStatus;
    this.roleName = authService.getRole;
    this.username = authService.getUsername;
    if (this.IsLoggin == false) {
      this.router.navigateByUrl('/login');

    }
  }

  //logout function
  logout() {
    this.authService.logout();
    window.location.reload();
  }
}
