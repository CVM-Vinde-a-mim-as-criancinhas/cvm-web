import {Directive, ElementRef, Input, OnInit} from '@angular/core';
import {PermissoesService} from './autorizacao-service';
import {isNullOrUndefined} from "util";

@Directive({
    selector: '[appHideNaoAutorizado]'
})
export class HideNaoAutorizadoDirective implements OnInit {

    @Input('appHideNaoAutorizado') permissoes: string[];

    constructor(private el: ElementRef,
                private autorizacaoService: PermissoesService) {
    }

    ngOnInit() {
        let possuiPermissao = false;

        if (!isNullOrUndefined(this.permissoes) && this.permissoes.length > 0) {
            for (let permissao of this.permissoes) {
                if (this.autorizacaoService.possuiPermissao(permissao)) {
                    possuiPermissao = true;
                }
            }
        } else { // caso seja chamado sem valor
            possuiPermissao = true;
        }

        if (!possuiPermissao) {
            this.el.nativeElement.style.display = 'none';
        }

    }

}
