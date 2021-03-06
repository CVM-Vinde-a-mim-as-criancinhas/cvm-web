import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../auth/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string = '';
  password: string = '';
  error = '';
  loginOk = true;
  mensagemErro = '';

  constructor(private route: ActivatedRoute, private router: Router, private authentication: AuthenticationService) {
  }

  ngOnInit(): void {
  }

  onSubmit(formulario) {
    if (formulario.valid) {
      var usuario: any = {};
      usuario.registro = this.login;
      usuario.senha = this.password;

      console.log(usuario)

      this.authentication.login(usuario).subscribe(result => {
          // salvar dados no localstorage
          this.loginOk = true;
          this.authentication.store(result.body, result.headers.get('x-authorization'));
          this.router.navigate(['/dashboard']);
        },
        error => {
          this.error = error;
          console.log(error);
          console.log(this.error);

          if (error.status === 401) {
            this.mensagemErro = 'Registro / Senha Inválidos!';
          } else {
            this.mensagemErro = 'Ocorreu um erro.';
          }
          this.loginOk = false;
          formulario.resetForm();
        });

    } else {
      this.mensagemErro = 'Registro / Senha Inválidos!';
      this.loginOk = false;
    }
  }

}
