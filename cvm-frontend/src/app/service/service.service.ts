import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Agenda} from '../data/agenda';
import {Noticia} from '../data/noticia';
import {Transparencia} from '../data/transparencia';

const host = 'http://localhost:8080/cvm/rest';

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
    return this.http.get<any>(host + '/agenda', httpOptions);
  }

  setAgenda(agenda: Agenda) {
    return this.http.post<Agenda>(host + '/agenda', agenda, httpOptions);
  }

  // TRANSPARENCIA
  getTransparencia(): Observable<HttpResponse<any>> {
    return this.http.get<any>(host + '/transparencia', {observe: 'response'});
  }

  setTransparencia(transparencia: Transparencia) {
    return this.http.post<Transparencia>(host + '/transparencia', transparencia, httpOptions);
  }

  // NOTICIA
  getNoticia(): Observable<HttpResponse<any>> {
    return this.http.get<any>(host + '/noticia', {observe: 'response'});
  }

  setNoticia(noticia: Noticia) {
    return this.http.post<Noticia>(host + '/noticia', noticia, httpOptions);
  }
}
