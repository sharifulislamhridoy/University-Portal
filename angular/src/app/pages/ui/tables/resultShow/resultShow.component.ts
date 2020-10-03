import { Component, OnInit, ViewChildren, QueryList } from '@angular/core';
import { DecimalPipe } from '@angular/common';

import { ResultService } from './resultShow.service';
import { Result } from './resultShow.model';



@Component({
  selector: 'app-Result-table',
  templateUrl: './resultShow.component.html',
  styleUrls: ['./resultShow.component.scss'],
  providers: [ResultService, DecimalPipe]
})

/**
 * Advanced table component - handling the advanced table with sidebar and content
 */
export class ResultComponent implements OnInit {



  allResult: Result[];
  // bread crum data
  breadCrumbItems: Array<{}>;



  
  constructor(
    public ResultService: ResultService,

  ) {

  }

  ngOnInit() {
    // tslint:disable-next-line: max-line-length
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '/' }, { label: 'Advanced', path: '/', active: true }];

    /**
     * fetch data
     */
  
      this.getAllResult();


  }

  

  




  getAllResult() {
    this.ResultService.getCoursesById("123302236").subscribe(
      (data: Result[]) => {
        this.allResult = data;
      });
  
  }




 
  




 

}

