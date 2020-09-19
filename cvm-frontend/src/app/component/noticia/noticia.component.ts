import {Component, OnInit} from '@angular/core';
import {Agenda} from '../../data/agenda';
import {Router} from '@angular/router';
import {ServiceService} from '../../service/service.service';
import {Noticia} from '../../data/noticia';

@Component({
  selector: 'app-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.css']
})
export class NoticiaComponent implements OnInit {
  noticia: Noticia = new Noticia();

  constructor(private router: Router, private api: ServiceService) {
  }

  addNoticia(noticia: Noticia) {
    this.api.setNoticia(noticia).subscribe(
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
