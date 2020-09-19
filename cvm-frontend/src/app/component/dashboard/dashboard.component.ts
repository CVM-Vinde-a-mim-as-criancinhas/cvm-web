import {Component, OnInit} from '@angular/core';
import {ServiceService} from '../../service/service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private service: ServiceService) {
  }

  // getAgenda() {
  //   this.service.getAgenda().subscribe(result => {
  //     console.log(result);
  //   });
  // }

  ngOnInit(): void {
    // this.getAgenda();
  }

}
