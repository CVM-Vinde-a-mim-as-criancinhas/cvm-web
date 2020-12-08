import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {UserPrincipal} from "../../data/usuario-principal";


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService implements OnInit{

  ngOnInit(): void {
    localStorage.setItem("isLogged", "false");
  }

  constructor(
    private http: HttpClient,
  ) {

  }

  login(usuario: UserPrincipal): Observable<any> {
    return this.http.post('http://localhost:8080/cvm/login', usuario, {observe:'response'});
  }

  logout() {
    localStorage.setItem("isLogged", "false");
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    localStorage.removeItem('tokenG');
    localStorage.removeItem('tokenE');
  }

  store(data, token) {
    localStorage.setItem("isLogged", "true");
    localStorage.setItem("token", token);
    localStorage.setItem("user", JSON.stringify(data.sub));
    localStorage.setItem("tokenG", data.gen);
    localStorage.setItem("tokenE", data.exp);
  }

}
