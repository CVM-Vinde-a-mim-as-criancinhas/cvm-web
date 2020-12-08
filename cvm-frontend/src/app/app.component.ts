import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "./component/auth/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'cvm-frontend';
  mostrarMenu: boolean;

  constructor(private authentication: AuthenticationService, public router: Router) {
  }

  ngOnInit(): void {
    if (localStorage.getItem('isLogged') === 'true') {
      this.mostrarMenu = true;
    } else {
      this.mostrarMenu = false;
    }
  }
}
