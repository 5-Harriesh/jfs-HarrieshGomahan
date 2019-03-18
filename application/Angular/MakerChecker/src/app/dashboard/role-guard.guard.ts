import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable()

export class RoleGuardGuard implements CanActivate  {

  constructor(private router: Router){}
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) : boolean {
    
    var userType = JSON.parse(localStorage.getItem('currentUser'))['userType'];

    if('Checker' == userType && '/dashboard/checker' == state.url ){
      return true;
    }else if('Maker' == userType && ('/dashboard/maker' == state.url || '/dashboard/makerform' ==state.url) ){
      return true;
    }else{
      alert("Access Denied");
      this.router.navigate(['/dashboard/home']);
      return false;
    }

  }
  
}
