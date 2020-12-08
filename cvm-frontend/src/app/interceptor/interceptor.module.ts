import { Injectable, NgModule } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';

Injectable()

@NgModule({
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorModule,
      multi: true,
    },
  ],
})
  
export class InterceptorModule implements HttpInterceptor {
  
  intercept(
   req: HttpRequest<any>,
   next: HttpHandler,
  ) : Observable<HttpEvent<any>> {
    const dupReq = req.clone({
      headers: req.headers.set('x-authorization', localStorage.getItem("token") !== null ? localStorage.getItem("token") : ''),
    });
    
    return next.handle(dupReq);
  }
}