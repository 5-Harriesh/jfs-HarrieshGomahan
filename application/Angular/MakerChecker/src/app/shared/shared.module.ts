import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MatButtonModule, MatCheckboxModule,MatGridListModule,
  MatInputModule,MatDatepickerModule,MatNativeDateModule,MatIconModule,MatFormFieldModule,MatSelectModule} from '@angular/material';


  @NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatButtonModule, 
    MatCheckboxModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  exports : [
    CommonModule,
    MatButtonModule, 
    MatCheckboxModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule
  ]
})
export class SharedModule { }
