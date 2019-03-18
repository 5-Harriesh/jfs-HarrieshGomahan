import { Component, OnInit } from '@angular/core';
import { FormsService } from './forms.service'
import { DatatableRequests } from 'src/app/model/datatableRequest';
import { DatatableFilter } from 'src/app/model/datatableFilter';


@Component({
  selector: 'app-maker',
  templateUrl: './maker.component.html',
  styleUrls: ['./maker.component.sass'],
  providers:[FormsService]
})
export class MakerComponent implements OnInit {

  tableColumns :string[] = ['customerid','name', 'emailid', 'createddate', 'modifieddate', 'applicationtype', 'status'];
  dataSource :any;
  datatableRequest:DatatableRequests;
  datatableFilter:DatatableFilter;

  constructor(private formsService:FormsService) { }

  ngOnInit() {
    this.datatableFilter = {'matchMode':'','value':''}
    this.datatableRequest = {
      'filters': {'':this.datatableFilter},
      'first': 0,
      'rows': 5,
      'sortField': 'customerid',
      'sortOrder': 0
    };
    this.getApprovedForms();
  }

  getApprovedForms(){

    this.formsService.getAllForms(this.datatableRequest).subscribe((response:any) =>{
        this.dataSource = response.data.data;
    })

  }

}
