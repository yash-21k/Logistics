import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private token: string | null = null;
  private isLoggedIn: boolean = false;

  constructor() { }

  // Method to save token received from login
  saveToken(token: string) {
    localStorage.setItem('token', token);
  }
  SetId(id: any) {
    localStorage.setItem('id', id);
  }
  setUsername(username: string) {
    localStorage.setItem('username', username);
  }
  get getUsername(): string | null {
    return localStorage.getItem('username');
  }
  get getId(): string | null {
    return localStorage.getItem('id');
  }

  SetRole(role: any) {
    localStorage.setItem('role', role);
  }
  get getRole(): string | null {
    return localStorage.getItem('role');
  }
  // Method to retrieve login status
  get getLoginStatus(): boolean {

    return !!localStorage.getItem('token');

  }
  getToken(): string | null {
    this.token = localStorage.getItem('token');
    return this.token;
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('role');
    localStorage.removeItem('id');
    this.token = null;
    this.isLoggedIn = false
  }
}
