import { Injectable, Injector } from '@angular/core';
import { HttpHandler, HttpInterceptor } from '@angular/common/http';
import { RegistrationService } from './registration.service';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private injector: Injector, private servive: RegistrationService) { }
  intercept(req: any, next: any) {
    const accessToken = sessionStorage.getItem("token");
    //Check if accesToken exists, else send request without bearer token
    if (accessToken) {
      console.log("Req: ", req.url);
      let url = req.url.split(".");
      console.log("Url: ", url);
      if (url.length == 1) {
        const cloned = req.clone({
          headers: req.headers.set('Authorization',
            `Bearer ${accessToken}`
          )
  
  
        });
        return next.handle(cloned);
      } else {
        const cloned = req.clone({});
        return next.handle(cloned);
      }
      console.log('Token added to HTTP request');
    //  return next.handle(true); 
    }
    else {
      //No token; proceed request without bearer token
      console.log('No token added to HTTP request');
      return next.handle(req);
    }


  }
}

