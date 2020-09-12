import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ServiceService} from '../../service/service.service';
import {FormBuilder, NgForm, Validators} from '@angular/forms';
import {Agenda} from '../../data/agenda';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.css']
})
export class AgendaComponent implements OnInit {
  agenda: Agenda = new Agenda();

  constructor(private router: Router, private api: ServiceService) {
  }

  ngOnInit(): void {
  }

  addAgenda(agenda: Agenda) {
    this.api.setAgenda(agenda).subscribe(
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
}
