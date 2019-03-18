import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';

import { dashboardRoutes } from './dashboard.routes';

import {MatToolbarModule} from '@angular/material/toolbar';

import { SharedModule } from './../shared/shared.module';

import {MatMenuModule} from '@angular/material/menu';

import {MatSidenavModule} from '@angular/material/sidenav';

import {MatListModule} from '@angular/material/list';
import { CheckerComponent } from './checker/checker.component';
import { MakerComponent } from './maker/maker.component';

import {MatCardModule} from '@angular/material/card';
import { RoleGuardGuard } from './role-guard.guard';

import {MatTableModule} from '@angular/material/table';
import { MakerformComponent } from './makerform/makerform.component';
import { MatInputModule, MatButtonModule, MatSelectModule, MatRadioModule } from '@angular/material';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [LayoutComponent, HomeComponent, CheckerComponent, MakerComponent, MakerformComponent],
  imports: [
    CommonModule,
    MatToolbarModule,
    SharedModule,
    MatMenuModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    RouterModule.forChild(dashboardRoutes),
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    ReactiveFormsModule
  ],
  providers : [RoleGuardGuard]
})
export class DashboardModule { }
