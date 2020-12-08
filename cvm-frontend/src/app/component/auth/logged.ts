import {Injectable} from '@angular/core';
import {Router, CanActivate} from '@angular/router';

@Injectable()
export class Logged implements CanActivate {

  constructor(
    private _router: Router
  ) {
  }

  canActivate() {
    var teste = localStorage.getItem("isLogged") == "true" ? true : false;
    if (teste) {
      return true;
    } else {
      // redireciona ao home
      this._router.navigate(['/auth']);
      // abort current navigation
      return false;
    }
  }

}
