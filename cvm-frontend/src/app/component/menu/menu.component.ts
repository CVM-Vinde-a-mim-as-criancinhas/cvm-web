import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../auth/authentication.service';
import {UserPrincipal} from '../../data/usuario-principal';
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  usuario: UserPrincipal = new UserPrincipal();
  mostrarMenuCompleto: boolean = false;
  logado: boolean;

  constructor(private authentication: AuthenticationService, public router: Router) {
  }

  ngOnInit(): void {

    if (localStorage.getItem('isLogged') === 'true') {
      this.logado = true;
    } else {
      this.logado = false;
    }
  }

  logout() {
    this.authentication.logout();
  }

}
