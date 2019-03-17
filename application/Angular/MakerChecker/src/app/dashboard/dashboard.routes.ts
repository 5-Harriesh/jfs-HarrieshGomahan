import { Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { HomeComponent } from './home/home.component';
import { MakerComponent } from './maker/maker.component';
import { CheckerComponent } from './checker/checker.component';

import {RoleGuardGuard} from './role-guard.guard';


export const dashboardRoutes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', component: HomeComponent},
      { path: 'maker', component: MakerComponent, canActivate:[RoleGuardGuard]},
      { path: 'checker', component: CheckerComponent, canActivate:[RoleGuardGuard]}
    ]
  }
];
