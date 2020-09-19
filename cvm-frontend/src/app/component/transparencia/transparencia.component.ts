import {Component, OnInit} from '@angular/core';
import {Transparencia} from '../../data/transparencia';
import {Router} from '@angular/router';
import {ServiceService} from '../../service/service.service';
import {Noticia} from '../../data/noticia';

@Component({
  selector: 'app-transparencia',
  templateUrl: './transparencia.component.html',
  styleUrls: ['./transparencia.component.css']
})
export class TransparenciaComponent implements OnInit {
  transparencia: Transparencia = new Transparencia();

  constructor(private router: Router, private api: ServiceService) {
  }

  addTransparencia(transparencia: Transparencia) {
    this.api.setTransparencia(transparencia).subscribe(
      resultado => {
        console.log(resultado);
      },
      erro => {
        if (erro.status == 400) {
          console.log(erro);
        }
      }
    );
  }

  ngOnInit(): void {
  }

}
