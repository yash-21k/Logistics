import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  IsLoggin: any = false;
  roleName: string | null;
  username: string | null;
  constructor(private authService: AuthService, private router: Router) {
    this.IsLoggin = authService.getLoginStatus;
    this.roleName = authService.getRole;
    this.username = authService.getUsername;


    if (this.IsLoggin == false) {
      this.router.navigateByUrl('/dashbaord');

    }
  }

  logout() {
    this.authService.logout();
    window.location.reload();
  }

}
// if(authService.getRole!= this.roleName){
//   this.router.navigateByUrl('/dashbaord');
// }