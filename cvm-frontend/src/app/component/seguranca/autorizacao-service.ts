import {Injectable, OnInit} from '@angular/core';
import {isNullOrUndefined} from 'util';

@Injectable()
export class PermissoesService implements OnInit {

  permissoes: any;
  listaPermissoesPossiveisNotaFiscal: string[];

  buscarPelaPropriedade<T, K extends keyof T>(obj: T, key: K) {
    return obj[key];
  }

  constructor() {
  }

  possuiPermissao(permissao: string): boolean {
    if (isNullOrUndefined(this.permissoes)) {
      // this.inicializarPermissoes();
    }
    return this.buscarPelaPropriedade(this.permissoes, permissao);
  }


  pussuiPermissaoAuth(url: string): boolean {
    // if (url === 'e-mails-imap') {
    //   return this.buscarPelaPropriedade(this.permissoes, this.rolesConstants.CADASTRAR_CONFIGURACAO_EMAIL);
    // }


    return true;
  }

  // inicializarPermissoes() {
  //   let user: any = JSON.parse(localStorage.getItem('user'));
  //   this.permissoes = user.userRoleDTO;
  // }

  ngOnInit(): void {
    // this.inicializarPermissoes();
  }

}
