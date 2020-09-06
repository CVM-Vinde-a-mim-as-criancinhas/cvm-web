import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';

const host = 'http://localhost:8080/cvm/rest';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) {
  }

  pesquisaTeste(): Observable<HttpResponse<any>> {
    return this.http.get<any>(host + '/dashboard', {observe: 'response'});
  }
}
