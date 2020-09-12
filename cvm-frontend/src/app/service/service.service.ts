import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Agenda} from '../data/agenda';

const host = 'http://localhost:8080/cvm/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) {
  }

  // DASHBOARD
  getDashboard(): Observable<HttpResponse<any>> {
    return this.http.get<any>(host + '/dashboard', {observe: 'response'});
  }

  // AGENDA
  getAgenda(): Observable<HttpResponse<any>> {
    return this.http.get<any>(host + '/agenda', {observe: 'response'});
  }

  setAgenda(agenda: Agenda){
    // return this.http.post(host+'/agenda', agenda);
    return this.http.post<Agenda>(host, agenda, httpOptions);
  }

  // TRANSPARENCIA
  getTransparencia(): Observable<HttpResponse<any>> {
    return this.http.get<any>(host + '/transparencia', {observe: 'response'});
  }

  // NOTICIA
  getNoticia(): Observable<HttpResponse<any>> {
    return this.http.get<any>(host + '/noticia', {observe: 'response'});
  }
}
