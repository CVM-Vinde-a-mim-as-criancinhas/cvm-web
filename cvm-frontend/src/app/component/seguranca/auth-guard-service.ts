import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot } from '@angular/router';
import {PermissoesService} from './autorizacao-service';

@Injectable()
export class AuthGuardService implements CanActivate {

  constructor(protected router: Router,
              protected autorizacaoService: PermissoesService) { }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    return this.possuiPermissao(route.url[0].path);
  }

  protected possuiPermissao(rota: string): boolean {
    return this.autorizacaoService.pussuiPermissaoAuth(rota);
  }
}
